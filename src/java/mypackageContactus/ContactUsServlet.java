package myPackageContact;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contactus")
public class ContactUsServlet extends HttpServlet {
    private final ContactDao contactDao = new ContactDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.sendRedirect("error.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String message = request.getParameter("message");
        
        if (name == null || email == null || message == null) {
            response.sendRedirect("error.jsp");
            return;
        }
        
        try {
            contactDao.insertContact(name, email, message);
            response.sendRedirect("thankyou.jsp");
        } catch (SQLException e) {
            e.printStackTrace(); // Log the exception
            response.sendRedirect("error.jsp");
        }
    }
}