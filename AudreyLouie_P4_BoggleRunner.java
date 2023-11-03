import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class AudreyLouie_P4_BoggleRunner {
    public static void main(String[] args) throws FileNotFoundException{

        ArrayList user_words = new ArrayList(); // array for user's input
        int point_counter = 0; // counter for score

            Scanner input = new Scanner(System.in);

            // displaying the rules
            System.out.println("-----------------WELCOME TO BOGGLE-----------------");
            System.out.println("Here are the rules:");
            System.out.println("1. Find as many 3 or more letter words as possible on the grid.");
            System.out.println("2. You can move from one letter to another if it is a neighbour (in all directions).");
            System.out.println("3. You cannot reuse a letter in the same position in a word.");
            System.out.println("4. You get points for each word.");
            System.out.println("    3 Letters: 1 point\n    4 Letters: 1 point\n    5 Letters: 2 points\n    6 Letters: 3 points\n    7 Letters: 4 points\n    8 or More Letters: 11 points");
            System.out.println("5. Enter '*' to end the game.\n");
            System.out.println("LET'S BEGIN\n");

            Board boggle_board = new Board(); // creating object

        boggle_board.printBoard(); // displays the Boggle board
        System.out.print("Enter a word: "); // asks user to enter a word
        String word = input.next().toUpperCase(); // takes user's input and makes it all capital letters

        if(word.charAt(0)=='*'){ // displays if user decided to end the game immediately
            System.out.println("Thanks for playing");
            System.out.println("Your scored: " + point_counter + " points");
        }
        else {

            do {

                File file = new File("//Users/audreylouie/IdeaProjects/AudreyLouie_Boggle_P4/src/WordList.txt"); // getting the text file

                Scanner scan = new Scanner(file); // scans through the word file

                Solution check = new Solution(); // creating object
                boolean is_word = false; // variable to see if word is valid

                while (scan.hasNextLine()) { // scans through the word file and returns true if the user's word is on the word list
                    String file_word = scan.nextLine();
                    if (word.equals(file_word)) {
                        is_word = true;
                    }
                }
                if (is_word) {
                    if (word.length() <= 2) { // if user's word is less than 3 letters
                        System.out.println("Words must be 3 letters or more");
                    } else {
                        if (check.is_there(boggle_board.charLayout, word)) { // checks if the word is on the board
                            if (user_words.contains(word)) { // checks if the word was already entered
                                System.out.println("You entered that word already");
                            } else {
                                System.out.println("Word found!");
                                user_words.add(word); // adds word to array list
                                // if statements to calculate the number of points
                                if (word.length() == 3 || word.length() == 4) {
                                    point_counter += 1;
                                }
                                if (word.length() == 5) {
                                    point_counter += 2;
                                }
                                if (word.length() == 6) {
                                    point_counter += 3;
                                }
                                if (word.length() == 7) {
                                    point_counter += 4;
                                }
                                if (word.length() >= 8) {
                                    point_counter += 11;
                                }
                            }
                        } else {
                            System.out.println("You entered an invalid word"); // if it is a word but not on the board this statement is displayed
                        }
                    }
                } else {
                    System.out.println("You entered an invalid word"); // displays statement if it is not a word
                }

                System.out.println("Game total: " + point_counter); // displays total points

                System.out.println(" ");
                boggle_board.printBoard(); // displays Boggle board
                System.out.print("Enter a word: "); // asks user to enter word
                word = input.next().toUpperCase(); // changes user's word to capital letters

                if (word.charAt(0) == '*') { // if the user ends the game
                    System.out.println("Thanks for playing");
                    System.out.println("Your scored: " + point_counter + " points");
                }
            } while (word.charAt(0) != '*'); // do while loop, loops until user ends the game

        }
    }
}
