package br.com.playbackparamissa.cursomc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.playbackparamissa.cursomc.domain.enums.EstadoApuracao;

@Entity
public class Apuracao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	private Integer estado;
	
	@JsonBackReference
	@OneToOne
	@JoinColumn(name="solicitacao_id")
	@MapsId
	private Solicitacao solicitacao;
	
	public Apuracao() {
		
	}

	public Apuracao(Integer id, EstadoApuracao estado, Solicitacao solicitacao, Servidor servidor) {
		super();
		this.id = id;
		this.estado = estado.getCod();
		this.solicitacao = solicitacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EstadoApuracao getEstado() {
		return EstadoApuracao.toEnum(estado);
	}

	public void setEstado(EstadoApuracao estado) {
		this.estado = estado.getCod();
	}

	public Solicitacao getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(Solicitacao solicitacao) {
		this.solicitacao = solicitacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Apuracao other = (Apuracao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}