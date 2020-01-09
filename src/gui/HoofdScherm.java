package gui;

import domein.Domeincontroller;
import javafx.scene.layout.HBox;

public class HoofdScherm extends HBox
{
    private Startscherm startscherm;
    private Spelerscherm spelerscherm;
    private Spelscherm spelscherm;
    
    private Domeincontroller dc = new Domeincontroller();
    private Scorescherm scorescherm;
    private Highscorescherm highscorescherm;

    public HoofdScherm()
    {
        startscherm = new Startscherm(this);
        getChildren().add(startscherm);
    }
    
    public void toonSpelerScherm()
    {
        getChildren().remove(startscherm);
        spelerscherm = new Spelerscherm(this,dc);
        getChildren().add(spelerscherm);
    }
    
    public void startSpel(Domeincontroller dc)
    {
        getChildren().remove(spelerscherm);
        spelscherm = new Spelscherm(this,dc);
        getChildren().add(spelscherm);
    }
    
    public void toonScorebord(Domeincontroller dc)
    {
        getChildren().remove(spelscherm);
        scorescherm = new Scorescherm(this,dc);
        getChildren().add(scorescherm);
    }

    public void toonSpelschermViaScore() {
        getChildren().remove(scorescherm);
        spelscherm = new Spelscherm(this,dc);
        getChildren().add(spelscherm);
    }
    
    public void toonHighscorescherm(){
        getChildren().remove(scorescherm);
        highscorescherm = new Highscorescherm(this);
        //getChildren().add(highscorescherm);
    }
    
}
