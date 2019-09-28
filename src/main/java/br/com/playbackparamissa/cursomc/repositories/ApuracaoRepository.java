package br.com.playbackparamissa.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.playbackparamissa.cursomc.domain.Apuracao;

@Repository
public interface ApuracaoRepository extends JpaRepository<Apuracao, Integer>{

}
