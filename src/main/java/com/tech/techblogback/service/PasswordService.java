package com.tech.techblogback.service;


import lombok.AllArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@AllArgsConstructor
@Service
public class PasswordService {

    private final PasswordEncoder passwordEncoder;

    public String encode(String rawPassword) {
        return this.passwordEncoder.encode(rawPassword);
    }

    public void newPasswordValidation(String newPass, String confirmation) {

        if (StringUtils.isEmpty(newPass))
            throw new ServiceException("A senha deve ser informada.");

        if (StringUtils.isEmpty(confirmation))
            throw new ServiceException("A confirmação da senha deve ser informada.");

        if (StringUtils.containsWhitespace(newPass))
            throw new ServiceException("A senha não pode conter espaços em branco.");

        if (!newPass.equals(confirmation))
            throw new ServiceException("A senha informada está diferente da confirmação da senha.");

        if (newPass.length() < 8)
            throw new ServiceException("A senha deve conter no mínimo 8 caracteres");

    }


}
