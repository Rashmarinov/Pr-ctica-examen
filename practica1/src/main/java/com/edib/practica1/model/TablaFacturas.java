package com.edib.practica1.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "FACTURAS")
public class TablaFacturas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idFactura;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "importe")
	private double importe;

	@Column(name = "pagado")
	private boolean pagado;

	@ManyToOne
	@JoinColumn(name="idCliente", nullable=false)
	private TablaClientes tablaClientes;

	public TablaFacturas() {
		super();
	}

	public TablaFacturas(String descripcion, double importe, boolean pagado, TablaClientes tablaClientes) {
		super();
		this.descripcion = descripcion;
		this.importe = importe;
		this.pagado = pagado;
		this.tablaClientes = tablaClientes;
	}

	public long getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(long idFactura) {
		this.idFactura = idFactura;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public boolean isPagado() {
		return pagado;
	}

	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}

	public TablaClientes getTablaClientes() {
		return tablaClientes;
	}

	public void setTablaClientes(TablaClientes tablaClientes) {
		this.tablaClientes = tablaClientes;
	}

	@Override
	public String toString() {
		return "TablaFacturas "
				+ "[idFactura=" + idFactura 
				+ ", descripcion=" + descripcion 
				+ ", importe=" + importe
				+ ", pagado=" + pagado + "]";
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof TablaFacturas)) {
			return false;
		}
		if (getClass() != o.getClass())
			return false;
		TablaFacturas that = (TablaFacturas) o;
		return getIdFactura() == that.getIdFactura() && Objects.equals(getDescripcion(), that.getDescripcion())
				&& getImporte() == that.getImporte() && isPagado() == that.isPagado();
	}

	@Override
	public int hashCode() {
		return Objects.hash(getIdFactura(),getDescripcion(),getImporte(),isPagado());
	}

	

	
}
