package com.bap.domain;

import java.util.List;

import com.bap.dto.UnitDTO;

public class UnitDTOJson {

	private List<UnitDTO> unitDTOList;

	public List<UnitDTO> getUnitDTOList() {
		return unitDTOList;
	}

	public void setUnitDTOList(List<UnitDTO> unitDTOList) {
		this.unitDTOList = unitDTOList;
	}

	@Override
	public String toString() {
		return "UnitDTOJson [unitDTOList=" + unitDTOList + "]";
	}
	
	
	
}
