package search.outil;

import java.util.Map;
import java.util.TooManyListenersException;

import gnu.io.*;
import search.commonUtil;

public class SerialRead {
	public static void StartReading(String portNum) throws TooManyListenersException, NoSuchPortException, PortInUseException, UnsupportedCommOperationException {
        //获得系统端口列表
        SerialTool.getSerialPortList();
        //开启端口COM7，波特率9600，根据自己的情况更改
        final SerialPort serialPort = SerialTool.openSerialPort(portNum, 9600);
        //设置串口的listener
        SerialTool.setListenerToSerialPort(serialPort, new SerialPortEventListener() {
            @Override
            public void serialEvent(SerialPortEvent arg0) {
            	// 解决数据断行
                try {
                    Thread.sleep(25);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(arg0.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
                	// 数据通知
                    byte[] bytes = SerialTool.readData(serialPort);
                    System.out.println("收到的数据长度："+bytes.length);
                    System.out.println("收到的数据："+ new String(bytes));
                    commonUtil.qrCodeData = new String(bytes);
                }
            }
        });
        
	}
	
	public static void ScanOpen(String PortNum) throws TooManyListenersException, NoSuchPortException, PortInUseException, UnsupportedCommOperationException {
        //获得系统端口列表
        SerialTool.getSerialPortList();
        //开启端口COM7，波特率9600，根据自己的情况更改
        final SerialPort serialPort = SerialTool.openSerialPort(PortNum, 9600);
        //设置串口的listener
        commonUtil.areaPrint("成功与扫码仪通信！");
        commonUtil.areaPrint("可以进行扫描啦！");
        SerialTool.setListenerToSerialPort(serialPort, new SerialPortEventListener() {
            @Override
            public void serialEvent(SerialPortEvent arg0) {
            	// 解决数据断行
                try {
                    Thread.sleep(25);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(arg0.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
                	// 数据通知
                    byte[] bytes = SerialTool.readData(serialPort);
//                    System.out.println("收到的数据长度："+bytes.length);
                    commonUtil.log.printInfo("收到的数据长度："+bytes.length);
                    String msg = new String(bytes);
                    commonUtil.QrString = msg;
//                    System.out.println("收到的数据："+ msg);
                    commonUtil.log.printInfo("该数据需要被加密，以保护客户的信息 安全！");
                    commonUtil.log.printInfo("收到的数据是，加密后 ："+ msg);
                    try {
						POI.getQrCodeMsg(msg);
						commonUtil.rep.ifAutoComplete(commonUtil.rep);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						commonUtil.areaPrint("读取错误！");
						e.printStackTrace();
						commonUtil.log.printErr(e.toString());
						
					}
//                    commonUtil.log.printInfo("收到的数据解密后是下面所示的信息： 需要在最后发布版 进行封闭，不能打出LOG！ ");
//                	for (Map.Entry<String,Object> entry :commonUtil.resultMap.entrySet()) {
//						System.out.println(entry.getKey()+" : "+entry.getValue());
//						 commonUtil.log.printInfo(entry.getKey()+" : "+entry.getValue());
//					}
                }
                try {
					POI.getQrCodeMsg(commonUtil.QrString);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
	}
    public static void main(String[] args) 
    		throws TooManyListenersException, NoSuchPortException, PortInUseException, UnsupportedCommOperationException {
        //获得系统端口列表
        SerialTool.getSerialPortList();
        //开启端口COM7，波特率9600，根据自己的情况更改
        final SerialPort serialPort = SerialTool.openSerialPort("COM7", 9600);
        //设置串口的listener
        SerialTool.setListenerToSerialPort(serialPort, new SerialPortEventListener() {
            @Override
            public void serialEvent(SerialPortEvent arg0) {
            	// 解决数据断行
                try {
                    Thread.sleep(25);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(arg0.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
                	// 数据通知
                    byte[] bytes = SerialTool.readData(serialPort);
                    System.out.println("收到的数据长度："+bytes.length);
                    String msg = new String(bytes);
                    System.out.println("收到的数据："+ msg);
                    try {
						POI.getQrCodeMsg(msg);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                	for (Map.Entry<String,Object> entry :commonUtil.resultMap.entrySet()) {
						System.out.println(entry.getKey()+" : "+entry.getValue());
					}
                }
            }
        });
    }
}
