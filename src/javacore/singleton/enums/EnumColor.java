package javacore.singleton.enums;

public enum EnumColor {
	
	Red("r"),White("w"),Purple("p"),Black("b");
	private String shortName;
	private EnumColor(String shortName) {
		this.shortName = shortName;
	}
}
