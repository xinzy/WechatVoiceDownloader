package com.xinzy.wechat.voice.downloader;

import java.util.Arrays;

public class WechatVoice {
	public static final String DOWNLOAD_DIR = "downloads";
	
	public static final String[] URLS = {
			"http://mp.weixin.qq.com/s/jg0RoLOdRK7oFb9IN1x3HQ", //从零到一
//			"http://mp.weixin.qq.com/s/jaUTzXx3yCe7ose9xdLUJg", // 哈佛财商课 全集
//			"http://mp.weixin.qq.com/s/IEkg7KuNsr8zIs6dFKe4cw", // 彼得林奇的成功投资 全集
//			"http://mp.weixin.qq.com/s/KFEtwwQgixYYDMis_g9IBQ", // 《富爸爸》给你的钱找份工作
//			"http://mp.weixin.qq.com/s/4hzNnA_xxokfXESkcfp4Lw", //​ 硅谷钢铁侠 
//			"http://mp.weixin.qq.com/s/OPGoYVndctbT1VrmiPOqag", //一课经济学 合集 
//			"https://mp.weixin.qq.com/s/VnsMvRxiTCu5FcDa39MM7Q", // ​怎样选择成长股 【费雪】全集
//			"http://mp.weixin.qq.com/s/jsavez01T_5K3bgLGVtGPA", //激荡三十年(上)
//			"http://mp.weixin.qq.com/s/rzICNYJvgwujGTAAXJr8Ug", //激荡三十年(下)
//			"http://mp.weixin.qq.com/s/mcdVuregO-g3b1twe9RCJQ", //小狗钱钱
//			"http://mp.weixin.qq.com/s/2DULpwUawXPGyqA7gD6TfA", //滚雪球
//			"http://mp.weixin.qq.com/s/e7yBj1LCmQbwv_UUURT6Pw", //怎样选择成长股
//			"http://mp.weixin.qq.com/s/TkLm6Q0JYXAQYRf3eKmGrg",	//灰犀牛
//			"http://mp.weixin.qq.com/s/ILLrWVheR7eHtyk_BS6rYQ", //​穷查理宝典
//			"http://mp.weixin.qq.com/s/cZsV2nL6nx2hiN8P6U6EfA", //股票作手回忆录
//			"http://mp.weixin.qq.com/s/xmbJWtC1ZsitCHzgmPUQQg", //为什么中国人勤劳而不富有
//			"http://mp.weixin.qq.com/s/cDquEhAd94q02MkMQ58RzA", //战胜华尔街
//			"http://mp.weixin.qq.com/s/YOLmhEz8r4lyhOdPRvTdfQ", //影响力
//			"http://mp.weixin.qq.com/s/wzqQgzA9Z1G9CbYMl25H5g", //手把手教你读财报
//			"http://mp.weixin.qq.com/s/RT8ZoqOk4L6Oydp74gudWw", //雪球投资
//			"http://mp.weixin.qq.com/s/pXL5jN1Nxr7vGgqTwZRtvg", //海底捞你学不会
//			"http://mp.weixin.qq.com/s/X62UwNWgba77qMA_MHdJsw", //索罗斯带你走出金融危机 
//			"http://mp.weixin.qq.com/s/dkNNl0k0svO1vE8ngBMbCw", //量化投资
//			"http://mp.weixin.qq.com/s/P6i87siJuS8ubDOjDtLIBQ", //巴菲特如何选出超级明星股
//			"http://mp.weixin.qq.com/s/slxbZdIs2DhusF-ks2_9vA", //鞋狗——耐克的故事
//			"http://mp.weixin.qq.com/s/ivGoL2xjmrpISOfAl0VBiw", //投资中最简单的事
//			"http://mp.weixin.qq.com/s/CzGIy3fi3F0ppBLv7BxzZw", //腾讯传
//			"http://mp.weixin.qq.com/s/zP-pMhQt2NbSn5UKihjrLA", //美国人为什么支持特朗普
//			"http://mp.weixin.qq.com/s/jBKY4A711YGjLLkWRHHf7w", //周鸿祎的互联网方法论
//			"http://mp.weixin.qq.com/s/WyoOWeyregWGhbJmx4JrvQ", //为什么你买不起房
//			"http://mp.weixin.qq.com/s/XsY8ZolFCE55P0ZHqDiCEg", //中国楼市的前世今生
//			"http://mp.weixin.qq.com/s/i89YJZeAZiA5qLlgvtnkDw", //低风险投资之路
//			"http://mp.weixin.qq.com/s/ZygRK3kux3jFWWBGWKDhuw", //爆品战略
//			"http://mp.weixin.qq.com/s/Ured9S8fbF34Xm8pNKULSQ", //股市投资的24堂必修课
//			"http://mp.weixin.qq.com/s/-cLKdkpq3Hg99at-5NJX7Q", //定位
//			"http://mp.weixin.qq.com/s/uH42EtAPDpEhq8MgTMqwTg", //大败局（上）
//			"http://mp.weixin.qq.com/s/HeIOjDupaCXueD_jSE86Uw", //大败局（下）
//			"http://mp.weixin.qq.com/s/v4ZUQdl_Axi93FCjcqsr9g", //历代经济变革得失
//			"http://mp.weixin.qq.com/s/k7wPdGGjNYcP2OZrXG_G1A", //基金定投
//			"http://mp.weixin.qq.com/s/73Iv9qnMt6Y5TMMgfC-1SA", //经济学思维
//			"http://mp.weixin.qq.com/s/J8iJNybFtRq7IfhHwkfilQ", //创京东
//			"http://mp.weixin.qq.com/s/SrKtb8PHHW2H1HZdH-0THA", //《雪球岛系列》及《说估值系列》
//			"http://mp.weixin.qq.com/s/kJ5Gr08wwQJftYRT3Ouo6Q", //富爸爸系列之财富自由之路
	};
	
