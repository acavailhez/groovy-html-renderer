package acavailhez.html.demo

import acavailhez.html.HtmlPage
import acavailhez.html.HtmlStyle
import org.eclipse.jetty.server.Request
import org.eclipse.jetty.server.handler.AbstractHandler

import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class HtmlPageHandler extends AbstractHandler {

    final HtmlPage page;

    public HtmlPageHandler(HtmlPage page) {
        this.page = page;
    }


    public void handle(String target,
                       Request baseRequest,
                       HttpServletRequest request,
                       HttpServletResponse response) throws IOException,
            ServletException {
        response.setContentType("text/html; charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);

        PrintWriter out = response.getWriter();

        out.println(page.withStyle(HtmlStyle.PRETTY).getRawHtml());

        baseRequest.setHandled(true);
    }
}
