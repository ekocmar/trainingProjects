/**
 * 
 */
package classsification;

/**
 * @author Emrullah Kocmar
 *
 */
public class Versicolor extends Iris
{

    /**
     * 
     */
    public Versicolor()
    {
        // TODO Auto-generated constructor stub
    }

    /**
     * 
     */
    public Versicolor(Iris obj)
    {
        this.setAttributes(obj.getAttributes());
    }

    /**
     * @param attributes
     */
    public Versicolor(double[] attributes)
    {
        super(attributes);
        // TODO Auto-generated constructor stub
    }

}
