package com.dmma.dashboard.midas.dto;


public class GetProspectShowDTO {

    public String datefrom;
    public String dateto;

   /* public EstateViewing toEstateViewing() {
        EstateViewing estateViewing = new EstateViewing();
        try {
            DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
            Date dateFrom = (Date) formatter.parse(datefrom);
            Date dateTo = (Date) formatter.parse(dateto);
            estateViewing.setTimeInterval(new Interval(dateFrom.getTime(), dateTo.getTime()));
        } catch (java.text.ParseException e) {
            throw new RuntimeException(e);
        }
        return estateViewing;
    }*/

}
