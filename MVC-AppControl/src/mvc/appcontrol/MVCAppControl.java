/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.appcontrol;

import java.util.ArrayList;

/**
 *
 * @author Jon
 */
public class MVCAppControl {

    /**
     * @param args the command line arguments
     */
    
    static AppCtrl appCtrl = new AppCtrl();
    public static ArrayList<String> users = new ArrayList();
    

    public static AppCtrl getAppCtrl() {
        return appCtrl;
    }

    public static void setAppCtrl(AppCtrl appCtrl) {
        MVCAppControl.appCtrl = appCtrl;
    }
    
    public static void main(String[] args) {
        users.add("Bob");
        users.add("Sandy");
        appCtrl.start();
    }
    
}
