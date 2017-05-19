package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Temperature;

public enum TemperatureDAO {

	INSTANCE;

	private static final String PERSISTENCE_UNIT_NAME = "themp";
	private EntityManagerFactory factory;
	EntityManager em;

	private TemperatureDAO() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = factory.createEntityManager();
	}
	
	public void create(Temperature temperature) {
		try {
			em.getTransaction().begin();
			em.persist(temperature);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 2 jours de mesures prises toutes les 10 minutes : les 288 dernières mesures
	 * */
	@SuppressWarnings("unchecked")
	public List<Temperature> readAll() {		
		Query query = em.createQuery("SELECT t FROM Temperature t order by t.ts desc")
						.setMaxResults(288);
	    return query.getResultList();
	}
}
