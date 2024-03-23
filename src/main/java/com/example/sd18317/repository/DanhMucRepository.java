package com.example.sd18317.repository;

import com.example.sd18317.connect.HibernateUtils;
import com.example.sd18317.model.DanhMuc;
import org.hibernate.Session;

import java.util.ArrayList;

public class DanhMucRepository {

    public ArrayList<DanhMuc> getList() {
        Session session = HibernateUtils.getFACTORY().openSession();
        ArrayList<DanhMuc> list =
                (ArrayList<DanhMuc>) session.createQuery("from DanhMuc").list();
        session.close();
        return list;
    }

    public static void main(String[] args) {
        ArrayList<DanhMuc> list = new DanhMucRepository().getList();
        for (DanhMuc danhMuc : list) {
            System.out.println(danhMuc.toString());
        }
    }

}
