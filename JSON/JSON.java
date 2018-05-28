/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

/**
 *
 * @author Jon
 */
public class JSON {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        //Parse JSON File
        Object obj = new JSONParser().parse(new FileReader("C:\\Users\\Jon\\Documents\\NetBeansProjects\\JSON\\src\\json\\Employees.txt"));
        //Add File to users array
        JSONArray users = (JSONArray) obj;
        //Iterate All Users in the file
        System.out.println("Current Users:");
        users.forEach(test -> parseUsername((JSONObject) test));
        //Create New JSON "user"
        JSONObject user = new JSONObject();
        user.put("user", "dlester");
        user.put("pw", "123456789");
        user.put("department", "IT");
        //Write New JSON USer to file
        users.add(user);
        try (FileWriter write = new FileWriter("C:\\Users\\Jon\\Documents\\NetBeansProjects\\JSON\\src\\json\\Employees-after.txt")){
             write.write(users.toJSONString());
             write.flush();
             System.out.println("Wrote new user to file");
        } catch (IOException e) {
            e.printStackTrace();
        }
        obj = new JSONParser().parse(new FileReader("C:\\Users\\Jon\\Documents\\NetBeansProjects\\JSON\\src\\json\\Employees-after.txt"));
        //Add File to users array
        JSONArray newUsers = (JSONArray) obj;
        //Iterate All Users in the file
        System.out.println("Updated Users:");
        newUsers.forEach(test -> parseUsername((JSONObject) test));        
        }
        
    private static void parseUsername(JSONObject jsonObject) {
        String user = (String) jsonObject.get("user");
        System.out.println(user);
    }
        
 
        
        
}
    
