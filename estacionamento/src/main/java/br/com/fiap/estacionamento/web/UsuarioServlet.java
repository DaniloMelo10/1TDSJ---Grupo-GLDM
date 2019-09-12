package br.com.fiap.estacionamento.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.estacionamento.business.UsuarioBO;
import br.com.fiap.estacionamento.dao.UsuarioDAO;
import br.com.fiap.estacionamento.model.entities.Usuario;

public class UsuarioServlet extends HttpServlet{
	private static final long serialVersionUID = 2817110082724333908L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		
		Usuario usuario = new Usuario(nome, email, senha);
		
		out.println("<html><body>");
		
		if(new UsuarioBO().validarUsuario(usuario)) {
			new UsuarioDAO().adicionar(usuario);
			out.println("<h2>Usuário " + usuario.getNome() + " foi criado.</h2>");
			
		} else {
			out.println("<h2 style=\"color:red;\"> É preciso "
					+ "informar todos os campos do usuário</h2>");
		}
		
		out.println("<a href=\"index.html\">Voltar para Home</a>");
		out.println("</body></html>");
		out.flush();
		out.close();
		
	}

}
