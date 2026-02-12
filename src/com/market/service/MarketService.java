package com.market.service;

import com.market.bean.*;
import com.market.dao.*;
import com.market.util.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public class MarketService {

    VendorDAO vendorDAO = new VendorDAO();
    StallBookingDAO bookingDAO = new StallBookingDAO();
    public boolean registerNewVendor(VendorBean v) throws Exception {
        if (v.getVendorID() == null || v.getVendorName().isEmpty())
            throw new ValidationException();
        if (vendorDAO.findVendor(v.getVendorID()) != null)
            return false;
        if (v.getStatus() == null)
            v.setStatus("ACTIVE");
        return vendorDAO.insertVendor(v);
    }
    public VendorBean viewVendorDetails(String vendorID) throws Exception {
        return vendorDAO.findVendor(vendorID);
    }
    public boolean bookStall(String vendorID, Date marketDate, String stallNo,
                             String zone, String timeSlot, Date bookingDate,
                             BigDecimal fee, String paymentStatus) throws Exception {

        VendorBean v = vendorDAO.findVendor(vendorID);
        if (v == null || !"ACTIVE".equals(v.getStatus()))
            throw new ValidationException();

        if (bookingDAO.isStallAlreadyBooked(marketDate, stallNo, timeSlot))
            throw new BookingConflictException();

        StallBookingBean b = new StallBookingBean();
        b.setBookingID(bookingDAO.generateBookingID());
        b.setVendorID(vendorID);
        b.setMarketDate(marketDate);
        b.setStallNo(stallNo);
        b.setZone(zone);
        b.setTimeSlot(timeSlot);
        b.setBookingDate(bookingDate);
        b.setStallFee(fee);
        b.setPaymentStatus(paymentStatus);
        b.setBookingStatus("BOOKED");

        return bookingDAO.insertBooking(b);
    }
    public void recordSalesSummary(int bookingID, BigDecimal sales, String notes) throws Exception {
    	bookingDAO.updateSalesSummary(bookingID, sales, notes, "COMPLETED");
    }
    public List<StallBookingBean> listBookingsByVendor(String vendorID) throws Exception {
           return bookingDAO.findBookingsByVendor(vendorID);
    }
    public void removeVendor(String vendorID, Date today) throws Exception {
        if (bookingDAO.hasActiveOrFutureBookings(vendorID, today))
            throw new ActiveBookingsExistException();
        vendorDAO.deleteVendor(vendorID);
    }
}
