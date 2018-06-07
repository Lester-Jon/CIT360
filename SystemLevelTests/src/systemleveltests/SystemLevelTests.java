/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemleveltests;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Jon
 */
public class SystemLevelTests {

    
    public static void main(String[] args) throws MalformedURLException, IOException {
        //Positive 200 response code
        URL url = new URL("https://lester-jon.github.io/students.txt");
        //Negative Response 404
        URL url1 = new URL("https://lester-jon.github.io/students.tx");
        //HTML response not JSON
        URL url2 = new URL("https://lester-jon.github.io/");
        testUrlConnection(url);
        testUrlConnection(url1);
        testUrlConnection(url2);
    }
    public static void testUrlConnection(URL url) throws IOException{
        
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        int resp = connection.getResponseCode();
        
        if (resp == 200){

            InputStream input = new BufferedInputStream(connection.getInputStream());
            BufferedReader read = new BufferedReader( new InputStreamReader(input));
            StringBuffer text = new StringBuffer();
            
            String first = read.readLine();
            if (first.equals("[")){
                text.append(first);
                for ( String line; (line = read.readLine()) != null;) text.append(line); 
                 read.close();
                 String output = text.toString();
                 System.out.println("Connection Successful To Url " + url + "JSON file contains: \n" + output);
            } else {
                System.out.println("Connection succesful to URL " + url + " , but response is not a JSON file as expected");
            }
            
        } else {
            System.out.println("Unable to connect to Url " + url + " recieved response code " + resp);
        }
    }
}
