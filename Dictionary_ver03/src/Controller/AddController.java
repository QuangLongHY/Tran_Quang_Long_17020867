package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Model.Word;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddController implements Initializable{
	Dictionary_Management dictman = new Dictionary_Management();
	
    @FXML
    private Button add;

    @FXML
    private TextField newword;

    @FXML
    private TextField newmean;
    
    @FXML
    private Label alert;

    @FXML
    void addword(ActionEvent event) {
    	String rs = dictman.search(newword.getText());
    	if (rs != null) {
    		alert.setText("Từ đã tồn tại");
    	}else {
    		dictman.AddWord(new Word(newword.getText(), newmean.getText()));
    		alert.setText("Thêm Thành Công ");
    	}

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {	
	
	}

}
