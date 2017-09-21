package com.kushmyruk.domain;

public enum EventRating {
    LOW(1), MID(1.5), HIGH(2);

    private double rate;

    EventRating(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }
}
