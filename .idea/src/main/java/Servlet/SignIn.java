package Servlet;

import accounts.*;
import templator.*;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/*
*  Сервлет для занесения пользователя в "базу"
*  принимает login и password в качестве парметров
*  */

public class SignIn extends HttpServlet{
    private final AccountService accountService;

    public SignIn(AccountService accountService){
        this.accountService = accountService;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response){

    }
    /**
     * Регистрируем нового пользователя
     * Если профиль в базе есть Возвращаем статус 200 и Надпись
     * Если нет , то 401 и UnAuth
     */
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        Map<String,Object> parameters = createListOfParameters(request);

        if (accountService.getProfile(parameters.get("login").toString())==null){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().println(PageGenerator.instance().getPage("unAuth.html", parameters));}
        else {
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().println(PageGenerator.instance().getPage("page.html", parameters));}
    }
    /**
     * Список параметров передаваемых в запросе
     */
    public Map createListOfParameters(HttpServletRequest request){
        Map<String,Object> parameters = new HashMap<>();

        parameters.put("login",request.getParameter("login"));
        parameters.put("password",request.getParameter("password"));
        return  parameters;
    }
}
