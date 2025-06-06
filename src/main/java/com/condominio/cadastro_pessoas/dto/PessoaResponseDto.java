package com.condominio.cadastro_pessoas.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class PessoaResponseDto {

    private UUID pessoaId;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String role;
    private LocalDateTime creationTimestamp;
    private LocalDateTime updateTimestamp;

    // Construtor com todos os atributos
    public PessoaResponseDto(UUID pessoaId, String nome, String cpf, String telefone, String email, String role, LocalDateTime creationTimestamp, LocalDateTime updateTimestamp) {
        this.pessoaId = pessoaId;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.role = role;
        this.creationTimestamp = creationTimestamp;
        this.updateTimestamp = updateTimestamp;
    }

    // Construtor vazio (necessário se usar frameworks como Jackson, JPA, etc.)
    public PessoaResponseDto() {
    }

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
}
