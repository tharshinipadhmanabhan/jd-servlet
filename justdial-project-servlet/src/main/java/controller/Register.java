package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Ad_Details;

@WebServlet("/register")
public class Register extends HttpServlet {

    ArrayList<Ad_Details> list = new ArrayList<Ad_Details>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
    ServletException, IOException {
    System.out.println("GET ALL AD");

    list.clear();

    try (Connection con =
    DriverManager.getConnection("jdbc:mysql://localhost:3306/justdial", "root",
    "")) {

    Statement stmt = con.createStatement();

    String stmtStr = "select * from ad_details";

    ResultSet rslt = stmt.executeQuery(stmtStr);

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

    }

    Gson g = new Gson();

    String fList = g.toJson(list);

    resp.getWriter().print(fList);

    }

    catch (SQLException e) {
    e.printStackTrace();
    }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("REGISTER");

        String requestData = req.getReader().lines().collect(Collectors.joining());
        Ad_Details newAD = new Gson().fromJson(requestData, Ad_Details.class);

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/justdial", "root", "")) {

            String stmt = "insert into ad_details (ad_name,contact_num,category,sub_category,f_d_num,area_,city,district,state,country,open_time,close_time,holidays,ad_description) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement prpStmt = con.prepareStatement(stmt);

            prpStmt.setString(1, newAD.getAd_name());
            prpStmt.setLong(2, newAD.getContactNum());
            prpStmt.setString(3, newAD.getCategory());
            prpStmt.setString(4, newAD.getSubCategory());
            prpStmt.setString(5, newAD.getF_d_num());
            prpStmt.setString(6, newAD.getArea());
            prpStmt.setString(7, newAD.getCity());
            prpStmt.setString(8, newAD.getDistrict());
            prpStmt.setString(9, newAD.getState());
            prpStmt.setString(10, newAD.getCountry());
            prpStmt.setString(11, newAD.getOpnTime());
            prpStmt.setString(12, newAD.getClsTime());
            prpStmt.setString(13, newAD.getHoliday());
            prpStmt.setString(14, newAD.getDesc());

            int rslt = prpStmt.executeUpdate();

            if (rslt != 0) {
                resp.getWriter().print("index.jsp");
            } 
            else {
                resp.getWriter().print("Error");
            }
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
