package edu.bootcamp.backoffice.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pedido database table.
 * 
 */
@Entity
@Table(name="pedido")
@NamedQuery(name="Pedido.findAll", query="SELECT p FROM Pedido p")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int estado;

	private String observaciones;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	private Cliente cliente;

	//bi-directional many-to-one association to PedidoItem
	@OneToMany(mappedBy="pedido")
	private List<PedidoItem> pedidoItems;

	public Pedido() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<PedidoItem> getPedidoItems() {
		return this.pedidoItems;
	}

	public void setPedidoItems(List<PedidoItem> pedidoItems) {
		this.pedidoItems = pedidoItems;
	}

	public PedidoItem addPedidoItem(PedidoItem pedidoItem) {
		getPedidoItems().add(pedidoItem);
		pedidoItem.setPedido(this);

		return pedidoItem;
	}

	public PedidoItem removePedidoItem(PedidoItem pedidoItem) {
		getPedidoItems().remove(pedidoItem);
		pedidoItem.setPedido(null);

		return pedidoItem;
	}

}