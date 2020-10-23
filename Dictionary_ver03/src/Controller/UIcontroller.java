package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import org.controlsfx.control.textfield.TextFields;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;


public class UIcontroller implements Initializable {
	ObservableList<String> list = FXCollections.observableArrayList();
	Dictionary_Management dictman = new Dictionary_Management();
	String[] answ = dictman.getWordAnswer();
	
    @FXML
    private Button Del;

    @FXML
    private Button Edit;
	
    @FXML
    private Button sound;
    
    @FXML
    private Button add;

    @FXML
    private WebView mean;
    
    WebEngine webEngine = null;
    
    @FXML
    private TextField showword;

    @FXML
    private ListView<String> listword;

    @FXML
    private Button trans;
    
    @FXML
    void addWord(ActionEvent event) {	
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/Add.fxml"));
			Parent root1;
			root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root1));  
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
    }

    @FXML
    void DelWord(ActionEvent event) {
    	try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/Delete.fxml"));
			Parent root2;
			root2 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root2));  
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
    }

    @FXML
    void editword(ActionEvent event) {
    	try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/edit.fxml"));
			Parent root3;
			root3 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root3));  
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
    }
    
    @FXML
    void play(ActionEvent event) {
    	Voice voice;
    	VoiceManager vm = VoiceManager.getInstance();
    	voice = vm.getVoice("kevin16");
    	voice.allocate();
    	voice.speak(showword.getText());
    }
    
    @FXML
    void translate(ActionEvent event) {
    	String rs = dictman.search(showword.getText());
    	if (rs == null) rs = "Từ không tồn tại";
    	WebEngine webEngine = mean.getEngine();
    	webEngine.loadContent(rs,"text/html");	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {	
		loadData();	
		TextFields.bindAutoCompletion(showword, answ);	
		WebEngine webEngine = mean.getEngine();
	}
	private void loadData() {
		List<String> dict = new ArrayList<String>();
		dict = dictman.getWord();
		list.removeAll(list);
		for (String i: dict) {
			list.add(i);
		}
		listword.getItems().addAll(list);
		
		SelectionModel<String> SelectionModel = listword.getSelectionModel();
		
		SelectionModel.selectedItemProperty().addListener(new ChangeListener<String>(){
            
            public void changed(ObservableValue<? extends String> changed, String oldValue, String newValue){
                 
                showword.setText(newValue);
            }
        });
	}

}
