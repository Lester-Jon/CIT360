

import junit.Student;
import junit.framework.TestCase;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertArrayEquals;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jon
 */
public class StudentTest extends TestCase {
    
    String name;
    int studentID;
    int[] classlist;
    
    public StudentTest(String test) {
        super(test);
    }
    
    protected void setUp() throws Exception {
        super.setUp();
        name = "Jon Lester";
        studentID = 12345;
        classlist = new int[2];
        classlist[0] = 360;
        classlist[1] = 495;
        
    }
    
    protected void tearDown() throws Exception {
        super.tearDown();
        name = "";
        studentID = 0;
        classlist = new int[0];
    }
    
    public void testChangeUsername() {
        String expected = "Jon Lester";
        String result = Student.setUsername(name);
        assertSame(expected, result);        
    }
    
    public void testDifferentUsername() {
        String expected = "Jon ester";
        String result = Student.setUsername(name);
        assertNotSame(expected, result);        
    }
    
    public void testSetStudentID() {
        int expected = 12345;
        int result = Student.setStudentID(studentID);
        assertEquals(expected, result);
    }
    
    public void testAdditionalSetStudentID() {
        int result = Student.setStudentID(studentID);
        assertThat(result, is(12345));
    }
    
    public void testUpdateClasses() {
        int[] expected = {360, 495};
        int[] result = Student.updatedClasses(classlist);
        assertArrayEquals(expected, result);
    }
    
    public void testIsRegistered() {
        boolean result = Student.isRegistered(classlist, 360);
        assertTrue(result);
    }
    
    public void testIsntRegistered() {
        boolean result = Student.isRegistered(classlist, 500);
        assertFalse(result);
    }
    
    public void testReturnUsername() {
        String result = Student.searchUsername(studentID);
        assertNotNull(result);
    }
    public void testFailedUsername() {
        String result = Student.searchUsername(1234);
        assertNull(result);
    }
}
