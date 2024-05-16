package myPackage.admin;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)
public class AddProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String proName = request.getParameter("pro_name");
        String proDesc = request.getParameter("pro_desc");
        Part proImgPart = request.getPart("pro_img");
        String proCat = request.getParameter("pro_cat");
        double proPrice = Double.parseDouble(request.getParameter("pro_price"));

        InputStream proImgInputStream = proImgPart.getInputStream();

        addProduct ap1 = new addProduct();
        ap1.addProductde(proName, proDesc, proImgInputStream, proCat, proPrice);

        response.sendRedirect("productAdded.jsp");
    }
}
