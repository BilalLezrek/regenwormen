package main;


import gui.HoofdScherm;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class StartUp extends Application {
    
    @Override
    public void start(Stage stage)
    {
        HoofdScherm root = new HoofdScherm();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.setMaximized(true);
        stage.show();
    }
    public static void main(String[] args) 
    {
        launch(args);
    }
}

