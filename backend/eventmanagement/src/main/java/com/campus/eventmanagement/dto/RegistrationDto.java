package com.campus.eventmanagement.dto;

public class RegistrationDto {

    private Long registrationId;
    private Long userId;
    private Long eventId;
    private String registrationDate;
    private String status;

    public RegistrationDto() {
    }

    public RegistrationDto(Long registrationId, Long userId, Long eventId,
                           String registrationDate, String status) {
        this.registrationId = registrationId;
        this.userId = userId;
        this.eventId = eventId;
        this.registrationDate = registrationDate;
        this.status = status;
    }

    public Long getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Long registrationId) {
        this.registrationId = registrationId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}