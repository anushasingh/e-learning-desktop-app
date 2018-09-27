package application;

import javafx.animation.AnimationTimer;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Date;
import java.util.ResourceBundle;



public class TestController implements Initializable {
	static BooleanProperty running = new SimpleBooleanProperty(false);

	public TestModel testModel = new TestModel();
	@FXML
	private Label quesNo;
	@FXML
	private TextArea question;
	@FXML
	private RadioButton aoption;
	@FXML
	private RadioButton boption;
	@FXML
	private RadioButton coption;
	@FXML
	private RadioButton doption;
	@FXML
	private Button next;
	@FXML
	private Button prev;
	@FXML
	private Button submit;
	@FXML
	private ImageView aimage;
	@FXML
	private ImageView bimage;
	@FXML
	private ImageView cimage;
	@FXML
	private ImageView dimage;
	@FXML
	private Button done;
	@FXML
	private AnchorPane side_pane;
	@FXML

	private Label label;

	@FXML

	private Label q;

	@FXML

	private Label no;

	@FXML

	private Label label2;

	@FXML
	private Button back;

	@FXML
	private ListView<String> qstatus;
	public static ObservableList<String> data = FXCollections.observableArrayList();

	public float MinutesTaken;
	@FXML
	public void nextQues(ActionEvent event) throws IOException {

		prev.setDisable(false);
		String answer = "-";
		if (aoption.isSelected()) {
			answer = "a";
		}
		if (boption.isSelected()) {
			answer = "b";
		}
		if (coption.isSelected()) {
			answer = "c";
		}
		if (doption.isSelected()) {
			answer = "d";
		}
		aoption.setSelected(false);
		boption.setSelected(false);
		coption.setSelected(false);
		doption.setSelected(false);
		String quesNumber = quesNo.getText();
		String q = quesNumber + " : " + answer;
		int nextq = (Integer.parseInt(quesNumber)) - 1;
		data = (qstatus.getItems());
		// int w=data.size();
		// int ei=Integer.parseInt(quesNumber);
		data.set(nextq, q);
		int questionn1 = (Integer.parseInt(quesNumber));
		String d = qstatus.getItems().get(questionn1);
		String d1 = d.substring(4);
		if (d1.equals("a")) {
			aoption.setSelected(true);
		}
		if (d1.equals("b")) {
			boption.setSelected(true);
		}
		if (d1.equals("c")) {
			coption.setSelected(true);
		}
		if (d1.equals("d")) {
			doption.setSelected(true);
		}

		qstatus.getItems().removeAll();
		qstatus.setItems(data);

		String topic1 = UniversalSetting.topic_name;
		int questionn = (Integer.parseInt(quesNumber)) + 1;
		int h = Integer.parseInt(UniversalSetting.ques);

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = "select * from " + UniversalSetting.branch_test + " where topic=?";

		try {
			Connection connection;
			connection = SqliteConnection.Connector();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, topic1);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				if (resultSet.getRow() == questionn) {
					question.setText(resultSet.getString("question"));
					aoption.setText(resultSet.getString("a"));
					boption.setText(resultSet.getString("b"));
					coption.setText(resultSet.getString("c"));
					doption.setText(resultSet.getString("d"));
					quesNo.setText(String.valueOf(questionn));
					break;
				}
			}
			if (questionn > (resultSet.getRow())) {
				next.setDisable(true);
			}

		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		if (questionn == h) {
			next.setDisable(true);
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		label2.setVisible(false);
		label2.setWrapText(true);

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
		String topic1 = UniversalSetting.topic_name;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = "select * from " + UniversalSetting.branch_test + " where topic=?";

		if (UniversalSetting.submit != 1)

		{

			back.setVisible(false);
			data.clear();
			qstatus.setItems(data);
			qstatus.getItems().removeAll();

			timer.start();

		}

		/*
		 * if(UniversalSetting.submit!=1) {
		 */
		prev.setDisable(true);
		try {
			Connection connection;
			connection = SqliteConnection.Connector();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, topic1);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				quesNo.setText(String.valueOf(resultSet.getRow()));
				question.setText(resultSet.getString("question"));
				aoption.setText(resultSet.getString("a"));
				boption.setText(resultSet.getString("b"));
				coption.setText(resultSet.getString("c"));
				doption.setText(resultSet.getString("d"));

				if (UniversalSetting.submit != 1) {
					data.add("1 : -");
				}
				int i = 0;

				if (UniversalSetting.submit != 1) {

					while (resultSet.next()) {
						i = resultSet.getRow();
						data.add(String.valueOf(i) + " : -");
					}
				}
				qstatus.setItems(data);

				UniversalSetting.ques = String.valueOf(i);
			} else {
				// isConnected.setText("No questions on this topic.");
			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}

