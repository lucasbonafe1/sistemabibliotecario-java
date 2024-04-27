package SIstemaDeBiblioteca.Class;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoLivros{
    private Livro livro;
    private Usuario usuario;
    private LocalDate dataBusca;
    private LocalTime horarioBusca;
    private LocalDate previsaoEntrega;
    public static List<EmprestimoLivros> livrosEmprestado = new ArrayList<>();

    public EmprestimoLivros(Livro livro, Usuario usuario, LocalDate dataBusca, LocalTime horarioBusca, LocalDate previsaoEntrega) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataBusca = dataBusca;
        this.horarioBusca = horarioBusca;
        this.previsaoEntrega = previsaoEntrega;
    }

    public Livro getLivro() {
        return livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDateTime getDataBusca() {
        return dataBusca.atStartOfDay();
    }

    public LocalDate getPrevisaoEntrega() {
        return previsaoEntrega;
    }

    public static void getLivrosEmprestado() {
        for(int i = 0; i < livrosEmprestado.size(); i++) {
            System.out.println(livrosEmprestado.get(i));
        }
    }

    public void removeLivroEmprestado(Livro livro) {
        livrosEmprestado.remove(livro);
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter dttf = DateTimeFormatter.ofPattern("HH:mm");
        return String.format("""
                Livro: %s
                Emprestado para o Usuário: %s
                Pegou no dia: %s ás %s
                Previsao Entrega: %s
                """, livro.getNameLivro(), getUsuario().nome, dtf.format(dataBusca), dttf.format(horarioBusca), dtf.format(previsaoEntrega));

    }
}
