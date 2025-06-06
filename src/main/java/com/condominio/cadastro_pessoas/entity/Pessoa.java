package com.condominio.cadastro_pessoas.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @UuidGenerator
    private UUID pessoaId;

    private String nome;

    @Column(unique = true, nullable = false)
    private String cpf;

    private String telefone;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private String role;

    private LocalDateTime creationTimestamp;
    private LocalDateTime updateTimestamp;

    // Construtor sem argumentos
    public Pessoa() {
    }

    // Construtor com todos os argumentos
    public Pessoa(UUID pessoaId, String nome, String cpf, String telefone, String email,
                  String senha, String role, LocalDateTime creationTimestamp, LocalDateTime updateTimestamp) {
        this.pessoaId = pessoaId;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.role = role;
        this.creationTimestamp = creationTimestamp;
        this.updateTimestamp = updateTimestamp;
    }

    // Getters e Setters
    public UUID getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(UUID pessoaId) {
        this.pessoaId = pessoaId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(LocalDateTime creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public LocalDateTime getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(LocalDateTime updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

    // Implementação manual do padrão Builder
    public static PessoaBuilder builder() {
        return new PessoaBuilder();
    }

    public static class PessoaBuilder {
        private UUID pessoaId;
        private String nome;
        private String cpf;
        private String telefone;
        private String email;
        private String senha;
        private String role;
        private LocalDateTime creationTimestamp;
        private LocalDateTime updateTimestamp;

        public PessoaBuilder pessoaId(UUID pessoaId) {
            this.pessoaId = pessoaId;
            return this;
        }

        public PessoaBuilder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public PessoaBuilder cpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public PessoaBuilder telefone(String telefone) {
            this.telefone = telefone;
            return this;
        }

        public PessoaBuilder email(String email) {
            this.email = email;
            return this;
        }

        public PessoaBuilder senha(String senha) {
            this.senha = senha;
            return this;
        }

        public PessoaBuilder role(String role) {
            this.role = role;
            return this;
        }

        public PessoaBuilder creationTimestamp(LocalDateTime creationTimestamp) {
            this.creationTimestamp = creationTimestamp;
            return this;
        }

        public PessoaBuilder updateTimestamp(LocalDateTime updateTimestamp) {
            this.updateTimestamp = updateTimestamp;
            return this;
        }

        public Pessoa build() {
            return new Pessoa(pessoaId, nome, cpf, telefone, email, senha, role, creationTimestamp, updateTimestamp);
        }
    }
}
