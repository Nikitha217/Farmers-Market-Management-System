package com.market.util;

public class BookingConflictException extends Exception {
    public String toString() {
        return "Stall already booked for the given date and time slot.";
    }
}
