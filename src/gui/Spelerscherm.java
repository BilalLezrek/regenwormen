package gui;

import domein.Domeincontroller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;

public class Spelerscherm extends VBox
{
    
    Button btnValideer = new Button("Valideer het aantal spelers");
    Button btnStartSpel = new Button("Start het spel");
    Label lblSpeler1 = new Label("Speler 1:");
    Label lblSpeler2 = new Label("Speler 2:");
    Label lblSpeler3 = new Label("Speler 3:");
    Label lblSpeler4 = new Label("Speler 4:");
    Label controle = new Label(" ");
    Label lblSpeler5 = new Label("Speler 5:");
    Label lblSpeler6 = new Label("Speler 6:");
    Label lblSpeler7 = new Label("Speler 7:");
    TextField txfSpeler1 = new TextField();
    TextField txfSpeler2 = new TextField();
    TextField txfSpeler3 = new TextField();
    TextField txfSpeler4 = new TextField();
    TextField txfSpeler5 = new TextField();
    TextField txfSpeler6 = new TextField();
    TextField txfSpeler7 = new TextField();
    DatePicker dpSpeler1 = new DatePicker();
    DatePicker dpSpeler2 = new DatePicker();
    DatePicker dpSpeler3 = new DatePicker();
    DatePicker dpSpeler4 = new DatePicker();
    DatePicker dpSpeler5 = new DatePicker();
    DatePicker dpSpeler6 = new DatePicker();
    DatePicker dpSpeler7 = new DatePicker();
    Domeincontroller dc;
    HoofdScherm hs;
    ObservableList<String> cbAantalSpelers = 
    FXCollections.observableArrayList(
        "2 Spelers",
        "3 Spelers",
        "4 Spelers",
        "5 Spelers",
        "6 Spelers",
        "7 Spelers"
    );
    
    ComboBox combo = new ComboBox(cbAantalSpelers); 
    
    public Spelerscherm(HoofdScherm aThis,Domeincontroller dc) 
    {
        hs = aThis;
        this.dc = dc;
        VBox knoppen = new VBox();
        Scene sceneKnoppen  = new Scene(knoppen,200,200);
        getChildren().addAll(combo,btnValideer);
        this.getChildren().add(knoppen);
        knoppen.setAlignment(Pos.TOP_RIGHT);
        setPadding(new Insets(15, 12, 15, 12));
        setId("pane");
        
        setDefaultBG();
        
        txfSpeler1.setPrefSize(600, 30);
        txfSpeler1.setMaxSize(600, 35);
        txfSpeler1.setPromptText("Naam");
        txfSpeler2.setPrefSize(600, 35);
        txfSpeler2.setMaxSize(600, 35);
        txfSpeler2.setPromptText("Naam");
        txfSpeler3.setPrefSize(600, 35);
        txfSpeler3.setMaxSize(600, 35);
        txfSpeler3.setPromptText("Naam");
        txfSpeler4.setPrefSize(600, 35);
        txfSpeler4.setMaxSize(600, 35);
        txfSpeler4.setPromptText("Naam");
        txfSpeler5.setPrefSize(600, 35);
        txfSpeler5.setMaxSize(600, 35);
        txfSpeler5.setPromptText("Naam");
        txfSpeler6.setPrefSize(600, 35);
        txfSpeler6.setMaxSize(600, 35);
        txfSpeler6.setPromptText("Naam");
        txfSpeler7.setPrefSize(600, 35);
        txfSpeler7.setMaxSize(600, 35);
        txfSpeler7.setPromptText("Naam");
        
        btnValideer.setPrefSize(200, 40);
        btnStartSpel.setPrefSize(300, 40);
        
        setPrefWidth(1920);
        setPrefHeight(1080);
               
        btnValideer.setOnAction(this::getValidatie);
        
        btnStartSpel.setOnAction(this::startSpel);
    }
    
