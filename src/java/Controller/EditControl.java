
package Controller;

import DAO.DAO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet(name = "EditControl", urlPatterns = {"/edit"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50 // 50MB
)
public class EditControl extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int supplierId = Integer.parseInt(request.getParameter("supplierId"));
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int price = Integer.parseInt(request.getParameter("price"));
//        String image = request.getParameter("image");
        
        
//        DAO dao = new DAO();
//        
//        dao.editProduct(name, supplierId, categoryId, quantity, price, image, id);
//        response.sendRedirect("manager");


         Part filePart = request.getPart("image");
            if (filePart == null || filePart.getSize() == 0) {
                request.setAttribute("error", "Vui lòng chọn ảnh.");
                request.getRequestDispatcher("Edit.jsp").forward(request, response);
                return;
            }

            // Lấy tên file
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

            // Đường dẫn thư mục lưu ảnh
            String uploadPath = getServletContext().getRealPath("/") + "images";
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            // Lưu file vào thư mục
            String filePath = uploadPath + File.separator + fileName;
            filePart.write(filePath);

            // Lưu đường dẫn ảnh vào database
            String imagePath = "images/" + fileName;
            DAO dao = new DAO();
            boolean add = dao.editProduct(name, supplierId, categoryId, quantity, price, imagePath, id);

            if (add) {
                request.setAttribute("success", "Cập nhật sản phẩm thành công.");
                request.getRequestDispatcher("HomeControl").forward(request, response);
            } else {
                request.setAttribute("error", "Cập nhật thất bại.");
                request.getRequestDispatcher("HomeControl").forward(request, response);
            }
    }

    
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
    }// </editor-fold>

}
