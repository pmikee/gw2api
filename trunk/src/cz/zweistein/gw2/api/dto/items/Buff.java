package cz.zweistein.gw2.api.dto.items;

public class Buff {
	
	private String skill_id;
	
	private String description;

	public Buff(String skill_id, String description) {
		super();
		this.skill_id = skill_id;
		this.description = description;
	}

	public String getSkill_id() {
		return skill_id;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "Buff [skill_id=" + skill_id + ", description=" + description + "]";
	}

}
