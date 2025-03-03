package net.ddns.opazenha.ccrback.prayers;

public enum PrayerStatus {
    PENDING("pending"),
    ONGOING("ongoing"),
    DONE("done");

    private String status;

    private PrayerStatus(String status) {
        this.status = status;
    }
    
    public String getStatus() {
        return status;
    }
}
