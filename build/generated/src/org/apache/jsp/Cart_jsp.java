package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Cart_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <title>Cart</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\">\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Menu.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("    <div class=\"shopping-cart\">\n");
      out.write("        <div class=\"container py-5\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-lg-12 p-5 bg-white rounded shadow-sm\">\n");
      out.write("\n");
      out.write("                    <!-- Bảng giỏ hàng -->\n");
      out.write("                    <div class=\"table-responsive\">\n");
      out.write("                        <table class=\"table\">\n");
      out.write("                            <thead>\n");
      out.write("                                <tr>\n");
      out.write("                                    <th class=\"border-0 bg-light\">Product</th>\n");
      out.write("                                    <th class=\"border-0 bg-light\">Price</th>\n");
      out.write("                                    <th class=\"border-0 bg-light\">Quantity</th>\n");
      out.write("                                    <th class=\"border-0 bg-light\">Delete</th>\n");
      out.write("                                </tr>\n");
      out.write("                            </thead>\n");
      out.write("                            <tbody>\n");
      out.write("                                ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                            </tbody>\n");
      out.write("                        </table>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!-- Hiển thị tổng tiền -->\n");
      out.write("            <div class=\"row py-5 p-4 bg-white rounded shadow-sm\">\n");
      out.write("                <div class=\"col-lg-6\">\n");
      out.write("                    <div class=\"bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold\">Bill</div>\n");
      out.write("                    <div class=\"p-4\">\n");
      out.write("                        <ul class=\"list-unstyled mb-4\">\n");
      out.write("                            <li class=\"d-flex justify-content-between py-3 border-bottom\">\n");
      out.write("                                <strong class=\"text-muted\">Total money</strong>\n");
      out.write("                                <strong>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.cartTotal}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" $</strong>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"d-flex justify-content-between py-3 border-bottom\">\n");
      out.write("                                <strong class=\"text-muted\">Total: </strong>\n");
      out.write("                                <h5 class=\"font-weight-bold\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.cartTotal}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" VND</h5>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                        <a href=\"buy\" class=\"btn btn-dark rounded-pill py-2 btn-block\">Purchase</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- Bootstrap JS -->\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\"></script>\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\"></script>\n");
      out.write("    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("</body>\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("item");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cart}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                    <tr>\n");
          out.write("                                        <td>\n");
          out.write("                                            <div class=\"p-2\">\n");
          out.write("                                                <img src=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${item.productImage}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" alt=\"\" width=\"70\" class=\"img-fluid rounded shadow-sm\">\n");
          out.write("                                                <div class=\"ml-3 d-inline-block align-middle\">\n");
          out.write("                                                    <h5 class=\"mb-0\"><a href=\"#\" class=\"text-dark\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${item.productName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</a></h5>\n");
          out.write("                                                </div>\n");
          out.write("                                            </div>\n");
          out.write("                                        </td>\n");
          out.write("                                        <td class=\"align-middle\"><strong>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${item.unitPrice}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(" $</strong></td>\n");
          out.write("                                        <td class=\"align-middle\">\n");
          out.write("                                            <form action=\"updateCart\" method=\"post\" class=\"d-inline\">\n");
          out.write("                                                <input type=\"hidden\" name=\"productID\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${item.productID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\n");
          out.write("                                                <button type=\"submit\" name=\"action\" value=\"decrease\" class=\"btn btn-sm btn-outline-secondary\">-</button>\n");
          out.write("                                            </form>\n");
          out.write("                                            <strong>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${item.quantity}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</strong>\n");
          out.write("                                            <form action=\"updateCart\" method=\"post\" class=\"d-inline\">\n");
          out.write("                                                <input type=\"hidden\" name=\"productID\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${item.productID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\n");
          out.write("                                                <button type=\"submit\" name=\"action\" value=\"increase\" class=\"btn btn-sm btn-outline-secondary\">+</button>\n");
          out.write("                                            </form>\n");
          out.write("                                        </td>\n");
          out.write("                                        <td class=\"align-middle\">\n");
          out.write("                                            <form action=\"removeFromCart\" method=\"post\">\n");
          out.write("                                                <input type=\"hidden\" name=\"productID\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${item.productID}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\n");
          out.write("                                                <button type=\"submit\" class=\"btn btn-danger\">Delete</button>\n");
          out.write("                                            </form>\n");
          out.write("                                        </td>\n");
          out.write("                                    </tr> \n");
          out.write("                                ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
