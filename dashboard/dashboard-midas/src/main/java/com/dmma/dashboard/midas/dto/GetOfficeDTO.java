package com.dmma.dashboard.midas.dto;

import com.dmma.dashboard.core.entities.BrokerOffice;



public class GetOfficeDTO {

    public Long officeId;
    public String name;
    public String address;
    public String zip;
    public String city;
    public String phone;
    public String fax;
    public String email;
    public String legalName;
    public String displayName;
    public String visitingAddress;
    public String x;
    public String y;

    public BrokerOffice toOffice() {
        BrokerOffice office = new BrokerOffice();
        office.setMidasId(officeId);
        office.setAddress(address);
        office.setCity(city);
        office.setEmail(email);
        if (displayName!=null&&displayName.length()>0){
            office.setName(displayName);
        } else {
            office.setName(name);
        }
        office.setPhone(removeSpaces(phone));
        office.setZip(zip);
        return office;
    }
    
    protected static String removeSpaces(String phone) {
    	if(phone==null) return null;
    	return phone.replaceAll(" ","");
    }

}
