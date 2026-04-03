package com.udea.bankrules.model;

import java.util.ArrayList;
import java.util.List;

public class AirlineResponse {
    private boolean upgradedToBusinessClass;
    private boolean priorityCheckIn;
    private double discount;
    private boolean eligibleForUpgrade;
    private String assignedSeat;
    private double compensation;
    private int loyaltyPointsAdded;
    private boolean luggageAllowed;
    private boolean vipLoungeAccess;
    private List<String> appliedRules;

    public AirlineResponse() {
        this.eligibleForUpgrade = true;
        this.luggageAllowed = true;
        this.appliedRules = new ArrayList<>();
    }

    public boolean isUpgradedToBusinessClass() { return upgradedToBusinessClass; }
    public void setUpgradedToBusinessClass(boolean upgradedToBusinessClass) { this.upgradedToBusinessClass = upgradedToBusinessClass; }

    public boolean isPriorityCheckIn() { return priorityCheckIn; }
    public void setPriorityCheckIn(boolean priorityCheckIn) { this.priorityCheckIn = priorityCheckIn; }

    public double getDiscount() { return discount; }
    public void setDiscount(double discount) { this.discount = discount; }

    public boolean isEligibleForUpgrade() { return eligibleForUpgrade; }
    public void setEligibleForUpgrade(boolean eligibleForUpgrade) { this.eligibleForUpgrade = eligibleForUpgrade; }

    public String getAssignedSeat() { return assignedSeat; }
    public void setAssignedSeat(String assignedSeat) { this.assignedSeat = assignedSeat; }

    public double getCompensation() { return compensation; }
    public void setCompensation(double compensation) { this.compensation = compensation; }

    public int getLoyaltyPointsAdded() { return loyaltyPointsAdded; }
    public void setLoyaltyPointsAdded(int loyaltyPointsAdded) { this.loyaltyPointsAdded = loyaltyPointsAdded; }

    public boolean isLuggageAllowed() { return luggageAllowed; }
    public void setLuggageAllowed(boolean luggageAllowed) { this.luggageAllowed = luggageAllowed; }

    public boolean isVipLoungeAccess() { return vipLoungeAccess; }
    public void setVipLoungeAccess(boolean vipLoungeAccess) { this.vipLoungeAccess = vipLoungeAccess; }

    public List<String> getAppliedRules() { return appliedRules; }
    public void setAppliedRules(List<String> appliedRules) { this.appliedRules = appliedRules; }
}