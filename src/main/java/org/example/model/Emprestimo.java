package org.example.model;

import java.time.LocalDate;
import java.util.UUID;

public class Emprestimo {

    private String id;
    private String usuarioId;
    private String livroId;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoEsperada;
    private LocalDate dataDevolucaoReal;

    public Emprestimo(String usuarioId, String livroId) {
        this.id = UUID.randomUUID().toString();
        this.usuarioId = usuarioId;
        this.livroId = livroId;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucaoEsperada = LocalDate.now().plusDays(14);
        this.dataDevolucaoReal = null;
    }

    public boolean estaAtrasado() {
        return dataDevolucaoReal == null &&
                LocalDate.now().isAfter(dataDevolucaoEsperada);
    }

    public void devolver() {
        this.dataDevolucaoReal = LocalDate.now();
    }

    public String getId() { return id; }
    public String getUsuarioId() { return usuarioId; }
    public String getLivroId() { return livroId; }
    public LocalDate getDataEmprestimo() { return dataEmprestimo; }
    public LocalDate getDataDevolucaoEsperada() { return dataDevolucaoEsperada; }
    public boolean estaAtivo() { return dataDevolucaoReal == null; }

    @Override
    public String toString() {
        return "Emprestimo: \n" +
                "ID - " + id +
                "\nID do usuario - " + usuarioId +
                "\nID do livro - " + livroId +
                "\nData do Emprestimo - " + dataEmprestimo +
                "\nData de devolução esperada - " + dataDevolucaoEsperada + "\n";
    }
}

