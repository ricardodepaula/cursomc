package br.com.playbackparamissa.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.playbackparamissa.cursomc.domain.Categoria;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Categoria> listar() {
		Categoria cat1 = new Categoria(1, "Capacitação profissional com carga horária de 15 a 30 horas");
		Categoria cat2 = new Categoria(2, "Capacitação profissional com carga horária de 31 a 80 horas");
		Categoria cat3 = new Categoria(3, "Capacitação profissional com carga horária a partir de 81 horas");
		Categoria cat4 = new Categoria(4, "Participação Institucional");
		Categoria cat5 = new Categoria(5, "Produção científica/técnica apresentação/publicação de artigos e monografia");
		Categoria cat6 = new Categoria(6, "Produção científica/técnica apresentação/publicação de dissertações");
		Categoria cat7 = new Categoria(7, "Produção científica/técnica apresentação/publicação de teses");
		Categoria cat8 = new Categoria(8, "Capacitação profissional com carga horária inferior a 15 horas");
		Categoria cat9 = new Categoria(9, "Participação em bancas de trabalhos academicos/monitoria/instrutoria");
		
		List<Categoria> lista = new ArrayList<>();
		lista.add(cat1);
		lista.add(cat2);
		lista.add(cat3);
		lista.add(cat4);
		lista.add(cat5);
		lista.add(cat6);
		lista.add(cat7);
		lista.add(cat8);
		lista.add(cat9);
		
		return lista;
		
	}

}
