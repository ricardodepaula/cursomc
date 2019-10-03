package br.com.playbackparamissa.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.playbackparamissa.cursomc.domain.Servidor;
import br.com.playbackparamissa.cursomc.repositories.ServidorRepository;
import br.com.playbackparamissa.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ServidorService {
	
	@Autowired
	private ServidorRepository repo;
	
	public Servidor find(Integer id) {
		Optional<Servidor> obj = repo.findById(id);  
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Servidor.class.getName()));  	
	}

}
