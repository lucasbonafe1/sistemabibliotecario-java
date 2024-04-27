package SIstemaDeBiblioteca.Class;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Usuario {
    public String nome;
    private String sobrenome;
    private int idade;
    private LocalDateTime dataNasc;
    private String cpf = "";

    //private LocalDateTime previsaoDeEntrega;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Usuario(String nome, String sobrenome, LocalDateTime dataNasc, String cpf){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNasc = dataNasc;
        this.cpf = cpf;
    }

    @Override // ver
    public String toString() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("""
                Nome: %s %s
                Data de Nascimento: %s
                Cpf: %s 
                """, nome, sobrenome, df.format(dataNasc), cpf);
    }
}





