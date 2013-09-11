package fx.hq.main;

import org.springframework.context.annotation.Bean;

import fx.hq.sms.SmsSender;
import fx.hq.spring.BeanFactory;
import fx.hq.ui.MainPane;
import fx.hq.ui.MainScene;
import fx.hq.ui.entity.dao.SmsEntityDAO;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ApplicationFX extends Application {
	private static Scene scene;
	private static double width;
	private static double height;
	private static String title = "默认的标题";
	private static BorderPane pane = new MainPane();
	private static SmsEntityDAO smsEntityDAO;

	@Override
	public void start(Stage stage) throws Exception {
		setScene(new MainScene(getPane(), getWidth(), getHeight()));
		stage.setScene(getScene());
		stage.setTitle(getTitle());
		stage.getIcons().add(new Image("2013090601414683_easyicon_net_24.png"));
		// 窗口关闭事件，当关闭程序的之后停止发送、接收短信任务
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent windowEvent) {
				SmsSender scSmsSender = (SmsSender) BeanFactory
						.getApplicationContext().getBean("scSmsSender");
				SmsSender rlSmsSender = (SmsSender) BeanFactory
						.getApplicationContext().getBean("rlSmsSender");
				SmsSender jhSmsSender = (SmsSender) BeanFactory
						.getApplicationContext().getBean("jhSmsSender");
				scSmsSender.disConnect();
				rlSmsSender.disConnect();
				jhSmsSender.disConnect();
				BeanFactory.shutDown();
			}
		});
		// 程序开始时间，初始化发送对象
		stage.setOnShown(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent windowEvent) {
				SmsSender scSmsSender = (SmsSender) BeanFactory
						.getApplicationContext().getBean("scSmsSender");
				SmsSender rlSmsSender = (SmsSender) BeanFactory
						.getApplicationContext().getBean("rlSmsSender");
				SmsSender jhSmsSender = (SmsSender) BeanFactory
						.getApplicationContext().getBean("jhSmsSender");
				scSmsSender.connect();
				rlSmsSender.connect();
				jhSmsSender.connect();
			}
		});
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

	public SmsEntityDAO getSmsEntityDAO() {
		return smsEntityDAO;
	}

	public void setSmsEntityDAO(SmsEntityDAO smsEntityDAO) {
		ApplicationFX.smsEntityDAO = smsEntityDAO;
	}

}
