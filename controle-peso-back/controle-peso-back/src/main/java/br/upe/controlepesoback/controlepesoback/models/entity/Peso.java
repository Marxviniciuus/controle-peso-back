package br.upe.controlepesoback.controlepesoback.models.entity;

import org.joda.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Builder 
@Entity 
@AllArgsConstructor 
@NoArgsConstructor
@Accessors(chain = true)
public class Peso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataAtual;

    @Positive
    private double imc;

    @Positive
    private double pesoAtual;

    @Email
    @NotBlank
    private String email;

}
