package com.ua.service.authorization;

import com.ua.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.ua.util.Exceptions.UNAUTHORIZED;


@Service
@RequiredArgsConstructor
public class AuthorizationServiceImpl implements AuthorizationService {

    private final UserRepository userRepository;

    @Override
    public void isAuthorize(String username, String password) {
        if(!isUserExist(username, password)){
            throw new RuntimeException(UNAUTHORIZED);
        }
    }

    private boolean isUserExist(String username, String password) {
        return userRepository.getUserByUsernameAndPassword(username, password) != null;
    }
}
