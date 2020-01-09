package gui;

import java.awt.Desktop;
import java.io.File;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class Startscherm extends HBox
{
    HoofdScherm hoofdscherm;
    private final Button btnStartSpel,btnHandleiding;
    
    public Startscherm(HoofdScherm hoofdscherm)
    {
        this.hoofdscherm=hoofdscherm;
        
        btnStartSpel = new Button();
        btnStartSpel.setPrefSize(200,50);
        btnHandleiding = new Button();
        btnHandleiding.setPrefSize(200,50);
        
        getChildren().addAll(btnStartSpel,btnHandleiding);
        setId("pane");

        setPrefWidth(1920);
        setPrefHeight(1080);
        setAlignment(Pos.CENTER);
        setPadding(new Insets(15, 15, 15, 15));
        setSpacing(10);
        setHgrow(btnStartSpel, Priority.ALWAYS);
        setHgrow(btnHandleiding, Priority.ALWAYS);
        
        BackgroundImage myBI= new BackgroundImage(new Image("/images/hoofdmenu.png",1920,1080,false,true),
        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        setBackground(new Background(myBI));

        btnStartSpel.setText("Start spel!");
        btnStartSpel.setOnAction(this::startSpel);

        btnHandleiding.setText("Handleiding.");
        btnHandleiding.setOnAction(this::toonHandleiding);
    }
    
    private void startSpel(ActionEvent event){
        hoofdscherm.toonSpelerScherm();
    }
    
    private void toonHandleiding(ActionEvent event){
        try{
            Desktop.getDesktop().open(new File("src\\pdf\\spelregels-regenwormen.pdf"));
        }
        catch(Exception e)
        {
            
        }
    }
}
