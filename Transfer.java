import java.io.*;
class Transfer
{
    String nm,psd,gen,ad,ag,ph,text;
    double bal;
    void read(String no,double amnt)
    {
        try
        {
            FileReader FR=new FileReader(no);
            BufferedReader BR=new BufferedReader(FR);
            int i=0;
            while((text=BR.readLine())!=null)
            {
                i++;
                switch(i)
                {
                    case 1:psd=text;
                    break;
                    case 2:nm=text;
                    break;
                    case 3:gen=text;
                    break;
                    case 4:ad=text;
                    break;
                    case 5:ag=text;
                    break; 
                    case 6:ph=text;
                    break;
                    case 7:bal=Double.parseDouble(text)+amnt;
                    break;
                }
            }
            BR.close();
            FR.close();
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
            PW.println(gen);
            PW.println(ad);
            PW.println(ag);
            PW.println(ph);
            PW.println(bal);
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
