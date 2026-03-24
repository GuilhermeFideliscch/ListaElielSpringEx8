package com.example.Departamento.services;

import com.example.Departamento.models.DepartamentoModel;
import com.example.Departamento.repositories.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;


    public DepartamentoModel criarDepartamento(DepartamentoModel departamentoModel){
        return departamentoRepository.save(departamentoModel);
    }

    public Optional<DepartamentoModel> findById(Long id){
        return departamentoRepository.findById(id);
    }

    public List<DepartamentoModel> findAll(){
        return departamentoRepository.findAll();
    }

    public void deletarPorId(Long id){
        departamentoRepository.deleteById(id);
    }
}
