package br.com.playbackparamissa.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.playbackparamissa.cursomc.domain.Categoria;
import br.com.playbackparamissa.cursomc.domain.Item;
import br.com.playbackparamissa.cursomc.repositories.CategoriaRepository;
import br.com.playbackparamissa.cursomc.repositories.ItemRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ItemRepository itemRepository;
	
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
		
		Item i1 = new Item(null,"Curso de Excel", 20);
		Item i2 = new Item(null,"Curso de Direito Constitucional", 40);
		Item i3 = new Item(null,"Curso de Java", 40);
		Item i4 = new Item(null,"Curso de Direito Admministrativo", 90);
		
		cat1.getItens().addAll( Arrays.asList(i1));
		cat2.getItens().addAll( Arrays.asList(i2,i3));
		cat3.getItens().addAll( Arrays.asList(i4));
		
		i1.setCategoria(cat1);
		i2.setCategoria(cat2);
		i3.setCategoria(cat2);
		i4.setCategoria(cat3);
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9));
		itemRepository.saveAll(Arrays.asList(i1,i2,i3,i4));
		
	}

}
