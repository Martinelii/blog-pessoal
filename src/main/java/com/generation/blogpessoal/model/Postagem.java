package com.generation.blogpessoal.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_postagens")
public class Postagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Atributo titulo Obrigatorio!!")
	@Size(min = 5, max = 100, message = "O titulo deve conter entre 5 e 100 caracteres")
	private String titulo;
	
	@NotBlank(message = "Atributo texto é Obrigatorio")
	@Size(min = 10, max = 100, message = "O texto deve conter entre 10 e 100 caracteres")
	private String texto;
	
	@UpdateTimestamp
	private LocalDateTime data;
	
	//criando relação bi-direcional;
	@ManyToOne //Muitas postagens terão um tema;
	@JsonIgnoreProperties("postagem") //ignorando os atributos de postagem que virão de Tema
	private Tema tema;
	
	
	
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getTexto() {
		return this.texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public LocalDateTime getData() {
		return this.data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	
	public Tema getTema() {
		return this.tema;
	}
	public void setTema(Tema tema) {
		this.tema = tema;
	}
}
