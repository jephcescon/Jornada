package br.com.jornada.models.dto;

import java.util.Calendar;

import br.com.jornada.daos.UsuarioDAO;
import br.com.jornada.models.Evento;
import br.com.jornada.models.Usuario;

public class EventoDTO {
	
	private int id;
	private String nome;

	private String descricao;
	private String site;

	private Integer organizador;
	private String local;
	private String logo;

	private Calendar data;
	
	public Evento toEvento(UsuarioDAO dao){
		
		Evento evento = new Evento();
		evento.setData(data);
		evento.setDescricao(descricao);
		evento.setLocal(local);
		evento.setLogo(logo);
		evento.setNome(nome);
		evento.setSite(site);
		
		Usuario organizador = dao.buscar(this.organizador);
		
		evento.setOrganizador(organizador);
		
		return evento;
	}

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

	public Integer getOrganizador() {
		return organizador;
	}

	public void setOrganizador(Integer organizador) {
		this.organizador = organizador;
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

	
}
