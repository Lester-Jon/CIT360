/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.appcontrol;

import java.util.HashMap;
import java.util.Scanner;


/**
 *
 * @author Jon
 */
class AppCtrl {
    
    View view = new View();
    AddCollector addCtrl = new AddCollector();
    RemoveCollector removeCollector = new RemoveCollector();

     View getView() {
        return view;
    }
    
    static HashMap<String, Collector> collectorMap = new HashMap();
    public static void mapCollectors(String value, Collector collector) {
        collectorMap.put(value, collector);
    } 
    
    
    void start() {
        boolean done = false; // set flag to not done
        do {
            view.start();
            // prompt for input
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

        while(!valid) { // while a valid input has not been recieved
        
            //prompt for the input

            value = keyboard.nextLine(); //get the name from the keyboard
            value = value.trim(); //trim off the excess blanks
            value = value.toUpperCase(); // converts to upper case letter
        
            // if the input is invalid (less than one character in length))
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
        
   public boolean doAction(String choice) {
        
       Collector aCollector = collectorMap.get(choice);
       if (aCollector != null){
           aCollector.collect();
       }
        return false;
    }     


}
