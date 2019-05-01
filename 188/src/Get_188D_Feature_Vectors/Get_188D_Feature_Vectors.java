package Get_188D_Feature_Vectors;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintStream;

public class Get_188D_Feature_Vectors
{
  public static void main(String[] args)
  {
    try
    {
      int feaNum = 188;
//      String intputFile = args[0];
//      String outputFile = args[1];
      BufferedWriter bw = null;
      bw = new BufferedWriter(new FileWriter("w.txt"));
      BufferedReader br = new BufferedReader(new FileReader("guasq.txt"));
      
      bw.write("@Relation Protein");
      bw.newLine();
      for (int i = 0; i < feaNum; i++)
      {
        bw.write("@attribute Feature" + (i + 1) + " real");
        bw.newLine();
      }
      for(int n=1;n<=43;n++)
      {bw.write("@attribute Class"+n+" {0,1}");
//      String attributeClass = "{positive,negative}";
//      bw.write(attributeClass);
       bw.newLine();}
      bw.newLine();
      bw.write("@data");
      bw.newLine();
      bw.flush();
      
      String line = br.readLine();
//      System.out.println(line); 
      while (br.ready()) {
        if ((line.length() != 0) && (line.charAt(0) == '>'))
        {
          StringBuffer sb = new StringBuffer();
          line = br.readLine();
//          System.out.println(line); 
//          do
//          {
//            line = br.readLine();
//            if (!br.ready()) 
//            {
//              break;
//            }
//          } while (line.length() == 0);
          while ((line.length() != 0) && (line.charAt(0) != '>'))
          {
            sb.append(line);
           
            if (!br.ready()) {
              break;
            }
            line = br.readLine();
          }
          String seq = sb.toString();
//          System.out.println(seq); 
          Sequence_TO_188D_Features s = new Sequence_TO_188D_Features(seq);
          bw.write(s.run() + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?");
          bw.newLine();
          bw.flush();
        }
        else
        {
          line = br.readLine();
        }
      }
      br.close();
      bw.close();
    }
    catch (Exception ex)
    {
      System.out.print(ex.getMessage());
      System.exit(0);
    }
    System.out.println("success...");
  }
}
