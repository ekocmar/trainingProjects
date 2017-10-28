/**
 * 
 */
package classsification;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * @author Emrullah Kocmar
 *
 */
public class Main
{

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        ArrayList<Iris> arr = readFromFile();
        System.out.println(arr.size());
    }

    public static ArrayList<Iris> readFromFile() throws Exception
    {
        ArrayList<Iris> arrListFlowers = new ArrayList<Iris>();
        File f = new File("resources\\data.txt");

        FileReader fr = new FileReader(f);
        try (BufferedReader br = new BufferedReader(fr))
        {
            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null)
            {
                String[] strArray = sCurrentLine.split(",");
                double[] attributes = new double[4];

                for (int i = 0; i < strArray.length - 1; i++)
                {
                    attributes[i] = Double.valueOf(strArray[i]);
                }

                if (strArray[4].equalsIgnoreCase("Iris-setosa"))
                {
                    Setosa s = new Setosa(attributes);
                    arrListFlowers.add(s);
                }
                else if (strArray[4].equalsIgnoreCase("Iris-versicolor"))
                {
                    Versicolor v = new Versicolor(attributes);
                    arrListFlowers.add(v);
                }
                else if (strArray[4].equalsIgnoreCase("Iris-virginica"))
                {
                    Virginica virg = new Virginica(attributes);
                    arrListFlowers.add(virg);
                }
            }
        }

        return arrListFlowers;
    }
}
