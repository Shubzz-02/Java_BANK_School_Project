import java.io.*;
import java.util.*;
abstract class Raw
{
    private static FileWriter Fc=null;
    private static BufferedWriter Bc=null;
    private static PrintWriter Pc=null;
    private static InputStreamReader IR=new InputStreamReader(System.in);
    private static BufferedReader BR=new BufferedReader(IR);
    static String File,date,data,text,lp;
    static void file(String no,char c,double amt)throws Exception
    {
        File="detail"+no;
        Fc=new FileWriter(File,true);
        Bc=new BufferedWriter(Fc);
        Pc=new PrintWriter(Bc);
        if(c=='N')
        {
            data="Account made on:\t"+getDate();
            Pc.println(data);
        }
        else if(c=='A')
        {
            data="Account access on:\t"+getDate();
            Pc.println(data);   
        }
        else if(c=='U')
        {
            data="Updated Information of account on:\t"+getDate();
            Pc.println(data);
        }
        else if(c=='D')
        {
            data="Deposited R.S.\t"+amt+"\t on \t"+getDate();
            Pc.println(data);
        }
        else if(c=='W')
        {
            data="Withdraw R.S.\t"+amt+"\t on \t"+getDate();
            Pc.println(data);
        }
        closeFile();
    }

    static void file2(String no,String no2,double amt,char a)throws Exception
    {
        if(a=='t')
        {
            File="detail"+no;
            data="Transfered R.S \t"+amt+"\t on \t"+getDate()+" to "+no2;
        }
        else
        {
          File="detail"+no2;
            data="Received R.S \t"+amt+"\t on \t"+getDate()+" from "+no;
        }
        Fc=new FileWriter(File,true);
        Bc=new BufferedWriter(Fc);
        Pc=new PrintWriter(Bc);
        Pc.println(data);
        Pc.close();
        Bc.close();
        Fc.close();
    }
    
    static String getDate()
    {
        Date D=new Date();
        date=D.toString();
        return date;
    }

    static void closeFile()throws Exception
    {
        Pc.close();
        Bc.close();
        Fc.close();
    }

    static void getHistory(String no)
    {
        try
        {
            File="detail"+no;
            FileReader FW=new FileReader(File);
            BufferedReader BR=new BufferedReader(FW);
            while((text=BR.readLine())!=null)
            {
                System.out.println(text);
            }
            cont();
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
        }
    }

    static void cont()throws IOException
    {
        while(lp==null)
        {
            System.out.print("Press Enter to Continue");
            lp=getString();
        }
    }

    static int getInt()throws IOException
    {
        int a=Integer.parseInt(BR.readLine());
        return a;
    }

    static String getString()throws IOException
    {
        String a=(BR.readLine());
        return a;
    }

    static double getDouble()throws IOException
    {
        double a=Double.parseDouble(BR.readLine());
        return a;
    }

    static char getChar()throws IOException
    {
        char a=(char)(BR.read());
        return a;
    }
}
