package br.upe.controlepesoback.controlepesoback.models.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder 
@AllArgsConstructor 
@NoArgsConstructor
public class PesoDto {

  @Email
  @NotNull
  @NotBlank
  private String email;

  @Positive
  @Min(10)
  @Max(300)
  @NotNull(message="Para prosseguir informar peso")
  private double pesoAtual;

}