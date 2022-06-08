package br.upe.controlepesoback.controlepesoback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class ControlePesoBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControlePesoBackApplication.class, args);
	}

}