	public static final String[] SINGLE_URLS = {
			"http://mp.weixin.qq.com/s/nknHgvRytFryyqlwZzCc5Q", // 硅谷钢铁侠  7
//			"https://mp.weixin.qq.com/s?__biz=MzA5NTA2NTU4Mw==&mid=2247487411&idx=2&sn=a6aed26e602832622cd3884785f555dc&chksm=90444b33a733c2258d5bd0e298c915bc1b23033caae0b8153f17521f7ec2b0ebb146c0787537&scene=21#wechat_redirect",
//			"https://mp.weixin.qq.com/s?__biz=MzA5NTA2NTU4Mw==&mid=2247486714&idx=2&sn=d79d51f518b4b45fe90d777dce42e7ec&chksm=9044487aa733c16ca8347669fe979977762a5bb40ba4b1d86c12849385a5fe3314b7abc54c81&mpshare=1&scene=1&srcid=0621qaygPfdmKRK1uei0Lgnf&key=71bc190ce51da5654ef334341a8e6fa591abee51ca2d58140978679de512fe3de5396c93b4d56222790d405539e2a2ba3bddc94fa3c2ae212e99706aaedaa5d0b3f0be2fec4fb374b0fce36e9e69d1a4&ascene=0&uin=MTc3OTkzOTYw&devicetype=iMac+MacBookPro11%2C2+OSX+OSX+10.10.5+build(14F2009)&version=12020810&nettype=WIFI&fontScale=100&pass_ticket=7d9erXu49nnOMpAL9pw7fkjYdX9IKmCq4t12SUYuGYc%3D",
//			"https://mp.weixin.qq.com/s?__biz=MzA5NTA2NTU4Mw==&mid=2247486746&idx=1&sn=1dc163ede357c9f8ab6e3f57b805ffdb&chksm=9044499aa733c08cba1188192c0d9b3647df6d22693d7f33110bf836ac843475303b59a8e3b8&mpshare=1&scene=1&srcid=06213lw7rTsPQBy9L2D7P95B&key=d1e338eab434b0b482d820b68df34734fcb68a4f0554a4284508d21a6aae6094f965341a1d83e2e0068a7d0a3b5ab7c9663e5e9eeded73a68772b55212032c723c5be91181dfd0d5f172b7e1cfc62178&ascene=0&uin=MTc3OTkzOTYw&devicetype=iMac+MacBookPro11%2C2+OSX+OSX+10.10.5+build(14F2009)&version=12020810&nettype=WIFI&fontScale=100&pass_ticket=7d9erXu49nnOMpAL9pw7fkjYdX9IKmCq4t12SUYuGYc%3D"
	};
	
	public static void main(String[] args) {
		batch();
	}
	
	static void single() {
		Processor processor = new Processor(Arrays.asList(SINGLE_URLS), "0", false);
		processor.download();
	}
	
	static void batch() {
		Processor processor = new Processor(Arrays.asList(URLS), false);
		processor.process();
	}
}
