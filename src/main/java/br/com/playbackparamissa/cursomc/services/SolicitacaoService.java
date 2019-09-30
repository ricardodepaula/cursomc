package br.com.playbackparamissa.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.playbackparamissa.cursomc.domain.Solicitacao;
import br.com.playbackparamissa.cursomc.repositories.SolicitacaoRepository;
import br.com.playbackparamissa.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class SolicitacaoService {
	
	@Autowired
	private SolicitacaoRepository repo;
	
	public Solicitacao buscar(Integer id) {
		Optional<Solicitacao> obj = repo.findById(id);  
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Solicitacao.class.getName()));  	
	}

}
