import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean repetir = true;
		int option;
		do {
			System.out.println("MENU");
			System.out.println("1- Cadastrar livro" +
					"\n2- Listar livros no acervo" + 
					"\n3- Buscar livro pelo ID" +
					"\n4- Editar livro" +
					"\n5- Remover livro" +
					"\n6- Encerrar Sistema"
					);
			while (!sc.hasNextInt()) {
                System.out.println("Opção Inválida! Tente novamente.");
                sc.next();
            }
			option = sc.nextInt();
			sc.nextLine();
			switch(option) {
				case 1 -> {
					System.out.println("\nCadastrar livro");
					System.out.println("-----------------");
					Methods.adicionarLivro();
				}
				case 2 -> {
					System.out.println("\nListar livros");
                    System.out.println("-----------------");
					Methods.listar();
				}
				case 3 -> {
					System.out.println("\nBuscar livro pelo ID");
                    System.out.println("-----------------");
					Methods.buscarPorId();
				}
				case 4 -> {
					System.out.println("\nEditar livro");
                    System.out.println("-----------------");
					Methods.editarLivro();
				} 
				case 5 -> {
					System.out.println("\nRemover livro");
                    System.out.println("-----------------");
					Methods.deletarLivro();
				}
				case 6 -> {
					repetir = false;
					System.out.println("\nSistema encerrado.");
					System.exit(0);
				}
				default -> {
					System.out.println("\nOp��o n�o dispon�vel." + "\n");
				}
			}
		} while (repetir);
		sc.close();
	}
}