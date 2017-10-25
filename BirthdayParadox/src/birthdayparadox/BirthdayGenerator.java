package birthdayparadox;

import java.util.concurrent.ThreadLocalRandom;

public class BirthdayGenerator
{
    private int birthdays[];

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

}
