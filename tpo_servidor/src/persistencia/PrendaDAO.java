package persistencia;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.ColorEntity;
import entities.PrendaEntity;
import entities.PrendaID;
import entities.TalleEntity;
import hibernate.HibernateUtil;
import negocio.Prenda;

public class PrendaDAO  {
	
	private static SessionFactory sf;
	private static PrendaDAO instancia;
	
	public static PrendaDAO getInstancia(){
		if (instancia==null){
			sf = HibernateUtil.getSessionFactory();
			instancia= new PrendaDAO();
		}
		return instancia;
		
	}
	private PrendaDAO(){
		
	}
	
	public void eliminar(int id){
		SessionFactory sf= HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		PrendaEntity res= (PrendaEntity) session.get(PrendaEntity.class, id);
		session.beginTransaction();
		session.delete(res);
		session.getTransaction().commit();
		session.close();	
	}
	
	
	public void insert(Prenda prenda){
		PrendaEntity pr= toEntity(prenda);
		Session sesion;
		sesion = sf.openSession();
		sesion.beginTransaction();
		sesion.save(pr);
		sesion.getTransaction().commit();
		sesion.close();
	}


	public Prenda getPrenda(int id) {
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		PrendaEntity emp = (PrendaEntity) sesion.get(PrendaEntity.class, id);	
		sesion.close();		
		return new Prenda(emp);
	}
	
	

	public PrendaEntity toEntity(Prenda prenda){
		PrendaID id = new PrendaID();
		ColorEntity color = ColorDAO.getInstancia().getColor(prenda.getColor());
		TalleEntity talle = TalleDAO.getInstancia().getTalle(prenda.getTalle());	
		id.setColor(color);
		id.setTalle(talle);
		id.setIdPrenda(prenda.getIdPrenda());
		PrendaEntity p = new PrendaEntity();
		p.setId(id);
		p.setCantidadAConfeccionar(prenda.getCantidadAConfeccionar());
		p.setCostoProduccionActual(prenda.getCostoProduccionActual());
		p.setCostoProduccionReal(prenda.getCostoProduccionReal());
		p.setDescripcion(prenda.getDescripcion());
		p.setEstadoProduccion(prenda.isEstadoProduccion());
		p.setPorcentajeGanancia(prenda.getPorcentajeGanancia());
		p.setPrecio(prenda.getPrecio());
		p.setStockActual(prenda.getStockActual());
		p.setStockMinimo(prenda.getStockMinimo());	
		return p;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Prenda> getAll(){
		
		Session sesion = sf.openSession();
		sesion.beginTransaction();
		ArrayList<PrendaEntity> pre = new ArrayList<PrendaEntity>();
		Query query = sesion.createQuery("from PrendaEntity");
		pre = (ArrayList<PrendaEntity>) query.list();
		sesion.close();
		ArrayList<Prenda> prendas = new ArrayList<Prenda>();
		for (PrendaEntity ee : pre){
			prendas.add(new Prenda(ee));
		}
		return prendas;		
	}
	

}
