package com.udea.bankrules.model;

public class Flight {
    private String flightNumber;
    private int delayMinutes;        // minutos de retraso
    private double durationHours;    // duración en horas
    private boolean emergencyExitSeatAvailable;

    public Flight() {}

    public Flight(String flightNumber, int delayMinutes,
                  double durationHours, boolean emergencyExitSeatAvailable) {
        this.flightNumber = flightNumber;
        this.delayMinutes = delayMinutes;
        this.durationHours = durationHours;
        this.emergencyExitSeatAvailable = emergencyExitSeatAvailable;
    }

    public String getFlightNumber() { return flightNumber; }
    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }

    public int getDelayMinutes() { return delayMinutes; }
    public void setDelayMinutes(int delayMinutes) { this.delayMinutes = delayMinutes; }

    public double getDurationHours() { return durationHours; }
    public void setDurationHours(double durationHours) { this.durationHours = durationHours; }

    public boolean isEmergencyExitSeatAvailable() { return emergencyExitSeatAvailable; }
    public void setEmergencyExitSeatAvailable(boolean emergencyExitSeatAvailable) {
        this.emergencyExitSeatAvailable = emergencyExitSeatAvailable;
    }
}