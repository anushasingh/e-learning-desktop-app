package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class StudyTips2Controller implements Initializable {

	@FXML
	private ImageView img;
	@FXML
	private ImageView img2;
	@FXML
	private ImageView next;
	@FXML
	private ImageView prev;
	@FXML
	private AnchorPane side_pane;
	@FXML
	private TextField text;

	private int i = 0;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/MainMenuList.fxml"));
		Pane cmdPane;
		try {
			cmdPane = (Pane) fxmlLoader.load();
			side_pane.getChildren().clear();
			side_pane.getChildren().add(cmdPane);

		} catch (Exception e) {
			e.printStackTrace();
		}

		img2.setImage(new Image("/Images/1stt2.png"));

		img.setImage(new Image("/Images/1st2.png"));

		next.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				prev.setDisable(false);
				if (i < 4) {
					incint();
				}
				changeimage(i);

			}

		});


		next.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				next.setFitWidth(47);
				next.setFitHeight(54);
			}

		});
		next.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				next.setFitWidth(43);
				next.setFitHeight(49);
			}

		});

		prev.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {

				next.setDisable(false);

				if (i > 0) {
					decint();
				}

				changeimage(i);

			}

		});


		prev.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				prev.setFitWidth(47);
				prev.setFitHeight(54);
			}

		});
		prev.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				prev.setFitWidth(43);
				prev.setFitHeight(49);
			}

		});


	}

	protected void incint() {
		// TODO Auto-generated method stub
		i++;
	}

	protected void decint() {
		// TODO Auto-generated method stub
		i--;
	}

	private void changeimage(int x) {
		// TODO Auto-generated method stub

		if (i == 4) {

			next.setDisable(true);
		}

		else if (i == 0)

		{

			prev.setDisable(true);
		}

		if (x == 0) {

			img2.setImage(new Image("/Images/1stt2.png"));

			img.setImage(new Image("/Images/1st2.png"));

		}
		if (x == 1) {
			System.out.println(i);
			img2.setImage(new Image("/Images/2stt2.png"));

			img.setImage(new Image("/Images/2st2.png"));
		}

		else if (x == 2) {
			System.out.println(i);
			img2.setImage(new Image("/Images/3stt2.png"));

			img.setImage(new Image("/Images/3st2.png"));
		}

		else if (x == 3) {
			System.out.println(i);
			img2.setImage(new Image("/Images/4stt2.png"));

			img.setImage(new Image("/Images/4st2.png"));
		}

		else if (x == 4) {
			System.out.println(i);
			img2.setImage(new Image("/Images/5stt2.png"));

			img.setImage(new Image("/Images/5st2.png"));
		}

	}

}
