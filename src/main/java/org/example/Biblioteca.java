package org.example;

import java.io.IO;
import java.util.Scanner;

public class Biblioteca {

    Livro novoLivro = new Livro();
    Usuario novoUsuario = new Usuario("Tiago", "tiago@gmail.com", "999999999");
    Scanner scan = new Scanner(System.in);

    public void iniciar() {
        int opcao = -1;

        while (opcao != 0) {

            System.out.println("\n------BEM VINDO A BIBLIOTECA------\n");
            System.out.println("Digite o numero da opção desejada: ");
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Cadastrar usuario");
            System.out.println("3 - Retirar um livro");
            System.out.println("4 - Relatorios");
            System.out.println("0 - Sair");
            opcao = Integer.parseInt(scan.nextLine());

            switch (opcao) {
                case 1:
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
                    novoLivro.adicionarLivro(novoLivro);
                    System.out.println("Livro cadastrado com sucesso!\n");
                    novoLivro.listarLivros();
                    break;
                case 2:
                    System.out.println("Digite o nome do usuario: ");
                    novoUsuario.setNome(scan.nextLine());
                    System.out.println("Digite o email do usuario: ");
                    novoUsuario.setEmail(scan.nextLine());
                    System.out.println("Digite o telefone do usuario: ");
                    novoUsuario.setTelefone(scan.nextLine());
                    novoUsuario.adicionarUsuario(novoUsuario);
                    System.out.println("Usuario cadastrado com sucesso!");
                    break;
                case 3:
                    System.out.println("Digite o ID do livro que deseja retirar: ");
                    novoLivro.listarLivros();
                    String id = scan.nextLine();
                    novoLivro.emprestarLivro(novoUsuario, id);
                    break;
                case 4:
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
                                novoLivro.listarLivros();
                                break;
                            case 2:
                                novoUsuario.livrosEmprestados();
                                break;
                            case 3:
                                break;
                        }
                    }
                    break;
            }
        }


    }

}
