package cjweb;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fabricadeprogramador.persistencia.dao.UsuarioDAOJPA;

public class TestSpringContext {

	public static void main(String[] args) {

		System.out.println();

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"file:src/main/webapp/WEB-INF/springbeans.xml");

		UsuarioDAOJPA dao = (UsuarioDAOJPA) context.getBean("pepino");

	}

}
