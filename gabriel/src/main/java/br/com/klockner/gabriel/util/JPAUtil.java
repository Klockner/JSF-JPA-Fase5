/**
 * 
 */
package br.com.klockner.gabriel.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Gabriel Klockner
 */
public class JPAUtil {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnitMySQL");
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
