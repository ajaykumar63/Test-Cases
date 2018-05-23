import java.io.*;
class Null
{
public void display()
{
System.out.println("null class");
}
}
class Nullpointer
{
public static void main(String a[])throws IOException
{
Null ob=null;
try
{
ob.display();
}
catch(NullPointerException ne)
{
System.out.println("nullpointerexception="+ne);
}
}
}