/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository.Impl;

import DomainModel.HoaDon;
import DomainModel.SanPhamChiTiet;
import Repository.IHoaDonRepos;
import Utiliti.DBConnection;
import ViewModel.HoaDonDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.UUID;
import java.sql.*;
import java.text.SimpleDateFormat;

/**
 *
 * @author Admin
 */
public class HoaDonRepos implements IHoaDonRepos{
    private DBConnection connection;

    @Override
    public ArrayList<HoaDon> getListFormDB() {
        ArrayList<HoaDon> listCV = new ArrayList<>();
        
        try (Connection con = connection.getConnection();
                
                PreparedStatement ps = con.prepareStatement("SELECT *\n" +
"FROM     HOADON INNER JOIN\n" +
"                  HOADONCT ON HOADON.ID = HOADONCT.IDHD INNER JOIN\n" +
"                  KHACHHANG ON HOADON.IDKH = KHACHHANG.ID \n" +
"				  INNER JOIN\n" +
"                  NHANVIEN ON HOADON.IDTK = NHANVIEN.ID")){
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getString(4));
                hd.setNgayTao(rs.getDate(8));
                hd.setTenTK(rs.getString(18));
                hd.setTrangThaiHD(rs.getInt(6));
                listCV.add(hd);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listCV;
}
    
    public ArrayList<HoaDon> getListHoaDonFormDB() {
        ArrayList<HoaDon> listHD = new ArrayList<>();
        
        try (Connection con = connection.getConnection();
                
                PreparedStatement ps = con.prepareStatement("SELECT * from HoaDon LEFT join TAIKHOAN n on hoadon.idtk = n.id")){
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getString(5));
                hd.setTenTK(rs.getString(11));
                hd.setNgayTao(new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString(6)));
                hd.setTrangThaiHD(rs.getInt(9));
                listHD.add(hd);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listHD;
    }

      public HoaDon findHoaDonByMa(String maHd) {
        ArrayList<HoaDon> listCV = new ArrayList<>();
        
        try (Connection con = connection.getConnection();
                
                PreparedStatement ps = con.prepareStatement("SELECT * from HoaDon where mahd = ?")){
            ps.setObject(1, maHd);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
//                System.out.println(rs.getDate(4));
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getString(5));
                hd.setId(UUID.fromString(rs.getString(1)));
                hd.setNgayTao(new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString(6)));
                hd.setTrangThaiHD(rs.getInt(9));
                return hd;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Boolean add(HoaDon hd) {
        int check;
        
        try (Connection con = connection.getConnection();
                PreparedStatement ps = con.prepareStatement("INSERT INTO HOADON (IDTK, NGAYTAO, TRANGTHAIHD, MAHD) VALUES (?, ?, ?,?)")){
        
            ps.setObject(1, hd.getIdTK());
            ps.setObject(2, hd.getNgayTao());
            ps.setObject(3, hd.getTrangThaiHD());
            ps.setObject(4, hd.getMaHD());

            check = ps.executeUpdate();
            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean update(HoaDon hd) {
        int check;
        
        try (Connection con = connection.getConnection();
                PreparedStatement ps = con.prepareStatement("UPDATE hoadon SET TRANGTHAIHD = ?, IDTK = ?, IDKH = ? where MAHD = ?")){
                
            ps.setObject(2, hd.getIdTK());
            ps.setObject(3, hd.getIdKH());
            ps.setObject(1, hd.getTrangThaiHD());
            ps.setObject(4, hd.getMaHD());

            check = ps.executeUpdate();
            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return null;
    }

    public HoaDonDTO searchbyMaHDCT(String ma) {
        ArrayList<HoaDonDTO> listHDCT = new ArrayList<>();
        try (Connection con = connection.getConnection();
                PreparedStatement ps = 
                        con.prepareStatement
        ("SELECT * FROM     HOADON INNER JOIN\n" +
"                  HOADONCT ON HOADON.ID = HOADONCT.IDHD INNER JOIN\n" +
"                  SANPHAMCHITIET ON HOADONCT.IDSPCT = SANPHAMCHITIET.ID Join\n" +
"				  SANPHAM ON SANPHAMCHITIET.IDSP = SANPHAM.ID WHERE MAHDCT = ?");) {
                       ps.setObject(1, ma);

//            ps.executeUpdate();

            HoaDonDTO dto = new HoaDonDTO();

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                dto.setMaSP(rs.getString(31));
                dto.setTenSP(rs.getString(32));
                dto.setSoLuong(rs.getInt(17));
                dto.setDonGia(rs.getFloat(29));
                return dto;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }
    
    public ArrayList<SanPhamChiTiet> HoaDonCho (String MaHD){
        ArrayList<SanPhamChiTiet> listSPCT = new ArrayList<>();

        try (Connection con = connection.getConnection(); PreparedStatement ps = con.prepareStatement(
                "SELECT MASPCT,TENSP,SOLUONG,SANPHAMCHITIET.DONGIA FROM HOADON INNER JOIN\n" +
"                  HOADONCT ON HOADON.ID = HOADONCT.IDHD INNER JOIN\n" +
"                  SANPHAMCHITIET ON HOADONCT.IDSPCT = SANPHAMCHITIET.ID Join\n" +
"				  SANPHAM ON SANPHAMCHITIET.IDSP = SANPHAM.ID WHERE MAHD = ? ")) {
            
            ps.setObject(1, MaHD);
            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                SanPhamChiTiet spct = new SanPhamChiTiet();
                spct.setMaSPCT(rs.getString(1));
                spct.setTenSP(rs.getString(2));
                spct.setSoLuongTon(rs.getInt(3));
                spct.setDonGia(rs.getFloat(4));
                listSPCT.add(spct);
            }

        } catch (Exception e) {
        }
        return listSPCT;
    }
    
}
