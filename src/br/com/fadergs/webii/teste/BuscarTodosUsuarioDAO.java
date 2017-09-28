package br.com.fadergs.webii.teste;

import java.util.ArrayList;

import br.com.fadergs.webii.jdbc.UsuarioDAO;
import entidades.Usuario;


public class BuscarTodosUsuarioDAO {

public static void main(String[] args) {
		
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		ArrayList<Usuario> usuariosLista = usuDAO.buscarTodos();
		
		System.out.println(usuariosLista.get(1).getNome());
		
	}
	
}
