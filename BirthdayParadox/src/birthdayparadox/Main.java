package birthdayparadox;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args) throws Exception
    {
        menu();
    }

    public static void menu() throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int input = -1;
        while (input != 0)
        {
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("Please select an operation by entering operation number:(Enter 0 for exit)");
            System.out.println("1 - Simulate Birthday Paradox (Matrix Presentation)");
            System.out.println("2 - Simulate Birthday Paradox (Statistical)");
            System.out.println("3 - Simulate Random Number Count for Unique Birthdays");
            System.out.println("--------------------------------------------------------------------------");
            String strInput = sc.next();
            input = inputValidate(strInput, sc);
            if (input == 1)
            {
                System.out.println("Please enter the employee count:");
                String strInp = sc.next();
                int empCount = inputValidate(strInp, sc);

                System.out.println("Please enter the simulation count:");
                strInp = sc.next();
                int simCount = inputValidate(strInp, sc);

                simulate(empCount, simCount, true);
            }
            else if (input == 2)
            {
                System.out.println("Please enter the simulation count:");
                String strInp = sc.next();
                int simCount = inputValidate(strInp, sc);

                statisticalSimulate(simCount);

            }
            else if (input == 3)
            {
                System.out.println("Please enter the employee count:");
                String strInp = sc.next();
                int empCount = inputValidate(strInp, sc);
                simulateGeneratingUniqueBdays(empCount);
            }
            else if (input == 0)
            {
                System.out.println("Exited!");
            }
            else
            {
                System.out.println("Please enter a valid input:");
            }

        }
        sc.close();
    }

    private static int inputValidate(String input, Scanner sc)
    {
        int retVal = 0;
        try
        {
            retVal = Integer.valueOf(input);
        }
        catch (Exception ex)
        {
            System.out.println("Please enter a valid input:");
            String newInput = sc.next();
            retVal = inputValidate(newInput, sc);
        }
        return retVal;
    }

    private static int[] simulate(int numOfEmploye, int simCount, boolean print) throws Exception
    {
        int results[] = new int[simCount];

        for (int i = 0; i < simCount; i++)
        {
            BirthdayGenerator bdayGen = new BirthdayGenerator(numOfEmploye);
            bdayGen.generateRandomBdays();

            BirthdayParadox bdayParadox = new BirthdayParadox();
            bdayParadox.calculateBdayParadox(bdayGen.getBirthdays());
            if (print)
                bdayParadox.printBdayCollasMatrix();
            results[i] = bdayParadox.getTotalCollision();
        }

        return results;
    }

    private static void simulateGeneratingUniqueBdays(int size)
    {
        BirthdayGenerator bdayGen = new BirthdayGenerator(size);
        bdayGen.generateUniqueRandomBdyas();
        System.out.println("Generated random number count for " + size + " unique birthday:" + bdayGen.getRandomNumberCount());

    }

    private static void statisticalSimulate(int simCount) throws Exception
    {
        int employee50[] = simulate(50, simCount, false);
        int employee100[] = simulate(100, simCount, false);
        int employee500[] = simulate(500, simCount, false);
        int employee1000[] = simulate(1000, simCount, false);

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
        System.out.println();
    }

}
