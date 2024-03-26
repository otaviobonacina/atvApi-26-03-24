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

import application.model.Filme;
import application.repository.FilmeRepository;

@RestController
public class FilmeController {
    @Autowired
    private FilmeRepository filmeRepo;

    @GetMapping("/filmes")
    public List<Filme> getFilmes() {
        // Filme teste = new Filme();
        // teste.setTitulo("Teste de resposta");
        // return teste;
        return (List<Filme>) filmeRepo.findAll();
    }

    @PostMapping("/filmes")
    public Filme postFilme(@RequestBody Filme filme) {
        return filmeRepo.save(filme);
    }

    @GetMapping("/filmes/{id}")
    public Filme getFilme(@PathVariable Long id) {
        return filmeRepo.findById(id).get();
    }

    @PutMapping("/filmes/{id}")
    public Filme putFilmes(@RequestBody Filme filme, @PathVariable Long id) {
        Filme resposta = filmeRepo.findById(id).get();

        resposta.setTitulo(filme.getTitulo());
        resposta.setSinopse(filme.getSinopse());

        return filmeRepo.save(resposta);
    }

    @DeleteMapping("/filmes/{id}")
    public void deleteFilmes(@PathVariable Long id) {
        filmeRepo.deleteById(id);
    }

}
