package com.tech.techblogback.service;

import com.sun.istack.NotNull;
import com.tech.techblogback.dto.req.UsersReqDTO;
import com.tech.techblogback.dto.req.res.UserResDTO;
import com.tech.techblogback.model.Users;
import com.tech.techblogback.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@AllArgsConstructor
@Log4j2
@Service
public class UsersService {


    private final PasswordService passwordService;

    private final UsersRepository usersRepository;

    public UserResDTO createUsers(UsersReqDTO dto){

        if(this.findByPhone(dto.getPhone()).isPresent())
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "Telefone já esta em uso.");

        if(this.findByEmail(dto.getEmail()).isPresent())
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "Email já esta em uso.");

        if(this.findAutenthication(dto.getEmail()).isPresent())
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "Email inválido");

//        this.emailService.findAutenthication(dto.getEmail());

        this.passwordService.newPasswordValidation(dto.getPassword(), dto.getPasswordConfirmation());

            Users users = new Users();
        users.setPassword((dto.getPassword()));
        users.setProfileLink(dto.getProfileLink());
        users.setEmail(dto.getEmail());
        users.setName(dto.getName());
        users.setPhone(dto.getPhone());

        users = this.usersRepository.save(users);

        log.info("usuário cadastrado com sucesso");

        return new UserResDTO(users);
    }

    private Optional<Users> findByEmail(String email){
        return this.usersRepository.findByEmail(email);
    }
    private Optional<Users> findByPhone(String mobile){
        return this.usersRepository.findByPhone(mobile);
    }

    public Optional<Users> findAutenthication(String email) {
        if (email.contains("@")) {
            return Optional.ofNullable(this.usersRepository.findOneByEmail(email));
        }

        throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "Email inválido");
    }


}




