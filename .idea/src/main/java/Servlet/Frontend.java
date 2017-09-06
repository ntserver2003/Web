package Servlet;

import templator.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
/*
* Урок 1
* Сервлет принимает любой запрос и возвращает страницу с передаваемым парметром
* */
public class Frontend extends HttpServlet {

    private String login = "";

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {

        /*Map<String, Object> pageVariables = createPageVariablesMap(request);
        pageVariables.put("message", "");*/
        //String message = request.getParameter("message");
        response.getWriter().println(request.getParameter("key"));

        /*response.setContentType("text/html;charset=utf-8");

        response.setStatus(HttpServletResponse.SC_OK);*/

    }
    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        Map<String, Object> pageVariables = createPageVariablesMap(request);

        String message = request.getParameter("key");

        response.setContentType("text/html;charset=utf-8");

        if (message == null || message.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        } else {
            response.setStatus(HttpServletResponse.SC_OK);
        }
        pageVariables.put("message", message == null ? "" : message);

        response.getWriter().println(PageGenerator.instance().getPage("page.html", pageVariables));
    }
    private static Map<String, Object> createPageVariablesMap(HttpServletRequest request) {
        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("method", request.getMethod());
        pageVariables.put("URL", request.getRequestURL().toString());
        pageVariables.put("pathInfo", request.getPathInfo());
        pageVariables.put("sessionId", request.getSession().getId());
        pageVariables.put("parameters", request.getParameterMap().toString());
        return pageVariables;
    }
}
