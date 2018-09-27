package application;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import javafx.stage.Stage;

public class ElectronicCoursesController extends Application implements Initializable {

	@FXML
	private AnchorPane side_pane;
	@FXML
	private Button btn1;
	@FXML
	private Button btn2;
	@FXML
	private Button btn3;
	@FXML
	private Button btn4;
	@FXML
	private Button btn5;
	@FXML
	private Button btn6;
	@FXML
	private Button btn7;
	@FXML
	private Button btn8;
	@FXML
	private Button btn9;
	@FXML
	private Button btn10;
	@FXML
	private Button btn11;
	@FXML
	private Button btn12;
	@FXML
	private Button btn13;
	@FXML
	private Button btn14;

	@Override
	public void initialize(URL Location, ResourceBundle Resource) {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/MainMenuList.fxml"));
		Pane cmdPane;
		try {
			cmdPane = (Pane) fxmlLoader.load();
			side_pane.getChildren().clear();
			side_pane.getChildren().add(cmdPane);

		} catch (Exception e) {
			e.printStackTrace();
		}

		btn1.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				String inputPdf = "PDFs/An Introduction to Microprocessors 8085.pdf";
		        InputStream manualAsStream = getClass().getClassLoader().getResourceAsStream(inputPdf);
		        Path tempOutput = null;
				try {
					tempOutput = Files.createTempFile("TempManual", ".pdf");
		        tempOutput.toFile().deleteOnExit();
					Files.copy(manualAsStream, tempOutput, StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		        File userManual = new File (tempOutput.toFile().getPath());
		        if (userManual.exists())
		        {
		            try {
						Desktop.getDesktop().open(userManual);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
			}
		});

		btn1.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent t) {
				btn1.setStyle("-fx-background-color:#3E2723;");
				btn1.setOpacity(0.7);

			}
		});
		btn1.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent t) {
				btn1.setStyle("-fx-background-color:#8a603c ;");
				btn1.setOpacity(1);
			}
		});



		btn2.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				String inputPdf = "PDFs/A VHDL Primer - Jayaram Bhasker.pdf";
		        InputStream manualAsStream = getClass().getClassLoader().getResourceAsStream(inputPdf);
		        Path tempOutput = null;
				try {
					tempOutput = Files.createTempFile("TempManual", ".pdf");
		        tempOutput.toFile().deleteOnExit();
					Files.copy(manualAsStream, tempOutput, StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		        File userManual = new File (tempOutput.toFile().getPath());
		        if (userManual.exists())
		        {
		            try {
						Desktop.getDesktop().open(userManual);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
			}
		});

		btn2.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent t) {
				btn2.setStyle("-fx-background-color:#3E2723;");
				btn2.setOpacity(0.7);

			}
		});
		btn2.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent t) {
				btn2.setStyle("-fx-background-color:#8a603c ;");
				btn2.setOpacity(1);
			}
		});



		btn3.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				String inputPdf = "PDFs/Embedded Systems Design with 8051 Microcontrollers.pdf";
		        InputStream manualAsStream = getClass().getClassLoader().getResourceAsStream(inputPdf);
		        Path tempOutput = null;
				try {
					tempOutput = Files.createTempFile("TempManual", ".pdf");
		        tempOutput.toFile().deleteOnExit();
					Files.copy(manualAsStream, tempOutput, StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		        File userManual = new File (tempOutput.toFile().getPath());
		        if (userManual.exists())
		        {
		            try {
						Desktop.getDesktop().open(userManual);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
			}
		});

		btn3.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent t) {
				btn3.setStyle("-fx-background-color:#3E2723;");
				btn3.setOpacity(0.7);

			}
		});
		btn3.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent t) {
				btn3.setStyle("-fx-background-color:#8a603c ;");
				btn3.setOpacity(1);
			}
		});



		btn4.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				String inputPdf = "PDFs/dbms_tutorial.pdf";
		        InputStream manualAsStream = getClass().getClassLoader().getResourceAsStream(inputPdf);
		        Path tempOutput = null;
				try {
					tempOutput = Files.createTempFile("TempManual", ".pdf");
		        tempOutput.toFile().deleteOnExit();
					Files.copy(manualAsStream, tempOutput, StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		        File userManual = new File (tempOutput.toFile().getPath());
		        if (userManual.exists())
		        {
		            try {
						Desktop.getDesktop().open(userManual);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
			}
		});

		btn4.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent t) {
				btn4.setStyle("-fx-background-color:#3E2723;");
				btn4.setOpacity(0.7);

			}
		});
		btn4.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent t) {
				btn4.setStyle("-fx-background-color:#8a603c ;");
				btn4.setOpacity(1);
			}
		});


		btn5.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				String inputPdf = "PDFs/Verilog HDL - A Guide to Digital Design and Synthesis.pdf";
		        InputStream manualAsStream = getClass().getClassLoader().getResourceAsStream(inputPdf);
		        Path tempOutput = null;
				try {
					tempOutput = Files.createTempFile("TempManual", ".pdf");
		        tempOutput.toFile().deleteOnExit();
					Files.copy(manualAsStream, tempOutput, StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		        File userManual = new File (tempOutput.toFile().getPath());
		        if (userManual.exists())
		        {
		            try {
						Desktop.getDesktop().open(userManual);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
			}
		});

		btn5.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent t) {
				btn5.setStyle("-fx-background-color:#3E2723;");
				btn5.setOpacity(0.7);

			}
		});
		btn5.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent t) {
				btn5.setStyle("-fx-background-color:#8a603c ;");
				btn5.setOpacity(1);
			}
		});


		btn6.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				String inputPdf = "PDFs/Electromagnetic concepts.pdf";
		        InputStream manualAsStream = getClass().getClassLoader().getResourceAsStream(inputPdf);
		        Path tempOutput = null;
				try {
					tempOutput = Files.createTempFile("TempManual", ".pdf");
		        tempOutput.toFile().deleteOnExit();
					Files.copy(manualAsStream, tempOutput, StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		        File userManual = new File (tempOutput.toFile().getPath());
		        if (userManual.exists())
		        {
		            try {
						Desktop.getDesktop().open(userManual);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
			}
		});

		btn6.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent t) {
				btn6.setStyle("-fx-background-color:#3E2723;");
				btn6.setOpacity(0.7);

			}
		});
		btn6.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent t) {
				btn6.setStyle("-fx-background-color:#8a603c ;");
				btn6.setOpacity(1);
			}
		});
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

	}

}
