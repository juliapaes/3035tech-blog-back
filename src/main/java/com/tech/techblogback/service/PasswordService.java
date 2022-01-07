package com.tech.techblogback.service;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


@NoArgsConstructor
@Service
public class PasswordService {


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
