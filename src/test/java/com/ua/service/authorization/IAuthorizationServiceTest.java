package com.ua.service.authorization;

import com.ua.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static com.ua.service.authorization.util.MockGenerator.generateUser;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ActiveProfiles("test")
public class IAuthorizationServiceTest {

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private UserRepository userRepository;



    @Test
    public void isAuthorizeWhenUserIsValid(){
        // Arrange
        String username = "admin";
        String password = "admin";
        userRepository.save(generateUser(username, password));

        // Asserts
        assertDoesNotThrow(() -> authorizationService.isAuthorize(username, password));
    }

    @Test
    public void isAuthorizeWhenUserIsInvalid(){
        // Arrange
        String username = "admin";
        String password = "admin";
        String invalidPassword = "invalid";
        userRepository.save(generateUser(username, password));

        // Asserts
        assertThrows(RuntimeException.class, () -> authorizationService.isAuthorize(username, invalidPassword));
    }

    @Test
    public void isAuthorizeWhenUsernameAndPasswordAreEmpty(){
        // Arrange
        String username = "admin";
        String password = "admin";
        String emptyLogin = "";
        String emptyPassword = "";
        userRepository.save(generateUser(username, password));

        // Asserts
        assertThrows(RuntimeException.class, () -> authorizationService.isAuthorize(emptyLogin, emptyPassword));
    }
}
