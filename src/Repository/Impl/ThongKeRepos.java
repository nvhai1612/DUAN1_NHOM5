/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Buivuhoang
 */
public class ThongKeRepos {
    
    private Connection con = null;       // Biến kết nối với csdl
    private PreparedStatement pr = null; // Chuẩn bị thực hiện lệnh
    private ResultSet rs = null;         // Tập kết quả truy vấn select
    private String sql = null;           // Câu lệnh sql

    public ThongKeRepos() {
        con = Utiliti.DBConnection.getConnection();
    }
    
    public ArrayList<DomainModel.ThongKe> getAll() {
        // lấy tất cả dl từ bảng mylove trong sql server
        // đổ vào list
        sql = "select SANPHAM.MASP,SANPHAM.TENSP,SANPHAMCHITIET.SOLUONGTON,CHATLIEU.TENCL,MAUSAC.TENMS,KICHCO.TENKC,SANPHAM.TRANGTHAISP from SANPHAM \n"
                + "INNER JOIN SANPHAMCHITIET ON SANPHAM.ID = SANPHAM.ID\n"
                + "INNER JOIN CHATLIEU ON SANPHAM.ID = CHATLIEU.ID\n"
                + "INNER JOIN MAUSAC ON SANPHAM.ID = MAUSAC.ID\n"
                + "INNER JOIN KICHCO ON SANPHAM.ID = KICHCO.ID";
        
        ArrayList list_ThongKe = new ArrayList<>();
        try {
            // Kết nối thành công
            con = Utiliti.DBConnection.getConnection();
            pr = con.prepareStatement(sql);
            rs = pr.executeQuery();
            while (rs.next()) { // chạy từ đầu đến cuối tập rs
                String maSP, tenSP, chatLieu, mauSac, kichThuoc;
                boolean trangThai;
                int soLuong;
                
                maSP = rs.getString(1);
                tenSP = rs.getString(2);
                soLuong = rs.getInt(3);
                chatLieu = rs.getString(4);
                mauSac = rs.getString(5);
                kichThuoc = rs.getString(6);
                trangThai = rs.getBoolean(7);
                DomainModel.ThongKe ml = new DomainModel.ThongKe(maSP, tenSP, soLuong, chatLieu, mauSac, kichThuoc, trangThai);
                list_ThongKe.add(ml);
            }// đóng white
            return list_ThongKe;
            
        } catch (Exception e) {
            // Kết nối lỗi
            e.printStackTrace(); // In ra các lỗi
            return null;
        }
    }
    
}
