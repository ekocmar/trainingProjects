package birthdayparadox;

public class Main
{

    public static void main(String[] args) throws Exception
    {
        BirthdayGenerator bdayGen50 = new BirthdayGenerator(1000);
        bdayGen50.generateRandomBdays();

        BirthdayParadox bdayParadox = new BirthdayParadox();

        bdayParadox.calculateBdayParadox(bdayGen50.getBirthdays());
        // bdayParadox.printBirthdayCollision();
        bdayParadox.printBdayCollasMatrix();
        
    }

}
