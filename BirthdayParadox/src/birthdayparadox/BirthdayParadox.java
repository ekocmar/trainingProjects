package birthdayparadox;

public class BirthdayParadox
{
    int placedBdays[][];
    int numberOfDays[];

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
                else if (remaining == 0)
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
