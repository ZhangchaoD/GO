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
import java.util.HashMap;
import java.util.Map;


public class RemoveDuplicate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException 
    {
        // TODO code application logic here
        Map<String,Integer> map=new HashMap<String,Integer>();
        BufferedReader br=null;
        BufferedWriter bwD=null;   //duplicate  
        BufferedWriter bwN=null;  //Non-duplicate 
        String fileName;
        String number;
        String dupliFile;
        String nDupliFile;
        String line;
        Integer times;
        for(int i=1;i<=44;i++)
        {
            fileName=String.valueOf(i)+".txt";
            try 
            {
                br=new BufferedReader(new FileReader(fileName));
                while((line=br.readLine())!=null)  //read file
                {
                    line=br.readLine();  //only use even lines
                    times=map.get(line);
                    if(times==null)
                        map.put(line, 1);
                    else
                        map.put(line, times+1);
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
        for(int i=1;i<=44;i++)
        {
            number=String.valueOf(i);
            fileName=number+".txt";
            dupliFile=number+"d.txt";
            nDupliFile=number+"nd.txt";
            try 
            {
                br=new BufferedReader(new FileReader(fileName));
                bwD=new BufferedWriter(new FileWriter(dupliFile));
                bwN=new BufferedWriter(new FileWriter(nDupliFile));
                while((line=br.readLine())!=null)  //read file
                {
                    line=br.readLine();  //only use even lines
                    if(map.get(line)==1)
                    {    
                        bwN.write(">|"+number+"\n");
                        bwN.write(line+"\n");
                    }
                    else
                    {
                        bwD.write(">|"+number+"\n");
                        bwD.write(map.get(line)+" "+line+"\n");                        
                    }
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
                bwN.close();
                bwD.close();
            }
        }
        
    }
    
}
