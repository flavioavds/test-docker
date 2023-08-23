package teste.projeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import teste.projeto.entity.Teste;
import teste.projeto.repositories.TesteRepository;

@Service
public class TesteService {

    private final TesteRepository testeRepository;

    public TesteService(TesteRepository testeRepository) {
        this.testeRepository = testeRepository;
    }

    public Teste salvarTeste(Teste teste) {
        return testeRepository.save(teste);
    }

    public List<Teste> listarTodosTestes() {
        return testeRepository.findAll();
    }

    public Optional<Teste> buscarTestePorId(Long id) {
        return testeRepository.findById(id);
    }

    public void deletarTestePorId(Long id) {
        testeRepository.deleteById(id);
    }
}
