package com.xy.pois.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Entity
public class POI implements Serializable {
	
	private static final long serialVersionUID = 8318935238976017721L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	@NotBlank(message = "Informe um nome para o ponto de interesse!")
	@NotNull(message = "Informe um nome para o ponto de interesse!")
	private String name;
		
	@Column(nullable = false)
	@PositiveOrZero(message= "Informe um numero inteiro não negativo para a coordenada X!")
	private int x;
	
	@Column(nullable = false)
	@PositiveOrZero(message= "Informe um numero inteiro não negativo para a coordenada Y!")
	private int y;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;	
	}

	public void setY(int y) {
		this.y = y;
	}

	public Long getId() {
		return id;
	}	
	
}
