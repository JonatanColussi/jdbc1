package br.com.fadergs.webii.teste;

import br.com.fadergs.webii.jdbc.UsuarioDAO;
import entidades.Usuario;

public class TestUsuarioDAO {
	
	public static void main(String[] args) {
		
		Usuario usu = new Usuario();
		usu.setNome("Fulano");
		usu.setLogin("ful123");
		usu.setSenha("fulsenha");
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.cadastrar(usu);
		
	}

}
