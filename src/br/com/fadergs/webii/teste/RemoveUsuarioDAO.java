package br.com.fadergs.webii.teste;

import br.com.fadergs.webii.jdbc.UsuarioDAO;
import entidades.Usuario;

public class RemoveUsuarioDAO {
	
public static void main(String[] args) {
		
		Usuario usu = new Usuario();
		usu.setId(3);
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.remover(usu);
		
	}
	

}
