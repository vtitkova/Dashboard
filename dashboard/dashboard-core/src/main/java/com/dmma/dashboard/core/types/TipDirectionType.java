package com.dmma.dashboard.core.types;



public enum TipDirectionType {
	isMtoB(     1),
	isBtoM(     2);

	private Integer id;
	
	
	private TipDirectionType(Integer id){
		this.setId(id);
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getId() {
		return id;
	}


	public static TipDirectionType findById(Integer id) {
		for(TipDirectionType type : TipDirectionType.values()){
			if(type.getId().equals(id))
				return type;
		}
		return null;
	}
}
