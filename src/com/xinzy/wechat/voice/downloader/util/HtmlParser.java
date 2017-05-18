package com.xinzy.wechat.voice.downloader.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlParser {
	public static final String[] DISCARDED_TAG = {"a", "div", "img", "mpvoice", };

	public static String parseTitle(String content) {
		Pattern pattern = Pattern.compile("<title>(.*?)<\\/title>");
		Matcher matcher = pattern.matcher(content);
		
		if (matcher.find()) {
			return matcher.group(1).trim();
		}
		
		return null;
	}
	
	public static String parseContent(String input) {
		
		Pattern pattern = Pattern.compile("<div class=\"rich_media_content.*?>([\\s\\S]*?)<\\/div>");
		Matcher matcher = pattern.matcher(input);
		
		if (matcher.find()) {
			return matcher.group(1).trim();
		}
		
		return null;
	}
	
	public static String filterTag(String html, String... tags) {
		if (tags == null || tags.length == 0) {
			tags = DISCARDED_TAG;
		}
		
		for (String tag : tags) {
			String regex;
			if ("img".equals(tag)) {
				regex = "<img[^>]+>";
			} else {
				regex = "<" + tag + "[\\s\\S]*>[\\s\\S]*<\\/" + tag + ">";
			}
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(html);
			if (matcher.matches()) {
				System.out.println(tag + ": " + matcher.group());
			}
			html = matcher.replaceAll("");
		}
		
		return html;
	}
}
