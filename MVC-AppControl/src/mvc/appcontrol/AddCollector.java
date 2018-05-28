/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.appcontrol;

import java.util.Scanner;



/**
 *
 * @author Jon
 */
public class AddCollector implements Collector {
    

            
    AddCollector(){
        AppCtrl appctrl;   
        appctrl = MVCAppControl.getAppCtrl();
        AppCtrl.mapCollectors("1", this);
        
    }

    @Override
    public void collect() {
        
        AddView addView = new AddView();
        addView.display();
        boolean done = false; // set flag to not done
        do {
            
            String value = this.getInput();
            if (value.toUpperCase().equals("Q")) // user wants to quit
                return; // exit the Program
            
            // do the requested action and display the next view
            done = this.doAction(value);
        } while (!done);
    }

    @Override
    public String getInput() {
        Scanner keyboard = new Scanner(System.in); //keyboard input stream
        String value = "";
        boolean valid = false; //set flag to invalid value entered

        while(!valid) { // while a valid name has not been retrieved
        
            

            value = keyboard.nextLine(); //get the name from the keyboard
            value = value.trim(); //trim off the excess blanks
            value = value.toUpperCase(); // converts to upper case letter
        
            // if the name is invalid (less than one character in length))
            if (value.length() >= 20) {
              System.out.println(
                 "\n*************************************************************"
               + "\n***** Invalid value - the value cannot be more than 20 *****"
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

    private boolean doAction(String value) {
        AddModel addmodel = new AddModel();
        addmodel.add(value);
       return true; 
    }
}