		if (UniversalSetting.submit == 1) {
			question.setVisible(false);
			aoption.setVisible(false);
			boption.setVisible(false);
			coption.setVisible(false);
			doption.setVisible(false);
			back.setVisible(true);
			label2.setVisible(true);
			submit.setVisible(false);
			prev.setVisible(false);
			next.setVisible(false);
			q.setVisible(false);
			no.setVisible(false);
			quesNo.setVisible(false);

		}

		back.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Stage secondaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				try {
					Parent root = FXMLLoader.load(getClass().getResource("/application/TestResult.fxml"));
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

	}

	/*
	 * else{
	 * 
	 * question.setVisible(false); aoption.setVisible(false);
	 * boption.setVisible(false); coption.setVisible(false);
	 * doption.setVisible(false);
	 * 
	 * }
	 */

	@FXML
	public void prevQues(ActionEvent event) throws IOException {
		next.setDisable(false);
		String quesNumber = quesNo.getText();
		String answer = "-";
		if (aoption.isSelected()) {
			answer = "a";
		}
		if (boption.isSelected()) {
			answer = "b";
		}
		if (coption.isSelected()) {
			answer = "c";
		}
		if (doption.isSelected()) {
			answer = "d";
		}
		String q = quesNumber + " : " + answer;
		int prevq = (Integer.parseInt(quesNumber)) - 1;
		data = (qstatus.getItems());
		int w = data.size();
		int ei = Integer.parseInt(quesNumber);
		if (w >= ei) {
			data.set(prevq, q);
		} else {
			data.add(q);
		}
		qstatus.getItems().removeAll();
		qstatus.setItems(data);
		aoption.setSelected(false);
		boption.setSelected(false);
		coption.setSelected(false);
		doption.setSelected(false);
		int questionn = (Integer.parseInt(quesNumber)) - 1;
		int questionn1 = (Integer.parseInt(quesNumber)) - 2;
		String d = qstatus.getItems().get(questionn1);
		String d1 = d.substring(4);
		if (d1.equals("a")) {
			aoption.setSelected(true);
		}
		if (d1.equals("b")) {
			boption.setSelected(true);
		}
		if (d1.equals("c")) {
			coption.setSelected(true);
		}
		if (d1.equals("d")) {
			doption.setSelected(true);
		}
		String topic1 = UniversalSetting.topic_name;

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = "select * from " + UniversalSetting.branch_test + " where topic=?";

		try {
			Connection connection;
			connection = SqliteConnection.Connector();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, topic1);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				if (resultSet.getRow() == questionn) {
					question.setText(resultSet.getString("question"));
					aoption.setText(resultSet.getString("a"));
					boption.setText(resultSet.getString("b"));
					coption.setText(resultSet.getString("c"));
					doption.setText(resultSet.getString("d"));
					quesNo.setText(String.valueOf(questionn));
					break;
				}

			}
			if (questionn == 1) {
				prev.setDisable(true);
			}

		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
	}

	public void submitTest(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {

		String quesNumber = quesNo.getText();
		String answer = "-";
		if (aoption.isSelected()) {
			answer = "a";
		}
		if (boption.isSelected()) {
			answer = "b";
		}
		if (coption.isSelected()) {
			answer = "c";
		}
		if (doption.isSelected()) {
			answer = "d";
		}
		String q = quesNumber + " : " + answer;
		int nextq = (Integer.parseInt(quesNumber)) - 1;
		data = (qstatus.getItems());
		data.set(nextq, q);

		qstatus.getItems().removeAll();

		qstatus.setItems(data);
		UniversalSetting.marks = 0;
		UniversalSetting.total = 0;
		try {
			String topic1 = UniversalSetting.topic_name;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			String query = "select * from " + UniversalSetting.branch_test + " where topic=?";

			Connection connection;
			connection = SqliteConnection.Connector();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, topic1);
			resultSet = preparedStatement.executeQuery();
			data = (qstatus.getItems());

			while (resultSet.next()) {
				int f = (resultSet.getRow()) - 1;
				String r = data.get(f);
				String d1 = r.substring(4);
				String ans = resultSet.getString("correctans");
				if (ans.equals(d1)) {
					UniversalSetting.marks = UniversalSetting.marks + 1;
					UniversalSetting.total = UniversalSetting.total + 1;

				} else {
					UniversalSetting.total = UniversalSetting.total + 1;
				}

			}

			
			
			
			
			
			
			
			
			 resultSet.close(); preparedStatement.close(); connection.close();
			 

		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}

		float percentage_obtained = (((float) UniversalSetting.marks / (float) UniversalSetting.total) * 100);
		
		Class.forName("org.sqlite.JDBC");
		Connection connection = DriverManager.getConnection("jdbc:sqlite:data/" + UniversalSetting.user + ".db");
		UniversalSetting.timetaken = label.getText();

		String sql1 = "CREATE TABLE IF NOT EXISTS MyTest(Test_Name varchar(100) ,Max_Marks INTEGER(100), Obt_Marks INTEGER(100),percentage_obtained DOUBLE(100),Time_Taken FLOAT(50),Attempt_no INTEGER(10),Test_Branch varchar(100),Date_Time varchar(100))";

		Statement ps = connection.createStatement();
		ps.executeUpdate(sql1);
		
		
		Connection connection3 = DriverManager.getConnection("jdbc:sqlite:data/" + UniversalSetting.user + ".db");

		PreparedStatement ps6 = connection3.prepareStatement("SELECT COUNT(*) FROM MyTest WHERE Test_Name = '" +UniversalSetting.topic_name+"'");
		
		ResultSet rs3 = ps6.executeQuery();
		int i=0;
	
		i=rs3.getInt(1);
		i++;
	
		rs3.close();
		connection3.close();
		
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date date = new Date();
		String dateandtime=dateFormat.format(date);

		System.out.println(dateandtime);
		
	
		
	
		
		Connection connection5 = DriverManager.getConnection("jdbc:sqlite:data/" + UniversalSetting.user + ".db");
		
		
		
		String sql2 = "INSERT INTO MyTest " + "VALUES ('" + UniversalSetting.topic_name + "','" + UniversalSetting.total
				+ "','" + UniversalSetting.marks + "','" + percentage_obtained + "','" + MinutesTaken
				+ "','"+i+"','"+UniversalSetting.branch_test+"','"+dateandtime+"')";

		Statement ps2 = connection5.createStatement();
		ps2.executeUpdate(sql2);
		
	
		UniversalSetting.submit = 1;

		Stage secondaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/application/TestResult.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			secondaryStage.hide();
			secondaryStage.setScene(scene);
			secondaryStage.show();
			secondaryStage.setTitle("Test Result");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * String msg = "You have scored " + String.valueOf(marks) + "/" +
		 * String.valueOf(total) + "."; JOptionPane.showMessageDialog(null,
		 * msg); UniversalSetting.submit = 1; prev.setVisible(false);
		 * next.setVisible(false); submit.setVisible(false);
		 * done.setVisible(true);
		 */
	}

	@FXML
	public void done(ActionEvent event) {

		Stage secondaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		secondaryStage.hide();

	}

	public void select(MouseEvent event) {

		quesNo.setVisible(true);
		label2.setVisible(false);
		q.setVisible(true);
		no.setVisible(true);
		question.setVisible(true);
		aoption.setVisible(true);
		boption.setVisible(true);
		coption.setVisible(true);
		doption.setVisible(true);

		aoption.setSelected(false);
		boption.setSelected(false);
		coption.setSelected(false);
		doption.setSelected(false);
		String f = "";
		// Image img=new Image("Images/Tick.jpeg");
		// hi.setImage(img);
		// Image img1=new Image("Images/Cross.jpeg");
		if (UniversalSetting.submit == 1) {

			ObservableList<String> data1;

			data1 = qstatus.getSelectionModel().getSelectedItems();
			String a = data1.get(0);
			String q = a.substring(0, 1);
			String d1 = a.substring(4);

			if (d1.equals("a")) {
				aoption.setSelected(true);
			}
			if (d1.equals("b")) {
				boption.setSelected(true);
			}
			if (d1.equals("c")) {
				coption.setSelected(true);
			}
			if (d1.equals("d")) {
				doption.setSelected(true);
			}
			String topic1 = UniversalSetting.topic_name;
			PreparedStatement preparedStatement1 = null;
			ResultSet resultSet1 = null;
			String query1 = "select * from " + UniversalSetting.branch_test + " where topic=?";

			try {
				Connection connection1;
				connection1 = SqliteConnection.Connector();
				preparedStatement1 = connection1.prepareStatement(query1);
				preparedStatement1.setString(1, topic1);
				resultSet1 = preparedStatement1.executeQuery();

				while (resultSet1.next()) {
					if (resultSet1.getRow() == (Integer.parseInt(q))) {
						question.setText(resultSet1.getString("question"));
						aoption.setText(resultSet1.getString("a"));
						boption.setText(resultSet1.getString("b"));
						coption.setText(resultSet1.getString("c"));
						doption.setText(resultSet1.getString("d"));
						quesNo.setText(String.valueOf(q));
						f = resultSet1.getString("correctans");
						break;
					}

				}
			} catch (Exception e) {
				e.printStackTrace();// TODO: handle exception
			}
			aoption.setDisable(true);
			boption.setDisable(true);
			coption.setDisable(true);
			doption.setDisable(true);
			aimage.setImage(null);
			bimage.setImage(null);
			cimage.setImage(null);
			dimage.setImage(null);
			if (f.equals(d1)) {
				if (f.equals("a")) {
					Image img = new Image("Images/Tick.jpeg");
					aimage.setImage(img);
				}
				if (f.equals("b")) {
					Image img = new Image("Images/Tick.jpeg");
					bimage.setImage(img);
				}
				if (f.equals("c")) {
					Image img = new Image("Images/Tick.jpeg");
					cimage.setImage(img);
				}
				if (f.equals("d")) {
					Image img = new Image("Images/Tick.jpeg");
					dimage.setImage(img);
				}
			} else {
				if (f.equals("a")) {
					Image img = new Image("Images/Tick.jpeg");
					aimage.setImage(img);
				}
				if (f.equals("b")) {
					Image img = new Image("Images/Tick.jpeg");
					bimage.setImage(img);
				}
				if (f.equals("c")) {
					Image img = new Image("Images/Tick.jpeg");
					cimage.setImage(img);
				}
				if (f.equals("d")) {
					Image img = new Image("Images/Tick.jpeg");
					dimage.setImage(img);
				}
				if (d1.equals("a")) {
					Image img1 = new Image("Images/Cross.png");
					System.out.println("ji");
					aimage.setImage(img1);
				}
				if (d1.equals("b")) {
					Image img1 = new Image("Images/Cross.png");
					bimage.setImage(img1);
				}
				if (d1.equals("c")) {
					Image img1 = new Image("Images/Cross.png");
					cimage.setImage(img1);
				}
				if (d1.equals("d")) {
					Image img1 = new Image("Images/Cross.png");
					dimage.setImage(img1);
				}
			}

			/*
			 * if(f.equals(d1)){ if(f.equals("a")) { aimage.setImage(img); }
			 * if(f.equals("b")) { bimage.setImage(img); } if(f.equals("c")) {
			 * cimage.setImage(img); } if(f.equals("d")) { dimage.setImage(img);
			 * } } else{ if(f.equals("a")) { aimage.setImage(img); }
			 * if(f.equals("b")) { bimage.setImage(img); } if(f.equals("c")) {
			 * cimage.setImage(img); } if(f.equals("d")) { dimage.setImage(img);
			 * } if(d1.equals("a")) { aimage.setImage(img1); }
			 * if(d1.equals("b")) { bimage.setImage(img1); } if(d1.equals("c"))
			 * { cimage.setImage(img1); } if(d1.equals("d")) {
			 * dimage.setImage(img1); } }
			 */
		} else {
			ObservableList<String> data1;
			data1 = qstatus.getSelectionModel().getSelectedItems();
			String a = data1.get(0);
			String q = a.substring(0, 1);
			if (q.equals(UniversalSetting.ques)) {
				next.setDisable(true);
			} else {
				next.setDisable(false);
				prev.setDisable(false);
			}
			if (q.equals("1")) {
				prev.setDisable(true);
			}
			String d1 = a.substring(4);

			if (d1.equals("a")) {
				aoption.setSelected(true);
			}
			if (d1.equals("b")) {
				boption.setSelected(true);
			}
			if (d1.equals("c")) {
				coption.setSelected(true);
			}
			if (d1.equals("d")) {
				doption.setSelected(true);
			}
			String topic1 = UniversalSetting.topic_name;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			String query = "select * from " + UniversalSetting.branch_test + " where topic=?";

			try {
				Connection connection;
				connection = SqliteConnection.Connector();
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, topic1);
				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					if (resultSet.getRow() == (Integer.parseInt(q))) {
						question.setText(resultSet.getString("question"));
						aoption.setText(resultSet.getString("a"));
						boption.setText(resultSet.getString("b"));
						coption.setText(resultSet.getString("c"));
						doption.setText(resultSet.getString("d"));
						quesNo.setText(String.valueOf(q));

						break;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();// TODO: handle exception
			}

		}
	}

	public void images(String f, String d1) {
		Image img = new Image("Images/Tick.jpeg");
		Image img1 = new Image("/StopHub/src/application/Cross.jpeg");
		aimage.setImage(img);
		bimage.setImage(img1);
		/*
		 * if(f.equals(d1)){ if(f.equals("a")) { aimage.setImage(img); }
		 * if(f.equals("b")) { bimage.setImage(img); } if(f.equals("c")) {
		 * cimage.setImage(img); } if(f.equals("d")) { dimage.setImage(img); } }
		 * else{ if(f.equals("a")) { aimage.setImage(img); } if(f.equals("b")) {
		 * bimage.setImage(img); } if(f.equals("c")) { cimage.setImage(img); }
		 * if(f.equals("d")) { dimage.setImage(img); } if(d1.equals("a")) {
		 * aimage.setImage(img1); } if(d1.equals("b")) { bimage.setImage(img1);
		 * } if(d1.equals("c")) { cimage.setImage(img1); } if(d1.equals("d")) {
		 * dimage.setImage(img1); } }
		 */
	}

	AnimationTimer timer = new AnimationTimer() {

		private LocalTime startTime;

		@Override
		public void handle(long now) {
			long elapsedSeconds = Duration.between(startTime, LocalTime.now()).getSeconds();
			 long minutes = elapsedSeconds / 60;
			long seconds = elapsedSeconds % 60;
			
			MinutesTaken=(float)elapsedSeconds / 60;
			label.setText(+minutes + " mins " + seconds + " sec");

			label.setWrapText(true);
		}

		@Override
		public void start() {
			running.set(true);
			startTime = LocalTime.now();
			super.start();
		}

		@Override
		public void stop() {
			running.set(false);
			super.stop();
		}
	};

}
