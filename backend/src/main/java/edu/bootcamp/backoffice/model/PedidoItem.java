package edu.bootcamp.backoffice.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the pedido_item database table.
 * 
 */
@Entity
@Table(name="pedido_item")
@NamedQuery(name="PedidoItem.findAll", query="SELECT p FROM PedidoItem p")
public class PedidoItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private BigDecimal cantidad;

	private BigDecimal precio;

	//bi-directional many-to-one association to Ofrecido
	@ManyToOne
	private Ofrecido ofrecido;

	//bi-directional many-to-one association to Pedido
	@ManyToOne
	private Pedido pedido;

	public PedidoItem() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Ofrecido getOfrecido() {
		return this.ofrecido;
	}

	public void setOfrecido(Ofrecido ofrecido) {
		this.ofrecido = ofrecido;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}