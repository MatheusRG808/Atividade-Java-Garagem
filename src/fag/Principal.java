package fag;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fag.objetos.Carros;

public class Principal {
	static List<Carros> garagem = new ArrayList<>();
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		PopularLista();
		MostrarMenu();
	}
	
	public static void PopularLista() {
		Carros carro1 = new Carros("Pegout", "cinza", 2018);
		garagem.add(carro1);
		Carros carro2 = new Carros("Civic", "preto", 2000);
		garagem.add(carro2);
		Carros carro3 = new Carros("Civic", "cinza", 2010);
		garagem.add(carro3);
	}
	
	public static void MostrarMenu() {
		int escolhaUsuario = 0;
		do {
			System.out.println("\n-------------------Menu Da Garagem-------------------");
			System.out.println("1 - Adicionar Carro");
			System.out.println("2 - Listar Carro");
			System.out.println("3 - Remover Carro");
			System.out.println("4 - Filtrar por modelo");
			System.out.println("5 - Filtrar por cor");
			System.out.println("0 - Sair do Sistema");
			System.out.println("\nSelecione a Opção desejada:");
			escolhaUsuario = scan.nextInt();
			scan.nextLine();
			ValidarEscolha(escolhaUsuario);
		} while (escolhaUsuario != 0);
	}
	
 	public static void ValidarEscolha(int escolha) {
		switch (escolha) {
			case 0 : {
				System.out.println("Você saiu do Sistema...");
			}
			break;
			case 1: {
				AdicionarCarro();
			break;
			}
			case 2: {
				ListarCarros();
			}
			break;
			case 3: {
				RemoverCarro();
			}
			break;
			case 4: {
				FitrarModelo();
			}
			break;
			case 5: {
				FiltrarCor();
			}
			break;
			default:
				System.out.println("Escolha uma opção válida");
			break;
		}
	}
 	
 	public static void AdicionarCarro() {
 		Carros newCarro = addCarro();
 		if (newCarro != null) {
 			garagem.add(addCarro());
 	 		System.out.println("Carro adicionado com sucesso");
		}
 		else {
 			System.out.println("Cadastro Falhou");
 			return;
 		}
 	}
 	
 	public static Carros addCarro() {
 		Carros newCarro = new Carros();
 		System.out.println("Qual o modelo do Carro ?");
 		if (!newCarro.setModelo(scan.nextLine())) {
 			return null;
 		}
 		System.out.println("Qual a cor do Carro ?");
 		if (!newCarro.setCor(scan.nextLine())) {
 			return null;
 		}
 		System.out.println("Qual o ano do Carro? ");
 		if (!newCarro.setAno(scan.nextInt())) {
 			return null;
 		}
 		scan.nextLine();
 		
 		return newCarro;
 	}
 	
 	public static void RemoverCarro() {
 		ListarCarros();
 		System.out.println("0 - Cancelar");
		int escolhaUsuario = scan.nextInt() - 1;
		scan.nextLine();
		if(escolhaUsuario == -1) {
			return;
		}
		if (escolhaUsuario >= 0 && escolhaUsuario < garagem.size()) {
			garagem.remove(escolhaUsuario);
			System.out.println("Carro removido com sucesso!");
		} else {
			System.out.println("Informe um carro válido");
			RemoverCarro();
		}
 	}
 	
 	public static void FitrarModelo() {
 		MostrarModelos();
 		System.out.println("Escolha um modelo para filtrar");
 		String modeloEscolhido = scan.nextLine();
 		if(!modeloEscolhido.isBlank()) {
 			boolean encontrado = false;
	 		for (int i = 0; i < garagem.size(); i++) {
				if (garagem.get(i).getModelo().equals(modeloEscolhido)) {
					encontrado = true;
					System.out.printf("\n%d - ", i + 1);
					garagem.get(i).DetalharCarro();
				}
			}
	 		if (!encontrado) {
	 			System.out.printf("Nenhum modelo %s encontrado" , modeloEscolhido);
			}
	 		System.out.println("\n");
 		}
 		else {
 			System.out.println("O modelo não pode ser vazio");
 			FitrarModelo();
 		}
 	}
 	
 	public static void MostrarModelos() {
 		System.out.println("\n-------------------Modelos Disponiveis-------------------");

 	    List<String> modelosMostrados = new ArrayList<>();

 	    for (int i = 0; i < garagem.size(); i++) {
	        String modelo = garagem.get(i).getModelo();
	
	        if (!modelosMostrados.contains(modelo)) {
	            System.out.println(modelo);
	            modelosMostrados.add(modelo);
	        }
 	    }
 	}
 	
 	public static void FiltrarCor() {
 		MostrarCores();
 		System.out.println("Escolha uma cor para filtrar");
 		String corEscolhida = scan.nextLine();
 		if(!corEscolhida.isBlank()) {
	 		boolean encontrado = false;
 			for (int i = 0; i < garagem.size(); i++) {
				if (garagem.get(i).getCor().equals(corEscolhida)) {
					encontrado = true;
					System.out.printf("\n%d - ", i + 1);
					garagem.get(i).DetalharCarro();
				}
			}
 			if (!encontrado) {
 				System.out.printf("Nenhum carro da cor %s encontrado", corEscolhida);
			}
	 		System.out.println("\n");
 		}
 		else {
 			System.out.println("A cor não pode ser vazia");
 			FiltrarCor();
 		}
 	}
 	
 	public static void MostrarCores() {
 		System.out.println("\n-------------------Cores Disponíveis-------------------");

 	    List<String> coresMostradas = new ArrayList<>();

 	    for (int i = 0; i < garagem.size(); i++) {
	        String cores = garagem.get(i).getCor();
	
	        if (!coresMostradas.contains(cores)) {
	            System.out.println(cores);
	            coresMostradas.add(cores);
	        }
 	    }
 	}
 	
 	public static void ListarCarros() {
		for (int i = 0; i < garagem.size(); i++) {
			System.out.printf("\n%d - ", i + 1);
			garagem.get(i).DetalharCarro();
		}
		System.out.println("\n");
	}
}
