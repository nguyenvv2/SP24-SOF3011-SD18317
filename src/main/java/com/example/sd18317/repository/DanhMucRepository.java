package com.example.sd18317.repository;

import com.example.sd18317.connect.HibernateUtils;
import com.example.sd18317.model.DanhMuc;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class DanhMucRepository {

    public ArrayList<DanhMuc> getList() {
        Session session = HibernateUtils.getFACTORY().openSession();
        ArrayList<DanhMuc> list =
                (ArrayList<DanhMuc>) session.createQuery("from DanhMuc").list();
        session.close();
        return list;
    }

    public void add(DanhMuc danhMuc) {
        Session session = HibernateUtils.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.saveOrUpdate(danhMuc);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }

}
