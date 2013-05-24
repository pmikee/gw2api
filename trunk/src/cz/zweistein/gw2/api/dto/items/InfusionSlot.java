package cz.zweistein.gw2.api.dto.items;

import java.util.List;

import cz.zweistein.gw2.api.dto.enums.InfusionSlotFlag;

public class InfusionSlot {
	
	private List<InfusionSlotFlag> flag;
	
	private Object item; //FIXME

	public InfusionSlot(List<InfusionSlotFlag> flag, Object item) {
		super();
		this.flag = flag;
		this.item = item;
	}

	public List<InfusionSlotFlag> getFlag() {
		return flag;
	}

	public Object getItem() {
		return item;
	}

	@Override
	public String toString() {
		return "InfusionSlot [flag=" + flag + ", item=" + item + "]";
	}

}