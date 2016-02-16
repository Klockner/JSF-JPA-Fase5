/**
 * 
 */
package br.com.klockner.gabriel.service.usuario;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author Gabriel Klockner
 */
public abstract class GenericService<T> {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void salvar(T obj) {
		entityManager.persist(obj);
	}
}
