package br.com.fiap.estacionamento.business;

import br.com.fiap.estacionamento.dao.UsuarioDAO;
import br.com.fiap.estacionamento.model.entities.Usuario;

public class UsuarioBO {
	public Usuario autenticar(Usuario u) {
		Usuario usuario = new UsuarioDAO().consultarPorEmail(u.getEmail());
		if(usuario == null) return null;
		if(!usuario.getSenha().equals(u.getSenha())) return null;
		return usuario;
	}
	
	public boolean validarUsuario(Usuario u) {
		return u.getNome() != null && 
				u.getEmail() != null && 
				u.getSenha() != null; 
	}
}



