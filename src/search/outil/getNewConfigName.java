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
		System.out.println(EncryUtil.encrypt(Protection.getComputerName()));
		
		System.out.println(EncryUtil.encrypt("2021-02-23"));
		System.out.println(EncryUtil.encrypt(EncryUtil.encrypt("lcsxdck,lilujun1971223,潞城市鑫达财会,-1662024723,LAPTOP-LRQIVD86,7,PRINT AND SCAN,2020-02-24")));
		System.out.println(EncryUtil.encrypt("lcsxdck,lilujun1971223,潞城市鑫达财会,-1662024723,LAPTOP-LRQIVD86,7,PRINT AND SCAN,2021-02-24"));
//		System.out.println(EncryUtil.decrypt("77396c912d93f817b3a212d544df04b3f47964cebdc246eeab3085f94260f35259dd481fe20a383a721e7713549b8f7205bd07ce8b350a80cbea80a7e5b827d66343787914caad5ba5f1f54bcd7858b641faeb7e9b4a6693b4cdd48574ba6c2b"));
//		System.out.println("34f8e8b734bb91e6b3a212d544df04b3b31470746fb9508fab3085f94260f35259dd481fe20a383a99e848822071e7de05bd07ce8b350a801111ed149bd8106b6343787914caad5bd49b49c3097fe71441faeb7e9b4a6693687f754ee4f67e8cd80a33bdb4c1c1a5");
		System.out.println(EncryUtil.encrypt("2021-02-01"));
	}

}
