/**
 * 
 */
package classsification;

import java.util.ArrayList;

/**
 * @author Emrullah Kocmar
 *
 */
public class Iris
{
    private double attributes[];
    private String name;

    public double[] getAttributes()
    {
        return attributes;
    }

    public void setAttributes(double[] attributes)
    {
        this.attributes = attributes;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Iris()
    {

    }

    public Iris(double[] attributes)
    {
        this.attributes = attributes;
    }

    public double getDistance(Iris objToCompare)
    {
        double retVal = 0;

        for (int i = 0; i < getAttributes().length; i++)
        {
            retVal += Math.pow((this.getAttributes()[i] - objToCompare.getAttributes()[i]), 2);
        }

        return retVal;
    }

    public ArrayList<Iris> getClosestIrisList(ArrayList<Iris> irisArray, int k)
    {
        ArrayList<Iris> closestIrisArray = new ArrayList<Iris>();

        double tempDistanceArray[] = new double[k];
        int indexes[] = new int[k];

        for (int i = 0; i < tempDistanceArray.length; i++)
        {
            tempDistanceArray[i] = Double.MAX_VALUE;
        }

        for (Iris iris : irisArray)
        {
            int index = irisArray.indexOf(iris);
            double distance = getDistance(iris);
            placeClosest(tempDistanceArray, indexes, index, distance);
        }

        for (int i = 0; i < tempDistanceArray.length; i++)
        {
            closestIrisArray.add(irisArray.get(indexes[i]));
        }

        return closestIrisArray;
    }

    private void placeClosest(double[] closestArray, int[] indexes, int index, double distance)
    {
        for (int i = 0; i < closestArray.length; i++)
        {
            if (distance < closestArray[i])
            {
                double tempDistance = closestArray[i];
                closestArray[i] = distance;
                int tempIndex = indexes[i];
                indexes[i] = index;
                placeClosest(closestArray, indexes, tempIndex, tempDistance);
                break;
            }
        }
    }

    public String calculateClass(ArrayList<Iris> irisArray, int k)
    {
        String retValue;

        ArrayList<Iris> closestArray = getClosestIrisList(irisArray, k);

        int ranks[] = new int[closestArray.size()];
        int index = 0;
        for (int i = 0; i < closestArray.size(); i++)
        {
            int rank = 0;
            for (int j = 0; j < closestArray.size(); j++)
            {
                if (closestArray.get(i).getClass().getSimpleName().equals(closestArray.get(j).getClass().getSimpleName()))
                {
                    rank++;
                }
            }
            ranks[i] = rank;
        }

        int maxRank = 0;
        for (int i = 0; i < ranks.length; i++)
        {
            if (ranks[i] > maxRank)
            {
                maxRank = ranks[i];
                index = i;
            }
        }

        retValue = closestArray.get(index).getClass().getSimpleName();

        return retValue;
    }

    public String printAttributes()
    {
        String retVal = "";
        for (int i = 0; i < this.getAttributes().length; i++)
        {
            if (i == this.getAttributes().length - 1)
                retVal += this.getAttributes()[i];
            else
                retVal += this.getAttributes()[i] + ",";
        }

        return retVal;
    }

}
