/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository.Impl;

import DomainModel.NhanVien;
import Repository.INhanVienRepos;
import java.util.ArrayList;
import Utiliti.DBConnection;
import java.sql.*;

/**
 *
 * @author Admin
 */
public class NhanVienRepos implements INhanVienRepos{
    
    private DBConnection connection;

    @Override
    public ArrayList<NhanVien> getListFormDB() {
        ArrayList<NhanVien> listNV = new ArrayList<>();
        
        try (Connection con = connection.getConnection();
                PreparedStatement ps = con.prepareStatement("SELECT ID,MANV,TENNV,GIOITINH,NGAYSINH,CCCD,DIACHI,SDT,EMAIL,TRANGTHAI FROM NHANVIEN")){
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                NhanVien nv = new NhanVien();
                nv.setId(rs.getString(1));
                nv.setMaNV(rs.getString(2));
                nv.setTenNV(rs.getString(3));
                nv.setGioiTinh(rs.getInt(4));
                nv.setNgaySinh(rs.getDate(5));
                nv.setCCCD(rs.getString(6));
                nv.setDiaChi(rs.getString(7));
                nv.setSDT(rs.getString(8));
                nv.setEmail(rs.getString(9));
                nv.setTrangThai(rs.getInt(10));
                listNV.add(nv);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNV;
    }

    @Override
    public Boolean add(NhanVien nv) {
      int check;
        
        try (Connection con = connection.getConnection();
                PreparedStatement ps = con.prepareStatement("INSERT INTO NHANVIEN(MANV,TENNV,GIOITINH,NGAYSINH,CCCD,DIACHI,SDT,EMAIL,TRANGTHAI) Values(?,?,?,?,?,?,?,?,?)")){
            
            ps.setObject(1, nv.getMaNV());
            ps.setObject(2, nv.getTenNV());
            ps.setObject(3, nv.getGioiTinh());
            ps.setObject(4, nv.getNgaySinh());
            ps.setObject(5, nv.getCCCD());
            ps.setObject(6, nv.getDiaChi());
            ps.setObject(7, nv.getSDT());
            ps.setObject(8, nv.getEmail());
            ps.setObject(9, nv.getTrangThai());

            check = ps.executeUpdate();
            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean update(NhanVien nv) {
int check;
        
        try (Connection con = connection.getConnection();
                PreparedStatement ps = con.prepareStatement
        ("UPDATE NHANVIEN SET TENNV = ?, GIOITINH = ?, NGAYSINH = ?, CCCD = ?, DIACHI = ?, SDT = ?, EMAIL = ?, TRANGTHAI = ? WHERE MANV = ?")){

            ps.setObject(1, nv.getTenNV());
            ps.setObject(2, nv.getGioiTinh());
            ps.setObject(3, nv.getNgaySinh());
            ps.setObject(4, nv.getCCCD());
            ps.setObject(5, nv.getDiaChi());
            ps.setObject(6, nv.getSDT());
            ps.setObject(7, nv.getEmail());
            ps.setObject(8, nv.getTrangThai());
            ps.setObject(9, nv.getMaNV());

            

            check = ps.executeUpdate();
            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }

    @Override
    public Boolean delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<NhanVien> search() {
        ArrayList<NhanVien> listNV = new ArrayList<>();
        try (Connection con = connection.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM NHANVIEN WHERE MANV = ?");){
            ps.executeUpdate();
            
            NhanVien nv = new NhanVien();
            ps.setObject(1, nv.getMaNV());
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                nv.setId(rs.getString(1));
                nv.setMaNV(rs.getString(2));
                nv.setTenNV(rs.getString(3));
                nv.setGioiTinh(rs.getInt(4));
                nv.setNgaySinh(rs.getDate(5));
                nv.setCCCD(rs.getString(6));
                nv.setDiaChi(rs.getString(7));
                nv.setSDT(rs.getString(8));
                nv.setEmail(rs.getString(9));
                nv.setTrangThai(rs.getInt(10));
                listNV.add(nv);
            } 
        } catch (Exception e) {
            e.getMessage();
        }
        return listNV;
    }
    
}
