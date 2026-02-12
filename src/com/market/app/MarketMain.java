package com.market.app;

import com.market.bean.VendorBean;
import com.market.service.MarketService;
import com.market.util.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Scanner;

public class MarketMain {

    private static MarketService service = new MarketService();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Local Farmers' Market Console");
        try {
            VendorBean v = service.viewVendorDetails("VN1001");
            if (v != null) {
            	System.out.println(v.getVendorID() + " | " + v.getVendorName() + " | " + v.getProductCategory() + " | " + v.getStatus());
            } else {
                System.out.println("Vendor not found");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            Date marketDate = Date.valueOf("2025-04-06");
            Date bookingDate = new Date(System.currentTimeMillis());
            boolean ok = service.bookStall("VN1004", marketDate, "S18", "VEGETABLE_ROW", "FULL_DAY", bookingDate, new BigDecimal("500.00"), "PAID");
            System.out.println(ok ? "STALL BOOKED" : "STALL BOOKING FAILED");
        } catch (BookingConflictException e) {
            System.out.println("Booking Conflict: Stall already booked");
        } catch (ValidationException e) {
            System.out.println("Validation Error (Vendor inactive / invalid)");
        } catch (Exception e) {
            System.out.println("System Error: " + e.getMessage());
        }
        try {
            service.recordSalesSummary(880001, new BigDecimal("1800.00"), "High demand for vegetables");
            System.out.println("SALES SUMMARY UPDATED");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            service.listBookingsByVendor("VN1001").forEach(b -> System.out.println(b.getBookingID() + " | " + b.getStallNo() + " | " + b.getBookingStatus()));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
}
}