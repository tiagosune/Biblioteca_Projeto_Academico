package org.example.model;

import java.util.*;
import java.util.stream.Collectors;

public class Biblioteca {

    private Map<String, Livro> livros = new HashMap<>();
    private Map<String, Usuario> usuarios = new HashMap();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    Scanner scan = new Scanner(System.in);

    public void adicionarLivro(Livro livro) {
        livros.put(livro.getId(), livro);
    }

    public void listarLivros() {
        System.out.println("Lista de livros: \n");
        livros.forEach((id, livro) -> System.out.println(livro));
    }

    public void listarUsuarios() {
        System.out.println("Lista de usuários: \n");
        usuarios.forEach((id, usuario) -> System.out.println(usuario));
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }


    public void emprestarLivro(String usuarioId, String livroId) {
        if (!usuarios.containsKey(usuarioId)) {
            throw new IllegalArgumentException("Usuário não encontrado!");
        }
        if (!livros.containsKey(livroId)) {
            throw new IllegalArgumentException("Livro não encontrado!");
        }
        if (qtdEmprestimosUsuario(usuarioId) >= 3) {
            throw new IllegalArgumentException("Maximo de 3 livros emprestados por usuario!");
        } else if (livros.get(livroId).getQuantidadeEstoque() > 0) {
            Emprestimo emprestimo = new Emprestimo(usuarioId, livroId);
            emprestimos.add(emprestimo);
            livros.get(livroId).setQuantidadeEstoque(livros.get(livroId).getQuantidadeEstoque() - 1);
        } else {
            throw new IllegalArgumentException("Livro sem estoque!");
        }
    }

    private int qtdEmprestimosUsuario(String usuarioId) {
        return (int) emprestimos.stream()
                .filter(emprestimo -> emprestimo.getUsuarioId().equals(usuarioId)).count();
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.put(usuario.getId(), usuario);
    }

    public void devolverLivro(String emprestimoId) {
        Emprestimo emprestimo = emprestimos.stream()
                .filter(e -> e.getId().equals(emprestimoId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Empréstimo não encontrado!"));

        String livroId = emprestimo.getLivroId();
        livros.get(livroId).setQuantidadeEstoque(
                livros.get(livroId).getQuantidadeEstoque() + 1
        );
        emprestimo.devolver();

        System.out.println("Livro devolvido com sucesso!");
    }


    public void iniciar() {
        int opcao = -1;

        while (opcao != 0) {

            System.out.println("\n------BEM VINDO A BIBLIOTECA------\n");
            System.out.println("Digite o numero da opção desejada: ");
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Cadastrar usuario");
            System.out.println("3 - Retirar um livro");
            System.out.println("4 - Devolver um livro");
            System.out.println("5 - Relatorios");
            System.out.println("0 - Sair");
            opcao = Integer.parseInt(scan.nextLine());

            switch (opcao) {
                case 1:
                    Livro novoLivro = new Livro();
                    System.out.println("Digite o titulo do livro: ");
                    novoLivro.setTitulo(scan.nextLine());
                    System.out.println("Digite o autor do livro: ");
                    novoLivro.setAutor(scan.nextLine());
                    System.out.println("Digite o ISBN do livro: ");
                    novoLivro.setIsbn(scan.nextLine());
                    System.out.println("Digite o ano de publicacao do livro: ");
                    novoLivro.setAnoPublicacao(Integer.parseInt(scan.nextLine()));
                    System.out.println("Digite a quantidade de estoque do livro: ");
                    novoLivro.setQuantidadeEstoque(Integer.parseInt(scan.nextLine()));
                    adicionarLivro(novoLivro);
                    System.out.println("Livro cadastrado com sucesso!\n");
                    listarLivros();
                    break;
                case 2:
                    Usuario novoUsuario = new Usuario();
                    System.out.println("Digite o nome do usuario: ");
                    novoUsuario.setNome(scan.nextLine());
                    System.out.println("Digite o email do usuario: ");
                    novoUsuario.setEmail(scan.nextLine());
                    System.out.println("Digite o telefone do usuario: ");
                    novoUsuario.setTelefone(scan.nextLine());
                    adicionarUsuario(novoUsuario);
                    System.out.println("Usuario cadastrado com sucesso!");
                    listarUsuarios();
                    break;
                case 3:
                    System.out.println("Digite o ID do usuário: ");
                    listarUsuarios();
                    String usuarioId = scan.nextLine();
                    System.out.println("Digite o ID do livro que deseja retirar: ");
                    listarLivros();
                    String livroId = scan.nextLine();
                    try {
                        emprestarLivro(usuarioId, livroId);
                        System.out.println("Livro retirado com sucesso!");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro ao realizar empréstimo: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Digite o codigo do emprestimo que deseja devolver: ");
                    getEmprestimos().forEach(emprestimo -> System.out.println(emprestimo));
                    String emprestimoId = scan.nextLine();
                    devolverLivro(emprestimoId);
                    break;
                case 5:
                    int opcaoRelatorio = -1;
                    while (opcaoRelatorio != 0) {
                        System.out.println("Escolha o relatorio desejado: ");
                        System.out.println("1 - Relatorio de livros em estoque.");
                        System.out.println("2 - Relatorio de livros emprestados.");
                        System.out.println("3 - Relatorio de usuarios em atraso.");
                        System.out.println("0 - Voltar");
                        opcaoRelatorio = Integer.parseInt(scan.nextLine());
                        switch (opcaoRelatorio) {
                            case 1:
                                listarLivros();
                                break;
                            case 2:
                                System.out.println("Livros emprestados: \n");
                                getEmprestimos().forEach(emprestimo -> System.out.println(emprestimo));
                                break;
                            case 3:
                                System.out.println("Usuarios em atraso: \n");
                                emprestimos.stream().filter(Emprestimo::estaAtrasado)
                                        .forEach(emp -> {
                                            String usuarioId1 = emp.getUsuarioId();
                                            Usuario usuario = usuarios.get(usuarioId1);
                                            System.out.println(usuario);
                                        });
                                break;
                        }
                    }
                    break;
            }
        }


    }
}
