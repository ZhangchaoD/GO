/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getgo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class GetGO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException 
    {
        // TODO code application logic here
        String line="";
        BufferedReader br=null;
        BufferedWriter bw=null;
        BufferedWriter bw1=null;
        int times[]=new int[10000000];
        String[] str;
        String id;
        try 
        {    
            br=new BufferedReader(new FileReader("select.txt"));
            bw=new BufferedWriter(new FileWriter("res.txt"));
            bw1=new BufferedWriter(new FileWriter("error.txt"));
            while((line=br.readLine())!=null)
            {
                str=line.split("\\|");
                for(int i=0;i<str.length;i++)
                {
                    if(str[i].length()>=9)
                    {
                        id=str[i].substring(3,10);
                        times[Integer.parseInt(id)]++;   
                    }
                    else
                    {
                        bw1.write(str[i]);
                        bw1.newLine();
                    }
                }
            }
            for(int i=0;i<times.length;i++)
            {
                if(times[i]!=0&&times[i]>1000)
                {
                    bw.write(String.format("%07d", i)+" "/*+times[i]*/);
                    bw.newLine();
                }
            }
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
        finally
        {
            if(bw!=null)
                bw.close();
            if(br!=null)
                br.close();
            if(bw1!=null)
                bw1.close();
        }
    }
    
}
