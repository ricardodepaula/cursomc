/**
 * 
 * @author ricardo.paula
 * Classe equivalente ao Produto do Curso
 */

package br.com.playbackparamissa.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private Integer cargaHoraria;
	

	@JsonIgnore
	@ManyToMany
	@JoinTable(name="ITEM_CATEGORIA",
		joinColumns = @JoinColumn(name = "item_id"),
		inverseJoinColumns = @JoinColumn(name = "categoria_id")
	)
	private List<Categoria> categorias = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "id.item")
	private Set<ItemSolicitacao> itens = new HashSet<>();
	
	Item(){
		
	}

	public Item(Integer id, String descricao, Integer cargaHoraria) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.cargaHoraria = cargaHoraria;
	}
	
	@JsonIgnore
	public List<Solicitacao> getSolicitacoes(){
		List<Solicitacao> lista = new ArrayList<>();
		for (ItemSolicitacao x : itens) {
			lista.add(x.getSolicitacao());
		}
		return lista;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
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
		Item other = (Item) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
