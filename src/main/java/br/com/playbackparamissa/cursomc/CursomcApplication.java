package br.com.playbackparamissa.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.playbackparamissa.cursomc.domain.Apuracao;
import br.com.playbackparamissa.cursomc.domain.Categoria;
import br.com.playbackparamissa.cursomc.domain.Cidade;
import br.com.playbackparamissa.cursomc.domain.Estado;
import br.com.playbackparamissa.cursomc.domain.Item;
import br.com.playbackparamissa.cursomc.domain.ItemSolicitacao;
import br.com.playbackparamissa.cursomc.domain.Local;
import br.com.playbackparamissa.cursomc.domain.Servidor;
import br.com.playbackparamissa.cursomc.domain.Solicitacao;
import br.com.playbackparamissa.cursomc.domain.enums.Cargo;
import br.com.playbackparamissa.cursomc.domain.enums.EstadoApuracao;
import br.com.playbackparamissa.cursomc.repositories.ApuracaoRepository;
import br.com.playbackparamissa.cursomc.repositories.CategoriaRepository;
import br.com.playbackparamissa.cursomc.repositories.CidadeRepository;
import br.com.playbackparamissa.cursomc.repositories.EstadoRepository;
import br.com.playbackparamissa.cursomc.repositories.ItemRepository;
import br.com.playbackparamissa.cursomc.repositories.ItemSolicitacaoRepository;
import br.com.playbackparamissa.cursomc.repositories.LocalRepository;
import br.com.playbackparamissa.cursomc.repositories.ServidorRepository;
import br.com.playbackparamissa.cursomc.repositories.SolicitacaoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired 
	private CidadeRepository cidadeRepository;
	@Autowired
	private ServidorRepository servidorRepository;
	@Autowired
	private LocalRepository localRepository;
	@Autowired
	private SolicitacaoRepository solicitacaoRepository;
	@Autowired
	private ApuracaoRepository apuracaoRepository;
	@Autowired
	private ItemSolicitacaoRepository itemSolicitacaoRepository; 

	
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
		
		i1.getCategorias().addAll(Arrays.asList(cat1));
		i2.getCategorias().addAll(Arrays.asList(cat2));
		i3.getCategorias().addAll(Arrays.asList(cat2));
		i4.getCategorias().addAll(Arrays.asList(cat3));
			
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9));
		itemRepository.saveAll(Arrays.asList(i1,i2,i3,i4));
		
		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Servidor ser1 = new Servidor(null, "Servidor 01","servidor@mpce.mp.br","12345678900", Cargo.TECNICOMINISTERIAL);
		
		ser1.getTelefones().addAll(Arrays.asList("987876565","988776655"));		
		
		Local l1 = new Local(null, "1ª Promotoria de Justiça de Uberlandia", null, null, null, null,null, ser1, c1);
		Local l2 = new Local(null, "1ª Promotoria de Justiça de São Paulo", null, null, null, null,null, ser1, c2);
		
		ser1.getLocais().addAll(Arrays.asList(l1,l2));
		
		servidorRepository.saveAll(Arrays.asList(ser1));
		localRepository.saveAll(Arrays.asList(l1,l2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Solicitacao sol1 = new Solicitacao(null, sdf.parse("30/09/2018 09:00"), null, ser1);
		Solicitacao sol2 = new Solicitacao(null, sdf.parse("29/09/2019 09:00"), null, ser1);
		
		Apuracao apur1 = new Apuracao(null, EstadoApuracao.APROVADO, sol1, ser1);
		sol1.setApuracao(apur1);
		
		Apuracao apur2 = new Apuracao(null, EstadoApuracao.PENDENTE, sol2, ser1);
		sol2.setApuracao(apur2);
		
		ser1.getSolicitacoes().addAll(Arrays.asList(sol1,sol2));
		
		solicitacaoRepository.saveAll(Arrays.asList(sol1,sol2));
		apuracaoRepository.saveAll(Arrays.asList(apur1,apur2));
		
		ItemSolicitacao is1 = new ItemSolicitacao(sol1, i1, sdf.parse("30/09/2018 09:00"), sdf.parse("30/10/2018 09:00"), null);
		ItemSolicitacao is2 = new ItemSolicitacao(sol1, i2, sdf.parse("30/09/2018 09:00"), sdf.parse("30/10/2018 09:00"), null);
		ItemSolicitacao is3 = new ItemSolicitacao(sol2, i3, sdf.parse("30/09/2018 09:00"), sdf.parse("30/10/2018 09:00"), null);
		ItemSolicitacao is4 = new ItemSolicitacao(sol2, i4, sdf.parse("30/09/2018 09:00"), sdf.parse("30/10/2018 09:00"), null);
		
		sol1.getItens().addAll(Arrays.asList(is1,is2));
		sol2.getItens().addAll(Arrays.asList(is3,is4));
		
		i1.getItens().addAll(Arrays.asList(is1));
		i2.getItens().addAll(Arrays.asList(is2));
		i3.getItens().addAll(Arrays.asList(is3));
		i4.getItens().addAll(Arrays.asList(is4));
		
		itemSolicitacaoRepository.saveAll(Arrays.asList(is1,is2,is3,is4));
		
	}

}
