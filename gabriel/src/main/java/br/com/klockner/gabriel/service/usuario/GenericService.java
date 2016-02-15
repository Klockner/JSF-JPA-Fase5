/**
 * 
 */
package br.com.klockner.gabriel.service.usuario;

import br.com.klockner.gabriel.dao.GenericDao;

/**
 * @author Gabriel Klockner
 */
public abstract class GenericService<T> {
	
	public abstract GenericDao<T> getDAO();
	
	public void salvar(T obj) {
		getDAO().salvar(obj);
	}
}
