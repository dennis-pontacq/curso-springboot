package edu.bootcamp.backoffice.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
@Table(name="producto")
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="costo_soporte")
	private BigDecimal costoSoporte;

	//bi-directional one-to-one association to Ofrecido
	@OneToOne
	@JoinColumn(name="id")
	private Ofrecido ofrecido;

	public Producto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getCostoSoporte() {
		return this.costoSoporte;
	}

	public void setCostoSoporte(BigDecimal costoSoporte) {
		this.costoSoporte = costoSoporte;
	}

	public Ofrecido getOfrecido() {
		return this.ofrecido;
	}

	public void setOfrecido(Ofrecido ofrecido) {
		this.ofrecido = ofrecido;
	}

}