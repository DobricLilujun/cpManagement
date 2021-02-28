package search;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import gnu.io.*;


public class ScanBarcodeListener {
	

	public static final List<String> findPorts() {
		// 获得当前所有可用串口
		Enumeration<CommPortIdentifier> portList = CommPortIdentifier.getPortIdentifiers();
		List<String> portNameList = new ArrayList<String>();
		// 将可用串口名添加到List并返回该List
		while (portList.hasMoreElements()) {
			String portName = portList.nextElement().getName();
			portNameList.add(portName);
			System.out.println(portName);
		}
		return portNameList;
	}
	
	
	 public static void main(String[] args) throws Exception 
    { 
		
		 List<String> portNameList = findPorts();
		 System.out.println(portNameList.size());
    } 
	
}
	 

