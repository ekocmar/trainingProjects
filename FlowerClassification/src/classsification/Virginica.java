/**
 * 
 */
package classsification;

/**
 * @author Emrullah Kocmar
 *
 */
public class Virginica extends Iris
{

    /**
     * 
     */
    public Virginica()
    {
        // TODO Auto-generated constructor stub
    }

    /**
     * 
     */
    public Virginica(Iris obj)
    {
        this.setAttributes(obj.getAttributes());
    }

    /**
     * @param attributes
     */
    public Virginica(double[] attributes)
    {
        super(attributes);
        // TODO Auto-generated constructor stub
    }

}
