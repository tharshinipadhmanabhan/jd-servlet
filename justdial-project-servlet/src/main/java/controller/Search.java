package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Ad_Details;

@WebServlet("/search")
public class Search extends HttpServlet {

    ArrayList<Ad_Details> list = new ArrayList<Ad_Details>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Search");

        list.clear();

        String cat = req.getParameter("category");
        String subCat = req.getParameter("subCat");
        System.out.println(cat + " " + subCat);


        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/justdial", "root","")) {
            
            String stmtStr = "select * from ad_details where category = ? and sub_category = ?";

            PreparedStatement prpStmt = con.prepareStatement(stmtStr);

            prpStmt.setString(1, cat);
            prpStmt.setString(2, subCat);


            ResultSet rslt = prpStmt.executeQuery();

            while (rslt.next()) {
                int id = rslt.getInt("id");
                String name = rslt.getString("ad_name");
                long contact_num = rslt.getLong("contact_num");
                String category = rslt.getString("category");
                String subCategory = rslt.getString("sub_category");
                String f_d_num = rslt.getString("f_d_num");
                String area = rslt.getString("area_");
                String city = rslt.getString("city");
                String district = rslt.getString("district");
                String state = rslt.getString("state");
                String country = rslt.getString("country");
                String opn_time = rslt.getString("open_time");
                String cls_time = rslt.getString("close_time");
                String holiday = rslt.getString("holidayS");
                String des = rslt.getString("ad_description");

                list.add(new Ad_Details(id, name, contact_num, category, subCategory,
                        f_d_num, area, city, district,
                        state, country, opn_time, cls_time, holiday, des));

                System.out.println(name + " " + contact_num + " " + category + " " +
                        subCategory + " " + f_d_num + " "
                        + area + " " + city + " " + district + " " + state + " " + country + " " +
                        opn_time + " "
                        + cls_time + " " + holiday + " " + des);
            }

            Gson g = new Gson();

            String fList = g.toJson(list);

            resp.getWriter().print(fList);

        }

        catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
