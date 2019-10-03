package br.com.playbackparamissa.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.playbackparamissa.cursomc.domain.Servidor;
import br.com.playbackparamissa.cursomc.services.ServidorService;

@RestController
@RequestMapping(value="/servidores")
public class ServidorResource {
	
	@Autowired
	private ServidorService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Servidor> find(@PathVariable Integer id) {
		Servidor obj = service.find(id);
		return ResponseEntity.ok().body(obj);		
	}

}
