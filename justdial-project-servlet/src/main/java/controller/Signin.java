package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signin")
public class Signin extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Signin");


        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/justdial", "root", "")) {

            String srtStmt = "insert into signin_details (phone_number,first_name,last_name,password_) values (?,?,?,?)";

            PreparedStatement prpStmt = con.prepareStatement(srtStmt);

            prpStmt.setLong(1, Long.parseLong(req.getParameter("phone_num")));
            prpStmt.setString(2, req.getParameter("first_name"));
            prpStmt.setString(3, req.getParameter("last_name"));
            prpStmt.setString(4, req.getParameter("password"));

            prpStmt.executeUpdate();

        }

        catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
