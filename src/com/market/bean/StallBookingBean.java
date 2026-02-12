package com.market.bean;

import java.math.BigDecimal;
import java.sql.Date;

public class StallBookingBean {

    private int bookingID;
    private String vendorID;
    private Date marketDate;
    private String stallNo;
    private String zone;
    private String timeSlot;
    private Date bookingDate;
    private BigDecimal stallFee;
    private String paymentStatus;
    private BigDecimal totalSalesValue;
    private String salesNotes;
    private String bookingStatus;
	public int getBookingID() {
		return bookingID;
	}
	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}
	public String getVendorID() {
		return vendorID;
	}
	public void setVendorID(String vendorID) {
		this.vendorID = vendorID;
	}
	public Date getMarketDate() {
		return marketDate;
	}
	public void setMarketDate(Date marketDate) {
		this.marketDate = marketDate;
	}
	public String getStallNo() {
		return stallNo;
	}
	public void setStallNo(String stallNo) {
		this.stallNo = stallNo;
	}
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	public String getTimeSlot() {
		return timeSlot;
	}
	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public BigDecimal getStallFee() {
		return stallFee;
	}
	public void setStallFee(BigDecimal stallFee) {
		this.stallFee = stallFee;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public BigDecimal getTotalSalesValue() {
		return totalSalesValue;
	}
	public void setTotalSalesValue(BigDecimal totalSalesValue) {
		this.totalSalesValue = totalSalesValue;
	}
	public String getSalesNotes() {
		return salesNotes;
	}
	public void setSalesNotes(String salesNotes) {
		this.salesNotes = salesNotes;
	}
	public String getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
    
}