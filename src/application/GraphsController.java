package application;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;

import javafx.scene.chart.XYChart;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class GraphsController extends Application implements Initializable {
	int i = 0;
	@FXML
	private BarChart<String, Double> barchart1;

	@FXML
	private BarChart<String, Double> barchart2;
	@FXML

	private PieChart piechart;

	@FXML

	private Button marks;

	@FXML

	private Button time;

	@FXML

	private ChoiceBox<String> branch;

	@FXML

	private CategoryAxis xAxis;

	@FXML

	private NumberAxis yAxis;
	@FXML
	public Label alert;
	
	@FXML
	public Label label;

	@FXML
	public Label ylabel;
	@FXML
	public Label xlabel;
	@FXML
	private ImageView speed;

	@FXML
	private ImageView accuracy;
	@FXML
	private AnchorPane side_pane;
	@FXML

	private ChoiceBox<String> testtopic;
	public static final ObservableList<String> data = FXCollections.observableArrayList();
	public String selectedbranch;
	public String selectedtopic;
	XYChart.Series<String, Double> series = new XYChart.Series<>();

	public String yaxislabel = "Marks Scored";

	public String xaxislabel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
        alert.setVisible(false);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/MainMenuList.fxml"));
		Pane cmdPane;
		try {
			cmdPane = (Pane) fxmlLoader.load();
			side_pane.getChildren().clear();
			side_pane.getChildren().add(cmdPane);

		} catch (Exception e) {
			e.printStackTrace();
		}

		label.setVisible(false);
		branch.setItems(FXCollections.observableArrayList("Computer Science", "Electrical Engineering",
				"Electronic Engineering"));

		branch.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> selected, String oldbranch, String newbranch) {

				if (newbranch != null) {
					switch (newbranch) {
					case "Computer Science":
						loadtopicsfrom("CSETests");
						break;
					case "Electrical Engineering":
						loadtopicsfrom("ElectricalTests");
						break;
					case "Electronic Engineering":
						loadtopicsfrom("ElectronicTests");
						break;
					}
				}
			}
		});

		testtopic.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> selected, String oldtopic, String newtopic) {

				if (newtopic != null) {
                     
					settopic(newtopic);

				}
				else
				{
					settopic(null);
					
				}
			}

		});

		speed.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {

				yaxislabel = "Time Taken (minutes)";

				yAxis.setAutoRanging(true);

				if (selectedtopic == null && selectedbranch == null)

				{
					alert.setVisible(true);
					String msg = "Select your branch and Test topic";
					alert.setText(msg);
					//JOptionPane.showMessageDialog(null, msg);
				}

				if (selectedtopic == null && selectedbranch != null) {
					alert.setVisible(true);
					String msg = "Select Test topic";
					alert.setText(msg);
					//JOptionPane.showMessageDialog(null, msg);
				}
				if (selectedtopic.equals("All Topics"))

				{
					alert.setVisible(false);
					label.setVisible(true);
					String query1 = ("select Test_Name, max(Time_Taken)  from MyTest where Test_Branch ='"
							+ selectedbranch + "'  group by Test_Name ");

					xaxislabel = "Test Topic";

					bargraphload(query1, xaxislabel, yaxislabel);

				} else {
					alert.setVisible(false);
					label.setVisible(false);
					String query2 = ("select Date_Time,Time_Taken  from MyTest where Test_Name='" + selectedtopic
							+ "' and Test_Branch='" + selectedbranch + "' ");
					xaxislabel = "Date and Time";

					bargraphload(query2, xaxislabel, yaxislabel);
				}
			}

		});

		accuracy.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {

				yaxislabel = "Percentage Scored";
                System.out.println(selectedtopic);
				if (selectedtopic == null && selectedbranch == null)

				{

					alert.setVisible(true);
					String msg = "Select your branch and Test topic";
					alert.setText(msg);
					//JOptionPane.showMessageDialog(null, msg);
				}

				if (selectedtopic == null && selectedbranch != null) {
					alert.setVisible(true);
					String msg = "Select Test topic";
					alert.setText(msg);
					//JOptionPane.showMessageDialog(null, msg);
				}

				Platform.runLater(new Runnable() {
					@Override
					public void run() {

						yAxis.setAutoRanging(false);
						yAxis.setLowerBound(0);
						yAxis.setUpperBound(100);
						yAxis.setTickUnit(10);

					}
				});

				if (selectedtopic.equals("All Topics"))

				{
					alert.setVisible(false);
					yAxis.setAutoRanging(false);
					yAxis.setLowerBound(0);
					yAxis.setUpperBound(100);
					yAxis.setTickUnit(10);


					String query1 = ("select Test_Name, max(percentage_obtained)  from MyTest where Test_Branch ='"
							+ selectedbranch + "'  group by Test_Name ");

					xaxislabel = "Test Topic";

					bargraphload(query1, xaxislabel, yaxislabel);

				} else {
					alert.setVisible(false);
					yAxis.setAutoRanging(false);
					yAxis.setLowerBound(0);
					yAxis.setUpperBound(100);
					yAxis.setTickUnit(10);

					label.setVisible(false);

					String query2 = ("select Date_Time,percentage_obtained  from MyTest where Test_Name='"
							+ selectedtopic + "' and Test_Branch='" + selectedbranch + "' ");

					xaxislabel = "Date and Time";
					bargraphload(query2, xaxislabel, yaxislabel);

				}

			}

		});

		speed.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				speed.setFitWidth(40);
				speed.setFitHeight(46);
			}

		});
		speed.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				speed.setFitWidth(36);
				speed.setFitHeight(42);
			}

		});

		accuracy.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				accuracy.setFitWidth(40);
				accuracy.setFitHeight(46);
			}

		});
		accuracy.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				accuracy.setFitWidth(36);
				accuracy.setFitHeight(42);
			}

		});

	}

	public void bargraphload(String query, String xaxis, String yaxis) {

		try {

			i = 0;
			barchart1.getData().clear();
			barchart1.layout();
			barchart1.setLegendVisible(false);
			barchart1.setAnimated(false);
			Connection connection = DriverManager.getConnection("jdbc:sqlite:data/" + UniversalSetting.user + ".db");

			PreparedStatement ps = connection.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			XYChart.Series<String, Double> series = new XYChart.Series<>();
			while (rs.next()) {
				i++;

				String name = rs.getString(1);
				Double no = rs.getDouble(2);

				series.getData().add(new XYChart.Data<>(name, no));

			}

			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					if (i == 1) {

						barchart1.setCategoryGap(600);

					}

					else if (i == 2) {

						barchart1.setCategoryGap(280);
					}

					else if (i == 3) {

						barchart1.setCategoryGap(150);
					} else if (i == 4) {

						barchart1.setCategoryGap(100);
					}

					else if (i == 5) {

						barchart1.setCategoryGap(90);
					}

					else {

						barchart1.setCategoryGap(20);
					}

					barchart1.getData().add(series);
					for (Node n : barchart1.lookupAll(".default-color0.chart-bar")) {
						n.setStyle("-fx-bar-fill:#EF5350;");
					}

				}
			});

			barchart1.getXAxis().setVisible(false);
			ylabel.setText(yaxis);
			ylabel.setRotate(270);
			xlabel.setText(xaxis);

			ps.close();
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void settopic(String x) {

		selectedtopic = x;

	}

	public void loadtopicsfrom(String x) {
		selectedbranch = x;

		if (selectedbranch != null) {
			try {
				PreparedStatement preparedStatement = null;
				ResultSet resultSet = null;
				Connection connection;
				connection = SqliteConnection.Connector();
				data.clear();
				data.add("All Topics");
				testtopic.setItems(data);

				String query = "select distinct topic from " + selectedbranch;

				preparedStatement = connection.prepareStatement(query);
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					data.add(resultSet.getString("topic"));
					testtopic.setItems(data);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub

	}

}
