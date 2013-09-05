package fx.hq.ui.center;

import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;

public class VarargsAccordion extends Accordion {
	public VarargsAccordion() {
	}
	
	public VarargsAccordion(TitledPane... titledPanes) {
		this.getPanes().addAll(titledPanes);
	}
}
