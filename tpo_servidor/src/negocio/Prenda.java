package negocio;

import dto.PrendaDTO;
import entities.PrendaEntity;
import persistencia.PrendaDAO;

public class Prenda {
	private int idPrenda;
	private String descripcion;
	private boolean estadoProduccion;
	private float costoProduccionReal;
	private float costoProduccionActual;
	private float porcentajeGanancia;
	private float precio;
	public int cantidadAConfeccionar;
	private String color;
	private String talle;
	private int stockMinimo;
	private int stockActual;

	public String getTalle() {
		return talle;
	}


	public void setTalle(String talle) {
		this.talle = talle;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public Prenda(PrendaDTO preDTO) {
		this.idPrenda = preDTO.getIdPrenda();
		this.descripcion = preDTO.getDescripcion();
		this.estadoProduccion = preDTO.isEstadoProduccion();
		this.costoProduccionReal = preDTO.getCostoProduccionReal();
		this.costoProduccionActual = preDTO.getCostoProduccionActual();
		this.porcentajeGanancia = preDTO.getPorcentajeGanancia();
		this.precio = preDTO.getPrecio();	
		this.cantidadAConfeccionar = preDTO.getCantidadAConfeccionar();
		this.color = preDTO.getColor();
		this.talle = preDTO.getTalle();
		this.stockActual = preDTO.getStockActual();
		this.stockMinimo = preDTO.getStockMinimo();
	}


	public Prenda(PrendaEntity p) {
		this.idPrenda = p.getId().getIdPrenda();
		this.descripcion = p.getDescripcion();
		this.estadoProduccion = p.getEstadoProduccion();
		this.costoProduccionReal = p.getCostoProduccionReal();
		this.costoProduccionActual = p.getCostoProduccionActual();
		this.porcentajeGanancia = p.getPorcentajeGanancia();
		this.precio = p.getPrecio();
		this.cantidadAConfeccionar = p.getCantidadAConfeccionar();
		this.color = p.getId().getColor().getNombre();
		this.talle = p.getId().getTalle().getNombre();
		this.stockActual = p.getStockActual();
		this.stockMinimo = p.getStockMinimo();
	}

	
	public Prenda() {
		// TODO Auto-generated constructor stub
	}


	public void insertar() {
		PrendaDAO.getInstancia().insert(this);		
	}

	public void borrar() {
		PrendaDAO.getInstancia().eliminar(this.idPrenda);
	}
	public boolean sosLaPrenda(int numero) {
		return (numero == this.idPrenda); 

	}



	public int getIdPrenda() {
		return idPrenda;
	}


	public void setIdPrenda(int idPrenda) {
		this.idPrenda = idPrenda;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public boolean isEstadoProduccion() {
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


	public PrendaDTO toDTO() {
		PrendaDTO prenda = new PrendaDTO();
		prenda.setCantidadAConfeccionar(cantidadAConfeccionar);
		prenda.setIdPrenda(idPrenda);
		prenda.setColor(color);
		prenda.setTalle(talle);
		prenda.setCostoProduccionActual(costoProduccionActual);
		prenda.setCostoProduccionReal(costoProduccionReal);
		prenda.setDescripcion(descripcion);
		prenda.setEstadoProduccion(estadoProduccion);
		prenda.setPorcentajeGanancia(porcentajeGanancia);
		prenda.setPrecio(precio);
		prenda.setStockActual(stockActual);
		prenda.setStockMinimo(stockMinimo);
		return prenda;
	}


	public String getColor() {
		return color;
	}


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


}
