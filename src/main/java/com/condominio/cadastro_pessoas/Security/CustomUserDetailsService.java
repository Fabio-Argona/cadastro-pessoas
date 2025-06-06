package com.condominio.cadastro_pessoas.Security;

import com.condominio.cadastro_pessoas.entity.Usuario;
import com.condominio.cadastro_pessoas.repository.UsuarioRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public CustomUserDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        String sanitizedEmail = email.trim().toLowerCase();

        System.out.println("DEBUG >>> Email recebido: [" + email + "]");
        System.out.println("DEBUG >>> Email sanitizado: [" + sanitizedEmail + "]");

        Usuario usuario = usuarioRepository.findByEmail(sanitizedEmail)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + sanitizedEmail));

        System.out.println("DEBUG >>> Usuário encontrado: " + usuario.getEmail());

        return new User(
                usuario.getEmail(),
                usuario.getSenha(),
                Collections.singletonList(new SimpleGrantedAuthority(usuario.getRole()))
        );
    }
}
