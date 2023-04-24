package bankConsole;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.badjo.entities.Compte;
import com.badjo.session.IbankRemote;

public class Main {

	public static void main(String[] args) {

		try {
			String appName = "", moduleName = "BanqueEJB_", distinctName = "BP2",
					viewClassName = IbankRemote.class.getName();
			Context ctx = new InitialContext();
			String ejbRemoteJNDIName = "ejb:" + appName + "/" + moduleName + "/" + distinctName + 
					"!" + viewClassName;
			System.out.println(ejbRemoteJNDIName);
			IbankRemote stub = (IbankRemote) ctx.lookup(ejbRemoteJNDIName);
			System.out.println("Affichage de tous les comptes");
			List<Compte> cptes = stub.consulterComptes();
			for(Compte cp:cptes) 
				System.out.println(cp);
			System.out.println("Versement du montant");
			stub.verser(2L, 22000);
			System.out.println("Consultaiton du Compte 2");
			Compte cp = stub.consulterCompte(2L);
			System.out.println(cp);
			System.out.println("Retrait du montant compte 1");
			stub.retire(1L, 300);
			System.out.println("Consultation du Compte 1");
			stub.consulterCompte(1L);
			System.out.println(cp);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
