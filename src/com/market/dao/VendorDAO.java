package com.market.dao;

import com.market.bean.VendorBean;
import com.market.util.DBUtil;

import java.sql.*;

public class VendorDAO {

    public boolean insertVendor(VendorBean v) throws Exception {
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = con.prepareStatement("INSERT INTO VENDOR_TBL VALUES (?,?,?,?,?,?,?,?)");
        ps.setString(1, v.getVendorID());
        ps.setString(2, v.getVendorName());
        ps.setString(3, v.getFarmOrShopName());
        ps.setString(4, v.getProductCategory());
        ps.setString(5, v.getMobile());
        ps.setString(6, v.getEmail());
        ps.setString(7, v.getCityOrVillage());
        ps.setString(8, v.getStatus());
        return ps.executeUpdate() == 1;
    }

    public VendorBean findVendor(String vendorID) throws Exception {
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = con.prepareStatement( "SELECT * FROM VENDOR_TBL WHERE VENDOR_ID=?");
        ps.setString(1, vendorID);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            VendorBean v = new VendorBean();
            v.setVendorID(rs.getString(1));
            v.setVendorName(rs.getString(2));
            v.setFarmOrShopName(rs.getString(3));
            v.setProductCategory(rs.getString(4));
            v.setMobile(rs.getString(5));
            v.setEmail(rs.getString(6));
            v.setCityOrVillage(rs.getString(7));
            v.setStatus(rs.getString(8));
            return v;
        }
        return null;
    }

    public void deleteVendor(String vendorID) throws Exception {
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = con.prepareStatement("DELETE FROM VENDOR_TBL WHERE VENDOR_ID=?");
        ps.setString(1, vendorID);
        ps.executeUpdate();
    }
}
