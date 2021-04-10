package search;

import java.io.File;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;

public class logSystem {

	private Log infoLogger = LogFactory.getLog("infolog");
	private Log errorLogger = LogFactory.getLog("errorlog");
	
	
//	在这里初始化 日志系统，用于在文件中写入log，具体的配置文件在 file文件下的log4j文件下
	
	public logSystem() throws IOException {
		super();
		File directory = new File("");// 参数为空
        String courseFile = directory.getCanonicalPath();
		System.setProperty ("WORKDIR", courseFile);
		PropertyConfigurator.configure("resource/file/log4j.properties");
		// TODO Auto-generated constructor stub
	}
	
	public void printErr(String info) {
		this.errorLogger.error(info);
	}
	
	public void printInfo(String info) {
		this.infoLogger.info(info);
	}


	public static void main(String[] args) throws IOException {
//		File directory = new File("");// 参数为空
//        String courseFile = directory.getCanonicalPath();
//        System.out.println("path2: "+courseFile);
//		System.setProperty ("WORKDIR", courseFile);
//		PropertyConfigurator.configure("resource/file/log4j.properties");
//		System.out.println("123");	
//		infoLogger.info("写入成功");
//		errorLogger.error("写入失败");
		logSystem log = new logSystem();
		log.printErr("Hello");
		log.printInfo("Hello");
	}

}
