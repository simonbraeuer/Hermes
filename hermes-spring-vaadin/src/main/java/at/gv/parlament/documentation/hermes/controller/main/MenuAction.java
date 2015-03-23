package at.gv.parlament.documentation.hermes.controller.main;

public class MenuAction {
	public static final MenuAction LOGOUT = new MenuAction("LOGOUT");
	public static final MenuAction SEARCH = new MenuAction("SEARCH");
	public static final MenuAction RECORD = new MenuAction("RECORD");
	public static final MenuAction UPLOADVIDEO = new MenuAction("UPLOADVIDEO");
	private String action;
	
	public MenuAction(String action) {
		this.action = action;
	}
	
}