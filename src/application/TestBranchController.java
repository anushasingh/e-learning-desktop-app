package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TestBranchController extends Application implements Initializable {

	@FXML
	private Button cse;

	@FXML
	private Button electrical;

	@FXML
	private Button electronic;
	
	@FXML
	private AnchorPane side_pane ;
	

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
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
		
		
		
		
		
		
		
		
		
		
		
		
		cse.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				UniversalSetting.branch_test = "CSETests";

				Stage secondaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				try {

				    
					Parent root = FXMLLoader.load(getClass().getResource("/application/TestTopic.fxml"));
					Scene scene = new Scene(root);
					
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
		
		

		
		
		
		
		

		electrical.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				UniversalSetting.branch_test = "ElectricalTests";

				Stage secondaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				try {

					System.out.println("vfvfdb");
					Parent root = FXMLLoader.load(getClass().getResource("/application/TestTopic.fxml"));
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

		electronic.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				UniversalSetting.branch_test = "ElectronicTests";

				Stage secondaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				try {

					System.out.println("vfvfdb");
					Parent root = FXMLLoader.load(getClass().getResource("/application/TestTopic.fxml"));
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
