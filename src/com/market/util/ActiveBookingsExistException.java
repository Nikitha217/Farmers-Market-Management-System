package com.market.util;

public class ActiveBookingsExistException extends Exception {
    public String toString() {
        return "Vendor has active/future bookings. Cannot delete.";
    }
}
