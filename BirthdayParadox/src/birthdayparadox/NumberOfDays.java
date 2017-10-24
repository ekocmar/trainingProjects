package birthdayparadox;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class NumberOfDays
{
    private int numberOfDays[];
    
    public NumberOfDays() throws Exception
    {
        init();
    }
    
    private void init() throws IOException
    {
        numberOfDays = new int[12];
        File f = new File("resources\\numberofdays.txt");
        FileReader fr = new FileReader(f);
        try(BufferedReader br = new BufferedReader(fr))
        {
            String sCurrentLine;
            int index = 0;
            while((sCurrentLine = br.readLine()) != null)
            {
                this.numberOfDays[index] = Integer.valueOf(sCurrentLine);
                index++;
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            fr.close();
        }
        finally
        {
            fr.close();
        }
    }

    public int[] getNumberOfDays()
    {
        return numberOfDays;
    }

    public void setNumberOfDays(int[] numberOfDays)
    {
        this.numberOfDays = numberOfDays;
    }

    
}
