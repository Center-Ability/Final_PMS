package com.bap.domain;

import java.util.List;

public class UnitTeamListJson {
	
	private List<UnitTeam> unitteamList;

	public List<UnitTeam> getUnitTeamList() {
		return unitteamList;
	}

	public void setUnitTeamList(List<UnitTeam> unitTeamList) {
		this.unitteamList = unitTeamList;
	}

	@Override
	public String toString() {
		return "UnitListJson [unitList=" + unitteamList + "]";
	}
	
	
	
}
