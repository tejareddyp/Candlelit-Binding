package com.casestudy.webapp;

import com.casestudy.webapp.database.dao.UserDAO;
import com.casestudy.webapp.database.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
@ExtendWith(SpringExtension.class)
public class UserDAOTest {

    @Autowired
    private UserDAO userDAO;

    @Test
    public void testFindByUsernameIgnoreCase() {
        // create
        User user = new User();
        user.setUsername("testUser1");
        user.setFirstName("Jane");
        user.setLastName("Doe");
        user.setEmail("test1@example.com");
        userDAO.save(user);

        // read
        User foundUser = userDAO.findByUsernameIgnoreCase("TESTUSER1");
        assertNotNull(foundUser);
        assertEquals("testUser1", foundUser.getUsername());
        assertEquals("Jane", foundUser.getFirstName());
        assertEquals("Doe", foundUser.getLastName());

        // update
        foundUser.setFirstName("John");
        userDAO.save(foundUser);
        foundUser = userDAO.findByUsernameIgnoreCase("testuser1");
        assertNotNull(foundUser);
        assertEquals("John", foundUser.getFirstName());

        // delete
        userDAO.delete(foundUser);
    }

    @Test
    public void testFindByEmailIgnoreCase() {
        User user = new User();
        user.setUsername("anotherUser1");
        user.setFirstName("Jane");
        user.setLastName("Doe");
        user.setEmail("another1@example.com");
        userDAO.save(user);

        User foundUser = userDAO.findByEmailIgnoreCase("ANOTHER1@EXAMPLE.COM");

        assertNotNull(foundUser);
        assertEquals("another1@example.com", foundUser.getEmail());
        assertEquals("Jane", foundUser.getFirstName());
        assertEquals("Doe", foundUser.getLastName());
        userDAO.delete(foundUser);
    }
}
