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

import application.model.Compromisso;

import application.repository.CompromissoRepository;

@RestController
public class CompromissoController {
    @Autowired
    private CompromissoRepository compromissoRepo;

    @PostMapping("/compromissos")
    public Compromisso postCompromisso(@RequestBody Compromisso compromisso) {
        return compromissoRepo.save(compromisso);
    }

    @GetMapping("/compromissos")
    public List<Compromisso> compromissos() {
        return (List<Compromisso>) compromissoRepo.findAll();
    }

    @GetMapping("/compromissos/{id}")
    public Compromisso getCompromisso(@PathVariable Long id) {
        return compromissoRepo.findById(id).get();
    }

    @PutMapping("/compromissos/{id}")
    public Compromisso putCompromisso(
        @RequestBody Compromisso compromisso,
        @PathVariable Long id) {
        Compromisso resposta = compromissoRepo.findById(id).get();
        
        resposta.setDescricao(compromisso.getDescricao());
        resposta.setDatainicio(compromisso.getDatainicio());
        resposta.setDatafim(compromisso.getDatafim());
        resposta.setHorainicio(compromisso.getHorainicio());
        resposta.setHorafim(compromisso.getHorafim());

        return compromissoRepo.save(resposta);
    }

    @DeleteMapping("/compromissos/{id}")
    public void deleteCompromisso(@PathVariable Long id) {
        compromissoRepo.deleteById(id);
    }
}
