package br.com.playbackparamissa.cursomc.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity 
public class Solicitacao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date dataSolicitacao;
	private Date dataReferencia;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy = "solicitacao")
	private Apuracao apuracao;
	
	@ManyToOne
	@JoinColumn(name="servidor_id")
	private Servidor servidor;
	
	@OneToMany(mappedBy = "id.solicitacao")	
	private Set<ItemSolicitacao> itens = new HashSet<>();
	
	public Solicitacao() {
		
	}

	public Solicitacao(Integer id, Date dataSolicitacao, Date dataReferencia, Servidor servidor) {
		super();
		this.id = id;
		this.dataSolicitacao = dataSolicitacao;
		this.dataReferencia = dataReferencia;
		this.servidor = servidor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(Date dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public Date getDataReferencia() {
		return dataReferencia;
	}

	public void setDataReferencia(Date dataReferencia) {
		this.dataReferencia = dataReferencia;
	}

	public Apuracao getApuracao() {
		return apuracao;
	}

	public void setApuracao(Apuracao apuracao) {
		this.apuracao = apuracao;
	}
	
	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}	

	public Set<ItemSolicitacao> getItens() {
		return itens;
	}

	public void setItens(Set<ItemSolicitacao> itens) {
		this.itens = itens;
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
		Solicitacao other = (Solicitacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
