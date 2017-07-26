package br.com.jornada.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Voto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne
	private Usuario usuario;
	@OneToOne
	private Palestra palestra;
	private TipoVoto voto;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer idUsuario) {
		Usuario usuario = new Usuario();
		usuario.setId(idUsuario);
		this.usuario = usuario;
	}

	public Palestra getPalestra() {
		return palestra;
	}

	public void setPalestra(Integer idPalestra) {
		Palestra palestra = new Palestra();
		palestra.setId(idPalestra);
		this.palestra = palestra;
	}

	public TipoVoto getVoto() {
		return voto;
	}

	public void setVoto(TipoVoto voto) {
		this.voto = voto;
	}
}
