package com.xinzy.wechat.voice.downloader;

import java.util.Arrays;

public class WechatVoice {
	public static final String DOWNLOAD_DIR = "downloads";
	
	public static final String[] URLS = {
			"https://mp.weixin.qq.com/s?__biz=MzA5NTA2NTU4Mw==&mid=2247486776&idx=4&sn=ed4208fbb16acb0790cf85279cd8e640&chksm=904449b8a733c0ae54998057120dd141cf4f4501a59a0d4aa0bc52ea29cead27be12506f20bb&mpshare=1&scene=24&srcid=0621q0FWdmrg5dDlNkffokUe&key=6f757bd94c1c518243908305c41b3086319f15972bc7f3fc3c65c58f8636b1796483b803993bfd5b899966be0949a29f90998ce69aab0768dec997ff82c91dac169299b67f50c0bbb08a7e441d581450&ascene=0&uin=MTc3OTkzOTYw&devicetype=iMac+MacBookPro11%2C2+OSX+OSX+10.10.5+build(14F2009)&version=12020810&nettype=WIFI&fontScale=100&pass_ticket=7d9erXu49nnOMpAL9pw7fkjYdX9IKmCq4t12SUYuGYc%3D"
	};
	
	public static final String[] SINGLE_URLS = {
			"https://mp.weixin.qq.com/s?__biz=MzA5NTA2NTU4Mw==&mid=2247486714&idx=2&sn=d79d51f518b4b45fe90d777dce42e7ec&chksm=9044487aa733c16ca8347669fe979977762a5bb40ba4b1d86c12849385a5fe3314b7abc54c81&mpshare=1&scene=1&srcid=0621qaygPfdmKRK1uei0Lgnf&key=71bc190ce51da5654ef334341a8e6fa591abee51ca2d58140978679de512fe3de5396c93b4d56222790d405539e2a2ba3bddc94fa3c2ae212e99706aaedaa5d0b3f0be2fec4fb374b0fce36e9e69d1a4&ascene=0&uin=MTc3OTkzOTYw&devicetype=iMac+MacBookPro11%2C2+OSX+OSX+10.10.5+build(14F2009)&version=12020810&nettype=WIFI&fontScale=100&pass_ticket=7d9erXu49nnOMpAL9pw7fkjYdX9IKmCq4t12SUYuGYc%3D",
			"https://mp.weixin.qq.com/s?__biz=MzA5NTA2NTU4Mw==&mid=2247486746&idx=1&sn=1dc163ede357c9f8ab6e3f57b805ffdb&chksm=9044499aa733c08cba1188192c0d9b3647df6d22693d7f33110bf836ac843475303b59a8e3b8&mpshare=1&scene=1&srcid=06213lw7rTsPQBy9L2D7P95B&key=d1e338eab434b0b482d820b68df34734fcb68a4f0554a4284508d21a6aae6094f965341a1d83e2e0068a7d0a3b5ab7c9663e5e9eeded73a68772b55212032c723c5be91181dfd0d5f172b7e1cfc62178&ascene=0&uin=MTc3OTkzOTYw&devicetype=iMac+MacBookPro11%2C2+OSX+OSX+10.10.5+build(14F2009)&version=12020810&nettype=WIFI&fontScale=100&pass_ticket=7d9erXu49nnOMpAL9pw7fkjYdX9IKmCq4t12SUYuGYc%3D"
	};
	
	public static void main(String[] args) {
		single();
	}
	
	static void single() {
		Processor processor = new Processor(Arrays.asList(SINGLE_URLS), "手把手教你读财报 全集", false);
		processor.download();
	}
	
	static void batch() {
		Processor processor = new Processor(Arrays.asList(URLS), false);
		processor.process();
	}
}
