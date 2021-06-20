/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import entity.Product;

/**
 *
 * @author PC
 */
@WebServlet(name = "ProductServlet", urlPatterns = {"/ProductServlet"})
public class ProductServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
	ArrayList <Product> list = new ArrayList<Product>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String url = "product.jsp";
    	  
  	 	Product p1 = new Product("Điện thoại Nokia", 20, 1500000);
      	Product p2 = new Product("Điện thoại Samsung", 50, 5500000);
      	list.add(p1);
      	list.add(p2);
      	HttpSession session = request.getSession();
		session.setAttribute("LIST", list);
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
     
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
    	try {
    		String url = "product.jsp";
        	String name = request.getParameter("tenSanPham");
        	int quantity = Integer.parseInt(request.getParameter("quantity"));
        	float price = Float.parseFloat(request.getParameter("price"));
        	Product p = new Product(name, quantity, price);
        	
           
            if (!list.contains(p)) {
				list.add(p);
				request.setAttribute("SUCCESS", "Add product successfully!");
				HttpSession session = request.getSession();
				session.setAttribute("LIST", list);
				
			} else {

				request.setAttribute("FAIL", "FAIL!!");
			}

		} catch (Exception e) {
			request.setAttribute("FAIL", "FAIL!!");
		} finally {
			String url = "product.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		}
     
       
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
