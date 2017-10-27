package birthdayparadox;

import java.util.concurrent.ThreadLocalRandom;

public class BirthdayGenerator
{
    private int birthdays[];
    private int randomNumberCount;

    public int[] getBirthdays()
    {
        return birthdays;
    }

    public void setBirthdays(int[] birthdays)
    {
        this.birthdays = birthdays;
    }

    public BirthdayGenerator()
    {
        this.birthdays = new int[50];
    }

    public BirthdayGenerator(int size)
    {
        this.birthdays = new int[size];
    }

    public void generateRandomBdays()
    {
        for (int i = 0; i < this.birthdays.length; i++)
        {
            this.birthdays[i] = ThreadLocalRandom.current().nextInt(1, 365);
        }
    }

    public void generateUniqueRandomBdyas()
    {
        for (int i = 0; i < this.birthdays.length; i++)
        {
            boolean isComplete = false;
            while (!isComplete)
            {
                int randomBday = ThreadLocalRandom.current().nextInt(1, 365);
                this.randomNumberCount++;
                if (!isElement(randomBday, getBirthdays()))
                {
                    this.birthdays[i] = randomBday;
                    isComplete = true;
                }
            }
        }
    }

    private boolean isElement(int item, int[] array)
    {
        boolean isElement = false;
        for (int i = 0; i < array.length; i++)
        {
            if (item == array[i])
                isElement = true;
        }

        return isElement;
    }

    public int getRandomNumberCount()
    {
        return randomNumberCount;
    }

}
