package br.upe.controlepesoback.controlepesoback.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import br.upe.controlepesoback.controlepesoback.models.dto.PesoDto;
import br.upe.controlepesoback.controlepesoback.models.entity.Peso;
import br.upe.controlepesoback.controlepesoback.services.PesoService;

@RequestMapping("/api/peso")
@RestController
public class PesoController {

  @Autowired
  private PesoService pesoService;

  @PostMapping("/calcular")
  public Peso calcularImc(@RequestBody @Valid PesoDto bodyPeso) {
    return pesoService.calcular(bodyPeso);
  }

  @GetMapping("/historico/{email}")
  public List<Peso> getAllPesos(@PathVariable String email) {
    return pesoService.getPesos(email);
  }

}
