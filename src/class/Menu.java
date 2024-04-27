package SIstemaDeBiblioteca.Class;

import SIstemaDeBiblioteca.Class.EmprestimoLivros;
import SIstemaDeBiblioteca.Class.Livro;
import SIstemaDeBiblioteca.Class.Usuario;

import java.io.File; // import da classe File
import java.io.FileWriter;
import java.io.IOException;//import da classe IOException
import java.security.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

import static SIstemaDeBiblioteca.Class.Biblioteca.*;
import static SIstemaDeBiblioteca.Class.EmprestimoLivros.getLivrosEmprestado;
import static SIstemaDeBiblioteca.Class.EmprestimoLivros.livrosEmprestado;

public class Menu {
    Scanner s = new Scanner(System.in);

    public void menuBiblioteca() throws InterruptedException, IOException {
        while (true) {
            var mensagem = """
                     --------------------------------------------------------------------------------
                    |   MENU DA BIBLIOTECA BONES, DIGITE ALGUMA DAS OPÇÕES ABAIXO PARA PROSSEGUIR    |
                    |--------------------------------------------------------------------------------|
                    |                   1 - CADASTRO DE NOVOS USUÁRIOS                               | 
                    |                   2 - VER LISTA DE USUÁRIOS CADASTRADOS                        |
                    |                   3 - CHECAR LISTA DE LIVROS DISPONÍVEIS                       |
                    |                   4 - EMPRESTAR LIVROS A ALGUM USUÁRIO                         |
                    |                   5 - CHECAR LISTA DE LIVROS EMPRESTADOS                       |
                    |                   6 - SAIR                                                     |
                     --------------------------------------------------------------------------------
                    """;
            System.out.print(mensagem + "\nR:");
            int opcao = s.nextInt();

            switch (opcao) {
                case 1:
                    cadastroAluno();
                    // popular um pouco depois fixamente
                    break;
                case 2:
                    System.out.println("\n2) OS USUÁRIOS CADASTRADOS NA BIBLIOTECA SÃO:");
                    getListaUsuarios();
                    voltarMenu();
                    System.out.println("Sem opções a mais, retornando..");
                    break;
                case 3:
                    livrosCadastrados();
                    getListaLivros();
                    voltarMenu();
                    System.out.println("Sem opçôes a mais, retornando...\n");
                    break;
                case 4:
                    registroDeEmprestimos();
                    // EMITIR COMPROVANTE DE EMPRESTIMO DO LIVRO EM TXT
                    break;
                case 5:
                    System.out.println("\n4) OS LIVROS QUE ESTÃO EMPRESTADOS SÃO:");
                    getLivrosEmprestado();
                    voltarMenu();
                    break;
                case 6:
                    //add clearConsole depois
                    System.out.println("\nPrograma finalizado.");
                    s.close();
                    System.exit(0);
                    break;
                }
            }
        }
    public void voltarMenu() throws InterruptedException, IOException {
        String voltar;
        do {
            System.out.print("Voltar ao Menu? (S/n)");
            voltar = s.nextLine().trim(); // remove espaços em branco antes e depois da entrada
            if (voltar.isEmpty()) { // verifica se a entrada está em branco
                voltar = s.nextLine().trim();
            }
        } while (voltar.isEmpty()); // continua solicitando entrada até que não esteja em branco

        switch (voltar.toUpperCase()) {
            case "S":
                menuBiblioteca();
                break;
            case "N":
                break;
            default:
                System.out.println("Opção inválida. Por favor, escolha 'S' para sim ou 'N' para não.");
                voltarMenu(); // chama novamente o método se a opção for inválida
                break;
        }
    }
    public void cadastroAluno() throws InterruptedException, IOException {
        System.out.println("\n1) CADASTRO DE NOVO USUÁRIO\nNome:");
        String nome = s.next().trim();
        System.out.println("Sobrenome:");
        String sobrenome = s.next().trim();
        System.out.println("Ano de nascimento:");
        int ano = s.nextShort();
        while (ano < 1925 || ano > 2024) {
            System.err.println("ERRO\nInsira um ano válido:");
            ano = s.nextShort();
        }
        System.out.println("Número do Mês de nascimento:");
        int mes = s.nextShort();
        while (mes < 1 || mes > 12) {
            System.err.println("ERRO\nInsira um número do Mês válido:");
            mes = s.nextShort();
        }
        System.out.println("Dia de Nascimento:");
        int dia = s.nextShort();
        while (dia < 1 || dia > 31) {
            System.err.println("ERRO\nInsira um Dia de Nascimento válido:");
            dia = s.nextShort();
        }
        System.out.println("Por fim, Digite o CPF do usuário: ");
        String cpf = s.next();
        while (cpf.length() != 11) {
            System.err.println("Cpf inválido.\nDigite novamente seu CPF(11 números):");
            cpf = s.next();
        }
        Usuario novoUsuario = new Usuario(nome, sobrenome, LocalDate.of(ano, mes, dia).atStartOfDay(), cpf);
        adicionarUsuario(novoUsuario);
        System.out.println("-- USUÁRIO CADASTRADO --\n");
        System.out.println("Caso desejar checar o cadastro feito digite 'N':");
        voltarMenu();
        System.out.println(novoUsuario);
    }
    public void livrosCadastrados(){
        System.out.println("\n3) OS LIVROS CADASTRADOS NA BIBLIOTECA SÃO:");
        Livro book = new Livro();
        book.setName("Vida corrida");
        book.setTitle("Como ser um dev de sucesso?");
        book.setAutor("Bonafé marçal");
        book.setPublicationYear(1754);
        book.setNumberOfCopys(8);
        listaLivros.add(book);

        Livro book2 = new Livro();// Add todos os dados no construtor
        book2.setName("A arte da Guerra");
        book2.setTitle("Conselhos estratégicos para uma mente visionaria");
        book2.setAutor("Nenem Tzu");
        book2.setPublicationYear(1494);
        book2.setNumberOfCopys(10);
        listaLivros.add(book2);

        Livro book3 = new Livro();
        book3.setName("Javinha.java");
        book3.setTitle("Aprenda a criar seus projetos facilmente");
        book3.setAutor("Jaque");
        book3.setPublicationYear(2020);
        book3.setNumberOfCopys(14);
        listaLivros.add(book3);

        Livro book4 = new Livro();
        book4.setName("Sobrevivência na selva");
        book4.setTitle("Aprenda a viver em Amparo");
        book4.setAutor("Khezac Khaleb");
        book4.setPublicationYear(1994);
        book4.setNumberOfCopys(34);
        listaLivros.add(book4);

        Livro book5 = new Livro();
        book5.setName("Como ser contratado por meio do Linkedin");
        book5.setTitle("Em busca do sucesso");
        book5.setAutor("Zeze M.");
        book5.setPublicationYear(2004);
        book5.setNumberOfCopys(6);
        listaLivros.add(book5);

        Livro book6 = new Livro();
        book6.setName("The Joker");
        book6.setTitle("Eu queria ser um queridão");
        book6.setAutor("Miele L.");
        book6.setPublicationYear(2014);
        book6.setNumberOfCopys(2);
        listaLivros.add(book6);

        Livro book7 = new Livro();
        book7.setName("Mente derretida");
        book7.setTitle("5 dicas para conviver em meio ao trabalho");
        book7.setAutor("Gustavo Pinha");
        book7.setPublicationYear(2001);
        book7.setNumberOfCopys(1);
        listaLivros.add(book7);
    }
    public void registroDeEmprestimos() throws InterruptedException, IOException {
        LocalDate dataBusca = null;
        Livro livro = null;
        LocalTime horarioBusca = null;

        System.out.println("               SISTEMA DE EMPRESTIMO DE LIVROS\n              ESCOLHA UM DOS LIVROS DISPONIVEIS:");
        for (Livro livros : listaLivros) {
            livros.exibirLivro(); // rever se precisa do for
        }
        System.out.println("\nDIGITE O ID DO LIVRO:");
        int escolhaId = s.nextInt();
        boolean achouLivro = false;
        for (int i = 0; i < listaLivros.size(); i++) {
            if (escolhaId == listaLivros.get(i).idLivro) {
                System.out.println("\nOK, O lIVRO COM ESSE ID É: ");
                System.out.println(listaLivros.get(i));
            } else if (!achouLivro && i == listaLivros.size() - 1) { //!achoulivro = 'achouLivro == false'
                System.err.println("ID INVÁLIDO.");
            }
            livro = listaLivros.get(i);
        }
        Thread.sleep(1000);

        System.out.println("\nESCOLHA O USUÁRIO CADASTRADO QUE DESEJA O EMPRESTIMO DESSE LIVRO:");
        getListaUsuarios();

        System.out.println("DIGITE O CPF DO USUÁRIO:");
        String escolhaUsuario = s.next();
        for (Usuario usuario : listaUsuarios) {
            if (escolhaUsuario.equals(usuario.getCpf())) {
                System.out.println("O USUÁRIO COM ESSE CPF É:\n" + usuario);
            }
            System.out.println("A DATA DE BUSCA É NESSE EXATO MOMENTO? (S/n)");
            String pergunta = s.next();
            LocalDateTime horaEDataBusca = LocalDateTime.now(); // Definir por padrão para o momento atual
            if (pergunta.equalsIgnoreCase("N")) {
                System.out.println("DATA QUE BUSCOU DO LIVRO (YYYY-MM-DD):");
                LocalDate dataDigitada = LocalDate.parse(s.next());
                System.out.println("HORÁRIO QUE BUSCOU DO LIVRO (HH:MM):");
                LocalTime horarioDigitado = LocalTime.parse(s.next());
                horaEDataBusca = LocalDateTime.of(dataDigitada, horarioDigitado);
            }
            dataBusca = horaEDataBusca.toLocalDate();
            horarioBusca = horaEDataBusca.toLocalTime();
            LocalDate previsaoEntrega = dataBusca.plusDays(45);
            EmprestimoLivros emprestimoLivro1 = new EmprestimoLivros(livro, usuario, dataBusca, horarioBusca, previsaoEntrega);
            livrosEmprestado.add(emprestimoLivro1);
            System.out.println("\n= = = =   EMPRESTIMO CONCLUIDO   = = = =\n" + emprestimoLivro1);
            geradorRelatorio();
    }
}
    public void geradorRelatorio() throws IOException {
        // Especifique o caminho completo para o arquivo, incluindo o nome do arquivo
        File arq = new File("/home/administrador/IdeaProjects/BibliotecariaBonas/relatorio-de-emprestimo.txt");

        // Crie o escritor dentro do bloco try-with-resources para garantir que ele seja fechado corretamente
        try (FileWriter escritor = new FileWriter(arq)) {
            System.out.println("Deseja emitir o relatório desse empréstimo? (S/n)");
            String escolha = s.next();
            boolean emitirRelatorio = false;
            if (escolha.equalsIgnoreCase("S")) {
                emitirRelatorio = true;
                // Escreva no arquivo
                escritor.write(String.valueOf(livrosEmprestado.get(0))); // Alterar para obter o último empréstimo
                System.out.println("Concluído! Arquivo txt criado na sua pasta.");
            } else if (escolha.equalsIgnoreCase("n")) {
                emitirRelatorio = false;
                System.out.println("Ok, retornando ao menu..");
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao criar ou escrever no arquivo", e);
        }
    }
}