package com.condominio.cadastro_pessoas.service;

import com.condominio.cadastro_pessoas.dto.PessoaRequestDto;
import com.condominio.cadastro_pessoas.dto.PessoaResponseDto;
import com.condominio.cadastro_pessoas.entity.Pessoa;
import com.condominio.cadastro_pessoas.exception.EmailDuplicadoException;
import com.condominio.cadastro_pessoas.exception.PessoaNotFoundException;
import com.condominio.cadastro_pessoas.repository.PessoaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final PasswordEncoder passwordEncoder;

    public PessoaService(PessoaRepository pessoaRepository, PasswordEncoder passwordEncoder) {
        this.pessoaRepository = pessoaRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public PessoaResponseDto criar(PessoaRequestDto dto) {
        if (pessoaRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new EmailDuplicadoException("Email já cadastrado: " + dto.getEmail());
        }


        Pessoa pessoa = new Pessoa();
        atualizarCampos(pessoa, dto);
        pessoa.setSenha(passwordEncoder.encode(dto.getSenha()));
        pessoa.setCreationTimestamp(LocalDateTime.now());
        pessoa.setUpdateTimestamp(LocalDateTime.now());

        Pessoa salva = pessoaRepository.save(pessoa);
        return toDto(salva);
    }

    public List<PessoaResponseDto> listarTodos() {
        return pessoaRepository.findAll().stream()
                .map(this::toDto)
                .toList();
    }

    public PessoaResponseDto buscarPorId(UUID id) {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNotFoundException("Pessoa não encontrada com id: " + id));
        return toDto(pessoa);
    }

    public PessoaResponseDto atualizar(UUID id, PessoaRequestDto dto) {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNotFoundException("Pessoa não encontrada com id: " + id));

        if (!pessoa.getEmail().equals(dto.getEmail())) {
            // Verifica se email novo já existe em outro cadastro
            if (pessoaRepository.findByEmail(dto.getEmail()).isPresent()) {
                throw new EmailDuplicadoException("Email já cadastrado: " + dto.getEmail());
            }
        }

        atualizarCampos(pessoa, dto);
        if (dto.getSenha() != null && !dto.getSenha().isBlank()) {
            pessoa.setSenha(passwordEncoder.encode(dto.getSenha()));
        }

        pessoa.setUpdateTimestamp(LocalDateTime.now());

        Pessoa salva = pessoaRepository.save(pessoa);
        return toDto(salva);
    }

    public void deletar(UUID id) {
        if (!pessoaRepository.existsById(id)) {
            throw new PessoaNotFoundException("Pessoa não encontrada com id: " + id);
        }
        pessoaRepository.deleteById(id);
    }

    private void atualizarCampos(Pessoa pessoa, PessoaRequestDto dto) {
        pessoa.setNome(dto.getNome());
        pessoa.setCpf(dto.getCpf());
        pessoa.setTelefone(dto.getTelefone());
        pessoa.setEmail(dto.getEmail());
        pessoa.setRole(dto.getRole());
    }

    private PessoaResponseDto toDto(Pessoa pessoa) {
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
}
