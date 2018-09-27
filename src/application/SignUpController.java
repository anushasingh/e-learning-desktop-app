package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.controlsfx.control.decoration.Decorator;
import org.controlsfx.control.decoration.StyleClassDecoration;

import javafx.event.ActionEvent;
import java.sql.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class SignUpController implements Initializable
{
	@FXML
	private TextField user;
	@FXML
	private PasswordField pass;
	@FXML
	private  Label res;
	@FXML
	private AnchorPane side_pane;

	@FXML
	private Button signup;
	@FXML
	private Button back;

	@FXML
	public void signUp(ActionEvent event) throws IOException, ClassNotFoundException, SQLException
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
		{
				UniversalSetting.user=user.getText().replaceAll("[^A-Za-z0-9_]", "_");
				UniversalSetting.pass=pass.getText().replaceAll("[^A-Za-z0-9_]", "_");

				Class.forName("org.sqlite.JDBC");
				Connection connection=DriverManager.getConnection("jdbc:sqlite:data/"+UniversalSetting.user+".db");

				String sql = "INSERT INTO MyProfile VALUES ('"+ user.getText() + "','"+ pass.getText() + "')";
				try
				{
					Statement ps = connection.createStatement();
					ps.executeUpdate(sql);
				}
				catch (Exception e)
				{
					try
					{
						String sql1="CREATE TABLE IF NOT EXISTS MyProfile(UserName varchar(100),Passward varchar(100))";
						Statement ps = connection.createStatement();
						int r1 = ps.executeUpdate(sql1);
						int r = ps.executeUpdate(sql);
					}
					catch (Exception w)
					{
						e.printStackTrace();
						w.printStackTrace();
					}
				}
				finally
				{
					connection.close();
				}
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/GetStarted.fxml"));
				Pane cmdPane = (Pane) fxmlLoader.load();
				try
				{
					side_pane.getChildren().clear();
					side_pane.getChildren().add(cmdPane);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}}
			}

/*
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
	}*/


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








	public void signupcall(Stage secondaryStage) throws IOException
	{
		Parent root =FXMLLoader.load(getClass().getResource("/application/GetStarted.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		secondaryStage.hide();
		secondaryStage.setScene(scene);
		secondaryStage.show();
		secondaryStage.setTitle("Get Started");
	}

	public void back(ActionEvent event) throws IOException
	{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/GetStarted.fxml"));
		Pane cmdPane = (Pane) fxmlLoader.load();
		try
		{
			side_pane.getChildren().clear();
			side_pane.getChildren().add(cmdPane);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}}



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
