package com.bap.domain;

import java.util.List;

public class UnitListJson {
	
	private List<UnitVO> unitList;

	public List<UnitVO> getUnitList() {
		return unitList;
	}

	public void setUnitList(List<UnitVO> unitList) {
		this.unitList = unitList;
	}

	@Override
	public String toString() {
		return "UnitListJson [unitList=" + unitList + "]";
	}
	
	
	
}
