package birthdayparadox;

public class Main
{

    public static void main(String[] args) throws Exception
    {
        BirthdayGenerator bdayGen = new BirthdayGenerator(1000);
        bdayGen.generateRandomBdays();

        BirthdayParadox bdayParadox = new BirthdayParadox();

        bdayParadox.calculateBdayParadox(bdayGen.getBirthdays());
        // bdayParadox.printBirthdayCollision();
        bdayParadox.printBdayCollasMatrix();
        
    }

}
