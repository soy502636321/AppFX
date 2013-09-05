package fx.hq.main;

import fx.hq.ui.MainPane;
import fx.hq.ui.MainScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ApplicationFX extends Application {
	private static Scene scene;
	private static double width;
	private static double height;
	private static String title = "默认的标题";
	private static BorderPane pane = new MainPane();

	@Override
	public void start(Stage stage) throws Exception {
		setScene(new MainScene(getPane(), getWidth(), getHeight()));
		stage.setScene(getScene());
		stage.setTitle(getTitle());
		stage.show();
		
	}
	
	public void launch() {
		this.launch(new String[0]);
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		ApplicationFX.scene = scene;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		ApplicationFX.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		ApplicationFX.height = height;
	}

	public BorderPane getPane() {
		return pane;
	}

	public void setPane(BorderPane pane) {
		this.pane = pane;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		ApplicationFX.title = title;
	}
	
	

}
