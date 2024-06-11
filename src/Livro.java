public class Livro {
	
	public int id;
	public String titulo;
	public String genero;
	public String autor;
	public int anoPublicacao;

	public String mostrarInformacoes() {
		return "\nTítulo: " + titulo + 
				"\nAutor: " + autor +
				"\nGenero: " + genero + 
				"\nPublicado em: " + anoPublicacao + 
				"\n";
	}
}