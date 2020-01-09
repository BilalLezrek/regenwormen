package gui;

import domein.Domeincontroller;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Scorescherm extends HBox{
    
    HoofdScherm hoofdscherm;
    Label lblnaam1,lblnaam2,lblnaam3,lblnaam4,lblnaam5,lblnaam6,lblnaam7;
    Label lblscore1,lblscore2,lblscore3,lblscore4,lblscore5,lblscore6,lblscore7;
    Label lblWinnaar,lblWinnaarScore;
    Domeincontroller dc;
    Button btnHighscore,btnAfsluiten;
    VBox alles = new VBox();
    Scorescherm(HoofdScherm hoofdscherm,Domeincontroller dc){
        this.hoofdscherm=hoofdscherm;
        this.dc = dc;
        btnHighscore = new Button("Highscore");
        btnHighscore.setOnAction(this::getHighscore);
        btnAfsluiten = new Button("Afsluiten");
        btnAfsluiten.setOnAction(this::sluitAf);
        setPrefWidth(1920);
        setPrefHeight(1080);
        HBox knoppen = new HBox();
        knoppen.setBackground(Background.EMPTY);
        knoppen.getChildren().addAll(btnHighscore,btnAfsluiten);
        alles.setAlignment(Pos.CENTER);
        VBox scorebord = new VBox();
        scorebord.setBackground(Background.EMPTY);
        lblWinnaar= new Label("Proficiat "+dc.getNaam(dc.berekenWinnaar())+" u heeft gewonnen met "+ Integer.toString(dc.getScore(dc.berekenWinnaar())) + " punten");
        lblWinnaar.setFont(Font.font(60));
        btnHighscore.setPrefSize(200, 50);
        btnAfsluiten.setPrefSize(200, 50);
        lblWinnaar.setStyle("-fx-font-weight: bold;");
        lblWinnaar.setAlignment(Pos.CENTER);
        switch(dc.getAantalSpelers())
        { 
            case 7:
                if (dc.berekenWinnaar() == 6) {
                    BackgroundImage myBI= new BackgroundImage(new Image("/images/ScoreBG7.jpg",1920,1080,false,true),
                    BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
                    setBackground(new Background(myBI));
                    break;
                }
            case 6:
                if (dc.berekenWinnaar() == 5) {
                    BackgroundImage myBI= new BackgroundImage(new Image("/images/ScoreBG6.jpg",1920,1080,false,true),
                    BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
                    setBackground(new Background(myBI));
                    break;
                }
            case 5:
                if (dc.berekenWinnaar() == 4) {
                    BackgroundImage myBI= new BackgroundImage(new Image("/images/ScoreBG5.jpg",1920,1080,false,true),
                    BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
                    setBackground(new Background(myBI));
                    break;
                }
            case 4:
                if (dc.berekenWinnaar() == 3) {
                    BackgroundImage myBI= new BackgroundImage(new Image("/images/ScoreBG4.jpg",1920,1080,false,true),
                    BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
                    setBackground(new Background(myBI));
                    break;
                }
            case 3:
                if (dc.berekenWinnaar() == 2) {
                    BackgroundImage myBI= new BackgroundImage(new Image("/images/ScoreBG3.jpg",1920,1080,false,true),
                    BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
                    setBackground(new Background(myBI));
                    break;
                }
            case 2:
                if (dc.berekenWinnaar() == 1) {
                    BackgroundImage myBI= new BackgroundImage(new Image("/images/ScoreBG2.jpg",1920,1080,false,true),
                    BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
                    setBackground(new Background(myBI));
                    break;
                }
                if (dc.berekenWinnaar() == 0) {
                    BackgroundImage myBI= new BackgroundImage(new Image("/images/ScoreBG1.jpg",1920,1080,false,true),
                    BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
                    setBackground(new Background(myBI));
                    break;
                }
            break;
        }
        
        switch(dc.getAantalSpelers())
        {
            case 7:
                lblnaam7= new Label(dc.getNaam(6));
                lblscore7= new Label(Integer.toString(dc.getScore(6)));
                lblnaam7.setFont(Font.font(20));
                lblnaam7.setStyle("-fx-font-weight: bold;");
                lblscore7.setFont(Font.font(20));
                scorebord.getChildren().addAll(lblnaam7,lblscore7);
            case 6:
                lblnaam6= new Label(dc.getNaam(5));
                lblscore6= new Label(Integer.toString(dc.getScore(5)));
                lblnaam6.setFont(Font.font(20));
                lblnaam6.setStyle("-fx-font-weight: bold;");
                lblscore6.setFont(Font.font(20));
                scorebord.getChildren().addAll(lblnaam6,lblscore6);
            case 5:
                lblnaam5= new Label(dc.getNaam(4));
                lblscore5= new Label(Integer.toString(dc.getScore(4)));
                lblscore5.setFont(Font.font(20));
                lblnaam5.setFont(Font.font(20));
                lblnaam5.setStyle("-fx-font-weight: bold;");
                
                scorebord.getChildren().addAll(lblnaam5,lblscore5);
            case 4:
                lblnaam4= new Label(dc.getNaam(3)); 
                lblscore4= new Label(Integer.toString(dc.getScore(3)));
                lblnaam4.setFont(Font.font(20));
                lblnaam4.setStyle("-fx-font-weight: bold;");
                lblscore4.setFont(Font.font(20));
                
                scorebord.getChildren().addAll(lblnaam4,lblscore4);
            case 3:
                lblnaam3= new Label(dc.getNaam(2));
                lblscore3= new Label(Integer.toString(dc.getScore(2)));
                lblnaam3.setFont(Font.font(20));
                lblnaam3.setStyle("-fx-font-weight: bold;");
                lblscore3.setFont(Font.font(20));
                
                scorebord.getChildren().addAll(lblnaam3,lblscore3);
            case 2:
                lblnaam1= new Label(dc.getNaam(0));
                lblnaam2= new Label(dc.getNaam(1));
                lblscore1= new Label(Integer.toString(dc.getScore(0)));
                lblscore2= new Label(Integer.toString(dc.getScore(1)));
                lblnaam2.setFont(Font.font(20));
                lblnaam2.setStyle("-fx-font-weight: bold;");
                lblnaam1.setStyle("-fx-font-weight: bold;");
                lblnaam1.setFont(Font.font(20));
                lblscore1.setFont(Font.font(20));
                lblscore2.setFont(Font.font(20));
                
                scorebord.getChildren().addAll(lblnaam1,lblscore1,lblnaam2,lblscore2);
                break;
        }
        this.setAlignment(Pos.CENTER);
        scorebord.setAlignment(Pos.CENTER);
        knoppen.setAlignment(Pos.CENTER);
        alles.getChildren().addAll(lblWinnaar,scorebord,knoppen);
        this.getChildren().add(alles);
    }
    
    private void getHighscore(ActionEvent event)
    {
        hoofdscherm.toonHighscorescherm();
    }
    
    private void sluitAf(ActionEvent event)
    {
        System.exit(0);
    }
}
