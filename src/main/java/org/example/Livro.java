package org.example;

import java.util.*;

public class Livro {

    Map<String, Livro> livrosEstoque = new HashMap<>();
    private String id;
    private String titulo;
    private String autor;
    private String isbn;
    private int anoPublicacao;
    private int quantidadeEstoque;

    public Livro(String titulo, String autor, String isbn, int anoPublicacao, int quantidadeEstoque) {
        this.id = UUID.randomUUID().toString();
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
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
    public String getId() {
        return id;
    }

    public Map<String, Livro> getLivrosEstoque() {
        return livrosEstoque;
    }

    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void adicionarLivro (Livro livro) {
        livro.setTitulo(titulo);
        livro.setAutor(autor);
        livro.setAnoPublicacao(anoPublicacao);
        livro.setQuantidadeEstoque(quantidadeEstoque);
        livrosEstoque.put(getId(), livro);
    }


    public void listarLivros() {
        System.out.println("Lista de livros: \n");
        livrosEstoque.forEach((id, livro) -> System.out.println(livro)); {
        }
    }

    public void emprestarLivro(Usuario usuarioId, String livroId){

    }

    @Override
    public String toString() {
        return "Livro: \n" +
                "ID - " + getId() +
                "\nTítulo - " + getTitulo() +
                "\nAutor - " + getAutor() +
                "\nAno de publicação - " + getAnoPublicacao() +
                "\nQuantidade de estoque - " + getQuantidadeEstoque() +
                "\nISBN - " + getIsbn();
    }
}
