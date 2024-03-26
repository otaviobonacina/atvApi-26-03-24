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


import application.model.Tarefa;
import application.repository.TarefaRepository;

@RestController
public class TarefaController {
    @Autowired
    private TarefaRepository tarefaRepo;

    @PostMapping("/tarefas")
    public Tarefa postTarefa(@RequestBody Tarefa tarefa) {
        return tarefaRepo.save(tarefa);
    }

    @GetMapping("/tarefas")
    public List<Tarefa> tarefas() {
        return (List<Tarefa>) tarefaRepo.findAll();
    }

    @GetMapping("/tarefas/{id}")
    public Tarefa getTarefa(@PathVariable Long id) {
        return tarefaRepo.findById(id).get();
    }

    @PutMapping("/tarefas/{id}")
    public Tarefa putTarefa(
        @RequestBody Tarefa tarefa,
        @PathVariable Long id) {
        Tarefa resposta = tarefaRepo.findById(id).get();
        
        resposta.setDescricao(tarefa.getDescricao());
        resposta.setConcluido(tarefa.getConcluido());
        return tarefaRepo.save(resposta);
    }

    @DeleteMapping("/tarefas/{id}")
    public void deleteTarefa(@PathVariable Long id) {
        tarefaRepo.deleteById(id);
    }
}
