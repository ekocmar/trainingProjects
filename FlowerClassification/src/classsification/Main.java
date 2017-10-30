/**
 * 
 */
package classsification;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DecimalFormat;
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
        String mDataFilePath = "resources\\data.txt";
        ArrayList<Iris> mDataArr = readFromFile(mDataFilePath);
        String tDataFilePath = "resources\\testdata.txt";
        ArrayList<Iris> tDataArr = readFromFile(tDataFilePath);
        // printDataList(mDataArr);

        ArrayList<Iris> cDataArr = new ArrayList<Iris>();
        for (Iris tIris : tDataArr)
        {
            if (tIris.calculateClass(mDataArr, 3).equalsIgnoreCase(Setosa.class.getSimpleName()))
            {
                Setosa setosa = new Setosa(tIris);
                cDataArr.add(setosa);
            }
            else if (tIris.calculateClass(mDataArr, 3).equalsIgnoreCase(Versicolor.class.getSimpleName()))
            {
                Versicolor versicolor = new Versicolor(tIris);
                cDataArr.add(versicolor);
            }
            else if (tIris.calculateClass(mDataArr, 3).equalsIgnoreCase(Virginica.class.getSimpleName()))
            {
                Virginica virginica = new Virginica(tIris);
                cDataArr.add(virginica);
            }
        }
        // printDataList(cDataArr);
        DecimalFormat df = new DecimalFormat("#.##");
        for (Iris iris : tDataArr.get(0).getClosestIrisList(mDataArr, 3))
        {
            System.out.println(iris.printAttributes() + "," + iris.getClass().getSimpleName() + " Distance:" + df.format(tDataArr.get(0).getDistance(iris)));
        }

    }

    public static ArrayList<Iris> readFromFile(String filePath) throws Exception
    {
        ArrayList<Iris> arrListFlowers = new ArrayList<Iris>();
        File f = new File(filePath);

        FileReader fr = new FileReader(f);
        try (BufferedReader br = new BufferedReader(fr))
        {
            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null)
            {
                String[] strArray = sCurrentLine.split(",");
                double[] attributes = new double[strArray.length - 1];

                for (int i = 0; i < strArray.length - 1; i++)
                {
                    attributes[i] = Double.valueOf(strArray[i]);
                }

                if (strArray[strArray.length - 1].equalsIgnoreCase("Iris-setosa"))
                {
                    Setosa s = new Setosa(attributes);
                    arrListFlowers.add(s);
                }
                else if (strArray[strArray.length - 1].equalsIgnoreCase("Iris-versicolor"))
                {
                    Versicolor v = new Versicolor(attributes);
                    arrListFlowers.add(v);
                }
                else if (strArray[strArray.length - 1].equalsIgnoreCase("Iris-virginica"))
                {
                    Virginica virg = new Virginica(attributes);
                    arrListFlowers.add(virg);
                }
                else if (strArray[strArray.length - 1].equalsIgnoreCase("Iris"))
                {
                    Iris iris = new Iris(attributes);
                    arrListFlowers.add(iris);
                }
            }
        }

        return arrListFlowers;
    }

    private static void printDataList(ArrayList<Iris> arrayToPrint)
    {
        for (int i = 0; i < arrayToPrint.size(); i++)
        {
            System.out.print((i + 1) + ".item:");
            for (double d : arrayToPrint.get(i).getAttributes())
            {
                System.out.print(d + ",");
            }
            System.out.println("Iris-" + arrayToPrint.get(i).getClass().getSimpleName().toLowerCase());
        }
    }
}
