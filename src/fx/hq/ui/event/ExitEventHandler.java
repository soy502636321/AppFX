package fx.hq.ui.event;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ExitEventHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent actionEvent) {
		Stage stage = new Stage();
		stage.setScene(new Scene(
				new Group(new Text(10, 10, "my second window"))));
		stage.show();
		// Platform.exit();
	}

}
