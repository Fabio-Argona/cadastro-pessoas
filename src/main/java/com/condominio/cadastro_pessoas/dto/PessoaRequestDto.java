package com.condominio.cadastro_pessoas.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class PessoaRequestDto {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "CPF é obrigatório")
    @Size(min = 11, max = 14, message = "CPF deve ter entre 11 e 14 caracteres")
    private String cpf;

    private String telefone;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @NotBlank(message = "Senha é obrigatória")
    @Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres")
    private String senha;

    @NotBlank(message = "Role é obrigatória")
    private String role; // Ex: ROLE_PROPRIETARIO, ROLE_RESIDENTE

    public @NotBlank(message = "Nome é obrigatório") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "Nome é obrigatório") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "CPF é obrigatório") @Size(min = 11, max = 14, message = "CPF deve ter entre 11 e 14 caracteres") String getCpf() {
        return cpf;
    }

    public void setCpf(@NotBlank(message = "CPF é obrigatório") @Size(min = 11, max = 14, message = "CPF deve ter entre 11 e 14 caracteres") String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public @NotBlank(message = "Email é obrigatório") @Email(message = "Email inválido") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email é obrigatório") @Email(message = "Email inválido") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Senha é obrigatória") @Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres") String getSenha() {
        return senha;
    }

    public void setSenha(@NotBlank(message = "Senha é obrigatória") @Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres") String senha) {
        this.senha = senha;
    }

    public @NotBlank(message = "Role é obrigatória") String getRole() {
        return role;
    }

    public void setRole(@NotBlank(message = "Role é obrigatória") String role) {
        this.role = role;
    }
}

