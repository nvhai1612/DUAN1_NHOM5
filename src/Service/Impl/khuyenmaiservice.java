/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DomainModel.KhuyenMai;
import Utiliti.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thien
 */
public class khuyenmaiservice {

   public List<KhuyenMai> getAll() {
    String query = "SELECT * FROM KHUYENMAI"; // Sửa tên bảng thành KHUYENMAI
    try (Connection con = DBConnection.getConnection(); PreparedStatement pr = con.prepareStatement(query)) {
        ResultSet rs = pr.executeQuery();
        List<KhuyenMai> qls = new ArrayList<>();
        while (rs.next()) {
            KhuyenMai km = new KhuyenMai();
            km.setID(rs.getString("ID"));
            km.setIDSP(rs.getString("IDSP"));
            km.setMAKM(rs.getString("MAKM"));
            km.setTENKM(rs.getString("TENKM"));
            km.setTHOIGIANBATDAU(rs.getDate("THOIGIANBATDAU"));
            km.setTHOIGIANKETTHUC(rs.getDate("THOIGIANKETTHUC"));
            km.setTRANGTHAI(rs.getInt("TRANGTHAI")); // Sửa đoạn này để đọc giá trị kiểu INT
            qls.add(km);
        }
        return qls;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}



  public Boolean insert(KhuyenMai qls) {
    String query = "insert into KHUYENMAI values(NEWID(),?,?,?,?,?,?,?)"; // Sửa tên bảng thành KHUYENMAI
    int check = 0;
    try (Connection con = DBConnection.getConnection(); PreparedStatement pr = con.prepareStatement(query)) {
//        pr.setObject(1, qls.getID());
        pr.setObject(1, qls.getIDSP());
        pr.setObject(2 , qls.getMAKM());
        pr.setObject(3 , qls.getTENKM());
        pr.setObject(4, qls.getMUCGIAMGIA());
        pr.setObject(5, qls.getTHOIGIANBATDAU());
        pr.setObject(6, qls.getTHOIGIANKETTHUC());

        // Chuyển đổi giá trị TRANGTHAI từ "Đang hoạt động" và "Ngừng hoạt động" sang kiểu INT
        int trangThaiValue = ("Đang hoạt động".equals(qls.getTRANGTHAI())) ? 0 : 1;
        pr.setObject(7, trangThaiValue);

        check = pr.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return check > 0;
}
  public Boolean updateKhuyenMai(KhuyenMai km) {
    if (km == null) {
        System.out.println("Error: KhuyenMai object is null");
        return false;
    }

    // Tiếp tục với xử lý thông thường nếu km không null
    String query = "update KHUYENMAI set IDSP = ?, MAKM = ?, TENKM = ?, MUCGIAMGIA = ?, "
            + "THOIGIANBATDAU = ?, THOIGIANKETTHUC = ?, TRANGTHAI = ? where ID = ?";
    int check = 0;

    try (Connection con = DBConnection.getConnection(); PreparedStatement pr = con.prepareStatement(query)) {
        pr.setObject(1, km.getIDSP());
        pr.setObject(2, km.getMAKM());
        pr.setObject(3, km.getTENKM());
        pr.setObject(4, km.getMUCGIAMGIA());
        pr.setObject(5, km.getTHOIGIANBATDAU());
        pr.setObject(6, km.getTHOIGIANKETTHUC());

        // Chuyển đổi giá trị TRANGTHAI từ "Đang hoạt động" và "Ngừng hoạt động" sang kiểu INT
        int trangThaiValue = ("Đang hoạt động".equals(km.getTRANGTHAI())) ? 0 : 1;
        pr.setObject(7, trangThaiValue);
        pr.setString(8, km.getID());
        check = pr.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return check > 0;
}







   




}
