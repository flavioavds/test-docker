package teste.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import teste.projeto.entity.Teste;

public interface TesteRepository extends JpaRepository<Teste, Long>{

}
