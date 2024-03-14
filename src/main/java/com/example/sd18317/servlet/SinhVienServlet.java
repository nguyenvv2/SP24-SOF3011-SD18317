package com.example.sd18317.servlet;

import com.example.sd18317.model.SinhVien;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SinhVienServlet", value = {"/sinh-vien/trang-chu",
        "/sinh-vien/add"
})
public class SinhVienServlet extends HttpServlet {
    public SinhVienServlet() {
        listSinhVien.add(new SinhVien("123", "123", "HN", 23));
        listSinhVien.add(new SinhVien("123", "123", "HN", 23));
        listSinhVien.add(new SinhVien("123", "123", "HN", 23));
    }

    ArrayList<SinhVien> listSinhVien = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list", listSinhVien);
        request.getRequestDispatcher("/sinh-vien.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("maSinhVien");
        String ten = request.getParameter("tenSinhVien");
        String diaChi = request.getParameter("diaChi");
        Integer tuoi = Integer.parseInt(request.getParameter("tuoi"));
        SinhVien sinhVien = new SinhVien(ma, ten, diaChi, tuoi);
        listSinhVien.add(sinhVien);

        response.sendRedirect("/sinh-vien/trang-chu");
    }
}
