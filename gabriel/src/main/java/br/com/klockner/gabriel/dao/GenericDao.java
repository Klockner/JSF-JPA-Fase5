/**
 * 
 */
package br.com.klockner.gabriel.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;


/**
 * @author Gabriel Klockner
 */
@Transactional
public abstract class GenericDao<T> {
	
//	@PersistenceContext
//	private EntityManager entityManager = JPAUtil.getEntityManager();
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void salvar(T obj) {
		entityManager.persist(obj);
	}
	
//	@Transactional
//	public void salvar(T obj) {
//		entityManager.getTransaction().begin();
//		entityManager.persist(obj);
//		entityManager.getTransaction().commit();
//	}
}
