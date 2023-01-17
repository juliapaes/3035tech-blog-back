package com.tech.techblogback.service;

import com.tech.techblogback.dto.req.UserReqDTO;
import com.tech.techblogback.dto.res.UserResDTO;
import com.tech.techblogback.model.User;
import com.tech.techblogback.repository.UserRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserResDTO create(UserReqDTO dto) {

        User user = new User();

        user.setEmail(dto.getEmail());
        user.setName(dto.getName());
        user.setPhone(dto.getPhone());
        user.setProfileLink(dto.getProfileLink());

        this.userRepository.save(user);

        return new UserResDTO(user);
    }

    public List<UserResDTO> findAll() {
        return this.userRepository.findAll().stream().map(UserResDTO::of).collect(Collectors.toList());
    }

    public User findByIdEntity(Long id) {
        return this.userRepository.findById(id).orElseThrow(() -> new ServiceException("Id não encontrado"));
    }

    public UserResDTO findById(Long id) {
        return UserResDTO.of(this.findByIdEntity(id));
    }

    public UserResDTO update(Long id, UserReqDTO dto) {

        User user = this.findByIdEntity(id);

        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        user.setName(dto.getName());

        if (dto.getProfileLink() != null)
            user.setProfileLink(dto.getProfileLink());

        this.userRepository.save(user);

        return UserResDTO.of(user);
    }

    public void logicalExclusion(Long id) {
        if (!this.userRepository.findById(id).isPresent())
            throw new ServiceException("Usuário não existe");
        this.userRepository.softDelete(id);
    }
}




