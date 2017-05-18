package com.xinzy.wechat.voice.downloader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.xinzy.wechat.voice.downloader.util.HtmlParser;
import com.xinzy.wechat.voice.downloader.util.Utils;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DownloadTask implements Runnable {
	public static final String VOICE_URL = "https://res.wx.qq.com/voice/getvoice?mediaid=";
	public static final int BUFFER_SIZE = 16 * 1024;

	private String mUrl;
	private String mBookName;
	private boolean mSaveContent;
	private OkHttpClient mClient;
	
	private File mSavedDir;
	
	private ErrorCallback mErrorCallback;
	
	public DownloadTask(String mUrl, String bookName, boolean saveContent) {
		this.mUrl = mUrl;
		this.mBookName = bookName;
		this.mSaveContent = saveContent;
		mSavedDir = new File(WechatVoice.DOWNLOAD_DIR + "/" + mBookName);
		mClient = Utils.getOkHttpClient();
	}

	public void setErrorCallback(ErrorCallback callback) {
		this.mErrorCallback = callback;
	}
	
	@Override
	public void run() {
		String content = Utils.loadContent(mUrl);
		
		if (content == null) {
			if (mErrorCallback != null) {
				mErrorCallback.callback(mUrl, mBookName);
			}
			return;
		}
		String key = getKey(content);
		String title = HtmlParser.parseTitle(content);
		
		if (!Utils.isEmpty(key) && !Utils.isEmpty(title)) {
			if (mSaveContent) {
				saveContent(content, title);
			}
			download(key, title);
		}
	}
	
	private void download(String key, String title) {
		System.out.println("开始下载## " + title);
		String url = VOICE_URL + key;
		
		Request request = null;
		Response response = null;
		
		File tmpFile = null;
		File targetFile = new File(mSavedDir, title + ".mp3");
		
		InputStream is = null;
		FileOutputStream fos = null;
		
		try {
			request = new Request.Builder().get().url(url).tag(key).build();
			response = mClient.newCall(request).execute();
			
			if (response.isSuccessful()) {
				
				tmpFile = File.createTempFile(Utils.md5(title), ".tmp", mSavedDir);
				
				fos = new FileOutputStream(tmpFile);
				is = response.body().byteStream();
				byte[] buff = new byte[BUFFER_SIZE];
				int length;
				while ((length = is.read(buff, 0, BUFFER_SIZE)) > 0) {
					fos.write(buff, 0, length);
				}
				
				is.close();
				fos.close();
				tmpFile.renameTo(targetFile);
				
				System.out.println("下载完成## " + title);
			} else {
				System.out.println("下载网络失败： " + response.message());
			}
		} catch (IOException e) {
			System.err.println("下载# " + title + "# 失败; msg = " + e.getMessage());
			if (tmpFile != null && tmpFile.exists()) {
				tmpFile.delete();
			}
			if (mErrorCallback != null) {
				mErrorCallback.callback(mUrl, mBookName);
			}
		} finally {
			try {
				if (fos != null) {
					fos.flush();
					fos.close();
				}
				if (is != null) {
					is.close();
				}
			} catch (IOException e2) {
			}
		}
	}
	
	private void saveContent(String input, String title) {
		String outline = HtmlParser.filterTag(HtmlParser.parseContent(input));
		if (!Utils.isEmpty(outline)) {
			Utils.write(outline, new File(mSavedDir, title + ".txt"));
		}
	}
	
	private String getKey(String content) {
		Pattern pattern = Pattern.compile("voice_encode_fileid=\"(.*?)\"");
		Matcher matcher = pattern.matcher(content);
		
		if (matcher.find()) {
			return matcher.group(1);
		}
		
		return null;
	}
	
	public interface ErrorCallback {
		void callback(String url, String bookName);
	}
	
}
