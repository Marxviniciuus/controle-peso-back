package br.upe.controlepesoback.controlepesoback.models.entity;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import org.joda.time.LocalDate;

import javax.persistence.*;

@Data
@Builder 
@Entity 
@AllArgsConstructor 
@NoArgsConstructor
@Accessors(chain = true)
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 200)
    private String nome;
    
    @Email
    @NotBlank
    private String email;

    @Positive
    private double altura;
    
    @Enumerated(EnumType.STRING)
    private GeneroEnum genero;

    @Positive
    private double pesoInicial;
    
    @Positive
    private double pesoFinal;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataFinal;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataInicial;
    
}
