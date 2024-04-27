package SIstemaDeBiblioteca.Class;
import java.time.LocalDate;
import java.util.Random;

public class Livro {
    Random random = new Random();
    public int idLivro = random.nextInt(20);
    private String name;
    private String autor;
    private String title;
    private int publicationYear;
    private int numberOfCopys = 0;

    public void setName(String name){
        this.name = name;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setPublicationYear(int publicationYear){
        LocalDate dataAtual = LocalDate.now();
        int anoAtual = dataAtual.getYear();
        this.publicationYear = publicationYear;
        /*if(publicationYear > 1600 && publicationYear <= anoAtual) {
            this.publicationYear = publicationYear;
        }else {
            System.out.println("Ano inválido. \n");
        }USAR SOMENTE QUANDO FOR FAZER O CADASTRO DE LIVROS
         */
    }
    public void setNumberOfCopys(int numberOfCopys){
        this.numberOfCopys = numberOfCopys;
    }

    public int getIdLivro() {
        return idLivro;
    }
    public String getNameLivro(){
        return name;
    }
    public String getAutor() {
        return autor;
    }
    public String getTitle(){
        return title;
    }
    public int getPublicationYear(){
        return publicationYear;
    }
    public int getNumberOfCopys(){
        return numberOfCopys;
    }
    public void exibirLivro(){
        System.out.println("\nID: " + getIdLivro());
        System.out.println("Nome: " + getNameLivro());
        System.out.println("Titulo " + getTitle());
        System.out.println("Autor: "+ getAutor());
        System.out.println("Data de publicação: " + getPublicationYear());
        System.out.println("Nº de cópias: " + getNumberOfCopys());
    }
    @Override
    public String toString (){
        return String.format("""
                Nome: %s  
                Titulo: %s
                Autor: %s
                Ano de publicação: %d 
                Nº de copias: %d
                """, name, title, autor, publicationYear, numberOfCopys);
    }
}
