package com.edib.practica1.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "CLIENTES")
public class TablaClientes {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idCliente;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellidos")
	private String apellidos;

	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "email")
	private String email;
	
	@OneToMany(mappedBy="tablaClientes")
	private List<TablaFacturas> tablaFacturas;
	
	public TablaClientes() {
		
	}
	
	public TablaClientes(String nombre, String apellidos, String direccion, String telefono, String email) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
	}

	
	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<TablaFacturas> getTablaFacturas() {
		return tablaFacturas;
	}

	public void setTablaFacturas(List<TablaFacturas> tablaFacturas) {
		this.tablaFacturas = tablaFacturas;
	}

	@Override
	public String toString() {
		return "TablaClientes [idCliente=" + idCliente + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", direccion=" + direccion + ", telefono=" + telefono + ", email=" + email + "]";
	}


	
}


