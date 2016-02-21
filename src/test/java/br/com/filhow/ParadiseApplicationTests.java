package br.com.filhow;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.filhow.paradise.ParadiseApplication;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ParadiseApplication.class)
@WebAppConfiguration
public class ParadiseApplicationTests {

	@Test
	public void contextLoads() {
	}

}
