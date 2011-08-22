package com.dmma.dashboard.core.types;



public enum ClientVisitStatusType {
	isPlaningToGo(    1 ),
	isWasOnViewing(   2 ),
	isWasNotOnViewing(3 );
	
	private Integer id;
	
	public static ClientVisitStatusType getById(Integer id){
		for(ClientVisitStatusType type: ClientVisitStatusType.values()){
			if(type.getId()==id)
				return type;
		}
		return null;
	}
	
	private ClientVisitStatusType(Integer id){
		this.setId(id);
	}

	

	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getId() {
		return id;
	}
		
}
