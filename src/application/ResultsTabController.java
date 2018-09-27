package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class ResultsTabController implements Initializable{



	Statement ps = null;
	ResultSet rs = null;

	final ObservableList<data> p = FXCollections.observableArrayList();


	@FXML
	private TableView<data> resulttable;
	@FXML
	private TableColumn<data, String> testname;
	@FXML
	private TableColumn<data, Integer> max_marks;
	@FXML
	private TableColumn<data, Integer> obt_marks;
	@FXML
	private TableColumn<data, Float> timetaken;
	@FXML
	private TableColumn<data, Integer> attempt;
	@FXML
	private TableColumn<data, String> testbranch;
	@FXML
	private TableColumn<data, String> datetime;
	@FXML
	private AnchorPane side_pane;


	@Override
	public void initialize(URL location, ResourceBundle resources) {

		testname.setCellValueFactory(new PropertyValueFactory<data,String>("Test_Name"));
		max_marks.setCellValueFactory(new PropertyValueFactory<data,Integer>("Max_Marks"));
		obt_marks.setCellValueFactory(new PropertyValueFactory<data,Integer>("Obt_Marks"));
		timetaken.setCellValueFactory(new PropertyValueFactory<data,Float>("Time_Taken"));
		//percentage.setCellValueFactory(new PropertyValueFactory<data,Double>("percentage_obtained"));
		attempt.setCellValueFactory(new PropertyValueFactory<data,Integer>("Attempt_no"));
		testbranch.setCellValueFactory(new PropertyValueFactory<data,String>("Test_Branch"));
		datetime.setCellValueFactory(new PropertyValueFactory<data,String>("Date_Time"));
		loadtable();


		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/MainMenuList.fxml"));
		Pane cmdPane;
		try {
			cmdPane = (Pane) fxmlLoader.load();
			side_pane.getChildren().clear();
			side_pane.getChildren().add(cmdPane);

		} catch (Exception e) {
			e.printStackTrace();
		}


}
public void loadtable()
{
	String sql = "select * from MyTest";

	try
	{	//Connection connection;
	Connection connection = DriverManager.getConnection("jdbc:sqlite:data/" + UniversalSetting.user + ".db");
		//connection = SqliteConnection.connectDb();
		ps = connection.createStatement();
		rs = ps.executeQuery(sql);
		while (rs.next())
		{
					p.add(new data(
							rs.getString("Test_Name"),
							rs.getInt("Max_Marks"),
							rs.getInt("Obt_Marks"),
							rs.getDouble("percentage_obtained"),
							rs.getFloat("Time_Taken"),
							rs.getInt("Attempt_no"),
							rs.getString("Test_Branch"),
							rs.getString("Date_Time")
						));

			resulttable.setItems(p);
		}
		connection.close();


	}
	catch (Exception e)
	{
			e.printStackTrace();
	}
}
}
