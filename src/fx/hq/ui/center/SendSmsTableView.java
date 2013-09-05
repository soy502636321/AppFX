package fx.hq.ui.center;

import fx.hq.ui.entity.SmsEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class SendSmsTableView extends TableView<SmsEntity> {
	public SendSmsTableView() {
	}
	
	public SendSmsTableView(TableColumn... tableColumns) {
		this.getColumns().addAll(tableColumns);
		SmsEntity entity = new SmsEntity();
		entity.setMobilePhone("234324");
		ObservableList<SmsEntity> smsEntities = FXCollections.observableArrayList(entity);
		this.getItems().addAll(smsEntities);
		this.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	}
}
