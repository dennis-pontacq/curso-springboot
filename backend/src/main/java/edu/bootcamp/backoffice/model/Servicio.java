package edu.bootcamp.backoffice.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the servicio database table.
 * 
 */
@Entity
@Table(name="servicio")
@NamedQuery(name="Servicio.findAll", query="SELECT s FROM Servicio s")
public class Servicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="costo_instalacion")
	private BigDecimal costoInstalacion;

	//bi-directional one-to-one association to Ofrecido
	@OneToOne
	@JoinColumn(name="id")
	private Ofrecido ofrecido;

	public Servicio() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getCostoInstalacion() {
		return this.costoInstalacion;
	}

	public void setCostoInstalacion(BigDecimal costoInstalacion) {
		this.costoInstalacion = costoInstalacion;
	}

	public Ofrecido getOfrecido() {
		return this.ofrecido;
	}

	public void setOfrecido(Ofrecido ofrecido) {
		this.ofrecido = ofrecido;
	}

}