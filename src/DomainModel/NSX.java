/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

import ViewModel.*;

/**
 *
 * @author Admin
 */
public class NSX {
    private String id;
    private String MaNSX;
    private String TenNSX;

    public NSX() {
    }

    public NSX(String id, String MaNSX, String TenNSX) {
        this.id = id;
        this.MaNSX = MaNSX;
        this.TenNSX = TenNSX;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaNSX() {
        return MaNSX;
    }

    public void setMaNSX(String MaNSX) {
        this.MaNSX = MaNSX;
    }

    public String getTenNSX() {
        return TenNSX;
    }

    public void setTenNSX(String TenNSX) {
        this.TenNSX = TenNSX;
    }
    
}
