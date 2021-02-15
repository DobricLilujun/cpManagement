package search;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserController {

	private static Boolean desDecode(String str) {
		String t = EncryUtil.encrypt(str);
		 System.out.println("加密后：" + t);
		t = EncryUtil.decrypt(t);
		 System.out.println("解密后：" + t);
		if (t.equals("perpetual license")) {
			return true;
		} else {
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			String nowDate = format.format(date);
			Integer result = EncryUtil.compareDate(t, nowDate);
			if (result == -1) {
				return false;
			}
		}
		return true;
	}
	
	private static String encode(String str) {
		String t = EncryUtil.encrypt(str);
		return t;
	}
	
	private static String descode(String str) {
		String t = EncryUtil.decrypt(str);
		return t;
	}

	public static void main(String args[]) {
		// private String Key;//读取config文件中的key值
		System.out.println(desDecode("2020-08-21"));
		
		// 解密
	}

	// 加密
	private String desCode(String str) {
		// str为加密的截止日期
		String t = EncryUtil.encrypt(str);
		// System.out.println("加密后：" + t);
		return t;
	}
}
