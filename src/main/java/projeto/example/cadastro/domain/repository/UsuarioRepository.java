package projeto.example.cadastro.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projeto.example.cadastro.domain.model.Usuario;

public interface UsuarioRepository  extends  JpaRepository<Usuario,Long>{
    
}
