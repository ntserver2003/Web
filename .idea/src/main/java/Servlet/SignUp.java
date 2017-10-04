package Servlet;
import accounts.*;
import templator.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SignUp extends HttpServlet{
    public final AccountService accountService;

    public SignUp(AccountService accountService){
        this.accountService = accountService;
    }
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response){

    }

    /**
     * Регистрируем нового пользователя
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        Map<String,Object> parameters = createListOfParameters(request);
        UserProfile up = new UserProfile(parameters.get("login").toString(),parameters.get("password").toString());
        accountService.addProfile(up);
        System.out.println("1");
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(PageGenerator.instance().getPage("page.html", parameters));

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
