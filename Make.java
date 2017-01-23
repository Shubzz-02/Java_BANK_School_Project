import java.io.*;
class Make extends Raw
{
    private FileWriter FW=null;
    private BufferedWriter BW=null;
    private PrintWriter PW=null;
    int ch;
    String as;
    double amt;
    public void check(String n,String c,String s,int a,String p,String psd)
    {
        for(int i=1001;i>1000;i++)
        {
            as="2500"+String.valueOf(i);
            try
            { 
                FileReader fr=new FileReader(as);
                continue;
            }
            catch(IOException e)
            {
                System.out.println("\t ****Process completed****");
                System.out.println("\n \n Your Account no is: \t***["+as+"]***");
                newAcnt(n,c,s,as,a,p,psd);
                System.out.println("Your Inital Balance is="+"\t 0.00 rupees"+"\n"+"Do yo like to deposit money in your account"+" \n 1 for yes \n 2 for no");
                choice();
                break;
            }
        }
    } 

    private void choice()
    {
        try
        {
            System.out.print("Your choice: \t");
            ch=getInt();
            switch(ch)
            {
                case 1:System.out.print("Enter amount to Deposit \t");
                amt=getDouble();
                Process pr=new Process();
                pr.dAw(as,amt,2,null);
                break;
                case 2: cont();
                break;
                default:break;
            }
        }
        catch(Exception e)
        { 
            System.out.println(e.getMessage());
        }
    }

    public void newAcnt(String n,String c,String s,String no,int a,String p,String pa)
    {
        try 
        {
            FW=new FileWriter(no);
            BW=new BufferedWriter(FW);
            PW=new PrintWriter(BW);
            PW.println(pa);
            PW.println(n);
            PW.println(s);
            PW.println(c);
            PW.println(a);
            PW.println(p);
            close();
            super.file(no,'N',0.0);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    private void close()
    {
        try
        {
            PW.close();
            BW.close();
            FW.close();
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}  