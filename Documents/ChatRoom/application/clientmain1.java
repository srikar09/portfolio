/* 
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
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

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
 
public class clientmain1 extends Application {
	public static String name="Srikar";
	public static int first;  // tells whether occupied or not 
	public static int second;  // tells whether occupied or not 
	public static int third;
	
	public static ArrayList<String> clients1 = new ArrayList<String>();
	public static ArrayList<String> clients2 = new ArrayList<String>();
	public static ArrayList<String> clients3 = new ArrayList<String>();
	
	public static Set<String> clients11 =  new TreeSet<String>();
	public static Set<String> clients22 = new  TreeSet<String>();;
	public static Set<String> clients33 = new  TreeSet<String>();;

	
	public static BufferedReader reader ;
	public static PrintWriter outputStream ;
	public static TextArea io = new TextArea(); //left James
    public static TextArea io1 =new TextArea();   //Center Smith  
    public static  TextArea io3 =new TextArea();  //Right All
    public static Pane ogpane; //root pane for scene2
    //static Pane pane2Root;
    public Stage stage2;

    @Override
    public void start(Stage primaryStage)  {    
		Socket sock;
    	try {
    		sock = new Socket("127.0.0.1", 4199);
   		 outputStream = new PrintWriter(sock.getOutputStream());
			 reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			String Message  = ("Srikar"+ "%;&");
			outputStream.println(Message);
			outputStream.flush();
			Map<String,TextArea> rightHereMap = new HashMap<String,TextArea>();
			rightHereMap.put( "James",io1);
			rightHereMap.put("Smith",io);
			rightHereMap.put("no",io3); //all

			clientread x = new clientread(reader,rightHereMap);
			Thread t = new Thread(x);
			
			t.start();
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
        
       
      
        
        Pane pane1 = new Pane();
        Pane pane2 = new Pane();
        pane2.setPrefSize(100,100);
        TextArea io4 = new TextArea();
        io4.setPrefHeight(70);
        io4.setPrefWidth(500);
        
        io.setPrefHeight(500);
        io.setPrefWidth(290);
        io4.setPromptText("Enter text");
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
        ogpane2.setPrefSize(800, 100);
        Button sendLeft =new Button("Talk to James");
        Button sendRight =new Button("GroupChat");
        Button SendMiddle =new Button("Talk to Smith");
        sendLeft.setTranslateX(600);
        sendRight.setTranslateX(800);
        SendMiddle.setTranslateX(700);
        ogpane2.getChildren().add(io4);
        ogpane2.getChildren().add(sendLeft);
        ogpane2.getChildren().add(sendRight);
        ogpane2.getChildren().add(SendMiddle);
        
        
        BorderPane border = new BorderPane();            
        border.setCenter(pane1);
        border.setBottom(ogpane2);
           TextField notification = new TextField ();
        notification.setText("Critter");

        //canvas
        Pane canvas = new Pane();
        canvas.setPrefSize(500,1000);
        canvas.getChildren().add(pane2);
    
          //io3 is right 
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

        sendLeft.setOnAction(e->{
         String message=
        	io4.getText();
         System.out.println(message);
         io1.appendText("\n"+this.name+" :"+message);
         String output =  "Srikar"+"%;&"+"James"+"%;&"+"Yes"+"%;&"+message;
         outputStream.println(output);
         outputStream.flush(); 
        	
        });
    
        sendRight.setOnAction(e->{
            String message=
           	io4.getText();
            System.out.println(message);
          //  io3.appendText("\n"+this.name+" :"+message);
            String output =  "Srikar"+"%;&"+"Smith"+"%;&"+"no"+"%;&"+message;
            outputStream.println(output);
            outputStream.flush(); 
           	
           });
        
        
        SendMiddle.setOnAction(e->{
            String message=
           	io4.getText();
            System.out.println(message);
            io.appendText("\n"+this.name+" :"+message);
            String output =  "Srikar"+"%;&"+"Smith"+"%;&"+"Yes"+"%;&"+message;
            outputStream.println(output);
            outputStream.flush(); 
           	
           });
        
    
        primaryStage.setTitle(this.name);
    }
   
   


   
   
 
       
    public static void main (String[] args) {
        launch(args);
 
    }
    
    

    
    
      
}