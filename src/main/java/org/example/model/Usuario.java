package org.example.model;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Usuario {

    private String id;
    private String nome;
    private String email;
    private String telefone;

    public Usuario(String nome, String email, String telefone) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public Usuario(){
        this.id = UUID.randomUUID().toString();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Usuario: \n" +
                "ID - " + getId() +
                "\nNome - " + getNome() +
                "\nEmail - " + getEmail() +
                "\nTelefone - " + getTelefone() + "\n";
    }
}
