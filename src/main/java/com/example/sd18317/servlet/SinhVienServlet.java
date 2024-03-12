package com.example.sd18317.servlet;

import com.example.sd18317.model.SinhVien;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SinhVienServlet", value = "/sinh-vien/trang-chu")
public class SinhVienServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SinhVien sinhVien = new SinhVien("Ph12345", "Nguyen Thi B", "HCM", 20);
        request.setAttribute("sinhVien", sinhVien);
        ArrayList<SinhVien> listSinhVien = new ArrayList<>();
        listSinhVien.add(sinhVien);
        listSinhVien.add(new SinhVien("123", "123", "HN", 23));
        listSinhVien.add(new SinhVien("123", "123", "HN", 23));
        listSinhVien.add(new SinhVien("123", "123", "HN", 23));
        request.setAttribute("list", listSinhVien);

        request.getRequestDispatcher("/sinh-vien.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Da chay vao post");
    }
}
