package br.com.jornada.models;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Comentario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String mensagem;
	@OneToOne
	private Palestra palestra;
	@OneToOne
	private Usuario usuario;
	@DateTimeFormat
	private Calendar data;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Palestra getPalestra() {
		return palestra;
	}

	public void setPalestra(Integer idPalestra) {
		Palestra palestra = new Palestra();
		palestra.setId(idPalestra);
		this.palestra = palestra;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer palestranteId) {
		Usuario usuario = new Usuario();
		usuario.setId(palestranteId);
		this.usuario = usuario;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = Calendar.getInstance();
	}
}