    private void getValidatie(ActionEvent event)
    {
        if (combo.getValue() != null && !combo.getValue().toString().isEmpty()) {
            VBox spelers = new VBox();
            Scene sceneKnoppen  = new Scene(spelers,500,800);
            
            getChildren().removeAll(lblSpeler1,lblSpeler2,lblSpeler3,lblSpeler4,lblSpeler5,lblSpeler6,lblSpeler7,txfSpeler1,txfSpeler2,txfSpeler3,txfSpeler4,txfSpeler5,txfSpeler6,txfSpeler7,dpSpeler1,dpSpeler2,dpSpeler3,dpSpeler4,dpSpeler5,dpSpeler6,dpSpeler7,btnStartSpel);
            switch (combo.getValue().toString()) {
            case "7 Spelers":
                getChildren().addAll(lblSpeler7,txfSpeler7,dpSpeler7);
            case "6 Spelers":
                getChildren().addAll(lblSpeler6,txfSpeler6,dpSpeler6);
            case "5 Spelers":
                getChildren().addAll(lblSpeler5,txfSpeler5,dpSpeler5);
            case "4 Spelers":
                getChildren().addAll(lblSpeler4,txfSpeler4,dpSpeler4);
            case "3 Spelers":
                getChildren().addAll(lblSpeler3,txfSpeler3,dpSpeler3);
            case "2 Spelers":
                getChildren().addAll(lblSpeler2,txfSpeler2,dpSpeler2,lblSpeler1,txfSpeler1,dpSpeler1,btnStartSpel);
                break;
            default:
                break;
            }
            this.getChildren().add(spelers);
            spelers.setAlignment(Pos.CENTER);
            setDefaultBG();
        }
        else
        {
            foutAantalSpelers();
        }
    }
    
    private void startSpel(ActionEvent event)
    {
        switch(combo.getValue().toString())
        {
            case "7 Spelers":
                dc.setAantalSpelers(7);   
                break;                
            case "6 Spelers":
                dc.setAantalSpelers(6);
                break;
            case "5 Spelers":
                dc.setAantalSpelers(5);
                break;
            case "4 Spelers":
                dc.setAantalSpelers(4);
                break;
            case "3 Spelers":
                dc.setAantalSpelers(3);
                break;
            case "2 Spelers":
                dc.setAantalSpelers(2);    
            break;
        default:
            break;
        }
        
        
        
        switch (combo.getValue().toString()) {
            case "7 Spelers":
                if (!txfSpeler7.getText().isEmpty() && dpSpeler7 != null) 
                {
                    dc.setNaam(6, txfSpeler7.getText());
                    dc.setDatum(6, dpSpeler7.getValue());
                }
                else
                {
                    foutNaam();
                }
            case "6 Spelers":
                if (!txfSpeler6.getText().isEmpty() && dpSpeler6 != null) 
                {       
                    dc.setNaam(5, txfSpeler6.getText());  
                    dc.setDatum(5, dpSpeler6.getValue());
                }
                else
                {
                    foutNaam();
                }
            case "5 Spelers":
                if (!txfSpeler5.getText().isEmpty() && dpSpeler5 != null) 
                {
                    dc.setNaam(4, txfSpeler5.getText());
                    dc.setDatum(4, dpSpeler5.getValue());
                }
                else
                {
                    foutNaam();
                }
            case "4 Spelers":
                if (!txfSpeler4.getText().isEmpty()&& dpSpeler4 != null) 
                {
                    dc.setNaam(3, txfSpeler4.getText());
                    dc.setDatum(3, dpSpeler4.getValue());
                }
                else
                {
                    foutNaam();
                }
            case "3 Spelers":
                if (!txfSpeler3.getText().isEmpty() && dpSpeler3.getValue() != null) 
                {
                    dc.setNaam(2, txfSpeler3.getText());
                    dc.setDatum(2, dpSpeler3.getValue());
                }
                else
                {
                    foutNaam();
                }
            case "2 Spelers":
                if (!txfSpeler1.getText().isEmpty() && !txfSpeler2.getText().isEmpty() && dpSpeler1.getValue() != null && dpSpeler2.getValue() != null)
                {
                    dc.setNaam(1, txfSpeler2.getText());
                    dc.setDatum(1, dpSpeler2.getValue());
                    dc.setNaam(0, txfSpeler1.getText());
                    dc.setDatum(0, dpSpeler1.getValue());
                    dc.setBeurt();
                    hs.startSpel(dc);
                }
                else
                {
                    foutNaam();
                }
                break;
            default:
                break;
                
        }
        
        
    
    }
    
    private void foutAantalSpelers()
    {
        BackgroundImage myBI= new BackgroundImage(new Image("/images/FoutValidatie.jpg",1920,1080,false,true),
        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        setBackground(new Background(myBI));
    }
    
    private void foutNaam()
    {
        BackgroundImage myBI= new BackgroundImage(new Image("/images/FoutSpelers.jpg",1920,1080,false,true),
        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        setBackground(new Background(myBI));
    }

    private void setDefaultBG() 
    {
        BackgroundImage myBI= new BackgroundImage(new Image("/images/SpelerBG.jpg",1920,1080,false,true),
        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        setBackground(new Background(myBI));
    }
}
