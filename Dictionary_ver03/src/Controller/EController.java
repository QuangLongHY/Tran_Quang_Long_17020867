package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EController implements Initializable {
	Dictionary_Management dictman = new Dictionary_Management();
	 @FXML
	    private TextField Lword;

	    @FXML
	    private TextField Nword;
	    
	    @FXML
	    private Label alert;

	    @FXML
	    private Button Edit;

	    @FXML
	    void Eword(ActionEvent event) {
	    	String rs = dictman.search(Lword.getText());
	    	if (rs == null){
	    		alert.setText("Từ không tồn tại trong dữ liệu");
	    	}
	    	else {
	    		dictman.EditWord(Lword.getText(), Nword.getText());
	    		alert.setText("Sửa thành công ");
	    	}
	    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
