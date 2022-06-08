package br.upe.controlepesoback.controlepesoback.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.upe.controlepesoback.controlepesoback.models.entity.Usuario;
import br.upe.controlepesoback.controlepesoback.services.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    
    @PostMapping("/cadastrar")
    public Usuario save(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }
    
    @GetMapping("/todos")
    public List<Usuario> getUsuarios() {        
        return usuarioService.getUsuarios();
    }

    @GetMapping("/{email}")
    public Usuario getUsuarioByEmail(@PathVariable String email) {
        return usuarioService.getUsuario(email);
    }

    @PutMapping("/{id}/alterar")
    public Usuario updateUsuario(
        @PathVariable Long id, 
        @RequestBody Usuario usuario
    ) {
        return usuarioService.update(id, usuario);
    }

}