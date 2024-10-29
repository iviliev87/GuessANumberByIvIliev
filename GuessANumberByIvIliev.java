import java.util.Random;
import java.util.Scanner;

public class GuessANumberByIvIliev {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;
        int level = 1;

        while (playAgain) {
            Random randomNumber = new Random();
            int maxRange = level * 100;
            int computerNumber = randomNumber.nextInt(maxRange) + 1;

            System.out.print("Do you want to sweat a little bit and have only 5 tries? (yes/no): ");
            String response = scanner.nextLine();
            boolean limitedTries = response.equalsIgnoreCase("yes");
            int maxTries = limitedTries ? 5 : Integer.MAX_VALUE;
            int attempts = 0;
            boolean playerWon = false;

            while (attempts < maxTries) {
                System.out.print("Guess a number (1-" + maxRange + "): ");
                String playerInput = scanner.nextLine();
                int playerNumber;

                boolean isValid = true;

                for (int i = 0; i < playerInput.length(); i++) {
                    if (playerInput.charAt(i) < 48 || playerInput.charAt(i) > 57) {
                        isValid = false;
                        break;
                    }
                }

                if (isValid) {
                    playerNumber = Integer.parseInt(playerInput);
                    if (playerNumber == computerNumber) {
                        System.out.println("You guessed it!");
                        playerWon = true;
                        break;
                    }   if(computerNumber - playerNumber >= 30) {
                            System.out.println("Too Low");
                        } else if (computerNumber - playerNumber >= 20 && computerNumber - playerNumber <= 29) {
                            System.out.println("Low");
                        } else if (computerNumber - playerNumber >= 10 && computerNumber - playerNumber <= 19) {
                            System.out.println("Closer but Low");
                        } else if (computerNumber - playerNumber < 10 && computerNumber - playerNumber >0) {
                            System.out.println("Almost there but Low");
                        } else if (playerNumber - computerNumber >= 30) {
                            System.out.println("Too High");
                        } else if (playerNumber - computerNumber >= 20 && playerNumber - computerNumber <= 29) {
                            System.out.println("High");
                        } else if (playerNumber - computerNumber >= 10 && playerNumber - computerNumber <= 19) {
                            System.out.println("Closer but High");
                        } else if (playerNumber - computerNumber < 10) {
                            System.out.println("Almost there but High");
                        }
                    } else {
                    System.out.println("Invalid input.");
                }

                attempts++;
                if (attempts == maxTries) {
                    System.out.println("You've reached the maximum number of attempts. The number was: " + computerNumber);
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.nextLine().equalsIgnoreCase("yes");
            if (!playAgain) {
                break;
            }

            if (playerWon) {
                System.out.print("Do you want to go to the next level? (yes/no): ");
                boolean nextLevel = scanner.nextLine().equalsIgnoreCase("yes");
                if (nextLevel) {
                    level++;
                }
            }
        }

        scanner.close();
    }
}