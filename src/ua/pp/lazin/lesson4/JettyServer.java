package ua.pp.lazin.lesson4;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;


/**
 * Created by Laz on 03.08.2016.
 */
public class JettyServer {
    public static void main(String[] args) throws Exception {

        Server server = new Server(8080);
        ServletHandler handler = new ServletHandler();
        server.setHandler(handler);

        handler.addServletWithMapping(Calc.class, "/calc");
        handler.addServletWithMapping(Registration.class, "/registration");
        handler.addServletWithMapping(Hello.class,"/hello");

        server.start();
        server.join();
    }
}
