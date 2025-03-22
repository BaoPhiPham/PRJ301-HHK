package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Add_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Add Product</title>\n");
      out.write("        <link href=\"css/manager.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("        <style>\n");
      out.write("            body {\n");
      out.write("                font-family: Arial, sans-serif;\n");
      out.write("                background-color: #f4f4f4;\n");
      out.write("                margin: 0;\n");
      out.write("                padding: 20px;\n");
      out.write("                display: flex;\n");
      out.write("                justify-content: center;\n");
      out.write("                align-items: center;\n");
      out.write("                height: 100vh;\n");
      out.write("            }\n");
      out.write("            .container {\n");
      out.write("                background: white;\n");
      out.write("                padding: 20px;\n");
      out.write("                border-radius: 8px;\n");
      out.write("                box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);\n");
      out.write("                width: 400px;\n");
      out.write("            }\n");
      out.write("            h2 {\n");
      out.write("                text-align: center;\n");
      out.write("                margin-bottom: 20px;\n");
      out.write("            }\n");
      out.write("            .form-group {\n");
      out.write("                margin-bottom: 15px;\n");
      out.write("            }\n");
      out.write("            .form-group label {\n");
      out.write("                display: block;\n");
      out.write("                font-weight: bold;\n");
      out.write("            }\n");
      out.write("            .form-group input {\n");
      out.write("                width: 100%;\n");
      out.write("                padding: 8px;\n");
      out.write("                border: 1px solid #ccc;\n");
      out.write("                border-radius: 4px;\n");
      out.write("            }\n");
      out.write("            .btn {\n");
      out.write("                width: 100%;\n");
      out.write("                padding: 10px;\n");
      out.write("                border: none;\n");
      out.write("                border-radius: 4px;\n");
      out.write("                background: #28a745;\n");
      out.write("                color: white;\n");
      out.write("                cursor: pointer;\n");
      out.write("                font-size: 16px;\n");
      out.write("            }\n");
      out.write("            .btn:hover {\n");
      out.write("                background: #218838;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <h2>Add Product</h2>\n");
      out.write("            <form action=\"add\" method=\"post\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label>ID</label>\n");
      out.write("                    <input name=\"id\" type=\"number\" required>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label>Name</label>\n");
      out.write("                    <input name=\"name\" type=\"text\" required>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label>Supplier ID</label>\n");
      out.write("                    <input name=\"supplierId\" type=\"number\" required>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label>Category ID</label>\n");
      out.write("                    <input name=\"categoryId\" type=\"number\" required>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label>Quantity</label>\n");
      out.write("                    <input name=\"quantity\" type=\"number\" required>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label>Price</label>\n");
      out.write("                    <input name=\"price\" type=\"text\" required>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label>Image URL</label>\n");
      out.write("                    <input name=\"image\" type=\"text\" required>\n");
      out.write("                </div>\n");
      out.write("                <button type=\"submit\" class=\"btn\">Add</button>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
