/**
 * 
 */
package classsification;

/**
 * @author Emrullah Kocmar
 *
 */
public class Iris
{
    double attributes[];

    public double[] getAttributes()
    {
        return attributes;
    }

    public void setAttributes(double[] attributes)
    {
        this.attributes = attributes;
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
}
