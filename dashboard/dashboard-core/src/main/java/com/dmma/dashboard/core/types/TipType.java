package com.dmma.dashboard.core.types;

public enum TipType {
	isLoan(     1),
	isSell(     2),
	isInventory(3);

	private Integer id;
	
	
	private TipType(Integer id ){
		this.setId(id);
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getId() {
		return id;
	}


	public static TipType findById(Integer id) {
		for(TipType type : TipType.values()){
			if(type.getId().equals(id))
				return type;
		}
		return null;
	}


}
