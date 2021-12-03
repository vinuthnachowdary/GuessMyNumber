package edu.nwmissouri.guessmynumber;

import javax.swing.*;

/**
 * Java game “Guess a Number” that allows user to guess a random number that has
 * been generated. Uses Swing for GUI
 *
 * Source: https://hackr.io/blog/java-projects
 *
 * jOptionPane:
 * https://docs.oracle.com/javase/7/docs/api/javax/swing/JOptionPane.html
 * .showInputDialog() .showMessageDialog()
 *
 * @author Denise Case
 */
public class GuessingGameDone {

    public static void main(String[] args) {
        int secretNumber = (int) (Math.random() * 100 + 1);
        int userAnswer = 0;
        System.out.println("The correct guess would be " + secretNumber);
        int count = 1;

        while (userAnswer != secretNumber) {
            // TODO: create 3 local variables for the arguments so we know what they mean
            // showInputDialog - the first argument is just null (no parent)
            String message = "Enter a guess between 1 and 100";
            String title = "Guessing Game";
            int messageType = JOptionPane.INFORMATION_MESSAGE;
            String response = JOptionPane.showInputDialog(null, message, title, messageType);
            userAnswer = Integer.parseInt(response);

            JOptionPane.showMessageDialog(null, "" + calculateMessage(userAnswer, secretNumber, count));
            count++;
        }
    }

    public static String calculateMessage(int userAnswer, int computerNumber, int count) {
        String s = (count == 1) ? " guess." : " guesses.";

        if (userAnswer <= 0 || userAnswer > 100) {
            return "Your guess is invalid";
        } else if (userAnswer == computerNumber) {
            return "Correct!\nTotal Guesses: " + count;
        } else if (userAnswer > computerNumber) {
            return "Your guess is too high, try again.\nYou've used " + count + s;
        } else if (userAnswer < computerNumber) {
            return "Your guess is too low, try again.\nYou've used " + count + s;
        } else {
            return "Your guess is incorrect\nTry Number: " + count;
        }
    }
}
