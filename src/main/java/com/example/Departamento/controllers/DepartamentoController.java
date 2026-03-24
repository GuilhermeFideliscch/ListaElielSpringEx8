package com.example.Departamento.controllers;

import com.example.Departamento.models.DepartamentoModel;
import com.example.Departamento.services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Controller
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoServices;


    @GetMapping
    private ResponseEntity<List<DepartamentoModel>> findAll(){
        List<DepartamentoModel> departamentoModelList = departamentoServices.findAll();

        return ResponseEntity.ok().body(departamentoModelList);
    }

    @PostMapping
    private ResponseEntity<DepartamentoModel> criarDepartamento(@RequestBody DepartamentoModel departamentoModel){
        DepartamentoModel novoDepartamento = departamentoServices.criarDepartamento(departamentoModel);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(departamentoModel.getId()).toUri();

        return ResponseEntity.created(uri).body(novoDepartamento);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Optional<DepartamentoModel>> findById(@PathVariable Long id){
        Optional<DepartamentoModel> departamentoModelOptional = departamentoServices.findById(id);

        return ResponseEntity.ok().body(departamentoModelOptional);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deletarDepartamento(@PathVariable Long id){
        departamentoServices.deletarPorId(id);

        return ResponseEntity.noContent().build();
    }

}
