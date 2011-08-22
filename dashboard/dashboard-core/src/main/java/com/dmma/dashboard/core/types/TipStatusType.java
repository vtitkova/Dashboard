package com.dmma.dashboard.core.types;

public enum TipStatusType {
	isNew(       1),
	isInProcess( 2),
	isSucceed(   3),
	isRejected(  4);

	private Integer id;
	
	
	private TipStatusType(Integer id){
		this.setId(id);
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getId() {
		return id;
	}

	public static TipStatusType findById(Integer id) {
		for(TipStatusType type : TipStatusType.values()){
			if(type.getId().equals(id))
				return type;
		}
		return null;
	}

}
