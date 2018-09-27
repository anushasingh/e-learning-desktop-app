package application;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.sql.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ResourceBundle;

import org.controlsfx.control.decoration.Decorator;
import org.controlsfx.control.decoration.StyleClassDecoration;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;


public class LoginController implements Initializable
{
	@FXML
	private TextField user;
	@FXML
	private PasswordField pass;
	@FXML
	private  Label res;
	@FXML
	private AnchorPane content;
	@FXML
	private AnchorPane side_pane;

	@FXML
	private Button login;

	@FXML
	private MediaView mv;
	private MediaPlayer mp;
	private Media me;


	@FXML
	public void signup(ActionEvent event) throws IOException
	{
		Stage secondaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

		signupcall(secondaryStage);
	 }

	public void maincall(Stage secondaryStage) throws IOException
	{
		Parent root =FXMLLoader.load(getClass().getResource("/application/MainMenu.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		secondaryStage.hide();
		secondaryStage.setScene(scene);
		secondaryStage.show();
		secondaryStage.setTitle("MainMenu");


	}

	public void signupcall(Stage secondaryStage) throws IOException
	{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/SignUp.fxml"));
		Pane cmdPane = (Pane) fxmlLoader.load();

		try
		{
			side_pane.getChildren().clear();
			side_pane.getChildren().add(cmdPane);

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}



	@FXML
	public  void logintestM (ActionEvent event) throws IOException, SQLException
	{
		if(check_empty())
		{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("WARNING");
			alert.setHeaderText(null);
			alert.setContentText("Required fields cannot be left blank!");
			alert.showAndWait();
		}
		else

			UniversalSetting.user= user.getText();
			UniversalSetting.pass= pass.getText();
				PreparedStatement preparedStatement=null;
				ResultSet resultSet=null;
				String query="select * from MyProfile where UserName=? and Passward=?";
				Connection connection;
				connection=DriverManager.getConnection("jdbc:sqlite:data/"+UniversalSetting.user+".db");
				try{
				preparedStatement=connection.prepareStatement(query);
				preparedStatement.setString(1, UniversalSetting.user);
				preparedStatement.setString(2, UniversalSetting.pass);
				resultSet=preparedStatement.executeQuery();
				while(resultSet.next()){
					String username=resultSet.getString("UserName");
					String passward=resultSet.getString("Passward");

					if(username.equals(UniversalSetting.user) && passward.equals(UniversalSetting.pass))
					{
						Stage secondaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
						maincall(secondaryStage);
						preparedStatement.close();
						resultSet.close();
						connection.close();
					}



					}}
					catch (Exception e) {
						res.setText("Enter valid username and password.");


						}}

	@FXML
	public  void logintestk (KeyEvent event) throws IOException, SQLException
	{
          if(event.getCode()==KeyCode.ENTER)
          {
			UniversalSetting.user= user.getText();
			UniversalSetting.pass= pass.getText();


				PreparedStatement preparedStatement=null;
				ResultSet resultSet=null;
				String query="select * from MyProfile where UserName=? and Passward=?";
				Connection connection;
				connection=DriverManager.getConnection("jdbc:sqlite:data/"+UniversalSetting.user+".db");
				try{
				preparedStatement=connection.prepareStatement(query);
				preparedStatement.setString(1, UniversalSetting.user);
				preparedStatement.setString(2, UniversalSetting.pass);
				resultSet=preparedStatement.executeQuery();
				while(resultSet.next()){
					String username=resultSet.getString("UserName");
					String passward=resultSet.getString("Passward");

					if(username.equals(UniversalSetting.user) && passward.equals(UniversalSetting.pass))
					{
						Stage secondaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
						maincall(secondaryStage);
						preparedStatement.close();
						resultSet.close();
						connection.close();
					}

				else
					{
					res.setText("Enter valid username and password.");
					}}}
					catch (Exception e) {
						e.printStackTrace();// TODO: handle exception

						}}
	}



	private boolean check_empty() {
		if(user.getText().trim().isEmpty() || pass.getText().trim().isEmpty())
		{
			if(user.getText().trim().isEmpty())
				Decorator.addDecoration(user, new StyleClassDecoration("isempty"));
			else
				Decorator.removeAllDecorations(user);
			if(pass.getText().trim().isEmpty())
				Decorator.addDecoration(pass, new StyleClassDecoration("isempty"));
			else
				Decorator.removeAllDecorations(pass);
		return true;
		}
			else
		// TODO Auto-generated method stub
		return false;

	}




	@FXML
	void focus(KeyEvent event)
	{
		if(event.getCode()==KeyCode.DOWN)
		{
			if(user.isFocused())
			{
				pass.requestFocus();

			}

		}
		if(event.getCode()==KeyCode.UP)
		{
			if(pass.isFocused())
			{
				user.requestFocus();
			}
		}
	}



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		
		

			  if (Desktop.isDesktopSupported()) {
			        
				  
				  
				  String inputPdf = "Videos/getstarted.MP4";
			        InputStream manualAsStream = getClass().getClassLoader().getResourceAsStream(inputPdf);

			        Path tempOutput = null;
					try {
						tempOutput = Files.createTempFile("TempManual", ".MP4");
					
			        tempOutput.toFile().deleteOnExit();

			      
						Files.copy(manualAsStream, tempOutput, StandardCopyOption.REPLACE_EXISTING);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

			        File userManual = new File (tempOutput.toFile().getPath());
			        String  path =userManual.getAbsolutePath();
			        
			        if (userManual.exists())
			        {
			            me = new Media(new File(path).toURI().toString());

						mp = new MediaPlayer((me));
						mv.setMediaPlayer(mp);
						mp.setAutoPlay(true);

						mp.setMute(true);
						mp.setCycleCount(javafx.scene.media.MediaPlayer.INDEFINITE);
						mp.play();
			        }
				  
				  
				  
				  
				  
				  
				  
			      /*  File file = new File("getstarted.MP4");
			        try {OutputStream outputStream = new FileOutputStream(file);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			       // if(file.exists()){
			         //InputStream inputStream = ClassLoader.getSystemClassLoader()
			             //                 .getResourceAsStream("Videos/getstarted.MP4");
			          
			           
			          //  inputStream.close();
			         //   }
			        
			    	String path = file.getAbsolutePath();*/

					
			      
			    }
			
		

		if (UniversalSetting.login == 1) {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/MainMenu.fxml"));
			Pane cmdPane;
			try {
				cmdPane = (Pane) fxmlLoader.load();
				content.getChildren().clear();
				content.getChildren().add(cmdPane);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			/* NEED TO DECLARE ANCHOR PANE" */
		}
	}
	
	public static String convertStreamToString(InputStream is) throws Exception {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	    StringBuilder sb = new StringBuilder();
	    String line = null;
	    while ((line = reader.readLine()) != null) {
	      sb.append(line + "\n");
	    }
	    is.close();
	    return sb.toString();
	  }
	
	
	
	
	
	
	

}
