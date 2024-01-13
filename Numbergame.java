import java.util.Scanner;
import java.util.Random;
class Numbergame {
    public static void main(String[] args) {
        System.out.println("INFO: You can guess a random number within 5 chances.");
        System.out.println("If your guess is correct, you will get the score as follows:");
        System.out.println("For the first correct attempt: 5");
        System.out.println("For the second correct attempt: 4");
        System.out.println("For the third correct attempt: 3");
        System.out.println("For the fourth correct attempt: 2");
        System.out.println("For the fifth correct attempt: 1");
        System.out.println("If you are unable to guess the number within 5 chances: 0");
        RandomNumberGenerator obj = new RandomNumberGenerator();
        int attemptsLeft = obj.random();
        int score = 6 - attemptsLeft;
        int randomvalue = obj.getRandomNumber();
        if (score == 6) {
            score = 0;
            System.out.println(" The Random Integer is: " + randomvalue);
        }
        System.out.println("Attempts left: " + attemptsLeft);
        System.out.println(" Points Scored: " + score);
        Scanner sc = new Scanner(System.in);
            System.out.println("If you want to play the game again enter 1 or else enter any number");
            int game = sc.nextInt();
            while (game == 1) {
                attemptsLeft = obj.random();
                score = 6 - attemptsLeft;
                randomvalue = obj.getRandomNumber();
                if (score == 6) {
                score = 0;
                System.out.println(" The Random Integer is: " + randomvalue);
            }
                System.out.println("Attempts left: " + attemptsLeft);
                System.out.println(" Points Scored: " + score);
                System.out.println("If you want to play the game again enter 1 or else enter any number");
                game = sc.nextInt();
            }
        
        System.out.println("Thank you for playing!");
        sc.close();
    }
}


class RandomNumberGenerator {
    private int randomNumber;
    int getRandomNumber() {
        return randomNumber;
    }
    int random() {
        Random random = new Random();
        final int minRange = 1;
        final int maxRange = 100;
        int attempts = 5;
        randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= attempts; i++) {
            System.out.println("Enter the guess number (attempt " + i + "):");
            int guessNumber = sc.nextInt();
            if (guessNumber < minRange || guessNumber > maxRange) {
                System.out.println("Input should be between 1 and 100");
            }
            if (guessNumber < randomNumber) {
                System.out.println("Too low");
            } else if (guessNumber > randomNumber) {
                System.out.println("Too high");
            } else {
                System.out.println("You guessed the number! It is " + randomNumber);
                int correctAttempt = i - 1;
                return correctAttempt;
            }
        }
         return 0;
    }
}
