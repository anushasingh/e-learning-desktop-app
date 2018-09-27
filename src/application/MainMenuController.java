package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import javafx.scene.layout.AnchorPane;

import javafx.stage.Stage;
import javafx.util.Duration;

public class MainMenuController implements Initializable {
	@FXML
	private AnchorPane content;
	@FXML
	private ImageView tests;
	@FXML
	private ImageView logo;
	@FXML
	private ImageView courses;
	@FXML
	private ImageView aboutus;
	@FXML
	private ImageView profile;
	@FXML
	private ImageView expertadvice;

	@FXML
	private ImageView cyan;

	final DoubleProperty zoomProperty = new SimpleDoubleProperty(200);

	@Override
	public void initialize(URL Location, ResourceBundle Resource) {

		tests.setOnMousePressed(new EventHandler<MouseEvent>()
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
		tests.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				tests.setFitWidth(285);
				tests.setFitHeight(265);
			}

		});
		tests.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				tests.setFitWidth(278);
				tests.setFitHeight(256);
			}

		});
		courses.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Stage secondaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				try {
					Parent root = FXMLLoader.load(getClass().getResource("/application/Courses.fxml"));
					Scene scene = new Scene(root);
					scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

					secondaryStage.hide();
					secondaryStage.setScene(scene);
					secondaryStage.show();
					secondaryStage.setTitle("Courses");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		courses.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				courses.setFitWidth(230);
				courses.setFitHeight(475);
			}

		});
		courses.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				courses.setFitWidth(222);
				courses.setFitHeight(469);
			}

		});

		aboutus.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Stage secondaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				try {
					Parent root = FXMLLoader.load(getClass().getResource("/application/AboutUs.fxml"));
					Scene scene = new Scene(root);
					
					secondaryStage.hide();
					secondaryStage.setScene(scene);
					secondaryStage.show();
					secondaryStage.setTitle("About Us");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		aboutus.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				aboutus.setFitWidth(360);
				aboutus.setFitHeight(205);
			}

		});
		aboutus.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				aboutus.setFitWidth(351);
				aboutus.setFitHeight(199);
			}

		});

		profile.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Stage secondaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				try {
					Parent root = FXMLLoader.load(getClass().getResource("/application/MyProfile.fxml"));
					Scene scene = new Scene(root);
					scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

					secondaryStage.hide();
					secondaryStage.setScene(scene);
					secondaryStage.show();
					secondaryStage.setTitle("My Profile");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		profile.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				profile.setFitWidth(320);
				profile.setFitHeight(285);
			}

		});
		profile.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				profile.setFitWidth(311);
				profile.setFitHeight(275);
			}

		});

		expertadvice.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Stage secondaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				try {
					Parent root = FXMLLoader.load(getClass().getResource("/application/ExpertAdvice.fxml"));
					Scene scene = new Scene(root);
					scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

					secondaryStage.hide();
					secondaryStage.setScene(scene);
					secondaryStage.show();
					secondaryStage.setTitle("Expert Advice");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		expertadvice.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				expertadvice.setFitWidth(265);
				expertadvice.setFitHeight(345);
			}

		});
		expertadvice.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				expertadvice.setFitWidth(258);
				expertadvice.setFitHeight(336);
			}

		});

		RotateTransition rotation = new RotateTransition(Duration.seconds(6), cyan);
		rotation.setCycleCount(Animation.INDEFINITE);
		rotation.setByAngle(360);
        rotation.play();
		
		
		

	}
}
