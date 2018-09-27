package application;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

public class CseCoursesController extends Application implements Initializable {

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
				String inputPdf = "PDFs/Teach Yourself SQL.pdf";
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
				btn1.setStyle("-fx-background-color:#C5CAE9;");
				btn1.setOpacity(0.7);

				btn1.setMinWidth(294);
				btn1.setMinHeight(69);

			}
		});
		btn1.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent t) {
				btn1.setStyle("-fx-background-color:#BBDEFB ;");
				btn1.setOpacity(0.84);
				btn1.setMinWidth(293);
				btn1.setMinHeight(68);

			}
		});



		btn2.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				String inputPdf = "PDFs/ObjectOrientedProgramminginC++.pdf";
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
				btn2.setStyle("-fx-background-color:#C5CAE9;");
				btn2.setOpacity(0.7);
				btn2.setMinWidth(294);
				btn2.setMinHeight(69);

			}
		});
		btn2.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent t) {
				btn2.setStyle("-fx-background-color:#BBDEFB ;");
				btn2.setMinWidth(293);
				btn2.setMinHeight(68);
				btn2.setOpacity(0.84);
			}
		});



		btn3.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				String inputPdf = "PDFs/LinuxProgramming.pdf";
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
				btn3.setStyle("-fx-background-color:#C5CAE9;");
				btn3.setOpacity(0.7);
				btn3.setMinWidth(294);
				btn3.setMinHeight(69);

			}
		});
		btn3.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent t) {
				btn3.setStyle("-fx-background-color:#BBDEFB ;");
				btn3.setMinWidth(293);
				btn3.setMinHeight(68);

				btn3.setOpacity(0.84);
			}
		});



		btn4.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				String inputPdf = "PDFs/A Complete Guide to Programming in C++.pdf";
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
				btn4.setStyle("-fx-background-color:#C5CAE9;");
				btn4.setOpacity(0.7);
				btn4.setMinWidth(294);
				btn4.setMinHeight(69);

			}
		});
		btn4.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent t) {
				btn4.setStyle("-fx-background-color:#BBDEFB ;");
				btn4.setMinWidth(293);
				btn4.setMinHeight(68);

				btn4.setOpacity(0.84);
			}
		});



		btn5.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
			String inputPdf = "PDFs/Computer architecture.pdf";
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
				btn5.setStyle("-fx-background-color:#C5CAE9;");
				btn5.setOpacity(0.7);
				btn5.setMinWidth(294);
				btn5.setMinHeight(69);

			}
		});
		btn5.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent t) {
				btn5.setStyle("-fx-background-color:#BBDEFB ;");
				btn5.setMinWidth(293);
				btn5.setMinHeight(68);

				btn5.setOpacity(0.84);
			}
		});



		btn6.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
			String inputPdf = "PDFs/data_structures_algorithms_tutorial.pdf";
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
				btn6.setStyle("-fx-background-color:#C5CAE9;");
				btn6.setOpacity(0.7);
				btn6.setMinWidth(294);
				btn6.setMinHeight(69);

			}
		});
		btn6.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent t) {
				btn6.setStyle("-fx-background-color:#BBDEFB ;");
				btn6.setMinWidth(293);
				btn6.setMinHeight(68);

				btn6.setOpacity(0.84);
			}
		});



		btn7.setOnMousePressed(new EventHandler<MouseEvent>() {
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

		btn7.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent t) {
				btn7.setStyle("-fx-background-color:#C5CAE9;");
				btn7.setOpacity(0.7);
				btn7.setMinWidth(294);
				btn7.setMinHeight(69);

			}
		});
		btn7.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent t) {
				btn7.setStyle("-fx-background-color:#BBDEFB ;");
				btn7.setMinWidth(293);
				btn7.setMinHeight(68);

				btn7.setOpacity(0.84);
			}
		});



		btn8.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				String inputPdf = "PDFs/computer_graphics_tutorial.pdf";
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

		btn8.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent t) {
				btn8.setStyle("-fx-background-color:#C5CAE9;");
				btn8.setOpacity(0.7);
				btn8.setMinWidth(294);
				btn8.setMinHeight(69);

			}
		});
		btn8.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent t) {
				btn8.setStyle("-fx-background-color:#BBDEFB ;");
				btn8.setMinWidth(293);
				btn8.setMinHeight(68);

				btn8.setOpacity(0.84);
			}
		});



		btn9.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				String inputPdf = "PDFs/LinuxFundamentals.pdf";
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

		btn9.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent t) {
				btn9.setStyle("-fx-background-color:#C5CAE9;");
				btn9.setOpacity(0.7);
				btn9.setMinWidth(294);
				btn9.setMinHeight(69);

			}
		});
		btn9.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent t) {
				btn9.setStyle("-fx-background-color:#BBDEFB ;");
				btn9.setMinWidth(293);
				btn9.setMinHeight(68);

				btn9.setOpacity(0.84);
			}
		});

	}


	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

	}

}
