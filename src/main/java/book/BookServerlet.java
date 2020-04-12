package book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import book.*;
import java.util.*;
import com.google.gson.*;


@WebServlet(name = "BookServerlet", urlPatterns = "/BookServerlet")
public class BookServerlet  extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            List<User> userList = new ArrayList<>();
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/books","root","123456789");
            ps = conn.prepareStatement("select * from book");
            rs = ps.executeQuery();
//
//            Cookie c1 = new Cookie("arkadas", "Ozgur");
//            Cookie c2 = new Cookie("arkadas2", "Emre");
// Burada cookie lerimizi tanımladık. Name ve değerini girdik.

//            response.addCookie(c1);
//            response.addCookie(c2);
            // response ile cookie lerimizi ekledik.

//            response.addHeader("Set-Cookie","arkadas3-Umit Arslan");// addheader ile de cookie ekleyebiliyoruz.
//            Cookie[] cookie=request.getCookies();
//            if (cookie!=null)
//            {
//                for (Cookie c:cookie)
//                {
//                    System.out.println("Cookie adı"+ " "+ c.getName()+  " "+ "Cookie değeri"+ " " +c.getValue());
//                    //Bütün cookie leri name ve değerini konsola yazdırdık.
//                    PrintWriter out = response.getWriter();
//                    out.println("<!DOCTYPE html>");
//                    out.println("<html>");
//                    out.println("<head>");
//                    out.println("<title>Hello! World!</title>");
//                    out.println("</head>");
//                    out.println("<body>");
//                    out.println("<h1>Hello! World!</h1>");
//                    out.println("</body>");
//                    out.println("</html>");
//
//                }
//            }
            response.setContentType("application/json");
            Person p = new Person();
            p.setAge(10);
            p.setEmail("bob@hotmail.com");
            p.setName("Bob Qin");
            p.setSex(Person.SEX_MAN);
            List<String> telephones = new ArrayList<String>();
            telephones.add("13813841385");
            telephones.add("021-454566778");
            p.setTelephones(telephones);
            PrintWriter writer = response.getWriter();
            writer.write(new Gson().toJson(p, Person.class));
            writer.flush();

        }
        catch (Exception e)
        {e.printStackTrace();
        }
    }
}
