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
        "/sinh-vien/update",// POST
        "/sinh-vien/delete",// GET
})
public class SinhVienServlet extends HttpServlet {

    ArrayList<String> list = new ArrayList<>();

    public SinhVienServlet() {
        list.add("SD123");
        list.add("SD124");
        list.add("SD125");
        list.add("SD126");
        listSinhVien.add(new SinhVien("123", "Nguyen Van A", "HN", 23, "Nam","SD123"));
        listSinhVien.add(new SinhVien("124", "Nguyen Van B", "HN", 23, "Nam","SD1234"));
        listSinhVien.add(new SinhVien("125", "Nguyen Van C", "HN", 23, "Nu","SD125"));
    }

    ArrayList<SinhVien> listSinhVien = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/sinh-vien/trang-chu")) {
            this.hienThi(request, response);
        } else if (uri.equals("/sinh-vien/detail")) {
            this.detail(request, response);
        } else if (uri.contains("/sinh-vien/delete")) {
            this.delete(request, response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("maSinhVien");
        for (SinhVien sinhVien : listSinhVien) {
            if (sinhVien.getMaSinhVien().equals(ma)) {
                listSinhVien.remove(sinhVien);
                break;
            }
        }
        response.sendRedirect("/sinh-vien/trang-chu");
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("maSinhVien");
        SinhVien sinhVienDetail = new SinhVien();
        for (SinhVien sinhVien : listSinhVien) {
            if (sinhVien.getMaSinhVien().equals(ma)) {
                sinhVienDetail = sinhVien;
            }
        }
        request.setAttribute("listString", list);
        request.setAttribute("sinhVien", sinhVienDetail);
        request.getRequestDispatcher("/chi-tiet.jsp").forward(request, response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list", listSinhVien);
        request.setAttribute("listString", list);
        request.getRequestDispatcher("/sinh-vien.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/sinh-vien/add")) {
            this.add(request, response);
        } else if (uri.equals("/sinh-vien/update")) {
            this.update(request, response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("maSinhVien");
        String ten = request.getParameter("tenSinhVien");
        String diaChi = request.getParameter("diaChi");
        Integer tuoi = Integer.parseInt(request.getParameter("tuoi"));
        for (SinhVien sinhVien : listSinhVien) {
            if (sinhVien.getMaSinhVien().equals(ma)) {
                sinhVien.setTenSinhVien(ten);
                sinhVien.setTuoi(tuoi);
                sinhVien.setDiaChi(diaChi);
            }
        }
        response.sendRedirect("/sinh-vien/trang-chu");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("maSinhVien");
        String ten = request.getParameter("tenSinhVien");
        String diaChi = request.getParameter("diaChi");
        String gioiTinh = request.getParameter("gioiTinh");
        String lop = request.getParameter("lop");
        Integer tuoi = Integer.parseInt(request.getParameter("tuoi"));
        SinhVien sinhVien = new SinhVien(ma, ten, diaChi, tuoi, gioiTinh,lop);
        listSinhVien.add(sinhVien);
        String hoTen = request.getParameter("hoTen");
        list.add(hoTen);
        response.sendRedirect("/sinh-vien/trang-chu");
    }
}
