package br.com.filhow.paradise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.filhow.paradise.dto.UserDTO;
import br.com.filhow.paradise.model.Role;
import br.com.filhow.paradise.model.User;
import br.com.filhow.paradise.repository.UserRepository;
import br.com.filhow.paradise.service.UserService;


@Component
public class InitComponent implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(InitComponent.class);
	@Autowired private UserRepository repository;
	@Autowired private UserService service;
	
	
	public void run(String... args) {
		
		System.out.println("rodou");
		System.out.println(repository);
//		Role role = new Role(AuthoritiesConstants.ANONYMOUS);
//		roleRepository.save(role);
//		User usuario = new User("Jack", "12345");
		UserDTO newUser = new UserDTO();
		newUser.setEmail("m.filhow@gmail.com");
		newUser.setPassword("123456");
		newUser.setRole(Role.USER);
		User usuario = service.create(newUser);
		System.out.println(usuario.getEmail());
		
		
//		Role role = new Role(AuthoritiesConstants.ANONYMOUS);
//		roleRepository.save(role);
//		List<Role> roles = new ArrayList<>();
//		roles.add(role);
//		usuario.setRoles(roles);
//		repository.save(usuario);
//		List<Role> roles = (List<Role>) usuario.getAuthorities();
//		repository.save(new User("Jack", "12345"));
//		repository.save(new User("Chloe", "54321"));
//		repository.save(new User("Kim", "teste"));
//		repository.save(new User("David", "teste2"));
//		repository.save(new User("Michelle", "teste3"));

		// fetch all customers
		log.info("Customers found with findAll():");
		log.info("-------------------------------");
		for (User user : repository.findAll()) {
			log.info(user.toString());
		}
		log.info("");

		// fetch an individual customer by ID
		User user = repository.findOne(1L);
		log.info("Customer found with findOne(1L):");
		log.info("--------------------------------");
		log.info(user.toString());
		log.info("");

		// fetch customers by last name
		log.info("Customer found with findByLastName('Jack'):");
		log.info("--------------------------------------------");
//		User teste = repository.findOneByUsername("Jack");
//		log.info(teste.toString());
//		String[] kanxa = new String[teste.getRoles().size()];
//		System.out.println(kanxa);
//		for (GrantedAuthority auth : teste.getAuthorities()) {
//			System.out.println(auth.getAuthority());
//		}
//		for (User bauer : repository.findOneByUsername("Jack")) {
//			log.info(bauer.toString());
//		}
		log.info("");
    }
}
