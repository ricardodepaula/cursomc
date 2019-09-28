package br.com.playbackparamissa.cursomc.domain.enums;

public enum EstadoApuracao {
	PENDENTE(1,"Pendente"),
	APROVADO(2,"Aprovado"),
	REPROVADO(3,"Reprovado");
	
	private int cod;
	private String descricao;
	
	private EstadoApuracao(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static EstadoApuracao toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for(EstadoApuracao x : EstadoApuracao.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}	

}
