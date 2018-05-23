import java.io.*;
class A extends Thread
{
  public void run()
  {
    System.out.println("\n \t seat is reserved");
  }
}
class ThreadLife
{
  public static void main(String ar[])throws IOException
  {
    System.out.println("\n \t Start of main()");
    A ob=new A();
    System.out.println("\n \t Current state="+ob.getState());
    ob.start();
    System.out.println("\n \t Current state="+ob.getState());
     System.out.println("\n \t End of main()");
    System.out.println("\n \t Current state="+ob.getState());
  }
}  