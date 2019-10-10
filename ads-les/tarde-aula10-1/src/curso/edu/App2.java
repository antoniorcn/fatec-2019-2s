package curso.edu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App2 {
	public static void main(String[] args) {
		ApplicationContext app = 
				new FileSystemXmlApplicationContext("beans.xml");
		Pessoa p = (Pessoa)app.getBean("pessoa");
		p.falar();
	}
}
