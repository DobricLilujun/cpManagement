package search.outil;

import search.EncryUtil;
import search.Protection;
public class getNewConfigName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(EncryUtil.decrypt("daaa6de45db33b29bad8b119195320c4"));
//		Authority
		System.out.println(EncryUtil.encrypt("ONLY FOR PRINT"));
		System.out.println(EncryUtil.encrypt("PRINT AND SCAN"));
		
//		config
		System.out.println(EncryUtil.encrypt("IN ACTIVATION"));
		System.out.println(EncryUtil.encrypt("NOT IN ACTIVATION"));

//		Activation 表示 当前的激活状态： 判断是否是第一次激活
		System.out.println(EncryUtil.encrypt("FIRST TIME"));
		System.out.println(EncryUtil.encrypt("SECONDE TIME OR MORE"));
		System.out.println("------------------");
		System.out.println(Protection.getSerialNumber("C"));
		System.out.println(EncryUtil.encrypt(Protection.getSerialNumber("C")));
		System.out.println(EncryUtil.encrypt("LAPTOP-LRQIVD86"));
		
	}

}
