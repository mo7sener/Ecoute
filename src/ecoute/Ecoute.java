package ecoute;

import ecoute.gui.ControlBar;
import ecoute.gui.GridBuilder;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Ecoute extends Application 
{    
    final int   screenWidth = 1000,
                screenHeight = 600,
                buttonSize = 40;
    int     colNumber = 20,
            rowNumber = 10;
    
    public static Stage stage;
    @Override
    public void start(Stage primaryStage) 
    {
        this.stage = primaryStage;
        
        //Build the Control Area of the application
        FlowPane controlArea = ControlBar.build();
                
        //Build the Grid area of the application
        VBox gridArea = new GridBuilder().build(colNumber, rowNumber, buttonSize);
        
        VBox appArea = new VBox();
        appArea.getChildren().addAll(controlArea, gridArea);
        
        Group root = new Group(appArea);
        
        Scene scene = new Scene(root, Color.DARKSLATEGRAY);
//        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("ECOUTE PROTOTYPE");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.sizeToScene();
        
        stage.show();
        
        appArea.setMaxSize(stage.getWidth(), stage.getHeight());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
    }
    
}