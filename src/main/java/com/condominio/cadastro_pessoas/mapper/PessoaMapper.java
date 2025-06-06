package com.condominio.cadastro_pessoas.mapper;

import com.condominio.cadastro_pessoas.dto.PessoaRequestDto;
import com.condominio.cadastro_pessoas.dto.PessoaResponseDto;
import com.condominio.cadastro_pessoas.entity.Pessoa;

public class PessoaMapper {

    public static PessoaResponseDto toDto(Pessoa pessoa) {
        if (pessoa == null) {
            return null;
        }
        return new PessoaResponseDto(
                pessoa.getPessoaId(),
                pessoa.getNome(),
                pessoa.getCpf(),
                pessoa.getTelefone(),
                pessoa.getEmail(),
                pessoa.getRole(),
                pessoa.getCreationTimestamp(),
                pessoa.getUpdateTimestamp()
        );
    }

    public static Pessoa toEntity(PessoaRequestDto dto) {
        if (dto == null) {
            return null;
        }

        return Pessoa.builder()
                .nome(dto.getNome())
                .cpf(dto.getCpf())
                .telefone(dto.getTelefone())
                .email(dto.getEmail())
                .senha(dto.getSenha())
                .role(dto.getRole())
                .build();
    }
}
