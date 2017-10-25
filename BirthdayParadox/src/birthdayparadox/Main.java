package birthdayparadox;

public class Main
{

    public static void main(String[] args) throws Exception
    {
        // simulate(100, 10);
        statisticalSimulate(10);
    }

    public static int[] simulate(int numOfEmploye, int simCount) throws Exception
    {
        int results[] = new int[simCount];

        for (int i = 0; i < simCount; i++)
        {
            BirthdayGenerator bdayGen = new BirthdayGenerator(numOfEmploye);
            bdayGen.generateRandomBdays();

            BirthdayParadox bdayParadox = new BirthdayParadox();
            bdayParadox.calculateBdayParadox(bdayGen.getBirthdays());
            // bdayParadox.printBdayCollasMatrix();
            results[i] = bdayParadox.getTotalCollision();
        }

        return results;
    }

    public static void statisticalSimulate(int simCount) throws Exception
    {
        int employee50[] = simulate(50, simCount);
        int employee100[] = simulate(100, simCount);
        int employee500[] = simulate(500, simCount);
        int employee1000[] = simulate(1000, simCount);

        int collisionStatistic[][] = new int[simCount][4];
        double avgArray[] = new double[4];

        // filling the collision Statistic matrix
        for (int i = 0; i < simCount; i++)
        {
            collisionStatistic[i][0] = employee50[i];
            collisionStatistic[i][1] = employee100[i];
            collisionStatistic[i][2] = employee500[i];
            collisionStatistic[i][3] = employee1000[i];
        }

        // calculate average
        for (int i = 0; i < 4; i++)
        {
            int average = 0;
            for (int j = 0; j < simCount; j++)
            {
                average += collisionStatistic[j][i];
            }
            avgArray[i] = ((double) average / (double) simCount);
        }

        // print statistical output
        System.out.println("EmpCnt |50  |100 |500  |1000 |");
        System.out.println("------------------------------");
        for (int i = 0; i < collisionStatistic.length; i++)
        {
            for (int j = 0; j < collisionStatistic[i].length; j++)
            {
                if (j == 0)
                {
                    if (i < 9)
                    {
                        if (collisionStatistic[i][j] < 10)
                            System.out.print("Sim " + (i + 1) + "  |" + collisionStatistic[i][j] + "   |");
                        else
                            System.out.print("Sim " + (i + 1) + "  |" + collisionStatistic[i][j] + "  |");
                    }
                    else
                    {
                        if (collisionStatistic[i][j] < 10)
                            System.out.print("Sim " + (i + 1) + " |" + collisionStatistic[i][j] + "   |");
                        else
                            System.out.print("Sim " + (i + 1) + " |" + collisionStatistic[i][j] + "  |");
                    }
                }
                else
                {
                    if (collisionStatistic[i][j] < 10)
                        System.out.print(collisionStatistic[i][j] + "   |");
                    else
                        System.out.print(collisionStatistic[i][j] + "  |");
                }
            }
            System.out.print("\n");
        }
        System.out.println("------------------------------");
        for (int i = 0; i < avgArray.length; i++)
        {
            if (i == 0)
                System.out.print("Avg    |" + avgArray[i] + " |");
            else
                System.out.print(avgArray[i] + "|");
        }
    }

}
