package com.agenda.ale.controller;

import com.agenda.ale.entity.EntityAgenda;
import com.agenda.ale.repository.RepositoryAgenda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/agenda")
public class ContollerAgenda {

    @Autowired
    private RepositoryAgenda repositoryAgenda;

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<EntityAgenda> cadastrar(@RequestBody EntityAgenda entityAgenda){
        EntityAgenda agenda = repositoryAgenda.save(entityAgenda);
        return new ResponseEntity<EntityAgenda>(agenda, HttpStatus.CREATED);
    }

    @PutMapping(value = "/", produces = "application/json")
    public ResponseEntity<EntityAgenda> atualizar(@RequestBody EntityAgenda entityAgenda){
        EntityAgenda agenda = repositoryAgenda.save(entityAgenda);
        return new ResponseEntity<EntityAgenda>(agenda, HttpStatus.OK);
    }
    @DeleteMapping(value = "/")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Long idAgenda){
        repositoryAgenda.deleteById(idAgenda);
        return new ResponseEntity<String>("Foi exluido com exito", HttpStatus.OK);
    }

    @GetMapping(value = "/{idAgenda}")
    public ResponseEntity<EntityAgenda> getAgenda(@PathVariable (value = "idAgenda") Long idAgenda){
        EntityAgenda agenda = repositoryAgenda.findById(idAgenda).get();
        return new ResponseEntity<EntityAgenda>(agenda, HttpStatus.OK);
    }
    @GetMapping(value = "/buscarnome", produces = "application/json")
    public ResponseEntity<List<EntityAgenda>> getPorNome(@RequestParam (name = "nome") String nome){
        List<EntityAgenda> agenda = repositoryAgenda.getPorNome(nome);
        return new ResponseEntity<List<EntityAgenda>>(agenda, HttpStatus.OK);
    }
    @GetMapping(value = "/agenda")
    public List<EntityAgenda> getAll(){
        return repositoryAgenda.findAll();
    }
}
