package com.guildwars2.api.dto;

import com.guildwars2.api.dto.enums.WvWSide;

public class WvWObjective {

	private String objectiveId;

	private String ownerGuild;

	private WvWSide owner;

	public WvWObjective(String objectiveId, String ownerGuild, WvWSide owner) {
		super();
		this.objectiveId = objectiveId;
		this.ownerGuild = ownerGuild;
		this.owner = owner;
	}

	public String getObjectiveId() {
		return this.objectiveId;
	}

	public String getOwnerGuild() {
		return this.ownerGuild;
	}

	public WvWSide getOwner() {
		return this.owner;
	}

	@Override
	public String toString() {
		return "WvWObjective [objectiveId=" + this.objectiveId + ", ownerGuild=" + this.ownerGuild + ", owner=" + this.owner + "]";
	}

}