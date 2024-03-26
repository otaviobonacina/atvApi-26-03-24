package application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import application.model.Diretor;
import application.repository.DiretorRepository;

@RestController
public class DiretorController {
    @Autowired
    private DiretorRepository diretorRepo;

    @PostMapping("/diretores")
    public Diretor post(@RequestBody Diretor diretor) {
        return diretorRepo.save(diretor);
    }

    @GetMapping("/diretores")
    public List<Diretor> diretores() {
        return (List<Diretor>) diretorRepo.findAll();
    }

    @GetMapping("/diretores/{id}")
    public Diretor getDiretor(@PathVariable Long id) {
        return diretorRepo.findById(id).get();
    }

    @PutMapping("/diretores/{id}")
    public Diretor putDiretor(
        @RequestBody Diretor diretor,
        @PathVariable Long id) {
        Diretor resposta = diretorRepo.findById(id).get();
        resposta.setNome(diretor.getNome());

        return diretorRepo.save(resposta);
    }

    @DeleteMapping("/diretores/{id}")
    public void deleteDiretores(@PathVariable Long id) {
        diretorRepo.deleteById(id);
    }
}
