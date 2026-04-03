package com.udea.bankrules.model;

public class AirlineRequest {
    private Passenger passenger;
    private Flight flight;

    public AirlineRequest() {}

    public AirlineRequest(Passenger passenger, Flight flight) {
        this.passenger = passenger;
        this.flight = flight;
    }

    public Passenger getPassenger() { return passenger; }
    public void setPassenger(Passenger passenger) { this.passenger = passenger; }

    public Flight getFlight() { return flight; }
    public void setFlight(Flight flight) { this.flight = flight; }
}