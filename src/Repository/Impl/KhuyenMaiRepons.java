/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository.Impl;

import DomainModel.KhuyenMai;
import Repository.IkhuyenMairepons;
import Utiliti.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author Admin
 */
public class KhuyenMaiRepons implements IkhuyenMairepons {

    DBConnection Connection;

    @Override
    public ArrayList<KhuyenMai> getListFormDB() {
        ArrayList<KhuyenMai> khuyenmai = new ArrayList<>();

        try (Connection con = Connection.getConnection(); PreparedStatement ps = con.prepareStatement(
                "Select ID,IDSP,MAKM,TENKM,MUCGIAMGIA,THOIGIANBATDAU,THOIGIANKETTHUC,TRANGTHAIKM,SOLUONG\n"
                + "from KHUYENMAI ")) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                KhuyenMai km = new KhuyenMai();
                km.setIdKM(rs.getObject(1, UUID.class));
                km.setIDSP(rs.getObject(2, UUID.class));
                km.setMaKM(rs.getString(3));
                km.setTenKM(rs.getString(4));
                km.setMucGiamGia(rs.getFloat(5));
                km.setThoiGianBatDau(rs.getDate(6));
                km.setThoiGianKetThuc(rs.getDate(7));
                km.setTrangThai(rs.getInt(8));
                km.setTrangThai(rs.getInt(9));

                khuyenmai.add(km);
            }

        } catch (Exception e) {
        }
        return khuyenmai;
    }

//    @Override
//    public Integer add(KhuyenMai km) {
//         Integer row = 0;
//
//        String sql = "insert into KHUYENMAI (IDSP,MAKM,TENKM,MUCGIAMGIA,THOIGIANBATDAU,THOIGIANKETTHUC,TRANGTHAIKM,SOLUONG) values \n"
//                + "(?,?,?,?,?,?,?,?,?)";
//
//        try {
//            row = JDBCHelper.executeUpdate(sql,
//                    km.getMaKM(),
//                    km.getTenKM(),
//                    km.getMucGiamGia(),
//                    km.getThoiGianBatDau(),
//                    km.getThoiGianKetThuc(),
//                    km.getTrangThai(),
//                    km.getSoLuong()
//                    
//            );
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return row;
//    }
    @Override
    public UUID add(KhuyenMai km) {
        int check;
       
        try (Connection con = Connection.getConnection(); PreparedStatement ps = con.prepareStatement("insert into KHUYENMAI "
                + "(TENKM,MUCGIAMGIA,THOIGIANBATDAU,THOIGIANKETTHUC,TRANGTHAIKM) values (?,?,?,?,?)")) {
//            ps.setObject(1, km.getIdKM());
//            ps.setObject(2, km.getIDSP());
//            ps.setObject(, km.getMaKM());
            ps.setObject(1, km.getTenKM());
            ps.setObject(2, km.getMucGiamGia());
            ps.setObject(3, km.getThoiGianBatDau());
            ps.setObject(4, km.getThoiGianKetThuc());
            ps.setObject(5, km.getTrangThai());
//            ps.setObject(9, km.getSoLuong());
            check = ps.executeUpdate();
//            System.out.println(SelectSPByTen(km.getTenKM()));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    public UUID SelectSPByTen(String TenSP) {
//
//        try (Connection con = Connection.getConnection(); PreparedStatement ps = con.prepareStatement("select id from KHUYENMAI where TENKM= ?")) {
//            ps.setObject(1, TenSP);
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                return rs.getObject(1, UUID.class);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

}

//    public KhuyenMai them(KhuyenMai k) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    public KhuyenMai updateKhuyenMai(KhuyenMai km) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

