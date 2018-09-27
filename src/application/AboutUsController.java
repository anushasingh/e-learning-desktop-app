package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AboutUsController implements Initializable {
	@FXML
	private AnchorPane side_pane;

	@FXML
	private TextArea ans;

	

	@Override
	public void initialize(URL location, ResourceBundle resources) {

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
	
	
	@FXML
	public void whatis(ActionEvent event) throws IOException, ClassNotFoundException, SQLException
	{
		ans.setText("JavaFX is a set of graphics and media packages that enable developers to design, create, test, debug, and deploy rich client applications that operate consistently across diverse platforms. With JavaFX, you can build many types of applications. Typically, they are network-aware applications that are deployed across multiple platforms and display information in a high-performance modern user interface that features audio, video, graphics, and animation.");
	}
	
	@FXML
	public void whyj(ActionEvent event) throws IOException, ClassNotFoundException, SQLException
	{
		ans.setText("1. Java APIs. \nJavaFX is a Java library that consists of classes and interfaces that are written in native Java code. The APIs are designed to be a friendly alternative to JavaVirtual Machine (Java VM) languages, such as JRuby and Scala.\n\n2. FXML and Scene Builder. \nFXML is an XML-based declarative markup language for constructing a JavaFX application user interface. A designer can code in FXML or use JavaFX Scene Builder to interactively design the graphical user interface (GUI). Scene Builder generates FXML markup that can be ported to an IDE where a developer can add the business logic.\n\n3. WebView. \nA web component that uses WebKitHTML technology to make it possible to embed web pages within a JavaFX application. JavaScript running in WebView can call Java APIs, and Java APIs can call JavaScript running in WebView. \n\n4. Swing interoperability. Existing Swing applications can be updated with new JavaFX features, such as rich graphics media playback and embedded Web content.\n\n5. Built-in UI controls and CSS. JavaFX provides all the major UI controls required to develop a full-featured application. Components can be skinned with standard Web technologies such as CSS.\n\n6. Canvas API. The Canvas API enables drawing directly within an area of the JavaFX scene that consists of one graphical element (node).\n\n7. Multitouch Support. JavaFX provides support for multitouch operations, based on the capabilities of the underlying platform.\n\n8. Hardware-accelerated graphics pipeline. JavaFX graphics are based on the graphics rendering pipeline (Prism). JavaFX offers smooth graphics that render quickly through Prism when it is used with a supported graphics card or graphics processing unit(GPU). If a system does not feature one of the recommended GPUs supported by JavaFX, then Prism defaults to the Java 2D software stack.\n\n9. High-performance media engine. The media pipeline supports the playback of web multimedia content. It provides a stable, low-latency media framework that is based on the GStreamer multimedia framework.\n\n10. Self-contained application deployment model. Self-contained application packages have all of the application resources and a private copy of the Java and JavaFX runtimes. They are distributed as native installable packages and provide the same installation and launch experience as native applications for that operating system. See the Deploying JavaFX Applications document.");
	}
	@FXML
	public void softwarereq(ActionEvent event) throws IOException, ClassNotFoundException, SQLException
	{
		ans.setText("Software Requirements\n\nDevelopment Kit: JRE 1.8.0_91 and Java JDK 1.8.\nLanguages : Core Java\nIDE : Eclipse Mars.2 (4.5.2)\nBuild id : M20160212-1500\nPlatform : Any OS.");
	}
	@FXML
	public void hardwarereq(ActionEvent event) throws IOException, ClassNotFoundException, SQLException
	{
		ans.setText("Hardware Requirements\n\nOn Developer Side:\nProcessor: Intel Core™ i3 or above.\nRAM : 4GB.\nHard disk: 40GB or above.\nMonitor : 15’’ LCD or CRT Monitor or above.\nKeyboard: Standard windows keyboard\nGPU: NVidia GeForce 500 series and above (or any equivalent GPU)\n\nOn Client Side:\n\nProcessor: Dual core or above.\nRAM : 4GB.\nHard disk: 40GB or above.\nMonitor : 15’’ LCD or CRT Monitor or above.\nKeyboard: Standard windows keyboard\nGPU : NVidia GeForce 500 series and above (or any equivalent GPU)\n");
	}

}