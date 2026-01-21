package org.example;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Usuario {

    Map<String, Usuario> usuarios = new HashMap();
    Map<String, Livro> meusLivros = new HashMap<>();

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

    public void adicionarUsuario(Usuario usuario){
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setTelefone(telefone);
        usuarios.put(getId(), usuario);
    }
}
