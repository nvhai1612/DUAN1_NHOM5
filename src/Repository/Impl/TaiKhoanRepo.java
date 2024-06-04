/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository.Impl;

import DomainModel.TaiKhoan;
import Repository.ITaiKhoanRepo;
import Utiliti.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author admin
 */
public class TaiKhoanRepo implements ITaiKhoanRepo {

    DBConnection connection;

    @Override
    public ArrayList<TaiKhoan> getListFromDB() {
        ArrayList<TaiKhoan> list = new ArrayList<>();
        try (Connection conn = connection.getConnection()) {
            String sql = "Select * from TAIKHOAN";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TaiKhoan taiKhoan = new TaiKhoan();
                taiKhoan.setId(rs.getObject(1,UUID.class));
                taiKhoan.setTaiKhoan(rs.getString(2));
                taiKhoan.setMatKhau(rs.getString(3));
                list.add(taiKhoan);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
