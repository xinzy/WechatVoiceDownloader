package com.xinzy.wechat.voice.downloader;

import java.util.Arrays;

public class WechatVoice {
	public static final String DOWNLOAD_DIR = "downloads";
	
	public static final String[] URLS = {
			"https://mp.weixin.qq.com/s?__biz=MzA5NTA2NTU4Mw%3D%3D&mid=2247486384&idx=3&sn=c08e84913bc863b5e8f9d0b9e3924a7c&scene=45#wechat_redirect",
	};
	
	public static void main(String[] args) {
		Arrays.asList(URLS).stream().forEach(url -> {
			Processor processor = new Processor(url, true);
			processor.process();
		});
	}
}
