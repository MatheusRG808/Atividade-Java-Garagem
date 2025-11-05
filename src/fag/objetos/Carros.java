package fag.objetos;

public class Carros {
	public String modelo;
	public String cor;
	public int ano;
	
	public Carros (){
	}
	public Carros(String modelo, String cor, int ano) {
		setModelo(modelo);
		setCor(cor);
		setAno(ano);
	}
	
	public String getModelo() {
		return modelo;
	}
	public boolean setModelo(String modelo) {
		if(!modelo.isBlank()) {
			this.modelo = modelo;
			return true;
		}
		else {
			System.out.println("Retorne um Modelo válido");
			return false;
		}
	}
	public String getCor() {
		return cor;
	}
	public boolean setCor(String cor) {
		if (!cor.isBlank()) {
			this.cor = cor;
			return true;
		}
		else {
			System.out.println("Retorne uma cor válida");
			return false;
		}
	}
	public int getAno() {
		return ano;
	}
	public boolean setAno(int ano) {
		if (ano > 1899 && ano < 2025) {
			this.ano = ano;
			return true;
		}
		else {
			System.out.println("Ano inválido");
			return false;
		}
	}
	
	public void DetalharCarro() {
		System.out.printf("Modelo %s de cor %s do ano de %d", modelo, cor, ano);
	}
}
