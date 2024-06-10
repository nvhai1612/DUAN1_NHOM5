/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository.Impl;

import DomainModel.ChucVu;
import DomainModel.NhanVien;
import Repository.IChucVuRepo;
import Utiliti.DBConnection;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;

/**
 *
 * @author admin
 */
public class ChucVuRepo implements IChucVuRepo {

    DBConnection connection;

    @Override
    public ArrayList<ChucVu> getListFormDB() {
        ArrayList<ChucVu> listCV = new ArrayList<>();

        try (Connection conn = connection.getConnection(); PreparedStatement ps = conn.prepareStatement("SELECT * FROM CHUCVU"); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {

                ChucVu cv = new ChucVu();
                cv.setId(rs.getObject(1, UUID.class));
                cv.setMaCV(rs.getString(2));
                cv.setTenCV(rs.getString(3));
                listCV.add(cv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listCV;
    }

    @Override
    public Boolean add(ChucVu cv) {
        try (Connection con = connection.getConnection()) {
            String sql = "INSERT INTO CHUCVU (MACV,TENCV) VALUES  (?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, cv.getMaCV());
            ps.setObject(2, cv.getTenCV());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean update(ChucVu cv) {
        try (Connection con = connection.getConnection()) {
            String sql = "UPDATE CHUCVU SET TENCV=? WHERE MACV=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, cv.getMaCV());
            ps.setObject(2, cv.getTenCV());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<ChucVu> search(String maCV) {
        ArrayList<ChucVu> chucVuList = new ArrayList<>();
        try (Connection con = connection.getConnection()) {
            String sql = "SELECT * FROM ChucVu WHERE MaCV = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maCV);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                UUID id = UUID.fromString(rs.getString("id"));
                String tenCV = rs.getString("TenCV");
                ChucVu chucVu = new ChucVu(id, maCV, tenCV);
                chucVuList.add(chucVu);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chucVuList;
    }

    public ArrayList<NhanVien> searchbyCV(String TenCV) {
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
                + "WHERE CHUCVU.tenCV LIKE ?";
        try (Connection conn = connection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + TenCV + "%");

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
}
