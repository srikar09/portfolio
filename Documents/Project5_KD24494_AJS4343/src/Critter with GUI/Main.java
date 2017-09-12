package assignment5;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
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


import assignment5.Critter.*;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
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
	private Menu menu;
	static Scanner kb;	// scanner connected to keyboard input, or input file
    private static String inputFile;	// input file, used instead of keyboard input if specified
    static ByteArrayOutputStream testOutputString;	// if test specified, holds all console output
    private static String myPackage;	// package of Critter file.  Critter cannot be in default pkg.
    private static boolean DEBUG = false; // Use it or not, as you wish!
  
	
	static GridPane grid = new GridPane();
    
    public static final int scaling = 6;
    public static final double scaling2 = 6;

    public static final int width = Params.world_width;
    public static final int height = Params.world_height;
    
	public Stage theStage;
 	public static Pane ogpane; //root pane for scene2
 	//static Pane pane2Root;
	 
    
	@Override
	public void start(Stage primaryStage)  {    
		
		TextField runstat1 = new TextField ();
		TextField seed1 = new TextField ();
		
		theStage = primaryStage;
		Pane pane1 = new Pane();
		pane1.setPrefSize(700,500);
		ogpane = new Pane();
		Pane ogpane1 =new Pane();
		ogpane1.setPrefSize(10,10);
		Pane ogpane2 =new Pane();
		ogpane2.setPrefSize(10,10);
		ogpane.setPrefSize( (width * 30 ), (height *30));
		ogpane.getStyleClass().add("pane");
		BorderPane border = new BorderPane();
		border.setBottom(ogpane1);
		border.setRight(ogpane2);
		GridPane grid = new GridPane();
 
		
		
		border.setCenter(ogpane);
		theStage.setTitle("Critter");
	    Button createCritter = new Button("createCritter");
	   
	    
	    Button runStats = new Button("runStats");
	    Button quit =  new Button("quit");
	    Button seed =new Button("seed");
	    Button step1 = new Button("step 1");
	    Button step100 = new Button("step 100");
	    Button step1000 = new Button("step 1000");
	    Button step10 = new Button("step 10");
	    Button Display =  new Button("Display");
	    TextField notification = new TextField ();
	    notification.setText("Critter");
	    GridPane grid2 = new GridPane();

	    
	    
	    
	    //canvas
	    Pane canvas = new Pane();
	    canvas.setPrefSize(150,25);
	   
	    canvas.getChildren().add(grid2);
	    grid2.add(runstat1, 0, 1);
	    grid2.add(runStats, 0, 2);
	    grid2.add(seed1,0,3);
	    grid2.add(seed,0,4);

	   // canvas.getChildren().add(runstat1);
	    border.setLeft(canvas); 
	    
	    
	    HBox menuButtons2 = new HBox();
	    GridPane grid1 = new GridPane(); // add runstats
	    menuButtons2.getChildren().addAll(quit,step1,step100,step1000,createCritter,Display);
	    grid1.add(menuButtons2, 0, 1);
	    grid1.add(notification,1,1);
	    border.setTop(grid1);
		Scene scene1 = new Scene(border);
      scene1.getStylesheets().add( Main.class.getResource("grid1.css").toExternalForm());
      primaryStage.setScene(scene1);     // makes a pane with the required width and height
	 primaryStage.show();
		
      createCritter.setOnAction(e ->{
    	  String Crit;
    	   Crit =notification.getText();
    	  try {
    		  Critter.makeCritter(Crit);
    	  		Main.display();  

  		} catch (InvalidCritterException e1) {
  			e1.printStackTrace();
  		}
    	  runstat1.setText(Critter.runStats(Critter.population));
      });
      
      
      Display.setOnAction(e ->{
    	  runstat1.setText(Critter.runStats(Critter.population));
  		Main.display();  
      
      });
      
      step1.setOnAction(e ->{
    	Critter.worldTimeStep();
    	runstat1.setText(Critter.runStats(Critter.population));
  		Main.display();  
      
      });
      
      step100.setOnAction(e ->{
      	for(int i =0; i<100;i++){
      	  Critter.worldTimeStep();      		
      	}
      	runstat1.setText(Critter.runStats(Critter.population));
    	  Main.display();  
        
        });
      
      step1000.setOnAction(e ->{
    	  for(int i =0; i<100;i++){
          	  Critter.worldTimeStep();      		
          	}
    	  	runstat1.setText(Critter.runStats(Critter.population));
        	  Main.display(); 
        	  
      });
      
      runStats.setOnAction(e ->{
 		 runstat1.setText(Critter.runStats(Critter.population));    	  
      });
      
      step10.setOnAction(e ->{
    	  for(int i =0; i<10;i++){
          	  Critter.worldTimeStep();      		
          	}
    	  runstat1.setText(Critter.runStats(Critter.population));
        	  Main.display(); 
    	  
    	  
      });
      quit.setOnAction(e ->{
    	  System.exit(0);
    	  
      });
      
      seed.setOnAction(e ->{
    	  String in;
   	   in =seed1.getText();
   	   int x=	Integer.parseInt(in) ;
          Critter.rand = new java.util.Random(x);
    	  
      });
		    // where excactly do I call this 
		
		
							// Also how does scaling work with background pane
		
		}
	
	
	private static void display (){
		ogpane.getChildren().clear();
		int scaling3= (int) (scaling+scaling+scaling);
		for(Critter a :Critter.population) 
		{
			int x = a.x_coord;
			CritterShape sh = a.viewShape();
			Color col = a.viewFillColor();
			Color ol = a.viewOutlineColor();
			int y = a.y_coord;
			switch (sh){
			case CIRCLE:
				Circle circle = new Circle();
				circle.setCenterX(x*scaling2);
				circle.setCenterY(y*scaling2);
				circle.setRadius(scaling/2);
				circle.setFill(ol);
				int xg = (x);
				int yg= (y);
				ogpane.getChildren().add(circle);
				
				break;
			case TRIANGLE:
				Polygon triangle = new Polygon();
				triangle.getPoints().setAll(
					(double) (x*scaling2+scaling3/2), (double) (y*scaling2),
					(double) (x*scaling2), (double) (y*scaling2 + scaling3/2),
					(double) (x*scaling2), (double) (y*scaling2)
				);
				triangle.setFill(ol);
				ogpane.getChildren().add(triangle);
				break;
				
			case SQUARE:
				
				Rectangle square = new Rectangle (scaling,scaling);
				square.setFill(ol);
				square.setStroke(ol);
				square.setX(x*scaling2);
				square.setY(y*scaling2);
				
				ogpane.getChildren().add(square);
				break;
		
			case DIAMOND:
				Polygon diamond = new Polygon();
				diamond.getPoints().addAll(new Double[]{
						
					(double) (x*scaling2+scaling3), (double) (y*scaling2),
					(double) (x*scaling2), (double) (y*scaling2+scaling3/2 ),
					(double) (x*scaling2+scaling3/2), (double) (y*scaling2),
					(double) (x*scaling2+scaling3/2), (double) (y*scaling2+scaling3/2),
					
				});
				diamond.setFill(ol);
				ogpane.getChildren().add(diamond);
				break;
			case STAR:
				Polygon star = new Polygon();
				star.getPoints().addAll(new Double[]{
					(double) (x*scaling2+scaling3/2), (double) (y*scaling2),
					(double) (x*scaling2), (double) (y*scaling2 +scaling3),
					(double) (x*scaling2+scaling3), (double) (y*scaling2+scaling3/3),
					(double) (x*scaling2), (double) (y*scaling2+scaling3/3),
					(double) (x*scaling2+scaling3), (double) (y*scaling2+scaling3),
				});
				star.setFill(ol);
				ogpane.getChildren().add(star);
				break;
			
			}
			
			
			
			
			
		}

	}
		
	public static void main(String[] args) {
		launch(args);

	}
		
}