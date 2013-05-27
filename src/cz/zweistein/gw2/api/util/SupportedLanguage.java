package cz.zweistein.gw2.api.util;

public enum SupportedLanguage {

	ENGLISH("en"), DEUTCH("de"), FRENCH("fr"), SPANNISH("es");

	private final String code;

	private SupportedLanguage(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

}
