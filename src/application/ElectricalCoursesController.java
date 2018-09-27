package application;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
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

public class ElectricalCoursesController extends Application implements Initializable {

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
	public void initialize(URL arg0, ResourceBundle arg1) {

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

				 String inputPdf = "PDFs/Control Systems Engineering. By I.J. Nagrath.pdf";
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
				btn1.setStyle("-fx-background-color:#2979FF;");
				btn1.setOpacity(0.7);

			}
		});
		btn1.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent t) {
				btn1.setStyle("-fx-background-color:#4DD0E1 ;");
				btn1.setOpacity(0.84);

			}
		});

		btn2.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				 String inputPdf = "PDFs/Electric Power Generation.pdf";
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
				btn2.setStyle("-fx-background-color:#2979FF;");
				btn2.setOpacity(0.7);

			}
		});
		btn2.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent t) {
				btn2.setStyle("-fx-background-color:#4DD0E1 ;");
				btn2.setOpacity(0.84);

			}
		});

		btn3.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				 String inputPdf = "PDFs/Fundamentals_of_Electric_Power_Systems.pdf";
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
				btn3.setStyle("-fx-background-color:#2979FF;");
				btn3.setOpacity(0.7);

			}
		});
		btn3.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent t) {
				btn3.setStyle("-fx-background-color:#4DD0E1 ;");
				btn3.setOpacity(0.84);

			}
		});


		btn4.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				 String inputPdf = "PDFs/concepts-in-electric-circuits.pdf";
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
				btn4.setStyle("-fx-background-color:#2979FF;");
				btn4.setOpacity(0.7);

			}
		});
		btn4.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent t) {
				btn4.setStyle("-fx-background-color:#4DD0E1 ;");
				btn4.setOpacity(0.84);

			}
		});

		btn5.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				 String inputPdf = "PDFs/electrical machine.pdf";
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
				btn5.setStyle("-fx-background-color:#2979FF;");
				btn5.setOpacity(0.7);

			}
		});
		btn5.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent t) {
				btn5.setStyle("-fx-background-color:#4DD0E1 ;");
				btn5.setOpacity(0.84);

			}
		});

		btn6.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				String inputPdf = "PDFs/EMFT_Book.pdf";
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
				btn6.setStyle("-fx-background-color:#2979FF;");
				btn6.setOpacity(0.7);

			}
		});
		btn6.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent t) {
				btn6.setStyle("-fx-background-color:#4DD0E1 ;");
				btn6.setOpacity(0.84);

			}
		});

		btn7.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				String inputPdf = "PDFs/Microprocessor-7-19-2011.pdf";
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
				btn7.setStyle("-fx-background-color:#2979FF;");
				btn7.setOpacity(0.7);

			}
		});
		btn7.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent t) {
				btn7.setStyle("-fx-background-color:#4DD0E1 ;");
				btn7.setOpacity(0.84);

			}
		});

	}


	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub

	}
}
