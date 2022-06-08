package br.upe.controlepesoback.controlepesoback.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.upe.controlepesoback.controlepesoback.models.entity.Peso;

@Repository
public interface IPesoRepository extends JpaRepository<Peso, Long> {

    public Optional<Peso> findById(Long id);
    public List<Peso> findByEmail(String email);

}