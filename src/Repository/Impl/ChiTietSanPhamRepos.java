/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository.Impl;

import DomainModel.ChiTietSanPham;
import Repository.IChiTietSanPhamRepos;
import java.util.ArrayList;
import Utiliti.DBConnection;
import java.sql.*;

/**
 *
 * @author Admin
 */
public class ChiTietSanPhamRepos implements IChiTietSanPhamRepos{
    private DBConnection connection;
    

    @Override
    public ArrayList<ChiTietSanPham> getListFormDB() {
        ArrayList<ChiTietSanPham> listCTSP = new ArrayList<>();
        
        try (Connection con = connection.getConnection();
                PreparedStatement ps = con.prepareStatement("SELECT ID,MACTSP,SOLUONGTON,MOTA,TRANGTHAI,DONGIA,IDMS,IDCL,IDNSX,IDKC,IDSP FROM CHITIETSANPHAM")){
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                ChiTietSanPham ctsp = new ChiTietSanPham();
//                ctsp.setId(rs.getString(1));
//                ctsp.setMaCTSP(rs.getString(1));
//                ctsp.setSoLuongTon(rs.getString(1));
//                ctsp.setTrangThai(rs.getString(1));
//                ctsp.setDonGia(rs.getString(1));
//                ctsp.setIDMS(rs.getString(1));
//                ctsp.setId(rs.getString(1));
//                ctsp.setId(rs.getString(1));
            }
            
        } catch (Exception e) {
        }
        return listCTSP;
    }

    @Override
    public Boolean add(ChiTietSanPham ctsp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean update(ChiTietSanPham ctsp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
