package cz.zweistein.gw2.api.dto.items;

import cz.zweistein.gw2.api.dto.enums.ToolType;

public class Tool {
	
	private ToolType type;
	
	private String charges;

	public Tool(ToolType type, String charges) {
		super();
		this.type = type;
		this.charges = charges;
	}

	public ToolType getType() {
		return this.type;
	}

	public String getCharges() {
		return this.charges;
	}

	@Override
	public String toString() {
		return "Tool [type=" + this.type + ", charges=" + this.charges + "]";
	}

}
