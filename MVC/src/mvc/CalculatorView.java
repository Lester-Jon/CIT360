/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import static java.lang.Integer.parseInt;
import java.util.Scanner;

/**
 *
 * @author Jon
 */
class CalculatorView {
        String display;
        String prompt;
        int num1;
        int num2;
        int result;
    void start() {
        display = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                + "~~~    Welcome to the Quick Use Calculator       ~~~\n"
                + "~~~    Press q to quit at any time               ~~~\n"
                + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
        prompt  = "~~~     Press to select your Required Option     ~~~\n"
                + "~~~  1 - Add                                     ~~~\n"
                + "~~~  2 - Multiply                                ~~~\n"
                + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";     
        System.out.println(display);
        System.out.println(prompt);
        
        boolean done = false; // set flag to not done
        do {
            // prompt for and get players name
            String value = this.getInput();
            if (value.toUpperCase().equals("Q")) // user wants to quit
                return; // exit the Program
            
            // do the requested action and display the next view
            done = this.doAction(value);
        } while (!done);
    }
    
    public String getInput() {
        Scanner keyboard = new Scanner(System.in); //keyboard input stream
        String value = "";
        boolean valid = false; //set flag to invalid value entered

        while(!valid) { // while a valid name has not been retrieved
        
            //prompt for the player's name

            value = keyboard.nextLine(); //get the name from the keyboard
            value = value.trim(); //trim off the excess blanks
            value = value.toUpperCase(); // converts to upper case letter
        
            // if the name is invalid (less than one character in length))
            if (value.length() >= 2) {
              System.out.println(
                 "\n*************************************************************"
               + "\n***** Invalid value - the value cannot be more than one *****"
               + "\n*************************************************************");
                continue; // and repeat again
            }
            if (value.length() < 1) {
               System.out.println(
                       "\n*****************************************************"
                     + "\n***** Invalid value - the value cannot be blank *****"
                     + "\n*****************************************************");
              continue; // and repeat again
            }
            valid = true; // set flag to end repetition
        }
    
    return value;
}

    public int getNumber(String place) {
        Scanner keyboard = new Scanner(System.in); //keyboard input stream
        String value = "";
        int input = -10;
        boolean valid = false; //set flag to invalid value entered

        while(!valid) { // while a valid name has not been retrieved
            System.out.println(
                  "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                + "~~~    Enter Your " + place + " number                     ~~~\n"
                + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            //prompt for the player's name

            value = keyboard.nextLine(); //get the name from the keyboard
            value = value.trim(); //trim off the excess blanks
            if (value.length() < 1) {
               System.out.println(
                       "\n*****************************************************"
                     + "\n***** Invalid value - the value cannot be blank *****"
                     + "\n*****************************************************");
            continue; // and repeat again
            }
            try {
                input = parseInt(value);
            } catch (Exception e){
            System.out.println(
                       "\n*****************************************************"
                     + "\n***** Error in Parsing Intger from Input        *****"
                     + "\n*****************************************************");
            continue;
            }
            valid = true;
            
                
    }
        return input;
    }
    
    private boolean doAction(String value) {
        switch (value) {
            case "1": {
                   result = MVC.calculatorController.add();
                   this.printResults();
                   return true;
            }
            case "2": {
                   result = MVC.calculatorController.multiply();
                   this.printResults();
                   return true;
            }
            default: {
                return false;
            }
    
            
 }
}

    private void printResults() {
                       System.out.println(
                       "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
                     + "\n~~~~~ Your Result is " + result
                     + "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }


}
