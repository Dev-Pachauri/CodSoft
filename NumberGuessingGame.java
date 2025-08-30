import java.util.*;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int maxAttempts = 7;  // Limit attempts per round
        int score = 0;        // Track rounds won
        boolean playAgain = true;

        System.out.println("🎮 Welcome to the Number Guessing Game!");
        System.out.println("Guess a number between 1 and 100.");

        while (playAgain) {
            int numberToGuess = rand.nextInt(100) + 1; // 1 to 100
            int attempts = 0;
            boolean guessedCorrectly = false;

            while (attempts < maxAttempts) {
                System.out.print("\nEnter your guess (" + (maxAttempts - attempts) + " attempts left): ");
                int guess = sc.nextInt();
                attempts++;

                if (guess == numberToGuess) {
                    System.out.println("✅ Correct! You guessed the number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    score++;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("📉 Too low!");
                } else {
                    System.out.println("📈 Too high!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("❌ You've run out of attempts. The number was: " + numberToGuess);
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            String response = sc.next().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("\n🏆 Game Over! Your total score (rounds won): " + score);
        sc.close();
    }
}
