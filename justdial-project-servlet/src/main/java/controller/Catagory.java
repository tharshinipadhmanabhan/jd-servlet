package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.CatList;

@WebServlet("/category")
public class Catagory extends HttpServlet {
    ArrayList<CatList> catList = new ArrayList<CatList>();

    ArrayList<CatList> subCatList = new ArrayList<CatList>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Get Category");

        catList.clear();

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/justdial", "root", "")) {

            Statement stmt = con.createStatement();

            String strStmt = "select distinct(cat_name) from category";

            ResultSet rslt = stmt.executeQuery(strStmt);

            while (rslt.next()) {
                String category = rslt.getString("cat_name");

                catList.add(new CatList(1, category, ""));
            }

            Gson g = new Gson();

            String fList = g.toJson(catList);

            resp.getWriter().print(fList);

        }

        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Get Sub Category");

        subCatList.clear();

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/justdial", "root", "")) {

            String category = req.getParameter("a");

            // System.out.println(category);

            String stmt = "select distinct(sub_cat_name) from category where cat_name = ?";

            PreparedStatement prpStmt = con.prepareStatement(stmt);

            prpStmt.setString(1, category);

            ResultSet rslt = prpStmt.executeQuery();

            while (rslt.next()) {
                String subCategory = rslt.getString("sub_cat_name");

                subCatList.add(new CatList(1, "", subCategory));
            }

            Gson g = new Gson();

            String fList = g.toJson(subCatList);

            resp.getWriter().print(fList);

        }

        catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
