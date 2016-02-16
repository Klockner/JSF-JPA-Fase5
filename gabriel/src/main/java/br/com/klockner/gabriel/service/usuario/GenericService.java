/**
 * 
 */
package br.com.klockner.gabriel.service.usuario;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import br.com.klockner.gabriel.util.Model;

/**
 * @author Gabriel Klockner
 */
public abstract class GenericService<T extends Model<ID>, ID extends Serializable> implements Serializable {

	private static final long serialVersionUID = 1L;

	private Class<T> type;

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public GenericService() {
		Class<?> clazz = getClass();
		do {
			if (clazz.getSuperclass().equals(GenericService.class)) {
				break;
			}
		} while ((clazz = clazz.getSuperclass()) != null);

		this.type = (Class<T>) ((ParameterizedType) clazz.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public T findById(Long id) {
		return this.entityManager.find(type, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return createSession().createCriteria(type).list();
	}

	@Transactional
	public void remove(T object) {
		this.entityManager.remove(this.entityManager.getReference(this.type, object.getId()));
	}

	@Transactional
	public void create(T object) {
		this.entityManager.persist(object);
	}

	@Transactional
	public void update(T object) {
		this.entityManager.merge(object);
	}

	@Transactional
	public void save(T object) {
		if (object.getId() == null) {
			this.entityManager.persist(object);
		} else {
			this.entityManager.merge(object);
		}
	}

	protected Session createSession() {
		return (Session) this.entityManager.getDelegate();
	}

	protected EntityManager getEntityManager() {
		return this.entityManager;
	}

	protected Criteria getCriteria() {
		return createSession().createCriteria(type);
	}
}