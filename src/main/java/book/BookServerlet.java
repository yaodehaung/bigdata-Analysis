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
import java.util.Properties;



@WebServlet(name = "BookServerlet", urlPatterns = "/BookServerlet")
public class BookServerlet  extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;



        try {
            Class.forName("com.mysql.jdbc.Driver");// include this line in your code.

            conn =  DriverManager.getConnection("jdbc:mysql://localhost/bookstore?" +
                    "user=root&password=123456789");
            ps = conn.prepareStatement("select * from book");
            rs = ps.executeQuery();

            while(rs.next()){
                int book_id = rs.getInt("book_id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                float price =  rs.getFloat("price");
                System.out.format("%s, %s, %s, %s \n", book_id, title, author,price);

            }


//            Properties info = new Properties();
//            info.put("user", "root");
//            info.put("password", "test");


//            response.setContentType("application/json");
//            Person p = new Person();
//            p.setAge(10);
//            p.setEmail("bob@hotmail.com");
//            p.setName("Bob Qin");
//            p.setSex(Person.SEX_MAN);
//            List<String> telephones = new ArrayList<String>();
//            telephones.add("13813841385");
//            telephones.add("021-454566778");
//            p.setTelephones(telephones);
//            PrintWriter writer = response.getWriter();
//            writer.write(new Gson().toJson(p, Person.class));
//            writer.flush();

        }
        catch (Exception e)
        {e.printStackTrace();
        }
    }
}
