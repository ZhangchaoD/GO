/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getid;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


@SuppressWarnings("unused")
public class GetId {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException
    {
        String id="";
        BufferedReader br=null;
        BufferedWriter bw=null;
        BufferedWriter bw1=null;
        String url="";
        String str="";
        String[] strs;
        try 
        {    
            br=new BufferedReader(new FileReader("id.txt"));
            bw1=new BufferedWriter(new FileWriter("error.txt"));
            while((id=br.readLine())!=null)
            {
            	id=id.substring(0, id.length());
            	System.out.println(id);
                bw=new BufferedWriter(new FileWriter(id+".txt"));
                url="http://golr-aux.geneontology.io/solr/select?defType=edismax&qt=standard&indent=on&wt=csv&rows=100000&start=0&fl=id&facet=true&facet.mincount=1&facet.sort=count&json.nl=arrarr&facet.limit=25&hl=true&hl.simple.pre=%3Cem%20class=%22hilite%22%3E&hl.snippets=1000&csv.encapsulator=&csv.separator=%09&csv.header=false&csv.mv.separator=%7C&fq=regulates_closure:%22"
                + "GO:"+id
                + "%22&fq=document_category:%22bioentity%22&fq=taxon_subset_closure_label:%22Viridiplantae%22&fq=type:%22protein%22&fq=source:%22UniProtKB%22&facet.field=source&facet.field=taxon_subset_closure_label&facet.field=type&facet.field=panther_family_label&facet.field=annotation_class_list_label&facet.field=regulates_closure_label&q=*:*";
                str="";
                try 
                {
                    Document doc = Jsoup.connect(url).get();
                    str=doc.text();
                    strs=str.split(" ");
                    for(int i=0;i<strs.length;i++)
                    {
                        String url1="https://www.uniprot.org/uniparc/?query="
                        + strs[i].substring(10, 16)
                        + "&format=fasta&limit=10&sort=score";
                        doc=Jsoup.connect(url1).get();
                        str=doc.text();
                        str=str.replaceAll("", "");
                        if(!Character.isUpperCase(str.charAt(27)))
                            str=str.substring(29, str.length());
                        else
                            str=str.substring(27, str.length());
                        str=">|0\n"+str;
                        bw.write(str);
                        bw.newLine();
                    }
                }
                catch (Exception ex)
                {
                    bw1.write(id);
                    bw1.newLine();
                    System.out.println("Get error");
            /*        bw1.close();*/
                }
                finally
                {
                    try 
                    {
                        if(bw!=null)
                            bw.close();
                    } 
                    catch (IOException ex) 
                    {
                        Logger.getLogger(GetId.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } catch (Exception ex) 
        {
            bw1.write(id);
            bw1.newLine();
            bw1.close();
        }
        // TODO code application logic here   
    }
}
