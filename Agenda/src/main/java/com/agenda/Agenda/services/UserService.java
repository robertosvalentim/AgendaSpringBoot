package com.agenda.Agenda.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agenda.Agenda.models.User;
import com.agenda.Agenda.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findUserById(Long id) {
        Optional<User> user = this.userRepository.findById(id);

        return user.orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
    }

    @Transactional
    public User createUser(User obj) {
        obj.setId(null);
        obj = this.userRepository.save(obj);
        return obj;
    }

    @Transactional
    public User update(User obj) {
        User newObj = findUserById(obj.getId());
        
        newObj.setAddress(obj.getAddress());
        newObj.setCity(obj.getCity());
        newObj.setState(obj.getState());
        newObj.setEmail(obj.getEmail());
        newObj.setPhone(obj.getPhone());
        newObj.setName(obj.getName());

        return this.userRepository.save(newObj);
    }

    public void delete(Long id){
        User obj = findUserById(id);
        try {
            this.userRepository.delete(obj);
        } catch (Exception e) {
            throw new RuntimeException("Não foi possivel excluir o usuário!");
        }
    }
}
