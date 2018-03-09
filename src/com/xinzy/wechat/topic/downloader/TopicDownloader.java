package com.xinzy.wechat.topic.downloader;

import com.xinzy.wechat.voice.downloader.util.HtmlParser;
import com.xinzy.wechat.voice.downloader.util.Utils;

public class TopicDownloader {
	private static final String SAVE_DIR = "topics/";
	
	private static final String[] TOPICS = {
			"http://mp.weixin.qq.com/s/WmYkxgpJQJkVhonxpHD3ig",
			"http://mp.weixin.qq.com/s/lDYYl1Q7J9RnbiNAYh5nMA",
			"http://mp.weixin.qq.com/s/l8Yu70oHyMeh7lWjMO6jrA",
			"http://mp.weixin.qq.com/s/qM_8oOk8hB8wgTtdR4I0lw",
			"https://mp.weixin.qq.com/s/DFqpbf0Xf5DxTGPpmy4mnQ",
			"http://mp.weixin.qq.com/s/uOK_jkq4CNUwL-qLtd-78Q",
			"http://mp.weixin.qq.com/s/HrsD_M2Yuzq0CPhST0CFJg",
			"http://mp.weixin.qq.com/s/1ucfccYLIrTVYe7MB9wfjw",
			"http://mp.weixin.qq.com/s/V0y6NPjO51ucNfYTRqXc4w",
			"http://mp.weixin.qq.com/s/3fNaph3KMkXhWQ-ELTIRtg",
			"http://mp.weixin.qq.com/s/5qNEckZjvH9dvViYDuEkzA",
			"http://mp.weixin.qq.com/s/hU2KmqkPOxtMA78-AFF-LQ",
			"http://mp.weixin.qq.com/s/oqWuc7ZT_KZrwUlQJxF6cw",
			"http://mp.weixin.qq.com/s/wjXa-ywWQW_XKCS_5pe2sw",
			"http://mp.weixin.qq.com/s/N9oYhM_ThPuvi1QHBw85vQ",
			"http://mp.weixin.qq.com/s/Vt0xrtoyW_AwJeYy2RP8aQ",
	};

	public static void main(String[] args) {
		TopicDownloader downloader = new TopicDownloader();
		for (String url : TOPICS) {
			downloader.save(url);
		}
	}
	
	private void save(String url) {
		if (Utils.isEmpty(url)) return ;

		String all = Utils.loadContent(url);
		if (Utils.isEmpty(all)) return ;
		
		String title = HtmlParser.parseTitle(all);
		System.out.println("下载： " + title);
		
		String content = HtmlParser.parseContent(all).replaceAll("data-src", "src");
		if (!Utils.isEmpty(title) && !Utils.isEmpty(content)) {
			Utils.write(content, SAVE_DIR + title + ".html");
		}
	}
}
