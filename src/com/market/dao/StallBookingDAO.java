package com.market.dao;

import com.market.bean.StallBookingBean;
import com.market.util.DBUtil;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.*;

public class StallBookingDAO {
    public int generateBookingID() throws Exception {
        Connection con = DBUtil.getConnection();
        ResultSet rs = con.createStatement().executeQuery("SELECT NVL(MAX(BOOKING_ID),880000)+1 FROM STALL_BOOKING_TBL");
        rs.next();
        return rs.getInt(1);
    }
    public boolean isStallAlreadyBooked(Date date, String stallNo, String slot) throws Exception {
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM STALL_BOOKING_TBL WHERE MARKET_DATE=? AND STALL_NO=? AND TIME_SLOT=?");
        ps.setDate(1, date);
        ps.setString(2, stallNo);
        ps.setString(3, slot);
        ResultSet rs = ps.executeQuery();
        rs.next();
        return rs.getInt(1) > 0;
    }

    public boolean insertBooking(StallBookingBean b) throws Exception {
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = con.prepareStatement("INSERT INTO STALL_BOOKING_TBL (BOOKING_ID,VENDOR_ID,MARKET_DATE,STALL_NO,ZONE,TIME_SLOT,BOOKING_DATE,STALL_FEE,PAYMENT_STATUS,BOOKING_STATUS) VALUES (?,?,?,?,?,?,?,?,?,?)");
        ps.setInt(1, b.getBookingID());
        ps.setString(2, b.getVendorID());
        ps.setDate(3, b.getMarketDate());
        ps.setString(4, b.getStallNo());
        ps.setString(5, b.getZone());
        ps.setString(6, b.getTimeSlot());
        ps.setDate(7, b.getBookingDate());
        ps.setBigDecimal(8, b.getStallFee());
        ps.setString(9, b.getPaymentStatus());
        ps.setString(10, b.getBookingStatus());
        return ps.executeUpdate() == 1;
    }
    public void updateSalesSummary(int id, BigDecimal sales, String notes, String status) throws Exception {
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = con.prepareStatement("UPDATE STALL_BOOKING_TBL SET TOTAL_SALES_VALUE=?, SALES_NOTES=?, BOOKING_STATUS=? WHERE BOOKING_ID=?");
        ps.setBigDecimal(1, sales);
        ps.setString(2, notes);
        ps.setString(3, status);
        ps.setInt(4, id);
        ps.executeUpdate();
    }

    public List<StallBookingBean> findBookingsByVendor(String vendorID) throws Exception {
        List<StallBookingBean> list = new ArrayList<>();
        Connection con = DBUtil.getConnection();
        PreparedStatement ps =con.prepareStatement("SELECT * FROM STALL_BOOKING_TBL WHERE VENDOR_ID=?");
        ps.setString(1, vendorID);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            StallBookingBean b = new StallBookingBean();
            b.setBookingID(rs.getInt("BOOKING_ID"));
            b.setStallNo(rs.getString("STALL_NO"));
            b.setBookingStatus(rs.getString("BOOKING_STATUS"));
            list.add(b);
        }
        return list;
    }

    public boolean hasActiveOrFutureBookings(String vendorID, Date today) throws Exception {
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM STALL_BOOKING_TBL WHERE VENDOR_ID=? AND MARKET_DATE>=?");
        ps.setString(1, vendorID);
        ps.setDate(2, today);
        ResultSet rs = ps.executeQuery();
        rs.next();
        return rs.getInt(1) > 0;
    }
}
