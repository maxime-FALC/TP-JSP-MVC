package controllers;
 
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import simplejdbc.DAO;
import simplejdbc.Discount_Code_Entity;
import simplejdbc.CustomerEntity;
import simplejdbc.DAOException;
import simplejdbc.DataSourceFactory;
 
@WebServlet(name = "DiscountCodeView", urlPatterns = {"/controller"})
public class DiscountCodeController extends HttpServlet {
 
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        
        try {
            // Créér le ExtendedDAO avec sa source de données
            DAO dao = new DAO(DataSourceFactory.getDataSource());
            
            String name;
            String rate;
            String action;
            
            action = request.getParameter("action");
            rate = request.getParameter("rate");
            name = request.getParameter("name");
            
            
            if(action != null && action.equals("Ajouter")){
                try{
                    dao.addDiscount(name, Float.parseFloat(rate));
                } catch(Exception ex){}
               
            }
            
            
            List<Discount_Code_Entity> discount = dao.discountCodeList();
            
 
            request.setAttribute("discounts", discount);
            // On continue vers la page JSP sélectionnée
            request.getRequestDispatcher("views/DiscountCodeView.jsp").forward(request, response);
        } catch (DAOException ex) {
            Logger.getLogger("servlet").log(Level.SEVERE, "Erreur de traitement", ex);
        }
    }
 
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        processRequest(request, response);
    }
 
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        processRequest(request, response);
    }
 
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
 
}