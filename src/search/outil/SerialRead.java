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
                    commonUtil.QrString = msg;
                    System.out.println("收到的数据："+ msg);
                    try {
						POI.getQrCodeMsg(msg);
						commonUtil.rep.ifAutoComplete(commonUtil.rep);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                	for (Map.Entry<String,Object> entry :commonUtil.resultMap.entrySet()) {
						System.out.println(entry.getKey()+" : "+entry.getValue());
					}
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
