/* CRITTERS Critter2.java
* * <Attila Szabo> 
* * <Krishna Dandamuraju>
* * <ajs4343> 
* * <kd244>
* * <76175.> 
* * Summer 2017 
* * Slip days used: 3
 */
package application;
 
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Scene;
import javafx.scene.*;
import javafx.scene.layout.*;
 
 
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
 
 
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.*;
import javafx.scene.control.*;
 
public class Main extends Application {
	public static String name;
	public static int uniqueid;
	public static ArrayList<String> clients1 = new ArrayList<String>();
	public static ArrayList<String> clients2 = new ArrayList<String>();
	public static ArrayList<String> clients3 = new ArrayList<String>();
	
	
	
	
	
	private Menu menu;
    static Scanner kb;  // scanner connected to keyboard input, or input file
    private static String inputFile;    // input file, used instead of keyboard input if specified
    static ByteArrayOutputStream testOutputString;  // if test specified, holds all console output
    private static String myPackage;    // package of Critter file.  Critter cannot be in default pkg.
    private static boolean DEBUG = false; // Use it or not, as you wish!
 
   
    static GridPane grid = new GridPane();
   
    public static final int scaling = 6;
    public static final double scaling2 = 6;
 
    public static final int width = 100;
    public static final int height =100;
   
    public Stage theStage;
    public static Pane ogpane; //root pane for scene2
    //static Pane pane2Root;
    public Stage stage2;

    @Override
    public void start(Stage primaryStage)  {    
    	Socket sock;
    	try {
    		sock = new Socket("127.0.0.1", 4194);
    		InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
			BufferedReader reader = new BufferedReader(streamReader);
			ObjectOutputStream outputStream = new ObjectOutputStream(sock.getOutputStream());
			ObjectInputStream	inStream = new ObjectInputStream(sock.getInputStream());
			
				
    	}
    	
    	
    	catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    	Pane top = new Pane();
       top.setPrefSize(800, 50);

        TextField Input1 = new TextField ();
        TextField Input2 = new TextField ();
        Input2.setTranslateX(510);
        TextField Input3 = new TextField ();
        Input3.setTranslateX(800);
        
        
        Button input1add = new Button("add");
        input1add.setTranslateX(150);
        Button input1remove =  new Button("reset");
        input1remove.setTranslateX(190);
        Button input1show =new Button("show");
        input1show.setTranslateX(250);
        Button input2add = new Button("add");
        input2add.setTranslateX(660);
        Button input2show = new Button("show");
        input2show.setTranslateX(695);
        Button input2remove = new Button("reset");
        input2remove.setTranslateX(740);
        Button input3add = new Button("add");
        input3add.setTranslateX(950);
        Button input3show =  new Button("show");
        input3show.setTranslateX(990);
        Button input3remove =  new Button("reset");
        input3remove.setTranslateX(1030);
        
        top.getChildren().addAll(Input1,Input2,Input3,input1add,input1remove,input1show,input2add,input2show,input2remove,input3add,input3show,
		input3remove);
        
        input1add.setOnAction(e->{
        String input= Input1.getText();
        
        });
      
        
        Pane pane1 = new Pane();
        Pane pane2 = new Pane();
        pane2.setPrefSize(100,100);
        TextArea io = new TextArea();
        TextArea io4 = new TextArea();
        io4.setPrefHeight(70);
        io4.setPrefWidth(500);
        
        io.setPrefHeight(500);
        io.setPrefWidth(290);
        TextArea io1 =new TextArea();
        io1.setText("srikar \n"+"hsdhshdsj");
        io4.setPromptText("Srikar-James");
        io4.setOnMousePressed(e-> {io4.clear(); 
        });
        
       
        
        io1.setPrefHeight(500);
        pane1.setPrefSize(300,1000);
        pane1.getChildren().add(io);
        pane2.getChildren().add(io1);
        pane2.setPrefSize(5,5);
        Label label1 = new Label("Name: Srikar");
        label1.setTranslateY(500);
        
        pane2.getChildren().add(label1);
        Pane ogpane1 =new Pane();
        ogpane1.setPrefSize(100,100);
        Pane ogpane2 =new Pane();
        
        ogpane2.getChildren().add(io4);
  
        
        
        BorderPane border = new BorderPane();            
        border.setCenter(pane1);
        border.setBottom(ogpane2);
           TextField notification = new TextField ();
        notification.setText("Critter");

        //canvas
        Pane canvas = new Pane();
        canvas.setPrefSize(500,1000);
        canvas.getChildren().add(pane2);
    
        TextArea io3 =new TextArea();
        io3.setPrefHeight(500);
        Pane canvas1 = new Pane();
        canvas1.setPrefSize(500,1000);
        canvas1.getChildren().add(io3);
        border.setRight(canvas1);
 
        border.setLeft(canvas);
       
       
        HBox menuButtons2 = new HBox();
        GridPane grid1 = new GridPane(); // add runstats
        grid1.add(menuButtons2, 0, 1);
        grid1.add(notification,1,1);
        border.setTop(top); 
        
        Scene scene2 = new Scene(border);
        scene2.getStylesheets().add( Main.class.getResource("grid1.css").toExternalForm());
        primaryStage.setScene(scene2);     // makes a pane with the required width and height
        primaryStage.show();
       
        input2show.setOnAction(e->{
        	Input2.setText("Hi this works");
        });

        
        }
   
   
 
       
    public static void main(String[] args) {
        launch(args);
 
    }
       
}