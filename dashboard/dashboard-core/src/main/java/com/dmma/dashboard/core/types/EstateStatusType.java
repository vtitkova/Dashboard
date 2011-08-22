package com.dmma.dashboard.core.types;



public enum EstateStatusType {
	/*isFodSale(  1),
	isSold(     2),
	isForRent(  3),
	isRented(   4),
	isWithdrawn(5);*/
	
	/*READY(20, "Klargjort"),
	  FOR_SALE(30, "Til salgs"),
	  OFFER_RECEIVED(40, "Bud mottatt"), 
	  SOLD(50, "Solgt"), 
	
	  FOR_RENT(60, "Til utleie"),
	  RENTED(70, "Utleid"),
	
	  WITHDRAWN(90, "Trukket"), isWithdrawn
	  BROKEN(666, "Broken") */
	
	isReady(        20, "Ready"),
	isFodSale(      30, "For sale"),
	isOfferReceived(40, "Offer received"), 
	isSold(         50, "Sold"), 
	isForRent(      60, "For rent"),
	isRented(       70, "Rented"),
	isWithdrawn(    90, "Withdrawn"),
	isBroken(      666, "Broken");
	
	
	
	private Integer id;
	private String  title;
	
	private EstateStatusType(Integer id, String  title){
		this.setId(id);
		this.setTitle(title);
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getId() {
		return id;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}


	public String getTitle() {
		return title;
	}


	public static EstateStatusType findById(Integer statusIdFromMidas) {
		for(EstateStatusType type: values()){
			if(type.getId().equals(statusIdFromMidas))
				return type;
		}
		return isBroken;
	}

	
	public static String getActiveIDs(){
		StringBuffer sb = new StringBuffer();
		sb.append(isReady.getId()).append(", ");
		sb.append(isFodSale.getId()).append(", ");
		sb.append(isOfferReceived.getId()).append(", ");
		sb.append(isForRent.getId());
		return sb.toString();
	}

	public static String getNotActiveIDs(){
		StringBuffer sb = new StringBuffer();
		sb.append(isSold.getId()).append(", ");
		sb.append(isRented.getId()).append(", ");
		sb.append(isWithdrawn.getId()).append(", ");
		sb.append(isBroken.getId());
		return sb.toString();
	}

}
