package search;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;  
import java.io.OutputStreamWriter;  
import java.io.Writer;  
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import freemarker.template.Configuration;  
import freemarker.template.Template;  
import freemarker.template.TemplateException;  
	  
	public class print
	{
	   private Configuration configuration = null;  
	   public print() {  
	      configuration = new Configuration();  
	      configuration.setDefaultEncoding("utf-8");  
	  
	   }  
	   
	   public void createDoc(int flag,LinkedList<String>original,LinkedList<String>newer) 
	   {  
		   Map<String, String> dataMap = new HashMap<String, String>();   
		   configuration.setClassForTemplateLoading(this.getClass(),"/search");
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
		   else{}
	     
	   }  

	   private Map<String, String> exchange(LinkedList<String> origin,LinkedList<String> newer, Map<String, String> dataMap) 
	   {  
			   for(int i=0;i<newer.size();i++)
			   {
				   dataMap.put(origin.get(i),newer.get(i));
			   }
		   System.out.println(origin.get(0));
		   
		   return dataMap;
	   }  
		  
		}  