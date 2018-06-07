/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package httpurlconnection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
/**
 *
 * @author Jon
 */
@Entity
@Table(name="student", schema="cit360")
public class Student {
    
    
    @Id
    @Column(name="user")
    private String user;
    @Column(name="name")
    private String name;
    @Column (name="className")
    private String className;
    
    public Student(){}

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
    
    public Student(String user, String name, String className){
        this.user = user;
        this.name = name;
        this.className = className;
}
}

