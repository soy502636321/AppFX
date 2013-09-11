package fx.hq.ui.center;

import fx.hq.ui.entity.SmsEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class SendSmsTableView extends TableView<SmsEntity> {
	public SendSmsTableView() {
	}
	
	public SendSmsTableView(TableColumn<SmsEntity, String>... tableColumns) {
		this.getColumns().addAll(tableColumns);
		this.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	}
}
