package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name="Prendas")
public class PrendaEntity  implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 400630920252981500L;

	public PrendaEntity() {		
	}


	@EmbeddedId
	private PrendaID id;	
	
	private String descripcion;
	private boolean estadoProduccion;
	@Column(name="costoProduccion")
	private float costoProduccionReal;
	private float costoProduccionActual;
	private float porcentajeGanancia;
	private float precio;
	private int cantidadAConfeccionar;
	private int stockMinimo;
	private int stockActual;
/*
	@OneToMany
	//@JoinColumns(name="idPrenda")	//Mal, porque la clave primaria de prendas son las 3 ahora...
	@JoinColumns({
		@JoinColumn(name = "idPrenda", referencedColumnName = "idPrenda"),
		@JoinColumn(name = "idColor", referencedColumnName = "idColor"),
		@JoinColumn(name = "idTalle", referencedColumnName = "idTalle") })
	private List<ItemPrendaInsumoEntity> itemsPrendaInsumo;
	*/
	
	
	public int getStockMinimo() {
		return stockMinimo;
	}

	public void setStockMinimo(int stockMinimo) {
		this.stockMinimo = stockMinimo;
	}

	public int getStockActual() {
		return stockActual;
	}

	public void setStockActual(int stockActual) {
		this.stockActual = stockActual;
	}


public PrendaID getId() {
		return id;
	}

	public void setId(PrendaID id) {
		this.id = id;
	}

	/*	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinTable(name = "Prenda_Areas", joinColumns = {
	@JoinColumn(name = "idPrenda") }, inverseJoinColumns = { @JoinColumn(name = "idAreaProduccion") })
	private List<AreaProduccionEntity> areas;
	//Falta manejar los minutoEnArea de prenda_areas
*/
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public boolean getEstadoProduccion() {
		return estadoProduccion;
	}

	public void setEstadoProduccion(boolean estadoProduccion) {
		this.estadoProduccion = estadoProduccion;
	}

	public float getCostoProduccionReal() {
		return costoProduccionReal;
	}

	public void setCostoProduccionReal(float costoProduccionReal) {
		this.costoProduccionReal = costoProduccionReal;
	}

	public float getCostoProduccionActual() {
		return costoProduccionActual;
	}

	public void setCostoProduccionActual(float costoProduccionActual) {
		this.costoProduccionActual = costoProduccionActual;
	}

	public float getPorcentajeGanancia() {
		return porcentajeGanancia;
	}

	public void setPorcentajeGanancia(float porcentajeGanancia) {
		this.porcentajeGanancia = porcentajeGanancia;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public int getCantidadAConfeccionar() {
		return cantidadAConfeccionar;
	}

	public void setCantidadAConfeccionar(int cantidadAConfeccionar) {
		this.cantidadAConfeccionar = cantidadAConfeccionar;
	}

	
}
