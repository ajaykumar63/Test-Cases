import java.io.*;
class StrAsc
{
  public static void main(String ar[])throws IOException
  {
    String S[]=new String[5];
    String t=new String();
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    for(int i=0;i<5;i++)
    {
      System.out.println("\n \t Enter the string="+i);
      S[i]=br.readLine();
    }
    for(int i=0;i<5;i++)
    {
      for(int j=i+1;j<5;j++)
      {
        if(S[i].compareToIgnoreCase(S[j])>0)
        {
           t=S[i];
           S[i]=S[j];
           S[j]=t;
        }
       }
     }
     for(int i=0;i<5;i++)
     {
       System.out.println("\n \t"+S[i]);
      }
   }
}
  