package projeto.example.cadastro.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projeto.example.cadastro.domain.model.Tarefa;

public interface TarefaRepository  extends JpaRepository<Tarefa,Long>{
    
}
