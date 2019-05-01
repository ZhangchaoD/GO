import java.io.*;

public class TQ
{
	public static void write(BufferedWriter bw,String seq) throws IOException
	{
		seq=seq.replace("*", "");
	    seq=">|0\n"+seq;
		bw.write(seq);
		bw.newLine();
	}
	public static void main(String args[]) throws IOException
	{
		BufferedWriter bw;
		BufferedWriter bw3;
		BufferedReader br1=new BufferedReader(new FileReader("id.txt"));
		BufferedReader br2;
		String id;
		String content="";
		String cid;
		int times=0;
		while((id=br1.readLine())!=null)
		{
			times=0;
			String[] sequence=new String[30];
			String[] orf=new String[30];
			for(int i=0;i<30;i++)
			{
				sequence[i]="";
				orf[i]="";
			}
			br2=new BufferedReader(new FileReader("dg.txt"));
			do
			{
				content=br2.readLine();
				if(content!=null&&times!=0&&content.charAt(0)!='>')
				{
					sequence[times]+=content;
				}
				else if(content==null||content.charAt(0)=='>')
				{
					int index=0;
					if(content==null)
						cid="";
					else
					{
						index=content.indexOf("|");
						cid=content.substring(1, index);
					}
					if(cid.equals(id))
					{
						times++;
						orf[times]=content.substring(index+1,index+5);
					}
					else
					{
						if(times!=0)
						{
							bw=new BufferedWriter(new FileWriter("sq.txt",true));
							if(times==1)
							{
								write(bw,sequence[1]);
							}
							else
							{
								int i=1;
								String max_sq=sequence[1];
								for(;i<=times;i++)
								{
									if(orf[i].equals("orf1"))
										break;
									if(orf[i].length()>max_sq.length())
									{
										max_sq=sequence[i];
									}
									orf[i]="";
								}
								if(i>times)
								{
									write(bw,max_sq);
								}
								else
								{
									write(bw,sequence[i]);
								}
							}
							bw.close();
							break;
						}
						else if(content==null)
						{
							bw=new BufferedWriter(new FileWriter("sq.txt",true));
							bw3=new BufferedWriter(new FileWriter("error.txt",true));
							/*write(bw,"");*/
							bw3.write(id);
							bw3.newLine();
							bw3.close();
							bw.close();
						}
					}
				}
			}while(content!=null);
			br2.close();
		}
		br1.close();
	}
}