package com.xinzy.wechat.voice.downloader.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public final class Utils {

	private static OkHttpClient sOkHttpClient;
	
	public static final OkHttpClient getOkHttpClient() {
		
		if (sOkHttpClient == null) {
			synchronized (Utils.class) {
				if (sOkHttpClient == null) {
					sOkHttpClient = new OkHttpClient.Builder().build();
				}
			}
		}
		
		return sOkHttpClient;
	}
	
	public static String md5(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(input.getBytes());
			return new BigInteger(1, md.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String loadContent(String url) {
		OkHttpClient client = getOkHttpClient();
		Request request = new Request.Builder().get().url(url).build();
		try {
		
			Response response = client.newCall(request).execute();
			if (response.isSuccessful()) {
				return response.body().string();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static boolean isEmpty(String input) {
		
		return input == null || input.length() == 0;
	}
	
	public static boolean write(String content, File file) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.flush();
			writer.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean write(String content, String filename) {
		return write(content, new File(filename));
	}
}
