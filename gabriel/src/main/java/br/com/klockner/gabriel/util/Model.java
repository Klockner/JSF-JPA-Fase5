/**
 * 
 */
package br.com.klockner.gabriel.util;

import java.io.Serializable;

/**
 * @author Gabriel Klockner
 */
public interface Model<ID extends Serializable> extends Serializable {

	ID getId();
}