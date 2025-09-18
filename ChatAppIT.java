/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package chatapppoe;

import org.junit.Test; // use org.junit.jupiter.api.Test if you're on JUnit 5
import static org.junit.Assert.*; // use org.junit.jupiter.api.Assertions.* for JUnit 5

public class ChatAppIT {

    @Test
    public void testValidUsername() {
        assertTrue(ChatApp.checkUsername("user_name"));
    }

    @Test
    public void testInvalidUsername() {
        assertFalse(ChatApp.checkUsername("user"));       // too short
        assertFalse(ChatApp.checkUsername("username"));   // no underscore
    }

    @Test
    public void testValidPassword() {
        assertTrue(ChatApp.checkPasswordComplexity("Password1!"));
    }

    @Test
    public void testInvalidPassword() {
        assertFalse(ChatApp.checkPasswordComplexity("pass"));        // too short
        assertFalse(ChatApp.checkPasswordComplexity("password1"));   // missing uppercase & special
        assertFalse(ChatApp.checkPasswordComplexity("PASSWORD!"));   // missing lowercase & number
    }

    @Test
    public void testValidPhoneNumber() {
        assertTrue(ChatApp.checkPhoneNumber("+27123456789"));
        assertTrue(ChatApp.checkPhoneNumber("+2787654321"));
    }

    @Test
    public void testInvalidPhoneNumber() {
        assertFalse(ChatApp.checkPhoneNumber("0123456789"));   // no +27
        assertFalse(ChatApp.checkPhoneNumber("+27123"));       // too short
        assertFalse(ChatApp.checkPhoneNumber("+278765432100"));// too long
    }

    @Test
    public void testValidateInput() {
        // ✅ Valid case
        String resultSuccess = ChatApp.validateInput("user_name", "Password1!", "+27123456789");
        assertEquals("SUCCESS", resultSuccess);

        // ❌ Invalid username case
        String resultFail = ChatApp.validateInput("user", "Password1!", "+27123456789");
        assertEquals("Error: Username must contain '_' and be at least 5 characters long.", resultFail);
    }
}




