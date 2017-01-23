import java.io.*;
class Want extends Raw
{
    public void detail(String no)
    {
        try
        {
            String text,psd;
            FileReader FR=new FileReader(no);
            BufferedReader BR=new BufferedReader(FR);
            System.out.print("Enter your Password: \t");
            psd=getString();
            int lpp=0;
            int i=0;
            while((text=BR.readLine())!=null&&lpp==0)
            {
                i++;
                switch(i)
                {
                    case 1:if(text.equalsIgnoreCase(psd))
                    {
                        lpp=0;
                        super.file(no,'A',0.0);
                    }
                    else
                    {
                        lpp=1;
                        Menu.loop=false;
                        System.out.println("\t ****Acess Denied:Wrong Password****");
                    }
                    break;
                    case 2:System.out.println("\nFull Name: \t"+text);
                    break;
                    case 3:System.out.println("Gender: \t"+text);
                    break;
                    case 4:System.out.println("Address: \t"+text);
                    break;
                    case 5:System.out.println("AGE: \t \t"+text);
                    break; 
                    case 6:System.out.println("Phone NO: \t"+text);
                    break;
                    case 7:System.out.println("Balance: \t"+text);
                    lpp=1;
                    break;
                }
            
            }
            BR.close();
            FR.close();
        }
        catch(Exception e)
        {
            System.out.println("INVALID Account Number \n Choose 'New Account' option from main menu for a New Acccount");
            Menu.loop=false;
        }
    }
} 