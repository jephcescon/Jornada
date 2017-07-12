package br.com.jornada.models;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	@Lob
	private String descricao;
	private String site;
	@OneToOne
	private Usuario organizador;
	private String local;
	private String logo;
	@DateTimeFormat
	private Calendar data;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public Usuario getOrganizador() {
		return organizador;
	}

	public void setOrganizador(Integer organizador) {
		System.out.println(organizador);
		Usuario usuario = new Usuario();
		usuario.setId(1);
		this.organizador = usuario;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", site=" + site + ", organizador="
				+ organizador + ", local=" + local + ", logo=" + logo + "]";
	}
}
