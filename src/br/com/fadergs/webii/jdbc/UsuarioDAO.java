package br.com.fadergs.webii.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entidades.Usuario;

public class UsuarioDAO {

	private Connection con = Conexao.getConnection();
	
	public boolean cadastrar (Usuario usuario) {
		
		String sql = "INSERT INTO usuario (nome, login, senha) VALUES (?, ?, ?)";
		boolean retorno = false;
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, usuario.getSenha());
			
			preparador.execute();
			preparador.close();
			
			retorno = true;
		} catch (SQLException e) {
			e.printStackTrace();
			
		}

		return retorno;
	}
	
	public boolean editar (Usuario usuario) {
		String sql = "UPDATE usuario SET nome = ?, login = ?, senha = ? where id=?";
		boolean retorno = false;

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, usuario.getSenha());
			preparador.setInt(4, usuario.getId());
			
			preparador.execute();
			preparador.close();
			retorno = true;
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return retorno;
	}
	
	public boolean remover (Usuario usuario) {
		String sql = "DELETE FROM usuario WHERE id=?";
		boolean retorno = false;

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, usuario.getId());
			
			preparador.execute();
			preparador.close();
			
			retorno = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return retorno;
	}
	
	public ArrayList<Usuario> buscarTodos () {
		String sql = "SELECT * FROM usuario";
		ArrayList<Usuario> usuariosLista = new ArrayList<Usuario>();

		try {
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			while (result.next()) {
				Usuario usu = new Usuario();

				usu.setId(result.getInt(1));
				usu.setNome(result.getString(2));
				usu.setLogin(result.getString(3));
				usu.setSenha(result.getString(4));
				usuariosLista.add(usu);
			}

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuariosLista;
	}
	
	public Usuario buscarUsuarioPorId (Integer id) {
		String sql = "SELECT * FROM usuario WHERE id = ?";
		Usuario usuario = new Usuario();
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, id);
			ResultSet result = preparador.executeQuery();
			
			while (result.next()) {
				usuario.setId(result.getInt(1));
				usuario.setNome(result.getString(2));
				usuario.setLogin(result.getString(3));
				usuario.setSenha(result.getString(4));
			}

			preparador.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}

		return usuario;
	}

	public Usuario buscarUsuarioPorNome (String nome) {
		String sql = "SELECT * FROM usuario WHERE nome LIKE '%?%'";
		Usuario usuario = new Usuario();
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, nome);
			ResultSet result = preparador.executeQuery();
			
			while (result.next()) {
				usuario.setId(result.getInt(1));
				usuario.setNome(result.getString(2));
				usuario.setLogin(result.getString(3));
				usuario.setSenha(result.getString(4));
			}

			preparador.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}

		return usuario;
	}

	public Usuario buscarUsuarioPorLoginEId (String login, Integer id) {
		String sql = "SELECT * FROM usuario WHERE login LIKE '%?%' AND id = ?";
		Usuario usuario = new Usuario();
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, login);
			preparador.setInt(2, id);
			ResultSet result = preparador.executeQuery();
			
			while (result.next()) {
				usuario.setId(result.getInt(1));
				usuario.setNome(result.getString(2));
				usuario.setLogin(result.getString(3));
				usuario.setSenha(result.getString(4));
			}

			preparador.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}

		return usuario;
	}
}
