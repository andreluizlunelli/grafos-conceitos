package br.com.grafos_conceitos.questao7.retornos;

public class Cidade {
	byte saem = 0;
	byte chegam = 0;
	byte cidade = 0;
	
	public Cidade(byte cidade, byte saem, byte chegam) {
		super();
		this.cidade = cidade;
		this.saem = saem;
		this.chegam = chegam;
	}

	public byte getCidade() {
		return cidade;
	}
	
	public byte getSaem() {
		return saem;
	}

	public byte getChegam() {
		return chegam;
	}

	@Override
	public String toString() {
		return String.format("CIDADE: %d, SAEM: %d, CHEGAM: %d", cidade, saem, chegam);
	}
}
