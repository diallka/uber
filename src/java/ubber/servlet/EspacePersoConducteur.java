/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubber.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ubber.dao.ConducteurDAO;
import ubber.entity.Commande;
import ubber.entity.Conducteur;
import ubber.service.CommandeService;
import ubber.service.ConducteurService;

/**
 *
 * @author pro
 */
@WebServlet(name = "EspacePersoConducteur", urlPatterns = {"/espace_perso_conducteur"})
public class EspacePersoConducteur extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        

        long id = (long) req.getSession().getAttribute("idCond");
        Conducteur conducteur = new ConducteurService().RecupererUnConducteur(id);
        
        req.setAttribute("cond", conducteur);
        //String name = req.getUserPrincipal().getName();
        //Mettre ceci dans la JSP      ${pageContext.request.userPrincipal.name}
        //long idConducteur = Long.parseLong(req.getParameter("id"));
       
        //List<Commande>  mesCommandes = new CommandeService().listerCommandesParConducteur(idConducteur);
        
        
        req.getRequestDispatcher("espace_perso_conducteur.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        //long idReservation = (long) req.getSession().getAttribute("idReservation");
         long idConducteur = Long.parseLong(req.getParameter("id"));
        String origine = req.getParameter("origin");
        String destination = req.getParameter("destination");
        Conducteur cond = new Conducteur();
        cond.setId(idConducteur);
        
        Commande cmd = new Commande();
        cmd.setConducteur(cond);
        cmd.setAdresse_destination(destination);
        
        new CommandeService().creerCommande(cmd);
    }

    
    

}
