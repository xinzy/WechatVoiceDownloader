package com.xinzy.wechat.voice.downloader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.xinzy.wechat.voice.downloader.DownloadTask.ErrorCallback;
import com.xinzy.wechat.voice.downloader.util.HtmlParser;
import com.xinzy.wechat.voice.downloader.util.Utils;

public class Processor implements ErrorCallback {
	public static final int POOL_SIZE = 3;
	
	private ThreadFactory mThreadFactory = new ThreadFactory() {
		@Override
		public Thread newThread(Runnable r) {
			return new Thread(r, "Thread#" + mAtomicInteger.getAndIncrement());
		}
	};
	
	private List<String> mUrls;
	private String mTitle;
	private boolean mSaveContent;
	private ExecutorService mExecutorService = Executors.newFixedThreadPool(POOL_SIZE, mThreadFactory);;
	private AtomicInteger mAtomicInteger = new AtomicInteger(1);
	
	public Processor(List<String> urls, boolean saveContent) {
		this.mUrls = urls;
		this.mSaveContent = saveContent;
	}
	
	public Processor(List<String> urls, String title, boolean saveContent) {
		this.mUrls = urls;
		this.mTitle = title;
		this.mSaveContent = saveContent;
	}
	
	public void process() {
		mUrls.stream().forEach(url -> process0(url));
	}
	
	public void download() {
		mUrls.stream().forEach(url -> addTask(url, mTitle, mSaveContent));
	}
	
	private void process0(String url) {

		String content = Utils.loadContent(url);
		if (!Utils.isEmpty(content)) {
			String title = HtmlParser.parseTitle(content);
			if (Utils.isEmpty(title)) {
				title = Utils.md5(url);
			}
			File dir = new File(WechatVoice.DOWNLOAD_DIR + "/" + title);
			if (! dir.exists()) dir.mkdirs();
			
			if (mSaveContent) {
				String outline = HtmlParser.filterTag(HtmlParser.parseContent(content));
				if (!Utils.isEmpty(outline)) {
					Utils.write(outline, new File(dir, "outline.txt"));
				}
			}
			
			List<String> urls = getUrls(content);
			final String bookName = title;
			urls.stream().forEach(u -> addTask(u, bookName, mSaveContent));
		}
	}
	
	public List<String> getUrls(String content) {
		List<String> list = new ArrayList<>();
		
		Pattern pattern = Pattern.compile("<a.*?href=\"(.*?)\".*?>.*?<\\/a>");
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) {
			String url = matcher.group(1).replaceAll("&amp;", "&");
			list.add(url);
		}
		
		return list;
	}

	@Override
	public void callback(String url, String bookName) {
		addTask(url, bookName, mSaveContent);
	}
	
	private void addTask(String url, String bookname, boolean saveContent) {
		DownloadTask task = new DownloadTask(url, bookname, saveContent);
		task.setErrorCallback(this);
		mExecutorService.submit(task);
	}
}
