/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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


public class GetGOList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException 
    {
        // TODO code application logic here
        Map<String,List<String>> map=new HashMap<String,List<String>>();
        BufferedReader br=null;
        BufferedWriter bw=null;  
        String fileName;
        String line;
        List<String> list;
        for(int i=1;i<=43;i++)
        {
            fileName=String.valueOf(i)+".txt";
            try 
            {
                br=new BufferedReader(new FileReader(fileName));
                while((line=br.readLine())!=null)  //read file
                {
                    line=br.readLine();  //only use even lines
                    list=map.get(line);
                    if(list==null)
                        list=new ArrayList<String>();
                    list.add(String.valueOf(i));
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
        }
        try 
        {
            bw=new BufferedWriter(new FileWriter("Sample.txt"));
            for(String key : map.keySet())
            {
                bw.write(">|");
                list=map.get(key);
                for(String lable : list)
                {
                    bw.write(lable+' ');
                }
                bw.write('\n'+key+'\n');
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
