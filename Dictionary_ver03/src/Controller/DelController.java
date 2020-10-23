package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DelController implements Initializable {
	Dictionary_Management dictman = new Dictionary_Management();
    @FXML
    private TextField wdel;

    @FXML
    private Label alert;

    @FXML
    private Button del;

    @FXML
    void delword(ActionEvent event) {
    	String rs = dictman.search(wdel.getText());
    	if (rs == null){
    		alert.setText("Từ không tồn tại trong dữ liệu");
    	}
    	else {
    		dictman.DelWord(wdel.getText());
    		alert.setText("Xóa thành công ");
    	}

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

}
