import java.io.*;
import java.util.*;
class Menu extends Raw
{
    private static String name,gen,phno,city,no,psd;
    private static int age;
    private static double amnt;
    static boolean lc=true,loop;
    public static void main(String [] args)    
    {
        do
        {
            Date D=new Date();
            System.out.println("\n \n \t ****************************************");
            System.out.println("\t\t DATE:"+D+"\n");
            System.out.println(" \t \t WELCOME TO THERESIAN BANK");
            System.out.println(" \t \t ********MAIN MENU********");
            System.out.println("\t \t Choose an option");
            System.out.println(" \t 1.New Account");
            System.out.println(" \t 2.My Account");
            System.out.println(" \t 3.Feedback");
            System.out.println(" \t 4.About us");
            System.out.println(" \t 5.Exit");
            Menu.choice();
        }while(Menu.lc);
    }

    public static void newAcnt()  
    {
        try
        {
            System.out.println("\t \t Processing");
            System.out.println("\t \t ########LOADING########");
            System.out.print("***Enter a password for your account:\t");
            psd=getString();
            System.out.println("Enter your Details");
            System.out.print("Full Name: \t ");
            name=getString();
            System.out.print("Age: \t ");
            age=getInt();
            System.out.print("Gender: \t");
            gen=getString();
            System.out.print("Phone no.: \t");
            phno=getString();
            System.out.print("Address: \t");
            city=getString();
            Make M=new Make();
            M.check(name,city,gen,age,phno,psd);
        }
        catch(IOException e)
        { 
            System.out.print(e.getMessage());
        }
    }

    private static void myAcnt()
    {
        try
        {
            System.out.print("Enter Your Account no: \t");
            no=getString();
            loop=true;
            Want w=new Want();
            w.detail(no);
            while(loop)
            {
                System.out.println(" \n \n \t 1.Update Account");
                System.out.println(" \t 2.Deposit Money");
                System.out.println(" \t 3.Withdraw Money");
                System.out.println(" \t 4.Transfer money");
                System.out.println(" \t 5.My account History");
                System.out.println(" \t 6.Delete Account");
                System.out.println(" \t 7.Main Menu");
                System.out.print(" \t \t Enter your choice:");
                int c=getInt();
                switch(c)
                {
                    case 1:Update u=new Update();
                    u.take(no);
                    break;
                    case 2:System.out.print("Enter amount to Deposit: \t");
                    double dc=getDouble();
                    Process p=new Process();
                    p.dAw(no,dc,2,null);
                    break;
                    case 3:System.out.print("Enter amount to withdraw: \t");
                    double dcw=getDouble();
                    Process po=new Process();
                    po.dAw(no,dcw,3,null);
                    break;
                    case 4:System.out.print("Enter amount to Transfer: \t");
                    double tns=getDouble();
                    System.out.print("Transfer money to account no: \t");
                    String no2=getString();
                    Process tp=new Process();
                    tp.dAw(no,tns,4,no2);
                    break;
                    case 5:getHistory(no);
                    break;
                    case 6:Delete d=new Delete();
                    System.out.println("Are you Sure you want to delete Your Account \n \t Y=yes \t N=no");
                    String ch=getString();
                    if(ch.equalsIgnoreCase("y"))
                    {
                        System.out.print("Enter your Password: \t");
                        psd=getString();
                        d.acnt(no,psd);
                        break;
                    }
                    else if(ch.equalsIgnoreCase("n"))
                        break;
                    case 7:loop=false;
                    break;
                    default:System.out.println("Sorry choice did not exist. Please enter a right one. ");
                    break;
                }
            }
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
        }
    }

    private static void choice()
    {
        try
        {
            System.out.print(" \t \t Enter Your Choice: \t");
            int c=getInt();
            switch(c)
            {
                case 1:Menu.newAcnt();
                break;
                case 2:myAcnt();
                break;
                case 3:System.out.print("Enter your Name: \t");
                String nm=getString();
                System.out.println("Let Us Know About A Broken Feature or rate us");
                System.out.println("Rating 1 to 5"+"\n 1=poor \t 5=Excelent");
                String s;
                s=getString();
                Report r=new Report();
                r.submit(nm,s);
                break;
                case 4:About.us();
                cont();
                break;
                case 5:System.exit(1);
                break;
                default:System.out.println("Sorry choice did not exist. Please enter a right one. ");
                break;
            }
        }
        catch(IOException e)
        {
            System.out.print(e.getMessage());
        }
    }

    public static String raw()throws IOException
    {
        String s=getString();
        s=s.toLowerCase();
        return s;
    }
}
