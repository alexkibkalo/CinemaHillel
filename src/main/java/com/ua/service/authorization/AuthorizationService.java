package com.ua.service.authorization;

import com.ua.transport.dto.UserIncomeDto;

public interface AuthorizationService {

    boolean login(UserIncomeDto dto);

    void logout(UserIncomeDto dto);

    boolean signup(UserIncomeDto dto);

}
