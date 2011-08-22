package com.dmma.dashboard.app.servlets;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;

import com.dmma.base.app.clazz.Time;
import com.dmma.base.app.o2pdf.O2PdfAbstractServlet;
import com.dmma.dashboard.app.wrappers.ClientVisitPlanHeaderO2P;
import com.dmma.dashboard.app.wrappers.ClientVisitPlanO2P;
import com.dmma.dashboard.app.wrappers.ClientVisitShortO2P;
import com.dmma.dashboard.core.entities.ClientVisit;
import com.dmma.dashboard.core.entities.Estate;
import com.dmma.dashboard.core.entities.EstateViewing;
import com.dmma.dashboard.core.services.ClientVisitService;
import com.dmma.dashboard.core.services.EstateService;
import com.dmma.dashboard.core.services.EstateViewingService;



public class ClientVisitPlannerPDFServlet extends O2PdfAbstractServlet{
	private static final long serialVersionUID = 1476811843954172227L;
	public  static final String SEPARATOR      = File.separator;
	private static final String PATH_TO_XSL_TEMPLATES    = "WEB-INF"+SEPARATOR+"xsltemplates";
	private static final String CLIENT_VISIT_PLANNER_XSL = "clientVisitPlanner.xsl";

	private EstateViewingService estateViewingService;
	private EstateService estateService;
	private ClientVisitService clientVisitService;

	@Override
	protected void initMe(WebApplicationContext context) {
		estateViewingService    = context.getBean("estateViewingService",   EstateViewingService.class);
		estateService = context.getBean("estateService",   EstateService.class);
		clientVisitService = context.getBean("clientVisitService",   ClientVisitService.class);
	}

	@Override
	protected ObjectAndSource generateModelAndSource(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String estateViewingIdString = request.getParameter("id");
		if(estateViewingIdString == null ){
			response.getWriter().write("Error: No estate viewing parameter.");
			return null;
		}
		Integer viewingId = null;
		try{
			viewingId = Integer.parseInt(estateViewingIdString);
		}catch (Exception e) {
			response.getWriter().write("Error: Can't parse viewingId.");
			return null;
		}

		EstateViewing viewing = estateViewingService.findById(viewingId);
		if(viewing == null ){
			response.getWriter().write("Error: estate viewing not found.");
			return null;
		} 

		String pathname = this.getServletContext().getRealPath(PATH_TO_XSL_TEMPLATES+SEPARATOR+CLIENT_VISIT_PLANNER_XSL);
		File xslSource  = new File(pathname);
		if(!xslSource.exists()){
			response.getWriter().write("Error: XSL Transformation template not found.");
			return null;

		}

		ClientVisitPlanO2P model  = new ClientVisitPlanO2P();
		model.setHeader("Client Visit Planer");
		model.setFooter("This is demo PDF document designe for em1 Broker Dashboard project. Client Visit Planer is part of main functionallity ... ");
		model.setIsFuture((new Date()).before(viewing.getDateFrom()));
		
		Estate estate = estateService.findById(viewing.getEstateId());

		ClientVisitPlanHeaderO2P clientVisitPlanHeaderO2P = new ClientVisitPlanHeaderO2P();
		clientVisitPlanHeaderO2P.setEstate(estate.getTitle());
		clientVisitPlanHeaderO2P.setBroker(estate.getBroker().getName() + " "+estate.getBroker().getSurname());
		clientVisitPlanHeaderO2P.setViewingDate(viewing.getDateFrom());
		clientVisitPlanHeaderO2P.setViewingStart(new Time(viewing.getDateFrom()));
		clientVisitPlanHeaderO2P.setViewingEnd(new Time(viewing.getDateTo()));
		model.setClientVisitPlanHeader(clientVisitPlanHeaderO2P);
			

		List<ClientVisit> visits = clientVisitService.findByEstateViewingId(viewing.getId());
		if(visits != null){
			ArrayList<ClientVisitShortO2P> visitsO2P = new ArrayList<ClientVisitShortO2P>(visits.size());
			for(ClientVisit entity:visits){
				ClientVisitShortO2P clientVisitShort = new ClientVisitShortO2P();
				clientVisitShort.setNr(visitsO2P.size()+1);
				clientVisitShort.setClient(entity.getClient().getName() + " " + entity.getClient().getSurname() );
				clientVisitShort.setComments(entity.getComments());
				clientVisitShort.setStatus(""); // TODO 
				clientVisitShort.setCreated(entity.getCreated());
				visitsO2P.add(clientVisitShort);
			}
			model.setClientVisits(visitsO2P);
		} 
		
		for(int i = model.getClientVisits().size()+1;  i < 26; i++){
			model.getClientVisits().add(new ClientVisitShortO2P(i));
		}
		
		String pth = xslSource.getAbsolutePath();
		pth = pth.substring(0, pth.lastIndexOf(File.separator));
		pth+=File.separator+"logo.jpg";
		HashMap<String, String> aditionalParams = new HashMap<String, String>();
		aditionalParams.put("EM1.LOGO",pth);
		

		ObjectAndSource retVal = new ObjectAndSource();
		retVal.setFileName("ClientVisitPlanner_"+viewingId+".pdf");
		retVal.setModel(model);
		retVal.setXslSource(xslSource);
		retVal.setAditionalParams(aditionalParams);
		
		return retVal;
	}


}
