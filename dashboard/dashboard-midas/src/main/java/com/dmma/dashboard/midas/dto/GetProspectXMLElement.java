package com.dmma.dashboard.midas.dto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dmma.dashboard.core.entities.Estate;
import com.dmma.dashboard.core.entities.EstateViewing;
import com.dmma.dashboard.core.types.EstateStatusType;

public class GetProspectXMLElement {

    public GetProspectPropertyMainDTO prospectMain = new GetProspectPropertyMainDTO();
    public ArrayList<GetProspectShowDTO> shows = new ArrayList<GetProspectShowDTO>();
    public ArrayList<GetProspectAttachmentDTO> attachments = new ArrayList<GetProspectAttachmentDTO>();
    public GetProspectSellerDTO seller = new GetProspectSellerDTO();

    public Estate toEstate() {
    	Estate estate = new Estate();
    	estate.setMidasId(new Long(prospectMain.estateid));
    	estate.setFinnCode(new Integer(prospectMain.finnkode));
    	estate.setOrderNumber(prospectMain.oppdragsnr);
    	estate.setStatus(mapEstateStatusType(prospectMain.status).getId());
    	String title = "";
        if (!"".equals(prospectMain.overskrift1)) {
            title += prospectMain.overskrift1;
        }
        estate.setTitle(title);
    	estate.setAddress(prospectMain.eiendomsnavn);
    	estate.setPostCode(prospectMain.eiendompostnr);
    	estate.setPostCity(prospectMain.eiendompoststed);
    	estate.setGnr(prospectMain.gnr);
    	estate.setBnr(prospectMain.bnr);

    	if(shows!=null && !shows.isEmpty()){
    		//Set<Viewing> showList = new HashSet<Viewing>();
    		List<EstateViewing> showList = new ArrayList<EstateViewing>();
    		for(GetProspectShowDTO prospectShow: shows){
    			showList.add(toEstateViewing(prospectShow));
    		}
    		estate.setEstateViewings(showList);
    	}
    	
    	return estate;
	}

    private EstateViewing toEstateViewing(GetProspectShowDTO prospectShow) {
        try {
            DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
            Date dateFrom = (Date) formatter.parse(prospectShow.datefrom);
            Date dateTo   = (Date) formatter.parse(prospectShow.dateto);
            EstateViewing show = new EstateViewing();
    		show.setDateFrom(dateFrom);
    		show.setDateTo(dateTo);
    		return show;
        } catch (java.text.ParseException e) {
        	e.printStackTrace();
           return null; 
        }
    }
    
    private EstateStatusType mapEstateStatusType(Integer statusIdFromMidas){
    	return EstateStatusType.findById(statusIdFromMidas);
    }
    

}
