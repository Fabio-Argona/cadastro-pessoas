package com.condominio.cadastro_pessoas.controller;

import com.condominio.cadastro_pessoas.dto.PessoaRequestDto;
import com.condominio.cadastro_pessoas.dto.PessoaResponseDto;
import com.condominio.cadastro_pessoas.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<PessoaResponseDto> criarPessoa(@Valid @RequestBody PessoaRequestDto pessoaRequestDto) {
        PessoaResponseDto pessoaCriada = pessoaService.criar(pessoaRequestDto);
        return new ResponseEntity<>(pessoaCriada, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<PessoaResponseDto> buscarPessoaPorId(@PathVariable UUID id) {
        PessoaResponseDto pessoa = pessoaService.buscarPorId(id);
        return ResponseEntity.ok(pessoa);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<PessoaResponseDto>> listarTodasPessoas() {
        List<PessoaResponseDto> pessoas = pessoaService.listarTodos();
        return ResponseEntity.ok(pessoas);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<PessoaResponseDto> atualizarPessoa(
            @PathVariable UUID id,
            @Valid @RequestBody PessoaRequestDto pessoaRequestDto) {
        PessoaResponseDto pessoaAtualizada = pessoaService.atualizar(id, pessoaRequestDto);
        return ResponseEntity.ok(pessoaAtualizada);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPessoa(@PathVariable UUID id) {
        pessoaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
