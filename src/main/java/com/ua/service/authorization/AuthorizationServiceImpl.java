package com.ua.service.authorization;

import com.ua.exception.UserUnauthorized;
import com.ua.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.ua.util.ExceptionMessages.UNAUTHORIZED;


@Service
@RequiredArgsConstructor
public class AuthorizationServiceImpl implements AuthorizationService {

    private static final Logger logger = LoggerFactory.getLogger(AuthorizationServiceImpl.class);

    private final UserRepository userRepository;

    @Override
    public void isAuthorize(String username, String password) {
        Optional.ofNullable(userRepository.getUserByUsernameAndPassword(username, password))
                .orElseThrow(() -> {
                    logger.error(UNAUTHORIZED);
                    throw new UserUnauthorized();
                });
    }
}
