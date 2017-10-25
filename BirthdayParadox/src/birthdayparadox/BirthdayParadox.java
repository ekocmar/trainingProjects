package birthdayparadox;

public class BirthdayParadox
{
    private int placedBdays[][];
    private NumberOfDays numberOfDays;
    private int totalCollision;

    private void init() throws Exception
    {
        numberOfDays = new NumberOfDays();
        // init rows of placedBdays
        placedBdays = new int[12][];

        // init columbs of each row
        for (int i = 0; i < placedBdays.length; i++)
        {
            placedBdays[i] = new int[(numberOfDays.getNumberOfDays())[i]];
        }

        // init first values as 0
        for (int i = 0; i < placedBdays.length; i++)
        {
            for (int j = 0; j < placedBdays[i].length; j++)
            {
                placedBdays[i][j] = 0;
            }
        }
    }

    public BirthdayParadox() throws Exception
    {
        this.init();
    }

    public void calculateBdayParadox(int[] bdays)
    {
        for (int i = 0; i < bdays.length; i++)
        {
            int remaining = bdays[i];
            for (int j = 0; j < this.placedBdays.length; j++)
            {
                if (remaining > placedBdays[j].length)
                {
                    remaining = remaining - placedBdays[j].length;
                }
                else
                {
                    if (remaining == 0)
                    {
                        placedBdays[j][remaining]++;
                        break;
                    }
                    else
                    {
                        placedBdays[j][remaining - 1]++;
                        break;
                    }
                }
            }
        }
        
        for (int i = 0; i < placedBdays.length; i++)
        {
            for (int j = 0; j < placedBdays[i].length; j++)
            {
                if (placedBdays[i][j] > 1)
                {
                    setTotalCollision(getTotalCollision() + (placedBdays[i][j] - 1));
                }
            }
        }
    }

    public void printBirthdayCollision()
    {
        for (int i = 0; i < placedBdays.length; i++)
        {
            for (int j = 0; j < placedBdays[i].length; j++)
            {
                if (placedBdays[i][j] > 1)
                {
                    System.out.println("Month:" + (i + 1) + " Day:" + (j + 1) + " Collision Count:" + placedBdays[i][j]);
                }
            }
        }
    }

    public void printBdayCollasMatrix()
    {

        System.out.println("Days  :  |1  |2  |3  |4  |5  |6  |7  |8  |9  |10 |11 |12 |13 |14 |15 |16 |17 |18 |19 |20 |21 |22 |23 |24 |25 |26 |27 |28 |29 |30 |31 |");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < placedBdays.length; i++)
        {
            for (int j = 0; j < placedBdays[i].length; j++)
            {
                if (j == 0)
                {
                    if (i < 9)
                    {
                        if (placedBdays[i][j] < 10)
                            System.out.print("Month " + (i + 1) + "  |" + placedBdays[i][j] + "  |");
                        else
                            System.out.print("Month " + (i + 1) + "  |" + placedBdays[i][j] + " |");
                    }
                    else
                    {
                        if (placedBdays[i][j] < 10)
                            System.out.print("Month " + (i + 1) + " |" + placedBdays[i][j] + "  |");
                        else
                            System.out.print("Month " + (i + 1) + " |" + placedBdays[i][j] + " |");
                    }
                }
                else
                {
                    if (placedBdays[i][j] < 10)
                        System.out.print(placedBdays[i][j] + "  |");
                    else
                        System.out.print(placedBdays[i][j] + " |");
                }
            }
            System.out.print("\n");
        }
        System.out.println("Total Collusion Count:" + this.getTotalCollision());
    }

    public int[][] getBirthdayMatrix() throws Exception
    {
        if (this.placedBdays != null)
            return this.placedBdays;
        else
        {
            init();
            return this.placedBdays;
        }
    }

    public int getTotalCollision()
    {
        return totalCollision;
    }

    public void setTotalCollision(int totalCollision)
    {
        this.totalCollision = totalCollision;
    }
}
