/**
 * 
 */
package classsification;

/**
 * @author Emrullah Kocmar
 *
 */
public class Setosa extends Iris
{

    /**
     * 
     */
    public Setosa()
    {
        // TODO Auto-generated constructor stub
    }

    /**
     * 
     */
    public Setosa(Iris obj)
    {
        this.setAttributes(obj.getAttributes());
    }

    /**
     * @param attributes
     */
    public Setosa(double[] attributes)
    {
        super(attributes);
        // TODO Auto-generated constructor stub
    }

}
