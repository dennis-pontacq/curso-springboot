package edu.bootcamp.backoffice.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the ofrecido database table.
 * 
 */
@Entity
@Table(name="ofrecido")
@NamedQuery(name="Ofrecido.findAll", query="SELECT o FROM Ofrecido o")
public class Ofrecido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String nombre;

	private BigDecimal precio;

	//bi-directional many-to-one association to PedidoItem
	@OneToMany(mappedBy="ofrecido")
	private List<PedidoItem> pedidoItems;

	//bi-directional one-to-one association to Producto
	@OneToOne(mappedBy="ofrecido")
	private Producto producto;

	//bi-directional one-to-one association to Servicio
	@OneToOne(mappedBy="ofrecido")
	private Servicio servicio;

	public Ofrecido() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public List<PedidoItem> getPedidoItems() {
		return this.pedidoItems;
	}

	public void setPedidoItems(List<PedidoItem> pedidoItems) {
		this.pedidoItems = pedidoItems;
	}

	public PedidoItem addPedidoItem(PedidoItem pedidoItem) {
		getPedidoItems().add(pedidoItem);
		pedidoItem.setOfrecido(this);

		return pedidoItem;
	}

	public PedidoItem removePedidoItem(PedidoItem pedidoItem) {
		getPedidoItems().remove(pedidoItem);
		pedidoItem.setOfrecido(null);

		return pedidoItem;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Servicio getServicio() {
		return this.servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

}