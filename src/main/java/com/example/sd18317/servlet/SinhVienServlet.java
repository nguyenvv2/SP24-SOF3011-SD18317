package com.example.sd18317.servlet;

import com.example.sd18317.model.SinhVien;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SinhVienServlet", value = {
        "/sinh-vien/trang-chu",// GET
        "/sinh-vien/add",// POST
        "/sinh-vien/detail",// GET
})
public class SinhVienServlet extends HttpServlet {

    ArrayList<String> list = new ArrayList<>();

    public SinhVienServlet() {
        list.add("SD123");
        list.add("SD124");
        list.add("SD125");
        list.add("SD126");
        listSinhVien.add(new SinhVien("123", "123", "HN", 23));
        listSinhVien.add(new SinhVien("124", "123", "HN", 23));
        listSinhVien.add(new SinhVien("125", "123", "HN", 23));
    }

    ArrayList<SinhVien> listSinhVien = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/sinh-vien/trang-chu")) {
            request.setAttribute("list", listSinhVien);
            request.setAttribute("listString", list);
            request.getRequestDispatcher("/sinh-vien.jsp").forward(request, response);
        } else if (uri.equals("/sinh-vien/detail")) {
            request.getRequestDispatcher("/chi-tiet.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String ma = request.getParameter("maSinhVien");
//        String ten = request.getParameter("tenSinhVien");
//        String diaChi = request.getParameter("diaChi");
//        Integer tuoi = Integer.parseInt(request.getParameter("tuoi"));
//        SinhVien sinhVien = new SinhVien(ma, ten, diaChi, tuoi);
//        listSinhVien.add(sinhVien);
        String hoTen = request.getParameter("hoTen");
        list.add(hoTen);


        response.sendRedirect("/sinh-vien/trang-chu");
    }
}
