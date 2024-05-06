package myPackage.admin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import myPackage.DbUtil;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50) 
public class AddProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String proName = request.getParameter("pro_name");
        String proDesc = request.getParameter("pro_desc");
        int proCat = Integer.parseInt(request.getParameter("pro_cat"));
        double proPrice = Double.parseDouble(request.getParameter("pro_price"));
        String imgName = null;
        
        Part filePart = request.getPart("pro_img");
        if (filePart != null) {
            imgName = generateUniqueFileName(filePart);
            saveFile(filePart, imgName, request);
        }

        insertProduct(proName, proDesc, proPrice, proCat, imgName);
        response.getWriter().println("Product added successfully");
    }
    
    private void insertProduct(String proName, String proDesc, double proPrice, int proCat, String imgName){
        try (Connection conn = DbUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO products (cat_id, pro_name, pro_price, pro_img, pro_desc, reviews, date) VALUES (?, ?, ?, ?, ?, ?, ?)")) {
            stmt.setInt(1, proCat);
            stmt.setString(2, proName);
            stmt.setDouble(3, proPrice);
            stmt.setString(4, imgName);
            stmt.setString(5, proDesc);
            stmt.setInt(6, 0);
            stmt.setTimestamp(7, new java.sql.Timestamp(System.currentTimeMillis()));
            stmt.executeUpdate();
        }catch (SQLException e){
            e.getMessage();
        }
    }
    
    
    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
        
    }
    
    private String generateUniqueFileName(Part filePart) {
        String fileName = getFileName(filePart);
        String[] tokens = fileName.split("\\.");
        String extension = tokens[tokens.length - 1];
        String uniqueName = System.currentTimeMillis() + "_" + (int)(Math.random() * 1000) + "." + extension;
        return uniqueName;
    }
    
    private void saveFile(Part filePart, String fileName, HttpServletRequest request) throws IOException {
        if (fileName != null && !fileName.isEmpty()) {
            String uploadDir = request.getServletContext().getRealPath("/") + "uploads";
            String filePath = uploadDir + File.separator + fileName;

            File uploadDirFile = new File(uploadDir);
            if (!uploadDirFile.exists()) {
                boolean created = uploadDirFile.mkdirs();
                if (!created) {
                    System.err.println("Failed to create directory: " + uploadDir);
                    return;
                }
            }

            try (InputStream inputStream = filePart.getInputStream()) {
                Files.copy(inputStream, Paths.get(filePath));
                System.out.println("File saved successfully: " + filePath);
            } catch (IOException e) {
                System.err.println("Error saving file: " + e.getMessage());
                throw e;
            }
        }
    }
    
    


}
