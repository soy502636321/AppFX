package fx.hq.ui.top.menu;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class VarargsMenu extends Menu {
	public VarargsMenu() {
	}
	
	public VarargsMenu(MenuItem... menuItems) {
		this.getItems().addAll(menuItems);
	}
}
