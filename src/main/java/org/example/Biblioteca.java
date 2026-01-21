package org.example;

import java.io.IO;
import java.util.Scanner;

public class Biblioteca {

    Livro novoLivro = new Livro();
    Usuario novoUsuario;
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
            opcao = scan.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o titulo do livro: ");
                    novoLivro.setTitulo(scan.next());
                    System.out.println("Digite o autor do livro: ");
                    novoLivro.setAutor(scan.next());
                    System.out.println("Digite o ano de publicacao do livro: ");
                    novoLivro.setAnoPublicacao(scan.nextInt());
                    System.out.println("Digite a quantidade de estoque do livro: ");
                    novoLivro.setQuantidadeEstoque(scan.nextInt());
                    novoLivro.adicionarLivro(novoLivro);
                    System.out.println("Livro cadastrado com sucesso!\n");
                    novoLivro.listarLivros();
                    break;
                case 2:
                    System.out.println("Digite o nome do usuario: ");
                    novoUsuario.setNome(scan.next());
                    System.out.println("Digite o email do usuario: ");
                    novoUsuario.setEmail(scan.next());
                    System.out.println("Digite o telefone do usuario: ");
                    novoUsuario.setTelefone(scan.next());
                    novoUsuario.adicionarUsuario(novoUsuario);
                    System.out.println("Usuario cadastrado com sucesso!");
                    break;
                case 3:
                    System.out.println("Digite o titulo do livro que deseja retirar: ");


            }
        }


    }

}
