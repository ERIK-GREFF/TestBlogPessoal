package org.erik.Blog.pessoal.repositorios;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.erik.Blog.pessoal.model.Usuario;
import org.erik.Blog.pessoal.repository.UsuarioRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {

	
	@Autowired
	private UsuarioRepository repository;
	
	@BeforeAll
	void start() {
		Usuario usuario = new Usuario (null, "erik","greff","12345678");
		if(repository.findByUsuario(usuario.getUsuario())==null)
			repository.save(usuario);
	}
	@Test
	public void findByUsuarioRetornaUsuario() throws Exception{
		
		Usuario usuario = repository.findByUsuario("greff").get();
		assertTrue(usuario.getUsuario().equals("greff"));
	}
	@AfterAll
	public void end() {
	repository.deleteAll();
	}
}