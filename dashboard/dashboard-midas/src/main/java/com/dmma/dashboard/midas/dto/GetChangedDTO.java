package com.dmma.dashboard.midas.dto;


public class GetChangedDTO {
    
    public String id;
    public String status;

    @Override
    public String toString() {
        return id+" "+status;
    }
    
    public Long getMidasEstateId() {
        return Long.parseLong(id);
    }

    public boolean isStatusPresent() {
        return status != null;
    }

    public boolean isWithdrawn() {
        return status.toLowerCase().contains("trukket");
    }

}
