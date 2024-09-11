/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author Hung Bui
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        String u = request.getParameter("user");
        String p = request.getParameter("pass");

        // Validate the inputs
        if (u == null || p == null) {
            request.setAttribute("error", "Username or Password cannot be empty!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        // Create cookies
        Cookie cu = new Cookie("cuser", u);
        Cookie cp = new Cookie("cpass", p);
        response.addCookie(cu);
        response.addCookie(cp);

        // Check user credentials
        DAO d = new DAO();
        User a = d.check(u, p);
        HttpSession session = request.getSession();

        if (a == null) {
            request.setAttribute("error", "Username or Password invalid!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            session.setAttribute("account", a);
            response.sendRedirect("welcome.jsp");
        }
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
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String confirmPass = request.getParameter("confirmPass");

        DAO dao = new DAO();
        // Validate the inputs
        if (email == null || pass == null || confirmPass == null || !pass.equals(confirmPass)) {
            request.setAttribute("error", "Mật khẩu không khớp, vui lòng nhập lại!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
        if (dao.isEmailExists(email)) {
            request.setAttribute("error", "Email này đã được đăng ký, vui lòng chọn Email khác");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
        if (pass.contains(" ")) {
            request.setAttribute("error", "Mật khẩu không được chứa khoảng trắng");
        }

        // Create a new user
        
        boolean isRegistered = dao.register(email, pass);
        if (isRegistered) {
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "Đăng ký không thành công, vui lòng thử lại!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
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
