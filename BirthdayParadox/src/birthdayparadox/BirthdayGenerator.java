package birthdayparadox;

import java.util.Random;

public class BirthdayGenerator
{
    private int birthdays[];
    private Random rand;

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
        this.rand = new Random(System.currentTimeMillis());
        this.birthdays = new int[50];
    }

    public BirthdayGenerator(int size)
    {
        this.rand = new Random(System.currentTimeMillis());
        this.birthdays = new int[size];
    }

    public void generateRandomBdays()
    {
        for (int i = 0; i < this.birthdays.length; i++)
        {
            this.birthdays[i] = rand.nextInt(365);
        }
    }

}
