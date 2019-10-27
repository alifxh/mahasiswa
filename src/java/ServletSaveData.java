import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*; 
/**
 *
 * @author Baymax
 */
public class ServletSaveData extends HttpServlet {

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
            out.println("<title>Data Disimpan</title>");            
            out.println("</head>");
            out.println("<body background=bgimg.jpg>");
            out.println("<h1>Data Berhasil Disimpan</h1>");
            out.println("<a href=index.html>back to index</a>");
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
        //Mari kita buat koneksi didalam Servlet
        Connection con;
        Statement stmt;
        
        response.setContentType("text/html;charset=UTF-8");
        //buat variabel yang sama seperti pada database beserta type datanya
        int nim = Integer.parseInt(request.getParameter("nim"));
        String nama = request.getParameter("nama");
        String jk = request.getParameter("jk");
        String agama = request.getParameter("agama");
        String jurusan = request.getParameter("jurusan");
        String fakultas = request.getParameter("fakultas");
        
        //mari buat try catch
        try{
            //buat koneksi dengan mySQL
            Class.forName("com.mysql.jdbc.Driver");
            
            //database_mahasiswa adalah nama database , "root" = username mySQL, "" password
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_mahasiswa","root","");
            stmt = con.createStatement();
            
            //buat query Save data nya
            String sql = "INSERT INTO tabel_mhs values ('" + nim + "','" + nama + "','" + jk + "','" 
                    + agama + "','" + jurusan + "','" + fakultas + "')";
            stmt.execute(sql);
        }
        catch(Exception e){
            e.printStackTrace();
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
