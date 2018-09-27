package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ExpertAdviceController implements Initializable {

	@FXML
	private AnchorPane side_pane;
	
	
	@FXML
	private ImageView first;
	@FXML
	private ImageView second;
	
	@FXML
	private ImageView third;
	@FXML
	private ImageView fourth;
	
	
	
	
	
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/MainMenuList.fxml"));
		Pane cmdPane;
		try {
			cmdPane = (Pane) fxmlLoader.load();
			side_pane.getChildren().clear();
			side_pane.getChildren().add(cmdPane);

		} catch (Exception e) {
			e.printStackTrace();
		}

		// TODO Auto-generated method stub

	
	
	
	first.setOnMousePressed(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			Stage secondaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			try {
				Parent root = FXMLLoader.load(getClass().getResource("/application/StudyTips1.fxml"));
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

				secondaryStage.hide();
				secondaryStage.setScene(scene);
				secondaryStage.show();
				secondaryStage.setTitle("Study Tips");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	});
	first.setOnMouseEntered(new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent event) {
			// TODO Auto-generated method stub
			first.setFitWidth(235);
			first.setFitHeight(170);
		}

	});
	first.setOnMouseExited(new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent event) {
			// TODO Auto-generated method stub
			first.setFitWidth(223);
			first.setFitHeight(158);
		}

	});
	
	second.setOnMousePressed(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			Stage secondaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			try {
				Parent root = FXMLLoader.load(getClass().getResource("/application/StudyTips2.fxml"));
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

				secondaryStage.hide();
				secondaryStage.setScene(scene);
				secondaryStage.show();
				secondaryStage.setTitle("Study Tips");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	});
	second.setOnMouseEntered(new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent event) {
			// TODO Auto-generated method stub
			second.setFitWidth(235);
			second.setFitHeight(170);
		}

	});
	second.setOnMouseExited(new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent event) {
			// TODO Auto-generated method stub
			second.setFitWidth(223);
			second.setFitHeight(158);
		}

	});
	
	third.setOnMousePressed(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			Stage secondaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			try {
				Parent root = FXMLLoader.load(getClass().getResource("/application/StudyTips3.fxml"));
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
                secondaryStage.hide();
				secondaryStage.setScene(scene);
				secondaryStage.show();
				secondaryStage.setTitle("Study Tips");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	});
	third.setOnMouseEntered(new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent event) {
			// TODO Auto-generated method stub
			third.setFitWidth(235);
			third.setFitHeight(170);
		}

	});
	third.setOnMouseExited(new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent event) {
			// TODO Auto-generated method stub
			third.setFitWidth(223);
			third.setFitHeight(158);
		}

	});
	
	fourth.setOnMousePressed(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			Stage secondaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			try {
				Parent root = FXMLLoader.load(getClass().getResource("/application/StudyTips4.fxml"));
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
                secondaryStage.hide();
				secondaryStage.setScene(scene);
				secondaryStage.show();
				secondaryStage.setTitle("Study Tips");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	});
	fourth.setOnMouseEntered(new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent event) {
			// TODO Auto-generated method stub
			fourth.setFitWidth(235);
			fourth.setFitHeight(170);
		}

	});
	fourth.setOnMouseExited(new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent event) {
			// TODO Auto-generated method stub
			fourth.setFitWidth(223);
			fourth.setFitHeight(158);
		}

	});
	
	
	}

}
