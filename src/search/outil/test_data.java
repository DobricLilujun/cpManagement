package search.outil;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;


import org.apache.axis.AxisFault;
import javax.xml.namespace.QName;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;



public class test_data {
	public static String url="http://172.6.46.2/jcxws/TmriOutNewAccess.asmx?wsdl";

		public test_data() {
		super();
	}

	
		private TmriJaxRpcOutNewAccessSoapStub stub = null;
		private void ensureStub() throws MalformedURLException, AxisFault{
			if(stub==null){
				String webserviceURL = url;
				URL url = new URL(webserviceURL);
				Service service = new Service();
				stub = new TmriJaxRpcOutNewAccessSoapStub(url, service);
			}
		}
		public String doWrite() throws Exception{
				this.ensureStub();
				String result = "";
				String encrptXmlDoc ="<?xml version=\"1.0\" encoding=\"GBK\"?>\n<root>"
						+"\n<QueryCondition>\n<hphm>晋DUF109</hphm>\n<hpzl>02</hpzl>\n<clsbdh>"
						+"8993</clsbdh>\n<jyjgbh>1400000149</jyjgbh>\n</QueryCondition>\n</root>";
				String jkxlh = 
		"7D1A09090106170400158195E6FCF3E2F28C8AF3828AE6FB868FDEC7D5C2D18CD3D0CFDEB9ABCBBED2B5CEF1CFB5CDB3";
				TmriJaxRpcOutNewAccessLocator services = new TmriJaxRpcOutNewAccessLocator();
				result=stub.queryObjectOutNew("18", jkxlh, "18C49", "510101199001011234","001400000149","","","","172.6.46.103",encrptXmlDoc);
//				result=stub.queryObjectOut("18", jkxlh, "18C49",encrptXmlDoc);
				
				try{
					result = URLDecoder.decode(result, "utf-8");
				}catch(Exception ex){
					ex.printStackTrace();
				}
				System.out.println("机动车检验过程开始信息:"+result);
				return result;
			}
		
		  public static void main(String[] args) 
		    { 
			  test_data t = new test_data();
			  try {
				t.doWrite();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    } 

}
