package br.com.filhow.paradise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.filhow.paradise.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findOneByEmail(String email);
}
