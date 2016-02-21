package br.com.filhow.paradise.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.filhow.paradise.dto.UserDTO;
import br.com.filhow.paradise.model.User;
import br.com.filhow.paradise.repository.UserRepository;

@Service
public class UserService {

	@Autowired private UserRepository userRepository;
	
    public User getUserById(long id) {
		return userRepository.findOne(id);
    }

    public User getUserByEmail(String email) {
        return userRepository.findOneByEmail(email);
    }

    public Collection<User> getAllUsers() {
        return userRepository.findAll(new Sort("email"));
    }

    public User create(UserDTO form) {
        User user = new User();
        user.setEmail(form.getEmail());
        user.setPasswordHash(form.getPassword());
//        user.setPasswordHash(new BCryptPasswordEncoder().encode(form.getPassword()));
        user.setRole(form.getRole());
        return userRepository.save(user);
    }
}
