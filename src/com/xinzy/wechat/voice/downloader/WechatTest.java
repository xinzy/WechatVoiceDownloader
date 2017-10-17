package com.xinzy.wechat.voice.downloader;

import okhttp3.HttpUrl;

public class WechatTest {
	
	public static final String CONTENT_URL = "https://mp.weixin.qq.com/s?__biz=MzA5NTA2NTU4Mw==&mid=2247485833&idx=3&sn=71e60611f835e2d02f76ce8ca3e2e680&chksm=90444d09a733c41ff3631df0a2d38f4e54f0519dad5dfddedd0b4667445aa004973d9642fd4c&scene=21#wechat_redirect";
	public static final String COLLECT_URL = "https://mp.weixin.qq.com/s?__biz=MzA5NTA2NTU4Mw%3D%3D&mid=2247486384&idx=3&sn=c08e84913bc863b5e8f9d0b9e3924a7c&scene=45#wechat_redirect";
	
	
	public static void main(String[] args) {
		HttpUrl url = HttpUrl.parse("http://mp.weixin.qq.com/s/KFEtwwQgixYYDMis_g9IBQ");
		System.out.println(url);
	}

}
