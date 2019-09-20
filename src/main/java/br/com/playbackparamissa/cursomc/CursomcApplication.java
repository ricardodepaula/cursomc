package br.com.playbackparamissa.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.playbackparamissa.cursomc.domain.Categoria;
import br.com.playbackparamissa.cursomc.repositories.CategoriaRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Capacitação profissional com carga horária de 15 a 30 horas");
		Categoria cat2 = new Categoria(null, "Capacitação profissional com carga horária de 31 a 80 horas");
		Categoria cat3 = new Categoria(null, "Capacitação profissional com carga horária a partir de 81 horas");
		Categoria cat4 = new Categoria(null, "Participação Institucional");
		Categoria cat5 = new Categoria(null, "Produção científica/técnica apresentação/publicação de artigos e monografia");
		Categoria cat6 = new Categoria(null, "Produção científica/técnica apresentação/publicação de dissertações");
		Categoria cat7 = new Categoria(null, "Produção científica/técnica apresentação/publicação de teses");
		Categoria cat8 = new Categoria(null, "Capacitação profissional com carga horária inferior a 15 horas");
		Categoria cat9 = new Categoria(null, "Participação em bancas de trabalhos academicos/monitoria/instrutoria");
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9));
		
	}

}
