package com.android.yetee.yeteemobile.model;

public class PointOfInterest {
    private Long pointOfInterestId;
    private String name;
    private String description;
    private Double longitude;
    private Double latitude;
    private Event event;

    public Long getPointOfInterestId() {
        return pointOfInterestId;
    }

    public void setPointOfInterestId(Long pointOfInterestId) {
        this.pointOfInterestId = pointOfInterestId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
