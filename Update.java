import java.io.*;
class Update extends Raw
{
    String name,sex,phno,city,age,psd;
    double a;
    public void take(String no)
    {
        try
        {
            FileReader FW=new FileReader(no);
            BufferedReader B=new BufferedReader(FW);
            String text;
            int i=0;
            while((text=B.readLine())!=null)
            {
                i++;
                if(i==1)
                    psd=text;
                else if(i==2)
                    name=text;
                else if(i==3)
                    sex=text;
                else if(i==4)
                    city=text;
                else if(i==5)
                    age=text;
                else if(i==6)
                    phno=text;
                else if(i==7)
                    a=Double.parseDouble(text);
            }
            FW.close();
            B.close();
            account(no);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    void account(String no)throws Exception
    {
        file(no,'U',0.0);
        boolean lc=true;
        do
        {
            System.out.println("What you like to update");
            System.out.println("1.Name");
            System.out.println("2.Age");
            System.out.println("3.Phone no");
            System.out.println("4.Address");
            System.out.println("5.Exit");
            System.out.print("Enter your choice: \t");
            int ch=getInt();
            switch(ch)
            {
                case 1:System.out.print("Enter new Name: \t");
                name=getString();
                break;
                case 2:System.out.print("Enter new Age: \t");
                age=getString();
                break;
                case 3:System.out.print("Enter new Phone no: \t");
                phno=getString();
                break;
                case 4:System.out.print("Enter new Address: \t");
                city=getString();
                break;
                case 5:
                default:lc=false;
                break;
            }
            reload(no);
        }while(lc);
    }

    void reload(String no)
    {
        try 
        {
            FileWriter FW=new FileWriter(no);
            BufferedWriter BW=new BufferedWriter(FW);
            PrintWriter PW=new PrintWriter(BW);
            PW.println(psd);
            PW.println(name);
            PW.println(sex);
            PW.println(city);
            PW.println(age);
            PW.println(phno);
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