package br.com.playbackparamissa.cursomc.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.playbackparamissa.cursomc.domain.Categoria;

public class CategoriaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min=5, max=80, message = "O Tamanho deve ser entre 5 e 80 caracteres")
	private String descricao;
	private Integer codigo;
	private Integer codigoPai;
	private Integer pontos;
	private Integer limiteQuantidade;
	private Integer limitePontos;
	
	public CategoriaDTO() {
		
	}

	public CategoriaDTO(Categoria obj) {
		id = obj.getId();
		descricao = obj.getDescricao();
		codigo = obj.getCodigo();
		codigoPai = obj.getCodigoPai();
		pontos = obj.getPontos();
		limiteQuantidade = obj.getLimiteQuantidade();
		limitePontos = obj.getLimitePontos();
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

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCodigoPai() {
		return codigoPai;
	}

	public void setCodigoPai(Integer codigoPai) {
		this.codigoPai = codigoPai;
	}

	public Integer getPontos() {
		return pontos;
	}

	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}

	public Integer getLimiteQuantidade() {
		return limiteQuantidade;
	}

	public void setLimiteQuantidade(Integer limiteQuantidade) {
		this.limiteQuantidade = limiteQuantidade;
	}

	public Integer getLimitePontos() {
		return limitePontos;
	}

	public void setLimitePontos(Integer limitePontos) {
		this.limitePontos = limitePontos;
	}
	
	

}
