/**
 * 
 */
package br.com.klockner.gabriel.controller.usuario;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.klockner.gabriel.model.usuario.Usuario;
import br.com.klockner.gabriel.service.usuario.UsuarioService;

/**
* 
* @author Gabriel Klockner
*/

@Controller
@Scope("request")
public class UsuarioController {
	private Usuario usuario = new Usuario();
	
	@Autowired
	private UsuarioService usuarioService;

	public void salvar() {
		usuarioService.save(usuario);
		//TODO verificar se usuario ja existe no banco e mandar mensagem de erro
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, 
						"Cadastro realizado com sucesso.", null));
	}
	
	public UsuarioService getUsuarioService() {
		return usuarioService;
	}
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
