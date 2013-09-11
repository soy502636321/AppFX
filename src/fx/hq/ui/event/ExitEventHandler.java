package fx.hq.ui.event;

import java.util.Date;
import java.util.List;

import fx.hq.sms.SmsSender;
import fx.hq.spring.BeanFactory;
import fx.hq.ui.center.SendSmsTableView;
import fx.hq.ui.entity.SmsEntity;
import fx.hq.ui.entity.SmsLogEntity;
import fx.hq.ui.entity.dao.SmsEntityDAO;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ExitEventHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent actionEvent) {
		// Stage stage = new Stage();
		// stage.setScene(new Scene(
		// new Group(new Text(10, 10, "my second window"))));
		// stage.show();

//		TextArea textArea = BeanFactory.getTextArea();
//		String string = textArea.getText();
//
//		SmsSender scSmsSender = (SmsSender) BeanFactory.getApplicationContext()
//				.getBean("scSmsSender");
//		SmsSender rlSmsSender = (SmsSender) BeanFactory.getApplicationContext()
//				.getBean("rlSmsSender");
//		SmsSender jhSmsSender = (SmsSender) BeanFactory.getApplicationContext()
//				.getBean("jhSmsSender");
//		scSmsSender.disConnect();
//		rlSmsSender.disConnect();
//		jhSmsSender.disConnect();
//		BeanFactory.shutDown();
//		Platform.exit();
		
		SmsEntity entity = new SmsEntity();
		entity.setTaskId("852");
		entity.setContent("ÄÚÈÝ");
		entity.setMobilePhone("852369");
		BeanFactory.getSmsLogEntityDAO().save(entity, 2);
	}
}
