package birthdayparadox;

public class Main
{

    public static void main(String[] args) throws Exception
    {
        simulate(100, 10);
    }

    public static int[] simulate(int numOfEmploye, int simCount) throws Exception
    {
        int results[] = new int[simCount + 1];

        for (int i = 0; i < simCount; i++)
        {
            BirthdayGenerator bdayGen = new BirthdayGenerator(numOfEmploye);
            bdayGen.generateRandomBdays();

            BirthdayParadox bdayParadox = new BirthdayParadox();
            bdayParadox.calculateBdayParadox(bdayGen.getBirthdays());
            bdayParadox.printBdayCollasMatrix();
            results[i] = bdayParadox.getTotalCollision();
        }

        return results;
    }

    public static void statisticalSimulate() throws Exception
    {
        int simCount = 10;
        int employee50[] = simulate(50, simCount);
        int employee100[] = simulate(100, simCount);
        int employee500[] = simulate(500, simCount);
        int employee1000[] = simulate(1000, simCount);

        int collisionStatistic[][] = new int[simCount + 1][4];

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
        }
    }

}
