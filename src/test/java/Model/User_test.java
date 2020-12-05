package Model;

import org.junit.jupiter.api.Test;
import softwaredesign.sdproject.model.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class User_test {
    private User test_User =new User(1,"radu.cazacu1@gmail.com","1234","null");
    @Test
    void getID(){
        assertEquals(1,test_User.getUserId());
    }
    @Test
    void setID(){
        test_User.setUserId(2);
        assertEquals(2,test_User.getUserId());
    }
    @Test
    void getEmail(){
        assertEquals("radu.cazacu1@gmail.com",test_User.getEmail());
    }
    @Test
    void setEmail(){
        test_User.setEmail("radu0195");
        assertEquals("radu0195",test_User.getEmail());
    }
    @Test
    void getPass(){
        assertEquals("1234",test_User.getPassword());
    }
    @Test
    void setPass(){
        test_User.setPassword("1111");
        assertEquals("1111",test_User.getPassword());
    }
    @Test
    void getPermission(){
        assertEquals("null",test_User.getPermission());
    }
    @Test
    void setPermission(){
        test_User.setPermission("Admin");
        assertEquals("Admin",test_User.getPermission());
    }
}
