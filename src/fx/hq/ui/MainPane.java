package fx.hq.ui;

import fx.hq.ui.top.TopBar;
import javafx.geometry.Insets;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class MainPane extends BorderPane {

	public MainPane() {

	}

	// 初始化组建
	private void init() {
//		MenuBar menuBar = new MenuBar(new Button("xx"));
//		Menu menu = new Menu("File");
//		MenuItem menuItem = new MenuItem("File_1");
//		menuItem.setOnAction(arg0)
//		menu.getItems().
//		menuBar.getMenus().add(menu);
//		this.setTop(menuBar);
//		
//		TitledPane t1 = new TitledPane("T1", new Button("B1"));
//		 TitledPane t2 = new TitledPane("T2", new Button("B2"));
//		 TitledPane t3 = new TitledPane("T3", new Button("B3"));
//
		TitledPane titledPane = new TitledPane();
//		 TitledPane gridTitlePane = new TitledPane();
//		 
//		 	TableView table = new TableView();
//	        table.setEditable(true);
//	        
//	        TableColumn firstNameCol = new TableColumn("First Name");
//	        TableColumn lastNameCol = new TableColumn("Last Name");
//	        TableColumn emailCol = new TableColumn("Email");
//	        
//	        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
//	        gridTitlePane.setContent(table);
//	     
		 Accordion accordion = new Accordion();
//		 accordion.getPanes().addAll(t1, t2, t3, gridTitlePane);
//		 setCenter(accordion);
	}

}
