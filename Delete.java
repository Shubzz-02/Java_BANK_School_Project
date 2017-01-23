import java.io.*;
class Delete extends Raw
{
    void acnt(String no,String psd)
    {
        try
        {
            String text,name;
            FileReader FR=new FileReader(no);
            BufferedReader BR=new BufferedReader(FR);
            boolean sucess,sd;
            text=BR.readLine();
            name=BR.readLine();
            System.out.print(name);
            BR.close();
            FR.close();
            if(text.equalsIgnoreCase(psd))
            { 
                sucess=(new  File(no)).delete();
                sd=(new File("detail"+no)).delete();
                if(sucess)
                {
                    System.out.println("Account has been successfully deleted");
                    System.out.println("Give a feedback or tell us how we can improve this project");
                    String f=getString();
                    Menu.loop=false;
                    Report R=new Report();
                    R.submit(name,f);
                }
                else
                {
                    System.out.println("An error occured:Try again later");
                }
            }
            else
            {
                System.out.println("Acess Denied:Wrong Password");
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}