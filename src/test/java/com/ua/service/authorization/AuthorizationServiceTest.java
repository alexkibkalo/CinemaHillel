package com.ua.service.authorization;

import com.ua.model.User;
import com.ua.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.ua.service.authorization.util.MockGenerator.generateUser;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AuthorizationServiceTest {

    private AuthorizationService authorizationService;
    private UserRepository userRepository;

    @BeforeEach
    public void setup() {
        userRepository = mock(UserRepository.class);
        authorizationService = new AuthorizationServiceImpl(userRepository);
    }

    @Test
    public void isAuthorizeIfUserExists() {
        // given
        String username = "admin";
        String password = "admin";
        User user = generateUser(username, password);

        // when
        when(userRepository.getUserByUsernameAndPassword(username, password)).thenReturn(user);

        // then
        assertThatCode(() -> authorizationService.isAuthorize(username, password)).doesNotThrowAnyException();

        verify(userRepository).getUserByUsernameAndPassword(username, password);
    }

    @Test
    public void isAuthorizeIfUserDoesntExist() {
        // given
        String username = "invalid";
        String password = "invalid";

        // when
        when(userRepository.getUserByUsernameAndPassword(any(), any())).thenReturn(null);

        // then
        assertThrows(RuntimeException.class, () -> authorizationService.isAuthorize(username, password));

        verify(userRepository).getUserByUsernameAndPassword(any(), any());
    }
}
