package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Livro {

    List<Livro> livros = new ArrayList<>();
    private String id;
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private int quantidadeEstoque;

    public Livro(String titulo, String autor, int anoPublicacao, int quantidadeEstoque) {
        this.id = UUID.randomUUID().toString();
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Livro (){
        this.id = UUID.randomUUID().toString();
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getAutor() {
        return autor;
    }
    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
    public int getAnoPublicacao() {
        return anoPublicacao;
    }
    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }


    public void adicionarLivro (Livro livro) {
        livro.setTitulo(titulo);
        livro.setAutor(autor);
        livro.setAnoPublicacao(anoPublicacao);
        livro.setQuantidadeEstoque(quantidadeEstoque);
        livros.add(livro);
    }


    public void listarLivros() {
        System.out.println("Lista de livros: \n");
        for (Livro livro : livros) {
            System.out.println("Título: " + livro.getTitulo());
            System.out.println("Autor: " + livro.getAutor());
            System.out.println("Ano: " + livro.getAnoPublicacao());
            System.out.println("Estoque: " + livro.getQuantidadeEstoque() + "\n");
        };
    }

}
