package fx.hq.ui.center;

import fx.hq.ui.entity.RecvSms;
import fx.hq.ui.entity.SmsEntity;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ReceiveSmsTableView extends TableView<RecvSms> {
	public ReceiveSmsTableView() {
		// TODO Auto-generated constructor stub
	}
	
	public ReceiveSmsTableView(TableColumn<RecvSms, String>... tableColumns) {
		this.getColumns().addAll(tableColumns);
		this.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	}
}
