package br.upe.controlepesoback.controlepesoback.services;

import java.util.List;

import org.joda.time.LocalDate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;

import br.upe.controlepesoback.controlepesoback.models.dto.PesoDto;
import br.upe.controlepesoback.controlepesoback.models.entity.Peso;
import br.upe.controlepesoback.controlepesoback.models.entity.Usuario;
import br.upe.controlepesoback.controlepesoback.repository.IPesoRepository;
import br.upe.controlepesoback.controlepesoback.repository.IUsuarioRepository;

@Service
public class PesoService {

    @Autowired
    private IPesoRepository pesoRepository;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    public Peso calcular(PesoDto bodyPeso) {
        if (!usuarioRepository.existsByEmail(bodyPeso.getEmail()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado!");

        Usuario usuario = usuarioService.getUsuario(bodyPeso.getEmail());

        double pesoAtual = bodyPeso.getPesoAtual();
        double altura = usuario.getAltura();
        double imc = pesoAtual / (altura * altura);

        LocalDate dataAtual = LocalDate.now();

        Peso peso = Peso.builder()
            .pesoAtual(pesoAtual)
            .dataAtual(dataAtual)
            .email(usuario.getEmail())
            .imc(imc)
            .build();

        return pesoRepository.save(peso);
    }

    public List<Peso> getPesos(String email) {
        return pesoRepository.findAll();
    }

}
