import java.util.*;
import java.io.*;
class Strtoken
{
public static void main(String a[])throws IOException
{
String s=new String();
int sum=0;
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
System.out.println("enter the string");
s=br.readLine();
StringTokenizer st=new StringTokenizer(s,"  ");
while(st.hasMoreTokens())
{
int i=Integer.parseInt(st.nextToken());
sum=sum+i;
}
System.out.println("the value of sum="+sum);
}
}
