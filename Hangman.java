import java.util.ArrayList;
import java.util.Scanner;

public class Hangman {

    // Method to print the hang man.
    public static void printHangman(int n) {
        if (n == 6) {
            System.out.println(" ______     ");
            System.out.println("|      |    ");
            System.out.println("|           ");
            System.out.println("|           ");
            System.out.println("|           ");
            System.out.println("|           ");
            System.out.println("|           ");
        }
        else if (n == 5) {
            System.out.println(" ______     ");
            System.out.println("|      |    ");
            System.out.println("|      0    ");
            System.out.println("|           ");
            System.out.println("|           ");
            System.out.println("|           ");
            System.out.println("|           ");
        }
        else if (n == 4) {
            System.out.println(" ______     ");
            System.out.println("|      |    ");
            System.out.println("|      0    ");
            System.out.println("|      |    ");
            System.out.println("|           ");
            System.out.println("|           ");
            System.out.println("|           ");
        }
        else if (n == 3) {
            System.out.println(" ______     ");
            System.out.println("|      |    ");
            System.out.println("|      0    ");
            System.out.println("|     /|    ");
            System.out.println("|           ");
            System.out.println("|           ");
            System.out.println("|           ");
        }
        else if (n == 2) {
            System.out.println(" ______     ");
            System.out.println("|      |    ");
            System.out.println("|      0    ");
            System.out.println("|     /|\\  ");
            System.out.println("|           ");
            System.out.println("|           ");
            System.out.println("|           ");
        }
        else if (n == 1) {
            System.out.println(" ______     ");
            System.out.println("|      |    ");
            System.out.println("|      0    ");
            System.out.println("|     /|\\  ");
            System.out.println("|     /     ");
            System.out.println("|           ");
            System.out.println("|           ");
        }
        else if (n == 0) {
            System.out.println(" ______     ");
            System.out.println("|      |    ");
            System.out.println("|      0    ");
            System.out.println("|     /|\\  ");
            System.out.println("|     / \\  ");
            System.out.println("|           ");
            System.out.println("|           ");
        }
    }


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Words obj = new Words();

        char[] alphabet = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',};

        int lives = 6;

        char letter;

        obj.getWord();

        ArrayList<Character> usedLetters = new ArrayList<Character>();

        // Real Word as an array of chars.
        char[] charRealWordArray = new char[(obj.word).length()];

        // Guessed Word as an array of strings.
        String[] stringGuessedWordArray = new String[(obj.word).length()];

        for (int i = 0; i < (obj.word).length(); i++) {
            charRealWordArray[i] = (obj.word).charAt(i); // Sets each element in the Real Word array to each letter in the randomly picked word.
            stringGuessedWordArray[i] = "_"; // Sets each element in the Guessed Word to a "_" to represent the number of letters in the word.
        }

        // Real Word as a string.
        String stringRealWord = String.copyValueOf(charRealWordArray);

        // Guessed Word as a string.
        String stringGuessedWord = String.join("", stringGuessedWordArray);


        // While-loop while the Guessed Word and Real Word are not the same, AND lives are greater than 0.
        while ((!stringGuessedWord.equals(stringRealWord)) && lives > 0) {

            // Updates the Guessed Word string by joining each letter in the Guessed Word array.
            stringGuessedWord = String.join("", stringGuessedWordArray);

            // If the Guessed Word and Real Word are the same, print they won and break out of while-loop.
            if (stringGuessedWord.equals(stringRealWord)) {
                System.out.println("Y O U   W I N !");
                System.out.println("You successfully guessed the word: " + stringRealWord + "!");
                break;
            }

            // Prints the user's current Guessed Word, number of lives, the hangman, and their used letters.
            System.out.println("Current word: " + stringGuessedWord);
            System.out.println("Lives: " + lives);
            printHangman(lives);
            System.out.print("You have used these letters: ");
            for (char c : usedLetters) {
                System.out.print(c + " ");
            }

            // Prompts and stores user's letter.
            System.out.println("\nGuess a letter :)");
            letter = Character.toUpperCase(input.next().charAt(0));

            // Check if the letter is in the alphabet.
            if (String.valueOf(alphabet).contains(String.valueOf(letter))) {

                // Check if the letter is in the Real Word.
                if (stringRealWord.contains(String.valueOf(letter))) {

                    // Cycle through each letter in the Real Word.
                    for (int j = 0; j < (obj.word).length(); j++) {
                        // Check if user's letter is equal to the current letter in the Real Word.
                        if (stringRealWord.charAt(j) == letter) {
                            // Change that index of the Guessed Word from a "_" to the current letter.
                            stringGuessedWordArray[j] = String.valueOf(letter);
                        }
                    }
                    // Add letter to used letters.
                    usedLetters.add(letter);
                }


                // If the user's letter is not in the Real Word.
                else {
                    // Add letter to used letters array list.
                    usedLetters.add(letter);
                    // Take away a life.
                    lives = lives - 1;
                }
            }


            // If the user's letter is not in the alphabet, we don't take away a life.
            else {
            }

            // If user's lives = 0, they lost, print hangman and break out of while-loop.
            if (lives == 0) {
                printHangman(lives);
                System.out.println("G A M E   O V E R");
                System.out.println("The word was: " + stringRealWord + ".");
                break;
            }
        }



    }
}



