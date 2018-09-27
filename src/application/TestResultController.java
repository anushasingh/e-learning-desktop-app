package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TestResultController  implements Initializable {

	
	

	@FXML
	private Label marksobtained;

	@FXML
	private Label maxmarks;

	@FXML
	private Label timetaken;
	@FXML
	private AnchorPane side_pane;
	
	
	private ObservableValue<String> marksString;

	@FXML
	private Button evaluation;
	
	@FXML
	private ImageView anothertest;
	@FXML
	private ImageView evaluate;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/MainMenuList.fxml"));
		Pane cmdPane;
		try {
			cmdPane = (Pane) fxmlLoader.load();
			side_pane.getChildren().clear();
			side_pane.getChildren().add(cmdPane);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		marksobtained.setText(String.valueOf(UniversalSetting.marks));
		maxmarks.setText(String.valueOf(UniversalSetting.total));
		timetaken.setText(String.valueOf(UniversalSetting.timetaken));
		timetaken.setWrapText(true);
		
		evaluate.setOnMousePressed(new EventHandler<MouseEvent>()
		{
		
			
			@Override
		    public void handle(MouseEvent event)
			{
				Stage secondaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				try {
					Parent root =FXMLLoader.load(getClass().getResource("/application/Test.fxml"));
					Scene scene = new Scene(root);
					scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

					secondaryStage.hide();
					secondaryStage.setScene(scene);
					secondaryStage.show();
					secondaryStage.setTitle("Tests");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

		});
		
		
		
		
		anothertest.setOnMousePressed(new EventHandler<MouseEvent>()
		{
		
			
			@Override
		    public void handle(MouseEvent event)
			{
				Stage secondaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				try {
					Parent root =FXMLLoader.load(getClass().getResource("/application/TestBranch.fxml"));
					Scene scene = new Scene(root);
					scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

					secondaryStage.hide();
					secondaryStage.setScene(scene);
					secondaryStage.show();
					secondaryStage.setTitle("Tests");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

		});
		
		
		
		
		
		
		
		
		
		
		
		
		}







	
	
	
	
	
	
}
