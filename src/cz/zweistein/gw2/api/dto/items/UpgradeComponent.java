package cz.zweistein.gw2.api.dto.items;

import java.util.List;

import cz.zweistein.gw2.api.dto.enums.UpgradeComponentFlag;
import cz.zweistein.gw2.api.dto.enums.UpgradeComponentType;

public class UpgradeComponent {
	
	private UpgradeComponentType type;
	
	private List<UpgradeComponentFlag> flags;
	
	private InfixUpgrade infixUpgrade;
	
	private String suffix;

	private Object infusionUpgradeFlags; //FIXME

	public UpgradeComponent(UpgradeComponentType type, List<UpgradeComponentFlag> flags, InfixUpgrade infixUpgrade, String suffix, Object infusionUpgradeFlags) {
		super();
		this.type = type;
		this.flags = flags;
		this.infixUpgrade = infixUpgrade;
		this.suffix = suffix;
		this.infusionUpgradeFlags = infusionUpgradeFlags;
	}

	public UpgradeComponentType getType() {
		return type;
	}

	public List<UpgradeComponentFlag> getFlags() {
		return flags;
	}

	public InfixUpgrade getInfixUpgrade() {
		return infixUpgrade;
	}

	public String getSuffix() {
		return suffix;
	}

	public Object getInfusionUpgradeFlags() {
		return infusionUpgradeFlags;
	}

	@Override
	public String toString() {
		return "UpgradeComponent [type=" + type + ", flags=" + flags + ", infixUpgrade=" + infixUpgrade + ", suffix=" + suffix + ", infusionUpgradeFlags=" + infusionUpgradeFlags + "]";
	}

}
