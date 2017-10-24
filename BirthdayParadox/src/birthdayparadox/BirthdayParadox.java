package birthdayparadox;

public class BirthdayParadox
{
    private int placedBdays[][];
    private int numberOfDays[];

    private void init()
    {
        numberOfDays = new int[12];
        numberOfDays[0] = 31;
        numberOfDays[1] = 29;
        numberOfDays[2] = 31;
        numberOfDays[3] = 30;
        numberOfDays[4] = 31;
        numberOfDays[5] = 30;
        numberOfDays[6] = 31;
        numberOfDays[7] = 31;
        numberOfDays[8] = 30;
        numberOfDays[9] = 31;
        numberOfDays[10] = 30;
        numberOfDays[11] = 31;

        // init rows of placedBdays
        placedBdays = new int[12][];

        // init columbs of each row
        for (int i = 0; i < placedBdays.length; i++)
        {
            placedBdays[i] = new int[numberOfDays[i]];
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

    public BirthdayParadox()
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

        System.out.println("Days  :  |1  |2  |3  |4  |5  |6  |7  |8  |9  |10 |11 |12 |13 |14 |15 |16 |17 |18 |19 |20 |21 |22 |23 |24 |25 |26 |27 |28 |29 |30 |31");
        for (int i = 0; i < placedBdays.length; i++)
        {
            for (int j = 0; j < placedBdays[i].length; j++)
            {
                if (j == 0)
                {
                    if (i < 9)
                        System.out.print("Month " + (i + 1) + "  |" + placedBdays[i][j] + "  |");
                    else
                        System.out.print("Month " + (i + 1) + " |" + placedBdays[i][j] + "  |");
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
    }

    public int[][] getBirthdayMatrix()
    {
        if (this.placedBdays != null)
            return this.placedBdays;
        else
        {
            init();
            return this.placedBdays;
        }
    }
}
