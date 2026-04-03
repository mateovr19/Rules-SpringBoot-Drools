package com.udea.bankrules.model;

public class Passenger {
    private String name;
    private int age;
    private String membershipStatus; // "Basic", "Gold", "Platinum"
    private double luggageWeight;    // en kg
    private boolean travelingWithChildren;
    private String seatPreference;   // "Any", "Window", "Aisle"

    public Passenger() {}

    public Passenger(String name, int age, String membershipStatus,
                     double luggageWeight, boolean travelingWithChildren,
                     String seatPreference) {
        this.name = name;
        this.age = age;
        this.membershipStatus = membershipStatus;
        this.luggageWeight = luggageWeight;
        this.travelingWithChildren = travelingWithChildren;
        this.seatPreference = seatPreference;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getMembershipStatus() { return membershipStatus; }
    public void setMembershipStatus(String membershipStatus) { this.membershipStatus = membershipStatus; }

    public double getLuggageWeight() { return luggageWeight; }
    public void setLuggageWeight(double luggageWeight) { this.luggageWeight = luggageWeight; }

    public boolean isTravelingWithChildren() { return travelingWithChildren; }
    public void setTravelingWithChildren(boolean travelingWithChildren) { this.travelingWithChildren = travelingWithChildren; }

    public String getSeatPreference() { return seatPreference; }
    public void setSeatPreference(String seatPreference) { this.seatPreference = seatPreference; }
}