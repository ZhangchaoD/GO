package removeduplicate;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class sample {

	 public static void main(String[] args) throws IOException 
	   {
		 
		 Map<String,List<String>> map=new HashMap<String,List<String>>();
	        BufferedReader br=null;
	        BufferedWriter bw=null; 
	        String fileName;
	        String line;
	        List<String> list;
	  
    try { 
		   br=new BufferedReader(new FileReader("Sample.txt"));
		  while((line=br.readLine())!=null)  //read file
          {
             list=map.get(line);
             if(list==null)
                 list=new ArrayList<String>();
             list.add(br.readLine());
             map.put(line, list);
          }
	  }
		 catch (FileNotFoundException ex) 
         {
             ex.printStackTrace();
         }
         finally
         {
             if(br!=null)
             {
                 br.close();
             }           
         }
	     
        try 
        {
       	 	 String Name;
        	 for(String key : map.keySet())
             {
        		 System.out.println(123);
            	 Name=key.substring(2,key.length()-1);
            	 Name=Name.replace(" ", "_");
            	 bw=new BufferedWriter(new FileWriter(Name+".txt"));
                 list=map.get(key);
            	 for(String lable : list)
	              {
	            	  System.out.println(lable);
	                  bw.write(lable+'\n');
	              }
	               bw.close();
             }
        }
	   catch (FileNotFoundException ex) 
        {
            ex.printStackTrace();
        }
        finally
        {
            bw.close();
        }
	   }
}
      
	   
 