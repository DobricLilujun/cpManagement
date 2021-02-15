package search;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;  
import java.io.OutputStreamWriter;  
import java.io.Writer;  
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

import freemarker.template.Configuration;  
import freemarker.template.Template;  
import freemarker.template.TemplateException;  
	  
	public class print
	{
		
//		public static void main(String []args)
//		{
//			print a = new print();
//			a.createDoc();
////		String path="H:\\eclipse_java-workspace\\learn___java\\src\\learn___java\\Module.doc";
//			String path="H:\\eclipse_java-workspace\\learn___java\\src\\learn___java\\Secure_Artfitial.doc";
//	        System.out.println("开始打印");
//	        ComThread.InitSTA();
//	        ActiveXComponent word=new ActiveXComponent("Word.Application");
//	        Dispatch doc=null;
//	        Dispatch.put(word, "Visible", new Variant(false));
//	        Dispatch docs=word.getProperty("Documents").toDispatch();
//	        doc=Dispatch.call(docs, "Open", path).toDispatch();
//	        
//	        try {
//	            Dispatch.call(doc, "PrintOut");//打印
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	            System.out.println("打印失败");
//	        }finally{
//	            try {
//	                if(doc!=null){
//	                    Dispatch.call(doc, "Close",new Variant(0));
//	                }
//	            } catch (Exception e2) {
//	                e2.printStackTrace();
//	            }
//	            //释放资源
//	            ComThread.Release();
//	        }
//	        }
//
		   private Configuration configuration = null;  
		   
		   public print() {  
		  
		      configuration = new Configuration();  
		  
		      configuration.setDefaultEncoding("utf-8");  
		  
		   }  
		  
		   
		  
		   public void createDoc(int flag,LinkedList<String>original,LinkedList<String>newer) 
		   {  
			   Map dataMap = new HashMap();   
			   configuration.setClassForTemplateLoading(this.getClass(),"/search");
		      // 要填入模本的数据文件  
			   if(flag==0)
			   {
				  
				   Template t = null;  
				      try 
				      {  
				         t = configuration.getTemplate("1.ftl");  
				         t.setEncoding("utf-8");  
				      } catch (IOException e) 
				      {  
				         e.printStackTrace();  
				      }  
				      // 输出文档路径及名称   
				      
				      File outFile = new File("result.doc");  
				      Writer out = null;  
				      try {  
				         out = new BufferedWriter(new OutputStreamWriter (  	  
				                new FileOutputStream(outFile), "utf-8"));  

				      } catch (Exception e1) {  	  
				         e1.printStackTrace();  
				      }  
				      try 
				      {  
				    	 
				         t.process(dataMap, out);  
				         out.close();  
				      } catch (TemplateException e) 
				      {  
				         e.printStackTrace();  
				      } catch (IOException e) 
				      {  
				         e.printStackTrace();  
				      }  
				  
			   }
			   else if(flag==1)
			   {
				   dataMap =exchange(original,newer,dataMap);
				   Template t = null;  
				      try 
				      {  
				         t = configuration.getTemplate("2.ftl");  
				   
				         t.setEncoding("utf-8");  
				      } catch (IOException e) 
				      {  
				         e.printStackTrace();  
				      }  
				      // 输出文档路径及名称   
//				      File
				      File outFile = new File("result.doc");  
				      Writer out = null;  
				      try {  
				         out = new BufferedWriter(new OutputStreamWriter (  	  
				                new FileOutputStream(outFile), "utf-8"));  

				      } catch (Exception e1) {  	  
				         e1.printStackTrace();  
				      }  
				      try 
				      {  
				         t.process(dataMap, out); 
				         out.close();  
				      } catch (TemplateException e) 
				      {  
				         e.printStackTrace();  
				      } catch (IOException e) 
				      {  
				         e.printStackTrace();  
				      }  
			
			   }
			   else if(flag==2)
			   {
				   Template t = null;  
				      try 
				      {  
				         t = configuration.getTemplate("3.ftl");  
				         t.setEncoding("utf-8");  
				      } catch (IOException e) 
				      {  
				         e.printStackTrace();  
				      }  
				      // 输出文档路径及名称   
				      File outFile = new File("result.doc");  
				      Writer out = null;  
				      try {  
				         out = new BufferedWriter(new OutputStreamWriter (  	  
				                new FileOutputStream(outFile), "utf-8"));  

				      } catch (Exception e1) {  	  
				         e1.printStackTrace();  
				      }  
				      try 
				      {  
				         t.process(dataMap, out);  
				         out.close();  
				      } catch (TemplateException e) 
				      {  
				         e.printStackTrace();  
				      } catch (IOException e) 
				      {  
				         e.printStackTrace();  
				      }  
			   }
			   else if(flag==3)
			   {
				   Template t = null;  
				      try 
				      {  
				         t = configuration.getTemplate("4.ftl");  
				         t.setEncoding("utf-8");  
				      } catch (IOException e) 
				      {  
				         e.printStackTrace();  
				      }  
				      // 输出文档路径及名称   
				      File outFile = new File("result.doc");  
				      Writer out = null;  
				      try {  
				         out = new BufferedWriter(new OutputStreamWriter (  	  
				                new FileOutputStream(outFile), "utf-8"));  

				      } catch (Exception e1) {  	  
				         e1.printStackTrace();  
				      }  
				      try 
				      {  
				         t.process(dataMap, out);  
				         out.close();  
				      } catch (TemplateException e) 
				      {  
				         e.printStackTrace();  
				      } catch (IOException e) 
				      {  
				         e.printStackTrace();  
				      }  
			   }
			   else
			   {
				   
			   }
		       
		      // 设置模本装置方法和路径,FreeMarker支持多种模板装载方法。可以重servlet，classpath，数据库装载，   
		      // 这里我们的模板是放在com.havenliu.document.template包下面   
		       
		     
		   }  
//		  
//		   
//		  
//		   /** 
//		 
//		    * 注意dataMap里存放的数据Key值要与模板中的参数相对应 
//		 
//		    *  
//		 
//		    * @param dataMap 
//		 
//		    */  
//		  
		   private Map exchange(LinkedList<String> origin,LinkedList<String> newer, Map dataMap) 
		   {  
				   for(int i=0;i<newer.size();i++)
				   {
					   dataMap.put(origin.get(i),newer.get(i));
				   }
			   System.out.println(origin.get(0));
			   
			   return dataMap;
		   }  
		  
		}  