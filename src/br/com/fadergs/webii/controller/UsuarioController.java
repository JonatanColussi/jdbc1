package br.com.fadergs.webii.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fadergs.webii.jdbc.UsuarioDAO;
import entidades.Usuario;
/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/usucontroller.do")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UsuarioController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Chamando método GET");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Chamando método POST");
		int id       = Integer.parseInt(request.getParameter("txtId"));
		String nome  = request.getParameter("txtNome");
		String login = request.getParameter("txtLogin");
		String senha = request.getParameter("txtSenha");

		Usuario usu = new Usuario();
		usu.setId(id);
		usu.setNome(nome);
		usu.setLogin(login);
		usu.setSenha(senha);
		
		UsuarioDAO usuDAO = new UsuarioDAO();

		Usuario usuFind = usuDAO.buscarUsuarioPorId(id);

		PrintWriter saida = response.getWriter();

		boolean resultado = false;

		if(usuFind.getId() == null){
			resultado = usuDAO.cadastrar(usu);
			if(resultado == true){
				saida.print("cadastrado com sucesso");
			}else{
				saida.print("falha no cadastro");
			}
		}else{
			resultado = usuDAO.editar(usu);
			if(resultado == true){
				saida.print("alterado com sucesso");
			}else{
				saida.print("falha na alteração");
			}
		}
	}

}
