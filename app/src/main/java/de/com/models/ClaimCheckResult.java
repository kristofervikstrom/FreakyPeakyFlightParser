package com.models;

public class ClaimCheckResult {

    public int amountClaimed;
    public boolean successful;

    public ClaimCheckResult(boolean successful, int amountClaimed) {
        this.amountClaimed = amountClaimed;
        this.successful = successful;
    }
}
