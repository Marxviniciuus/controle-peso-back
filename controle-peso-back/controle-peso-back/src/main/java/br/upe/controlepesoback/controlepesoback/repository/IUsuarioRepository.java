package br.upe.controlepesoback.controlepesoback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.upe.controlepesoback.controlepesoback.models.entity.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    public Usuario findByEmail(String email);
    public boolean existsByEmail(String email);
    public boolean existsById(Long id);

}