package br.uniso.encontrosabadao.controller;

import br.uniso.encontrosabadao.model.entity.Aluno;
import br.uniso.encontrosabadao.model.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @PostMapping("/alunos")
    public boolean salvarAluno(@RequestBody Aluno aluno){
        Aluno salvo = repository.save(aluno);
        if(salvo != null){
            return true;
        }
        else{
            return false;
        }
    }


    @GetMapping("/alunos")
    public List<Aluno> listarAlunos(){

        List<Aluno> alunos = repository.findAll();
        return alunos;
    }

}