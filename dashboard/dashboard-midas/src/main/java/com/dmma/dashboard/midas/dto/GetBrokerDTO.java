package com.dmma.dashboard.midas.dto;

import com.dmma.dashboard.core.entities.Broker;


public class GetBrokerDTO {

    public Long   id;
    public String name;
    public String title;
    public String phone;
    public String cellPhone;
    public String fax;
    public String personalEmail;
    public String email;
    public String initials;

    public Broker toBroker() {
    	Broker broker = new Broker();
        broker.setMidasId(id);
        broker.setName(getFirstName(name));
        broker.setSurname(getLastName(name));
        broker.setPhone(removeSpaces(phone));
        broker.setCellPhone(removeSpaces(cellPhone));
        if (personalEmail!=null&&personalEmail.length()>0){
            broker.setEmail(personalEmail);
        } else {
            broker.setEmail(email);
        }
        //broker.setFax(fax);
        //broker.setTitle(title);
        //broker.setInitials(initials);
        return broker;
    }

    protected static String getLastName(String fullName) {
        if (fullName == null) {
            return "";
        }
        String[] names = fullName.split(" ");
        return names[names.length - 1];
    }

    protected static String getFirstName(String fullName) {
        if (fullName == null) {
            return "";
        }
        String[] names = fullName.split(" ");
        String name = "";
        for (int i = 0; i < names.length - 1; i++) {
            if (i == 0) {
                name = names[0];
            } else {
                name = name + " " + names[i];
            }
        }
        return name;
    }
    
    protected static String removeSpaces(String phone) {
    	if(phone==null) return null;
    	return phone.replaceAll(" ","");
    }

}
