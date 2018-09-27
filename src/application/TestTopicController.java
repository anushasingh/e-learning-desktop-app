package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TestTopicController implements Initializable {
	@FXML
	private Label selectedtopic;

	@FXML
	private AnchorPane side_pane;
	@FXML
	private Button start;
	@FXML
	private ListView<String> topic;
	public static final ObservableList<String> data = FXCollections.observableArrayList();
	public static final ObservableList<String> data1 = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/MainMenuList.fxml"));
		Pane cmdPane;
		try {
			cmdPane = (Pane) fxmlLoader.load();
			side_pane.getChildren().clear();
			side_pane.getChildren().add(cmdPane);
			side_pane.setDisable(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			Connection connection;
			connection = SqliteConnection.Connector();
			data.clear();
			topic.setItems(data);
			
			
			
			
			String query = "select distinct topic from " +UniversalSetting.branch_test;
			
			
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				data.add(resultSet.getString("topic"));
				topic.setItems(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void select(MouseEvent event) {
		ObservableList<String> data1;
		data1 = topic.getSelectionModel().getSelectedItems();
		selectedtopic.setText(data1.get(0));
	}

	public void start(ActionEvent event) {
		UniversalSetting.topic_name = selectedtopic.getText();
		UniversalSetting.login = 1;
		UniversalSetting.submit=0;
		

		
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
}
