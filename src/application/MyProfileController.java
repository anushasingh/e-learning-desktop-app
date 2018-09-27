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

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.Pane;

import javafx.stage.Stage;

public class MyProfileController extends Application implements Initializable {

	
	@FXML
	private ImageView graphs;
	
	
	@FXML
	private ImageView results;
	
	@FXML
	private AnchorPane side_pane;

	@FXML
	private Label name;

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
		
		name.setText(UniversalSetting.user);
		
		//name.setMaxWidth(Double.MAX_VALUE);
		//AnchorPane.setLeftAnchor(name, 0.0);
		//AnchorPane.setRightAnchor(name, 0.0);
		//name.setAlignment(Pos.CENTER);
		
		graphs.setOnMousePressed(new EventHandler<MouseEvent>()
		{
			@Override
		    public void handle(MouseEvent event)
			{
				Stage secondaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				try {
					Parent root =FXMLLoader.load(getClass().getResource("/application/Graphs.fxml"));
					Scene scene = new Scene(root);
					scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

					secondaryStage.hide();
					secondaryStage.setScene(scene);
					secondaryStage.show();
					secondaryStage.setTitle("Graphs");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

		});
		
		
		
		
		
		
		
		
		
		
		
		
		graphs.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				graphs.setFitWidth(164);
				graphs.setFitHeight(133);
			}

		});
		graphs.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				graphs.setFitWidth(158);
				graphs.setFitHeight(127);
			}

		});

		

		results.setOnMousePressed(new EventHandler<MouseEvent>()
		{
			@Override
		    public void handle(MouseEvent event)
			{
				Stage secondaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				try {
					Parent root =FXMLLoader.load(getClass().getResource("/application/ResultTab.fxml"));
					Scene scene = new Scene(root);
					scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

					secondaryStage.hide();
					secondaryStage.setScene(scene);
					secondaryStage.show();
					secondaryStage.setTitle("Result");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

		});
		
		results.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				results.setFitWidth(164);
				results.setFitHeight(133);
			}

		});
		results.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				results.setFitWidth(158);
				results.setFitHeight(127);
			}

		});

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	

	
	
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub

	}

}
