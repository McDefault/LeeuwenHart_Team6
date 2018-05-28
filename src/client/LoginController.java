package client;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.*;


public class LoginController {
	
	 @FXML
	 private TextField serverIp;
	 @FXML
	 private AnchorPane login;
	 @FXML
	 private TextField username;
	 @FXML
	 private Button connect;
	
	
    @FXML
    public void handleLogin(ActionEvent event) {
    	System.out.println(serverIp.getText());
    	System.out.println(username.getText());
    	System.out.println("Getting access to the registry");
    	this.login.setScaleX(100);
    	
    	
    }
    
    /*public String getUserName() {
    	String username = this.username.toString();
    	return username;
    }*/

}