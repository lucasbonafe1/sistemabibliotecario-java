package SIstemaDeBiblioteca.Class;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    public static List<Livro> listaLivros = new ArrayList<Livro>();
    public static List<Usuario> listaUsuarios = new ArrayList<Usuario>();
    private static Usuario usuario;
    private EmprestimoLivros emprestimoLivros;

    public void adicionarLivro(Livro livro) {
        listaLivros.add(livro);
    }
    public static void adicionarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }
    public void removeLivro(Livro livro){
        listaLivros.remove(livro);
    }
    public void removeUsuario(Usuario usuario){
        listaUsuarios.remove(usuario);
    }

    public static void getListaLivros() {
        for (Livro livro : listaLivros) {
            System.out.println(livro);
        }
    }
    public static void getListaUsuarios() {
        for (Usuario usuario : listaUsuarios) {
            System.out.println(usuario);
        }
    }
}
