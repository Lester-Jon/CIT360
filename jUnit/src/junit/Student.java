/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junit;

/**
 *
 * @author Jon
 */
public class Student {
    
    static String name;
    static int studentID;
    static int[] classlist;
    public static int setStudentID;
    
    public static String setUsername(String username) {
        name = username;
        return name;
    }

    public static int setStudentID(int studentID) {
        Student.studentID = studentID;
        return Student.studentID;
    }

    public static int[] updatedClasses(int[] classlist) {
        Student.classlist = classlist;
        return Student.classlist;
    }

    public static boolean isRegistered(int[] classlist, int classNum) {
        boolean test = false;
        for(int i = 0; i < classlist.length; i++ ){
            if (classlist[i] == classNum){
            test = true;
        }
        }
       return test;     
    }

    public static String searchUsername(int studentID) {
        Student.studentID = 12345;
        if ( Student.studentID == studentID) {
            Student.name = "Jon Lester";
        } else {
            Student.name = null;
        }
        return Student.name;
    }
    
}

   