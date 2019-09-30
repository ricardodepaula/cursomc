package br.com.playbackparamissa.cursomc.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemSolicitacao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private ItemSolicitacaoPK id = new ItemSolicitacaoPK();
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date inicio;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date fim;
	
	private String fazeAnexoDepois;
	
	public ItemSolicitacao() {
		
	}

	public ItemSolicitacao(Solicitacao solicitacao, Item item, Date inicio, Date fim, String fazeAnexoDepois) {
		super();
		id.setSolicitacao(solicitacao);
		id.setItem(item);
		this.inicio = inicio;
		this.fim = fim;
		this.fazeAnexoDepois = fazeAnexoDepois;
	}
	
	@JsonIgnore
	public Solicitacao getSolicitacao() {
		return id.getSolicitacao();
	}
	
	public Item getItem() {
		return id.getItem();
	}

	public ItemSolicitacaoPK getId() {
		return id;
	}

	public void setId(ItemSolicitacaoPK id) {
		this.id = id;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	public String getFazeAnexoDepois() {
		return fazeAnexoDepois;
	}

	public void setFazeAnexoDepois(String fazeAnexoDepois) {
		this.fazeAnexoDepois = fazeAnexoDepois;
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
		ItemSolicitacao other = (ItemSolicitacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
