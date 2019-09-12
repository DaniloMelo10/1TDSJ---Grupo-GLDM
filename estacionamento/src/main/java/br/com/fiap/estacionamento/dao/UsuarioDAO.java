package br.com.fiap.estacionamento.dao;

import java.util.ArrayList;

import br.com.fiap.estacionamento.model.entities.Usuario;


public class UsuarioDAO {
		private static ArrayList<Usuario> USUARIOS = new ArrayList<>();
		
		static {
			USUARIOS.add(new Usuario("Usuario", "usuario", "123"));
		}
		
		public void adicionar(Usuario u) {
			USUARIOS.add(u);
		}
		
		public ArrayList<Usuario> consultarTodos() {
			return USUARIOS;
		}
		
		public Usuario consultarPorEmail(String email) {
			for(Usuario u : USUARIOS) {
				if(u.getEmail().equals(email)) {
					return u;
				}
			}
			return null;
		}
		

	}



