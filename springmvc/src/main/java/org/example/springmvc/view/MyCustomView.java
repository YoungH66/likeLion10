package org.example.springmvc.view;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.View;

import java.io.PrintWriter;
import java.util.Map;

public class MyCustomView implements View {
    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType(getContentType());
        PrintWriter out =  response.getWriter();
        out.print("<html><body>");
        out.print("<h1>Custom View Content</h1>");
        out.print("<p>personal information</p>");
        out.print("</body></html>");

        out.close();
    }

    @Override
    public String getContentType() {
        return "text/html";
    }
}
