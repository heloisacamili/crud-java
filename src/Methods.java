import java.util.ArrayList;
import java.util.Scanner;

public class Methods {
	
	static Scanner sc = new Scanner(System.in);
	
	static ArrayList<Livro> listaLivros = new ArrayList<>();
	
	static int idCounter = 1;
	
	private static String isEmpty(String mensagem) {
        String value;
        do {
            System.out.print(mensagem);
            value = sc.nextLine();
            if (value.isEmpty()) {
                System.out.println("Entrada invalida. Por favor, informe um valor.");
            }
        } while (value.isEmpty());
        return value;
    }
	
	public static Livro adicionarLivro() {
		Livro livro = new Livro();
		livro.id = idCounter++;
		livro.titulo = isEmpty("Informe o título do livro: ");
		livro.autor = isEmpty("Autor: ");
		livro.genero = isEmpty("Genero do livro: ");
		System.out.print("Ano de publicação: ");
		while (!sc.hasNextInt()) {
            System.out.println("Ano invalido. Tente novamente.");
            sc.next(); 
        }
		livro.anoPublicacao = sc.nextInt();
		sc.nextLine();
		System.out.print("\n");
		System.out.println("Livro cadastrado com sucesso!\n");
		listaLivros.add(livro);	
		return livro;
	}
	
	public static void listarEdit() {
		if (listaLivros.size() == 0) {
			System.out.println("\nNenhum dado cadastrado ainda!" + "\n");
		}
		for (Livro livro : listaLivros) {
			System.out.println("ID: " + livro.id + " - Título: " + livro.titulo);
		}
	}
	
	public static void listar() {
		if (listaLivros.size() == 0) {
			System.out.println("\nNenhum dado cadastrado ainda!" + "\n");
		}
		for (Livro livro : listaLivros) {
			System.out.println(
					"Identificação: " + livro.id + 
					"\nTítulo: " + livro.titulo +
					"\nAutor: " + livro.autor +
					"\nGenero: " + livro.genero +
					"\nPublicado em: " + livro.anoPublicacao + "\n"
			);
		}
	}
	
	public static void buscarPorId() {
		boolean encontrado = false;
		if (listaLivros.size() == 0) {
			System.out.println("\nNenhum dado cadastrado ainda!\n");
		} else {
			System.out.print("\nInforme o código do livro: ");
			while (!sc.hasNextInt()) {
                System.out.println("ID invalido. Tente novamente.");
                sc.next();
            }
			int codigoEscolhido = sc.nextInt();
			sc.nextLine();
			for(Livro livro : listaLivros) {
				if (codigoEscolhido == livro.id) {
					System.out.println(
							"\nIdentificação: " + livro.id + 
							"\nTítulo: " + livro.titulo +
							"\nAutor: " + livro.autor +
							"\nGenero: " + livro.genero +
							"\nPublicado em: " + livro.anoPublicacao + "\n"
					);
					encontrado = true;
					break;
				} 
			}
		}
		if (!encontrado) {
            System.out.println("Nenhum dado disponível para o ID informado!\n");
        }
	}
	
	public static void deletarLivro() {
		boolean removido = false;
		System.out.print("Informe o ID a ser removido: ");
		while (!sc.hasNextInt()) {
            System.out.println("ID invalido. Tente novamente.");
            sc.next(); 
        }
		int id = sc.nextInt();
		sc.nextLine();
        for (int i = 0; i < listaLivros.size(); i++) {
            if (id == listaLivros.get(i).id) {
                listaLivros.remove(i);
                removido = true;
                System.out.println("\nLivro removido com sucesso!\n");
            }
        }
        if (!removido) {
            System.out.println("Nenhum livro encontrado para remoção com o ID informado!\n");
        }
	}
	
	public static void editarLivro() {
		boolean encontrado = false;
		listarEdit();
		System.out.print("Informe o ID do livro a ser editado: ");
		while (!sc.hasNextInt()) {
            System.out.println("ID invalido. Tente novamente.");
            sc.next();
        }
		int idEscolhido = sc.nextInt();
		sc.nextLine();
		for (Livro livro : listaLivros) {
			if (idEscolhido == livro.id) {
				encontrado = true;
				int campo = 0;
				do {
					System.out.println("Escolha o campo a ser editado: " +
							"\n1- Título" +
							"\n2- Autor" + 
							"\n3- Genero" +
							"\n4- Ano de publicação" +
							"\n5- Voltar"
					);
					while (!sc.hasNextInt()) {
						System.out.println("Opção invalida. Tente novamente.");
						sc.next();
		            }
					campo = sc.nextInt();
					sc.nextLine();
					switch(campo) {
						case 1 -> {
							livro.titulo = isEmpty("\nInforme o novo título do livro: ");
						}
						case 2 -> {
							livro.autor = isEmpty("Informe o novo autor: ");
						}
						case 3 -> {
							livro.genero = isEmpty("Informe o novo genero do livro: ");
						}
						case 4 -> {
							System.out.print("Informe o novo ano de publicação: ");
							livro.anoPublicacao = sc.nextInt();
						}
						case 5 -> {
							System.out.println("Voltando ao menu principal.");
						}
						default -> {
							System.out.println("Campo indispon�vel. ");
						}
					}
				} while (campo != 5);
				break;
			}
		}
		if (!encontrado) {
	        System.out.println("Nenhum dado disponível para o ID informado!\n");
	    }
	}
}