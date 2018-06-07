/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package httpurlconnection;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Jon
 */


public class HttpUrlConnection {

    /**
     * @param args the command line arguments
     */
    private static SessionFactory db;
    
    public static void main(String[] args) throws MalformedURLException, IOException, ParseException {
        URL url = new URL("https://lester-jon.github.io/students.txt");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        try {
                db = (SessionFactory) new Configuration()
                        .configure()
                        .addAnnotatedClass(Student.class)
                        .buildSessionFactory();
            } catch (Throwable e) {
                
                System.err.println("Failed to connect due to " + e);               
            }
        
        try {
            InputStream input = new BufferedInputStream(connection.getInputStream());
            BufferedReader read = new BufferedReader( new InputStreamReader(input));
            StringBuffer text = new StringBuffer();
            
            for ( String line; (line = read.readLine()) != null;) text.append(line); 
             read.close();
            String output = text.toString();
            
            Object obj = new JSONParser().parse(output);
            System.out.println();
            
           
           JSONArray users = (JSONArray) obj;
            
            System.out.println("Current Users:");
            users.forEach(test -> parseUsername((JSONObject) test));
        } finally {
            connection.disconnect();
        }
        db.close();
    }
    
    
    
    private static void parseUsername(JSONObject jsonObject) {
        addStudent((String) jsonObject.get("user"), (String) jsonObject.get("name"), (String) jsonObject.get("className"));
    }
    
    public static void addStudent(String user, String name, String className){
        
        Session session = db.openSession();
        Transaction t = null;
        try{
            t = session.beginTransaction();
            Student stu = new Student(user, name, className);
            session.save(stu);
            t.commit();
        } catch (HibernateException e) {
            
        } finally {
            session.close();
        }

    }
}
