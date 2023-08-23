package teste.projeto.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import teste.projeto.entity.Teste;
import teste.projeto.services.TesteService;

@RestController
@RequestMapping("/api/testes")
public class TesteController {

    private final TesteService testeService;

    public TesteController(TesteService testeService) {
        this.testeService = testeService;
    }

    @PostMapping
    public ResponseEntity<Teste> criarTeste(@RequestBody Teste teste) {
        Teste novoTeste = testeService.salvarTeste(teste);
        return ResponseEntity.ok(novoTeste);
    }

    @GetMapping
    public ResponseEntity<List<Teste>> listarTestes() {
        List<Teste> testes = testeService.listarTodosTestes();
        return ResponseEntity.ok(testes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teste> buscarTestePorId(@PathVariable Long id) {
        return testeService.buscarTestePorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTestePorId(@PathVariable Long id) {
        testeService.deletarTestePorId(id);
        return ResponseEntity.noContent().build();
    }
}
