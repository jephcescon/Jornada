package br.com.jornada.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity
public class Palestra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String titulo;
	@Lob
	private String descricao;
	@OneToOne
	private Usuario palestrante;
	@OneToOne
	private Evento evento;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Usuario getPalestrante() {
		return palestrante;
	}

	public void setPalestrante(Integer palestranteId) {
		Usuario usuario = new Usuario();
		usuario.setId(palestranteId);
		this.palestrante = usuario;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Integer eventoId) {
		Evento evento = new Evento();
		evento.setId(eventoId);
		this.evento = evento;
	}
}
