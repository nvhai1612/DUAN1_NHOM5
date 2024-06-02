/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository.Impl;

import DomainModel.NhanVien;
import Repository.INhanVienRepos;
import Utiliti.DBConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author Admin
 */
public class NhanVienRepos implements INhanVienRepos {

    DBConnection connection;

    @Override
    public ArrayList<NhanVien> getListFormDB() {
        ArrayList<NhanVien> list = new ArrayList<>();
        try (Connection con = connection.getConnection()) {
            String sql = "SELECT ID,MANV,TENNV,GIOITINH,NGAYSINH,CCCD,DIACHI,SDT,EMAIL,TRANGTHAINV,VAITRO from NHANVIEN";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nhanVien = new NhanVien();
                nhanVien.setId(rs.getObject(1, UUID.class));
                nhanVien.setMaNV(rs.getString(2));
                nhanVien.setTenNV(rs.getString(3));
                nhanVien.setGioiTinh(rs.getInt(4));
                nhanVien.setNgaySinh(rs.getDate(5));
                nhanVien.setCCCD(rs.getString(6));
                nhanVien.setDiaChi(rs.getString(7));
                nhanVien.setSDT(rs.getString(8));
                nhanVien.setEmail(rs.getString(9));
                nhanVien.setTrangThaiNV(rs.getInt(10));
                nhanVien.setVaiTro(rs.getString(11));
                list.add(nhanVien);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Boolean add(NhanVien nv) {
        try (Connection con = connection.getConnection()) {
            String sql = "INSERT INTO NHANVIEN(MANV, TENNV, GIOITINH, NGAYSINH, CCCD, DIACHI, SDT, EMAIL, TRANGTHAINV, VAITRO ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, nv.getMaNV());
            ps.setObject(2, nv.getTenNV());
            ps.setObject(3, nv.getGioiTinh());
            ps.setObject(4, nv.getNgaySinh());
            ps.setObject(5, nv.getCCCD());
            ps.setObject(6, nv.getDiaChi());
            ps.setObject(7, nv.getSDT());
            ps.setObject(8, nv.getEmail());
            ps.setObject(9, nv.getTrangThaiNV());
            ps.setObject(10, nv.getVaiTro());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public ArrayList<NhanVien> search(String MaNV) {
        ArrayList<NhanVien> list = new ArrayList<>();
        String sql = "SELECT ID, MANV, TENNV, GIOITINH, NGAYSINH, CCCD, DIACHI, SDT, EMAIL, TRANGTHAINV, VAITRO "
                + "FROM NHANVIEN WHERE MANV LIKE ? OR TENNV = ?";

        try (Connection conn = connection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + MaNV + "%");
            ps.setString(2, MaNV); 

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    NhanVien nhanVien = new NhanVien();
                    nhanVien.setId(rs.getObject("ID", UUID.class));
                    nhanVien.setMaNV(rs.getString("MANV"));
                    nhanVien.setTenNV(rs.getString("TENNV"));
                    nhanVien.setGioiTinh(rs.getInt("GIOITINH"));
                    nhanVien.setNgaySinh(rs.getDate("NGAYSINH"));
                    nhanVien.setCCCD(rs.getString("CCCD"));
                    nhanVien.setDiaChi(rs.getString("DIACHI"));
                    nhanVien.setSDT(rs.getString("SDT"));
                    nhanVien.setEmail(rs.getString("EMAIL"));
                    nhanVien.setTrangThaiNV(rs.getInt("TRANGTHAINV"));
                    nhanVien.setVaiTro(rs.getString("VAITRO"));
                    list.add(nhanVien);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public String update(NhanVien nv, UUID ID) {
        try (Connection con = connection.getConnection()) {
            String sql = "UPDATE NHANVIEN SET MANV = ?, TENNV = ?, GIOITINH = ?, NGAYSINH = ?, CCCD = ?, DIACHI = ?, SDT = ?, EMAIL = ?, TRANGTHAINV = ?, VAITRO = ? WHERE ID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, nv.getMaNV());
            ps.setObject(2, nv.getTenNV());
            ps.setObject(3, nv.getGioiTinh());
            ps.setObject(4, nv.getNgaySinh());
            ps.setObject(5, nv.getCCCD());
            ps.setObject(6, nv.getDiaChi());
            ps.setObject(7, nv.getSDT());
            ps.setObject(8, nv.getEmail());
            ps.setObject(9, nv.getTrangThaiNV());
            ps.setObject(10, nv.getVaiTro());
            ps.setObject(11, nv.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Thanh Cong";
    }

}
