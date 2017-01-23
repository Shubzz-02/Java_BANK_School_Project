import java.io.*;
class Process extends Raw
{
    String nm,s,no,city,age,p,mth,psd;
    double a;
    public void dAw(String no,double x,int c,String no2)
    {
        try
        {
            FileReader FW=new FileReader(no);
            BufferedReader BR=new BufferedReader(FW);
            String text;
            int i=0;
            while((text=BR.readLine())!=null)
            {
                i++;
                if(i==1)
                    psd=text;
                else if(i==2)
                    nm=text;
                else if(i==3)
                    s=text;
                else if(i==4)
                    city=text;
                else if(i==5)
                    age=text;
                else if(i==6)
                    p=text;
                else if(i==7)
                    a=Double.parseDouble(text);

            }
            if(c==2)
            {  
                a=a+x;
                super.file(no,'D',x);
                System.out.println(" \t Transition complete \n Now you have R.S. \t"+a+" \t in your account");
                BR.close();
                FW.close();
                cont();
            }
            else
            {
                if(x>a)
                {
                    if(c==4)
                        System.out.print("You did not have enough money to TRANSFER");
                    else    
                        System.out.println("You did not have enough money to WITHDRAW");
                    BR.close();
                    FW.close();    
                    cont();
                }
                else
                {
                    a=a-x;
                    if(c==3)
                    {
                        super.file(no,'W',x);
                        System.out.println(" \t Transition complete \n Now you have R.S. \t"+a+" \t in your account");
                        BR.close();
                        FW.close();
                        cont();
                    }
                    else
                    {
                        {
                            Transfer t=new Transfer();
                            t.read(no2,x);
                        }
                        super.file2(no,no2,x,'t');
                        System.out.println("Successfully Transfered money to account no:"+no2);
                        super.file2(no,no2,x,'r');
                        System.out.println("Now you have R.S. \t"+a+" \t in your account");
                        BR.close();
                        FW.close();
                        cont();
                    }
                }
            }
            reload(no);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }    

    void reload(String no)
    {
        try 
        {
            FileWriter FW=new FileWriter(no);
            BufferedWriter BW=new BufferedWriter(FW);
            PrintWriter PW=new PrintWriter(BW);
            PW.println(psd);
            PW.println(nm);
            PW.println(s);
            PW.println(city);
            PW.println(age);
            PW.println(p);
            PW.println(a);
            PW.close();
            BW.close();
            FW.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}    