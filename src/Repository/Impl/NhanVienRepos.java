/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository.Impl;

import DomainModel.NhanVien;
import Repository.INhanVienRepos;
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
public class NhanVienRepos implements INhanVienRepos {

    DBConnection connection;

    @Override
    public ArrayList<NhanVien> getListFormDB() {
        ArrayList<NhanVien> list = new ArrayList<>();
        try (Connection con = connection.getConnection()) {
            String sql = "SELECT * from NHANVIEN JOIN CHUCVU ON NHANVIEN.IDCV = CHUCVU.ID";
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
                nhanVien.setMatKhau(rs.getString(10));
                nhanVien.setTrangThaiNV(rs.getInt(11));
                nhanVien.setIdCV(rs.getObject(12, UUID.class));
                list.add(nhanVien);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void add(NhanVien nv) {
        try (Connection con = connection.getConnection()) {
            String sql = "INSERT INTO NHANVIEN(MANV, TENNV, GIOITINH, NGAYSINH, CCCD, DIACHI, SDT, EMAIL,MATKHAU, TRANGTHAINV, IdCV ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, nv.getMaNV());
            ps.setObject(2, nv.getTenNV());
            ps.setObject(3, nv.getGioiTinh());
            ps.setObject(4, nv.getNgaySinh());
            ps.setObject(5, nv.getCCCD());
            ps.setObject(6, nv.getDiaChi());
            ps.setObject(7, nv.getSDT());
            ps.setObject(8, nv.getEmail());
            ps.setObject(9, nv.getMatKhau());
            ps.setObject(10, nv.getTrangThaiNV());
            ps.setObject(11, nv.getIdCV());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<NhanVien> search(String MaNV) {
        ArrayList<NhanVien> list = new ArrayList<>();
        String sql = "SELECT "
                + "NHANVIEN.MANV,"
                + "NHANVIEN.TENNV,"
                + "NHANVIEN.GIOITINH,"
                + "NHANVIEN.NGAYSINH,"
                + "NHANVIEN.CCCD,"
                + "NHANVIEN.DIACHI,"
                + "NHANVIEN.SDT,"
                + "NHANVIEN.TRANGTHAINV,"
                + "CHUCVU.tenCV "
                + "FROM NHANVIEN "
                + "JOIN CHUCVU ON NHANVIEN.IDCV = CHUCVU.ID "
                + "WHERE NHANVIEN.MANV LIKE ? OR NHANVIEN.TENNV = ?";
        try (Connection conn = connection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + MaNV + "%");
            ps.setString(2, MaNV);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    NhanVien nhanVien = new NhanVien();
                    nhanVien.setMaNV(rs.getString("MANV"));
                    nhanVien.setTenNV(rs.getString("TENNV"));
                    nhanVien.setGioiTinh(rs.getInt("GIOITINH"));
                    nhanVien.setNgaySinh(rs.getDate("NGAYSINH"));
                    nhanVien.setCCCD(rs.getString("CCCD"));
                    nhanVien.setDiaChi(rs.getString("DIACHI"));
                    nhanVien.setSDT(rs.getString("SDT"));
                    nhanVien.setEmail(rs.getString("EMAIL"));
                    nhanVien.setTrangThaiNV(rs.getInt("TRANGTHAINV"));
                    nhanVien.setTenCV(rs.getString("TenCV"));
                    list.add(nhanVien);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public String update(NhanVien nv) {
        try (Connection con = connection.getConnection()) {
            String sql = "UPDATE NHANVIEN SET TENNV = ?, GIOITINH = ?, NGAYSINH = ?, CCCD = ?, DIACHI = ?, SDT = ?, EMAIL = ?, MATKHAU = ?, TRANGTHAINV = ?, IdCV = ? WHERE MANV = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, nv.getTenNV());
            ps.setObject(2, nv.getGioiTinh());
            ps.setObject(3, nv.getNgaySinh());
            ps.setObject(4, nv.getCCCD());
            ps.setObject(5, nv.getDiaChi());
            ps.setObject(6, nv.getSDT());
            ps.setObject(7, nv.getEmail());
            ps.setObject(8, nv.getMatKhau());
            ps.setObject(9, nv.getTrangThaiNV());
            ps.setObject(10, nv.getIdCV());
            ps.setObject(11, nv.getMaNV());
            ps.executeUpdate();
            return "Thanh Cong";
        } catch (Exception e) {
            e.printStackTrace();
            return "That Bai";
        }

    }

    public String capNhatMatKhau(String matKhauMoi, String Email) {
        try (Connection con = connection.getConnection()) {
            String sql = "UPDATE NHANVIEN SET MATKHAU = ? WHERE EMAIL = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, matKhauMoi);
            ps.setString(2, Email);
            ps.executeUpdate();
            return "Thanh Cong";
        } catch (Exception e) {
            e.printStackTrace();
            return "That Bai";
        }
    }

    public NhanVien selectByEmail(String email) {
        try (Connection con = connection.getConnection(); PreparedStatement ps = con.prepareStatement("SELECT * FROM NHANVIEN WHERE EMAIL = ?")) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    NhanVien nhanVien = new NhanVien();
                    nhanVien.setMaNV(rs.getString("MANV"));
                    nhanVien.setTenNV(rs.getString("TENNV"));
                    nhanVien.setGioiTinh(rs.getInt("GIOITINH"));
                    nhanVien.setNgaySinh(rs.getDate("NGAYSINH"));
                    nhanVien.setCCCD(rs.getString("CCCD"));
                    nhanVien.setDiaChi(rs.getString("DIACHI"));
                    nhanVien.setSDT(rs.getString("SDT"));
                    nhanVien.setEmail(rs.getString("EMAIL"));
                    nhanVien.setMatKhau(rs.getString("MATKHAU"));
                    nhanVien.setTrangThaiNV(rs.getInt("TRANGTHAINV"));
                    nhanVien.setTenCV(rs.getString("TenCV"));
                    return nhanVien;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String SelectById(UUID id) {
        
        try (Connection con = connection.getConnection();
                PreparedStatement ps = con.prepareStatement("SELECT TENCV FROM CHUCVU WHERE ID = ?")){
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
           
            while (rs.next()) {                
                return rs.getString(1);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    public UUID SelectByname(String id) {

        try (Connection con = connection.getConnection(); PreparedStatement ps = con.prepareStatement("SELECT ID FROM NHANVIEN WHERE TENNV = ?")) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                return UUID.fromString(rs.getString(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
