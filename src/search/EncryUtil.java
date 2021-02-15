package search;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 加密解密工具类
 */
public class EncryUtil {
	/**
	 * 使用默认密钥进行DES加密
	 */
	public static String encrypt(String plainText) {
		try {
			return new DES().encrypt(plainText);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 使用指定密钥进行DES解密
	 */
	public static String encrypt(String plainText, String key) {
		try {
			return new DES(key).encrypt(plainText);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 使用默认密钥进行DES解密
	 */
	public static String decrypt(String plainText) {
		try {
			return new DES().decrypt(plainText);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 使用指定密钥进行DES解密
	 */
	public static String decrypt(String plainText, String key) {
		try {
			return new DES(key).decrypt(plainText);
		} catch (Exception e) {
			return null;
		}
	}

	public static int compareDate(String deadLine, String now) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dt1 = df.parse(now);
			Date dt2 = df.parse(deadLine);
			if (dt1.getTime() < dt2.getTime()) {
				// System.out.println("now = "+now);
				// System.out.println("deadLine = "+deadLine);
				// System.out.println("在截止日期前");
				return 1;
			} else if (dt1.getTime() > dt2.getTime()) {
				// System.out.println("在截止日期后");
				return -1;
			} else {
				return 0;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}
}