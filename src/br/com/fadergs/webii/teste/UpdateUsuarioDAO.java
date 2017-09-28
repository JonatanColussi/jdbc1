package br.com.fadergs.webii.teste;

import br.com.fadergs.webii.jdbc.UsuarioDAO;
import entidades.Usuario;

public class UpdateUsuarioDAO {

public static void main(String[] args) {
		
		Usuario usu = new Usuario();
		usu.setNome("Beltrano");
		usu.setLogin("bel123");
		usu.setSenha("belsenha");
		usu.setId(3);
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.editar(usu);
		
	}
	
	
}
