import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import Servlet.*;

import javax.servlet.ServletContext;

public class main {
    public static void main(String [] args) throws Exception {
        Frontend frontend = new Frontend();

        Server server = new Server(8080);
        ServletContextHandler context =
                new ServletContextHandler(ServletContextHandler.SESSIONS);

        context.addServlet(new ServletHolder(frontend), "/*");
        server.setHandler(context);
        server.start();
        System.out.println("Server started");
        server.join();
    }
}
