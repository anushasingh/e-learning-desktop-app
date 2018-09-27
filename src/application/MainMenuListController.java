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

import javafx.scene.control.Label;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import javafx.stage.Stage;

public class MainMenuListController implements Initializable {
	@FXML
	private AnchorPane side_pane;
	@FXML
	private ImageView tests;
	@FXML
	private ImageView courses;
	@FXML
	private ImageView aboutus;
	@FXML
	private ImageView profile;
	@FXML
	private ImageView expertadvice;

	@FXML
	private Label Tests;
	@FXML
	private Label Courses;
	@FXML
	private Label Aboutus;
	@FXML
	private Label Profile;
	@FXML
	private Label Expertadvice;

	@Override
	public void initialize(URL Location, ResourceBundle Resource) {

		tests.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Stage secondaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				try {
					Parent root = FXMLLoader.load(getClass().getResource("/application/TestBranch.fxml"));
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

		Tests.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Stage secondaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				try {
					Parent root = FXMLLoader.load(getClass().getResource("/application/TestBranch.fxml"));
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
		Tests.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				Tests.setPrefWidth(120);
				Tests.setPrefHeight(35);
			}

		});
		Tests.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				Tests.setPrefWidth(110);
				Tests.setPrefHeight(28);
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
		Courses.setOnMousePressed(new EventHandler<MouseEvent>() {
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
		Courses.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				Courses.setPrefWidth(120);
				Courses.setPrefHeight(35);
			}

		});
		Courses.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				Courses.setPrefWidth(110);
				Courses.setPrefHeight(26);
			}

		});

		aboutus.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Stage secondaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				try {
					Parent root = FXMLLoader.load(getClass().getResource("/application/AboutUs.fxml"));
					Scene scene = new Scene(root);
					scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

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
		Aboutus.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Stage secondaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				try {
					Parent root = FXMLLoader.load(getClass().getResource("/application/AboutUs.fxml"));
					Scene scene = new Scene(root);
					scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

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
		Aboutus.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				Aboutus.setPrefWidth(129);
				Aboutus.setPrefHeight(32);
			}

		});
		Aboutus.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				Aboutus.setPrefWidth(110);
				Aboutus.setPrefHeight(17);
			}

		});

		

		Profile.setOnMousePressed(new EventHandler<MouseEvent>() {
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

		Profile.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				Profile.setPrefWidth(140);
				Profile.setPrefHeight(30);
			}

		});
		Profile.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				Profile.setPrefWidth(127);
				Profile.setPrefHeight(17);
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

		Expertadvice.setOnMousePressed(new EventHandler<MouseEvent>() {
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
		Expertadvice.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				Expertadvice.setPrefWidth(145);
				Expertadvice.setPrefHeight(35);
			}

		});
		Expertadvice.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				Expertadvice.setPrefWidth(136);
				Expertadvice.setPrefHeight(21);
			}

		});
	}
}
