package com.backend.unab.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "partidos")
public class Match implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "usuario", nullable = false)
	private User usuario;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "local", nullable = false)
	private Team local;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "visitante", nullable = false)
	private Team visitante;
	@Column(nullable = true)
	@Temporal(TemporalType.DATE)
	private Date fecha;
	@Column(name = "goles_local")
	private Integer golesLocal;
	@Column(name = "goles_visitante")
	private Integer golesVisitante;

	private Long usuario_id;
	private Long visitante_id;
	private Long local_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	public Team getLocal() {
		return local;
	}

	public void setLocal(Team local) {
		this.local = local;
	}

	public Team getVisitante() {
		return visitante;
	}

	public void setVisitante(Team visitante) {
		this.visitante = visitante;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getGolesLocal() {
		return golesLocal;
	}

	public void setGolesLocal(Integer golesLocal) {
		this.golesLocal = golesLocal;
	}

	public Integer getGolesVisitante() {
		return golesVisitante;
	}

	public void setGolesVisitante(Integer golesVisitante) {
		this.golesVisitante = golesVisitante;
	}

	public Long getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(Long usuario_id) {
		this.usuario_id = usuario_id;
	}

	public Long getVisitante_id() {
		return visitante_id;
	}

	public void setVisitante_id(Long visitante_id) {
		this.visitante_id = visitante_id;
	}

	public Long getLocal_id() {
		return local_id;
	}

	public void setLocal_id(Long local_id) {
		this.local_id = local_id;
	}

}
