package cz.zweistein.gw2.api.dto.items;

import cz.zweistein.gw2.api.dto.enums.ContainerType;

public class Container {
	
	private ContainerType type;

	public Container(ContainerType type) {
		super();
		this.type = type;
	}
	
	public ContainerType getType() {
		return type;
	}
	
	@Override
	public String toString() {
		return "Container [type=" + type + "]";
	}

}
