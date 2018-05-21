/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.appcontrol;

/*
 * @author Jon
 */
class View {
    String display;
    String output;
    String prompt;

    public String getDisplay() {
        return display;
    }
    public void setDisplay(String display) {
        this.display = display;
        System.out.println(this.display);
    }
    public String getOutput() {
        return output;
    }
    public void setOutput(String output) {
        this.output = output;
    }
    
    public String getPrompt() {
        return prompt;
    }
    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }
    
    

    void start() {
        display = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                + "~~~    Welcome to  the User Management System    ~~~\n"
                + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
        prompt  = "~~~     Press to complete the Required Option    ~~~\n"
                + "~~~  1 - Add a new User                          ~~~\n"
                + "~~~  2 - Remove User                             ~~~\n"
                + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
        
        System.out.println(display);
        System.out.println(prompt);
    }
    
    void updateBoth(String display, String prompt) {
        this.display = display;
        this.prompt = prompt;
    }
    
    
}
