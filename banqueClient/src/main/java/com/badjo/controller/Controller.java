package com.badjo.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.badjo.entities.Compte;
import com.badjo.session.IbankLocal;


@WebServlet(name = "cs", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
    private IbankLocal metier;
    
    public Controller() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String action = request.getParameter("action");
			if(action != null) {
				if(action.equals("consulter")){
					Long code = Long.parseLong(request.getParameter("code"));
					request.setAttribute("code", code);
					Compte cp = metier.consulterCompte(code);
					request.setAttribute("compte", cp);
				}
				else
				{
					if(action.equals("Tous les Comptes!")) {
						request.setAttribute("comptes", metier.consulterComptes());
					}
					else {
						if(action.equals("Consulter") || action.equals("Retirer")){
							double montant = Double.parseDouble(request.getParameter("montant"));
							Long code = Long.parseLong(request.getParameter("code"));
							request.setAttribute("montant", montant);
							request.setAttribute("code", code);
							if(action.equals("Verser")) {
								metier.verser(code, montant);
							}
							else
								metier.retire(code, montant);
							metier.consulterCompte(code);
						}
					}
				}
								
			}
		}catch(Exception e){
			request.setAttribute("exception", e.getMessage());
		}
		request.getRequestDispatcher("bank.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
