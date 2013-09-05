package fx.hq.ui.top;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

public class TopBar extends MenuBar {
	public TopBar() {
	}
	
	public TopBar(Menu... menus) {
		this.getMenus().addAll(menus);
	}
}
