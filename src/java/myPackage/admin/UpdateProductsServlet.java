package myPackage.admin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import myPackage.DbUtil;

public class UpdateProductsServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int proId = parseInt(request.getParameter("pro_id"));
        String proName = request.getParameter("pro_name");
        String proDesc = request.getParameter("pro_desc");
        String proImg = request.getParameter("pro_img");
        int catId = parseInt(request.getParameter("pro_cat"));
        double proPrice = parseFloat(request.getParameter("pro_price"));
        
        
        String imgName = null;
              
        Part filePart = request.getPart("pro_img");
        if (filePart != null) {
            imgName = generateUniqueFileName(filePart);
            saveFile(filePart, imgName, request);
        }
        updateProduct(proId, catId, proName, proDesc, imgName, proPrice);          


        
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
    }
    
    private void updateProduct(int proId, int catId, String proName, String proDesc, String proImg, double proPrice){
        try(Connection conn = DbUtil.getConnection()){
            String query = "UPDATE products SET cat_id = ?, pro_name = ?, pro_price = ?, pro_img = ?, pro_desc = ?, reviews = ?, date = ? WHERE pro_id = ?";
            
            try(PreparedStatement stmt = conn.prepareStatement(query)){
                stmt.setInt(1, catId);
                stmt.setString(2, proName);
                stmt.setDouble(3, proPrice);
                stmt.setString(4, proImg);
                stmt.setString(5, proDesc);
                stmt.setDouble(6, 0);
                stmt.setTimestamp(7, new java.sql.Timestamp(System.currentTimeMillis()));
                stmt.setInt(8, proId);
                stmt.executeUpdate();
                
            }
        }catch(SQLException e){
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
