/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.appcontrol;

/**
 *
 * @author Jon
 */
class RemoveModel {

    boolean add(String value) {
      boolean check = MVCAppControl.users.remove(value);
      return check;
    }
    
   
}
