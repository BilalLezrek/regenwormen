package gui;

import domein.Domeincontroller;
import java.awt.Font;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.FontWeight;

public class Spelscherm extends HBox{
    HoofdScherm Hoofdscherm;
    Label lblnaamSpeler1,lblnaamSpeler2,lblnaamSpeler3,lblnaamSpeler4,lblnaamSpeler5,lblnaamSpeler6,lblnaamSpeler7;
    Label lblgenomenTegels1,lblgenomenTegels2,lblgenomenTegels3,lblgenomenTegels4,lblgenomenTegels5,lblgenomenTegels6,lblgenomenTegels7;
    Label lblCommunicatie,lblspelerAanBeurt,lblsom;
    Label lblScore1,lblScore2,lblScore3,lblScore4,lblScore5,lblScore6,lblScore7,lblDobbelstenenAanKant;
    Button btnStoppen,btnDobbelen,btnOpgeven;
    Image tegel21,tegel22,tegel23,tegel24,tegel25,tegel26,tegel27,tegel28,tegel29,tegel30,tegel31,tegel32,tegel33,tegel34,tegel35,tegel36;
    Image tegel21Trans,tegel22Trans,tegel23Trans,tegel24Trans,tegel25Trans,tegel26Trans,tegel27Trans,tegel28Trans,tegel29Trans,tegel30Trans,tegel31Trans,tegel32Trans,tegel33Trans,tegel34Trans,tegel35Trans,tegel36Trans;
    Image dobbelsteen1,dobbelsteen2,dobbelsteen3,dobbelsteen4,dobbelsteen5,dobbelsteen6;
    ImageView[] tegels = new ImageView[16];
    ImageView[] gegooideDobbelstenen = new ImageView[8];
    ImageView[] genomenDobbelstenen = new ImageView[8];
    GridPane grid = new GridPane();
    HBox dobbelstenenGegooid = new HBox();
    Domeincontroller dc;
    
    Spelscherm(HoofdScherm hoofdscherm,Domeincontroller dc) {
        this.Hoofdscherm=hoofdscherm;
        this.dc = dc;
        this.dc.createDobbelstenen();
        this.dc.createTegels();
        this.dc.setBeurt();
        setPrefWidth(1920);
        setPrefHeight(1080);
        
        
        BackgroundImage myBI= new BackgroundImage(new Image("/images/SpelBG.jpg",1920,1080,false,true),
        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        setBackground(new Background(myBI));
        lblspelerAanBeurt= new Label("Het is nu aan speler: " + this.dc.getNaam(dc.getSpelerAanBeurt()));
        lblCommunicatie = new Label("VEEL PLEZIER!");
        btnStoppen = new Button("Stoppen");
        btnDobbelen = new Button("Gooi dobbelstenen");
        btnOpgeven = new Button("Opgeven");
        btnStoppen.setPrefSize(200, 50);
        btnDobbelen.setPrefSize(200, 50);
        btnOpgeven.setPrefSize(200, 50);
        lblCommunicatie.setStyle("-fx-font-weight: bold;");
        lblspelerAanBeurt.setStyle("-fx-font-weight: bold;");
        lblspelerAanBeurt.setFont(javafx.scene.text.Font.font(15));
        for (int i = 0; i < 16; i++) {
            tegels[i] = new ImageView();
        }
        tegel21 = new Image("/images/tegels/Tegel21.png");
        tegel21Trans = new Image("/images/tegels_transparant/Tegel21Trans.png");
        tegel22 = new Image("/images/tegels/Tegel22.png");
        tegel22Trans = new Image("/images/tegels_transparant/Tegel22Trans.png");
        tegel23 = new Image("/images/tegels/Tegel23.png");
        tegel23Trans = new Image("/images/tegels_transparant/Tegel23Trans.png");
        tegel24 = new Image("/images/tegels/Tegel24.png");
        tegel24Trans = new Image("/images/tegels_transparant/Tegel24Trans.png");
        tegel25 = new Image("/images/tegels/Tegel25.png");
        tegel25Trans = new Image("/images/tegels_transparant/Tegel25Trans.png");
        tegel26 = new Image("/images/tegels/Tegel26.png");
        tegel26Trans = new Image("/images/tegels_transparant/Tegel26Trans.png");
        tegel27 = new Image("/images/tegels/Tegel27.png");
        tegel27Trans = new Image("/images/tegels_transparant/Tegel27Trans.png");
        tegel28 = new Image("/images/tegels/Tegel28.png");
        tegel28Trans = new Image("/images/tegels_transparant/Tegel28Trans.png");
        tegel29 = new Image("/images/tegels/Tegel29.png");
        tegel29Trans = new Image("/images/tegels_transparant/Tegel29Trans.png");
        tegel30 = new Image("/images/tegels/Tegel30.png");
        tegel30Trans = new Image("/images/tegels_transparant/Tegel30Trans.png");
        tegel31 = new Image("/images/tegels/Tegel31.png");
        tegel31Trans = new Image("/images/tegels_transparant/Tegel31Trans.png");
        tegel32 = new Image("/images/tegels/Tegel32.png");
        tegel32Trans = new Image("/images/tegels_transparant/Tegel32Trans.png");
        tegel33 = new Image("/images/tegels/Tegel33.png");
        tegel33Trans = new Image("/images/tegels_transparant/Tegel33Trans.png");
        tegel34 = new Image("/images/tegels/Tegel34.png");
        tegel34Trans = new Image("/images/tegels_transparant/Tegel34Trans.png");
        tegel35 = new Image("/images/tegels/Tegel35.png");
        tegel35Trans = new Image("/images/tegels_transparant/Tegel35Trans.png");
        tegel36 = new Image("/images/tegels/Tegel36.png");
        tegel36Trans = new Image("/images/tegels_transparant/Tegel36Trans.png");
        dobbelsteen1 = new Image("/images/dobbelstenen/Dobbelsteen1.png");
        dobbelsteen2 = new Image("/images/dobbelstenen/Dobbelsteen2.png");
        dobbelsteen3 = new Image("/images/dobbelstenen/Dobbelsteen3.png");
        dobbelsteen4 = new Image("/images/dobbelstenen/Dobbelsteen4.png");
        dobbelsteen5 = new Image("/images/dobbelstenen/Dobbelsteen5.png");
        dobbelsteen6 = new Image("/images/dobbelstenen/DobbelsteenWorm.png");
        
        for (int teller = 0; teller < 8; teller++) {
            gegooideDobbelstenen[teller] = new ImageView();
        }
        
        
        tegelUpdate();
        
        
        
        VBox[] spelers = new VBox[7];
        
        VBox info = new VBox();
        for (int i = 0; i < dc.getAantalSpelers(); i++) {
            spelers[i] = new VBox();
            spelers[i].setBackground(Background.EMPTY);
        }
        
        switch(dc.getAantalSpelers())
        {
            case 7:
                lblnaamSpeler7= new Label(dc.getNaam(6)); 
                lblnaamSpeler7.setStyle("-fx-font-weight: bold;");
                lblgenomenTegels7= new Label("Nog geen genomen tegels."); 
                lblnaamSpeler7.setFont(javafx.scene.text.Font.font(20));
                lblScore7= new Label("0"); 
                spelers[6].getChildren().addAll(lblnaamSpeler7,lblgenomenTegels7,lblScore7);
            case 6:
                lblnaamSpeler6= new Label(dc.getNaam(5)); 
                lblnaamSpeler6.setStyle("-fx-font-weight: bold;");
                lblgenomenTegels6= new Label("Nog geen genomen tegels.");
                lblnaamSpeler6.setFont(javafx.scene.text.Font.font(20));
                lblScore6= new Label("0"); 
                spelers[6].getChildren().addAll(lblnaamSpeler6,lblgenomenTegels6,lblScore6);
            case 5:
                lblnaamSpeler5= new Label(dc.getNaam(4)); 
                lblnaamSpeler5.setStyle("-fx-font-weight: bold;");
                lblgenomenTegels5= new Label("Nog geen genomen tegels.");
                lblnaamSpeler5.setFont(javafx.scene.text.Font.font(20));
                lblScore5= new Label("0"); 
                spelers[6].getChildren().addAll(lblnaamSpeler5,lblgenomenTegels5,lblScore5);
            case 4:
                lblnaamSpeler4= new Label(dc.getNaam(3)); 
                lblnaamSpeler4.setStyle("-fx-font-weight: bold;");
                lblnaamSpeler4.setFont(javafx.scene.text.Font.font(20));
                lblgenomenTegels4= new Label("Nog geen genomen tegels.");
                lblScore4= new Label("0"); 
                spelers[6].getChildren().addAll(lblnaamSpeler4,lblgenomenTegels4,lblScore4);
            case 3:
                lblnaamSpeler3= new Label(dc.getNaam(2)); 
                lblnaamSpeler3.setStyle("-fx-font-weight: bold;");
                lblgenomenTegels3= new Label("Nog geen genomen tegels.");
                lblnaamSpeler3.setFont(javafx.scene.text.Font.font(20));
                lblScore3= new Label("0"); 
                spelers[6].getChildren().addAll(lblnaamSpeler3,lblgenomenTegels3,lblScore3);
            case 2:
                
                lblgenomenTegels2= new Label("Nog geen genomen tegels.");
                lblnaamSpeler2 = new Label(this.dc.getNaam(1));
                lblnaamSpeler1 = new Label(this.dc.getNaam(0));
                lblnaamSpeler2.setFont(javafx.scene.text.Font.font(20));
                lblnaamSpeler1.setFont(javafx.scene.text.Font.font(20));
                lblnaamSpeler2.setStyle("-fx-font-weight: bold;");
                lblnaamSpeler1.setStyle("-fx-font-weight: bold;");
                lblScore1 = new Label("0");
                lblgenomenTegels1= new Label("Nog geen genomen tegels.");
                lblScore2 = new Label("0");
                spelers[1].getChildren().addAll(lblnaamSpeler1,lblgenomenTegels1,lblScore1,lblnaamSpeler2,lblgenomenTegels2,lblScore2);
                break;
        }
        lblsom = new Label("u som is momenteel " + dc.getSom());
        lblDobbelstenenAanKant = new Label("nog geen dobbelstenen aan de kant");
        info.getChildren().addAll(lblCommunicatie,lblspelerAanBeurt,lblsom,lblDobbelstenenAanKant);
        for (int i = 0; i < dc.getAantalSpelers(); i++) {
            grid.add(spelers[i],0,i);
        }
        grid.add(info, 0,dc.getAantalSpelers());
        VBox knoppen = new VBox();
        Scene sceneKnoppen  = new Scene(knoppen,100,500);
        knoppen.setMaxHeight(100);
        knoppen.setMaxWidth(500);
        knoppen.setBackground(Background.EMPTY);
        knoppen.getChildren().addAll(btnDobbelen,btnStoppen,btnOpgeven);
        this.getChildren().add(knoppen);
        knoppen.setAlignment(Pos.BOTTOM_LEFT);
        
        btnStoppen.setOnAction(this::spelStoppen);
        btnDobbelen.setOnAction(this::gooiDobbelstenen);
        btnOpgeven.setOnAction(this::opgeven);
        
        HBox tegelsPane = new HBox();
        tegelsPane.setMaxWidth(1080);
        tegelsPane.setMaxHeight(200);
        tegelsPane.setBackground(Background.EMPTY);
        Scene sceneTegels  = new Scene(tegelsPane,100,100);
        for (int nummer = 0; nummer < 16; nummer++) {
           tegelsPane.getChildren().add(tegels[nummer]);
           
        }
        this.getChildren().addAll(tegelsPane);
        grid.add(knoppen, 0, dc.getAantalSpelers()+2);
        grid.add(tegelsPane, 2, dc.getAantalSpelers()+1);
        this.getChildren().add(grid);
    }
    
    private void spelStoppen(ActionEvent event)
    {
        Hoofdscherm.toonScorebord(dc);
    }
    
    private void tegelNemen(int nummer)
    {
        boolean worm = false;
            for (int i = 0; i < 8; i++) {
                if (dc.getDobbelsteenGepakt(i) == true && dc.getDobbelsteen(i).equals("worm")) {
                    worm = true;
                }
            }
        int tegel = nummer-21;
        if (dc.getTegelPositie(tegel).equals("tafel") && dc.getSom() >= nummer && worm == true) 
        {
            dc.tegelToevoegen(tegel);
            int check = 0;
            for (int i = 0; i < 15; i++) {
                if (!dc.getTegelPositie(i).equals("tafel")) {
                    check++;
                }
            }
            if (check == 16) {
                Hoofdscherm.toonScorebord(dc);
            }
            dc.reset();
            
            String genomen1 = "",genomen2= "",genomen3= "",genomen4= "",genomen5= "",genomen6= "",genomen7= "";
                 for (int index = 0; index < 16; index++) {
                switch(dc.getTegelPositie(index))
                {
                    case "6":
                        genomen7 = genomen7+" " + dc.getTegel(index);
                        break;
                    case "5":
                        genomen6 = genomen6 +" " + dc.getTegel(index);
                        break;
                    case "4":
                        genomen5 = genomen5 +" " + dc.getTegel(index);
                        break;
                    case "3":
                        genomen4 = genomen4 + " " +dc.getTegel(index);
                        break;
                    case "2":
                        genomen3 = genomen3 +" " + dc.getTegel(index);
                        break;
                    case "1":
                        genomen2 = genomen2 +" " + dc.getTegel(index);
                        break;
                    case "0":
                        genomen1 = genomen1 +" " + dc.getTegel(index);
                        break;
                }
                }
                 switch(dc.getAantalSpelers())
                 {
                    case 7:lblgenomenTegels7.setText(genomen7);
                    case 6:lblgenomenTegels6.setText(genomen6); 
                    case 5:lblgenomenTegels5.setText(genomen5);
                    case 4:lblgenomenTegels4.setText(genomen4);
                    case 3:lblgenomenTegels3.setText(genomen3);
                    case 2:
                        lblgenomenTegels2.setText(genomen2);
                        lblgenomenTegels1.setText(genomen1); 
                          break;                   
                 }
                    
                    
                    
                    
                    
                    
            lblDobbelstenenAanKant.setText("nog geen dobbelstenen aan de kant");        
            dc.setSpelerAanBeurt();
            tegelUpdate();
            
            dobbelstenenUpdate();
            scoreUpdate();
            lblsom.setText("U som is momenteel " + dc.getSom());
            lblspelerAanBeurt.setText("Het is nu aan speler " + dc.getNaam(dc.getSpelerAanBeurt()));
            btnDobbelen.setDisable(false);
        btnDobbelen.setVisible(true);
        }
        else
        {
            lblCommunicatie.setText("U kunt deze waarde niet kiezen");
        }
        
        grid.getChildren().remove(dobbelstenenGegooid); 
        
    }
    private void gooiDobbelstenen(ActionEvent event)
    {
        
        dc.rolDobbelstenen();
        dobbelstenenUpdate();
        btnDobbelen.setDisable(true);
        btnDobbelen.setVisible(false);
        
            
    }
    private void dobbelstenenNemen(String teller)
    {
        
        boolean gepakt = false;
        for (int i = 0; i < 8; i++) {
            if (dc.getDobbelsteen(i).equals(teller) && dc.getDobbelsteenGepakt(i) == true) {
                gepakt = true;
            }
        }
        if (gepakt == true) {
            lblCommunicatie.setText("U heeft deze dobbelsteen al gepakt");
            
        }else
        {
            
            
            
            int kleinste = 21;
            for (int i = 15; i >= 0; i--) {
                if (dc.getTegelPositie(i).equals("tafel")) {
                    kleinste = dc.getTegel(i);
                }
            }
            
            int aantal=0;
            boolean worm = false;
            for (int i = 0; i < 8; i++) {
                if (dc.getDobbelsteenGepakt(i) == true && dc.getDobbelsteen(i).equals("worm")) {
                    worm = true;
                }
            }
            for (int i = 0; i < 8; i++) {
                if(dc.getDobbelsteenGepakt(i) == true)
                {
                    aantal= aantal +1;
                }
            }
        
            
           for (int i = 0; i < 8; i++) {
                if (dc.getDobbelsteen(i).equals(teller) && dc.getDobbelsteenGepakt(i) == false) {
                    dc.pakDobbelstenen(dc.getDobbelsteen(i), i);
                }
            }
        lblsom.setText(Integer.toString(dc.getSom()));
        String kant = "";
        for (int index = 0; index < 8; index++) 
            {
                if (dc.getDobbelsteenGepakt(index) ==true) 
                {
                   kant = kant + " " + dc.getDobbelsteen(index);
                }
            }
        lblDobbelstenenAanKant.setText(kant);
        lblsom.setText("u som is momenteel " + dc.getSom());
        btnDobbelen.setDisable(false);
        btnDobbelen.setVisible(true);
        tegelUpdate();
        scoreUpdate();
        grid.getChildren().remove(dobbelstenenGegooid); 
        
        }
        
    }
    private void steelTegel(int tegel)
    {
        
        String verliezendeSpeler = "";
            for (int index = 0; index < 16; index++) {
                if (tegel == dc.getTegel(index)) {
                    verliezendeSpeler = dc.getTegelPositie(index);
                }
                
            }
            dc.TegelVerliezen(verliezendeSpeler);
            dc.tegelToevoegen(tegel-21); 
            
        
            dc.reset();
                 dc.setSpelerAanBeurt();
                 dobbelstenenUpdate();
                 String aanKant = "";
                 for (int i = 0; i < 8; i++) {
                    aanKant = aanKant + dc.getDobbelsteen(i);
                    }
                 lblDobbelstenenAanKant.setText(aanKant);
                 aanKant="";
                 tegelUpdate();
                 scoreUpdate();
                String genomen1 = "",genomen2= "",genomen3= "",genomen4= "",genomen5= "",genomen6= "",genomen7= "";
                 for (int index = 0; index < 16; index++) {
                switch(dc.getTegelPositie(index))
                {
                    case "6":
                        genomen7 = genomen7 + " " + dc.getTegel(index);
                        lblgenomenTegels7.setText(genomen7);
                        break;
                    case "5":
                        genomen6 = genomen6 + " " +dc.getTegel(index);
                        lblgenomenTegels6.setText(genomen6); 
                        break;
                    case "4":
                        genomen5 = genomen5 + " " +dc.getTegel(index);
                        lblgenomenTegels5.setText(genomen5);
                        break;
                    case "3":
                        genomen4 = genomen4 + " " +dc.getTegel(index);
                        lblgenomenTegels4.setText(genomen4);
                        break;
                    case "2":
                        genomen3 = genomen3 + " " +dc.getTegel(index);
                        lblgenomenTegels3.setText(genomen3);
                        break;
                    case "1":
                        genomen2 = genomen2 + " " +dc.getTegel(index);
                        lblgenomenTegels2.setText(genomen2);
                        break;
                    case "0":
                        genomen1 = genomen1 + " " +dc.getTegel(index);
                        lblgenomenTegels1.setText(genomen1); 
                        break;
                }
                }
                    
                    
               btnDobbelen.setDisable(false);
                btnDobbelen.setVisible(true);     
                    
                    
                    
                    
          
    }
    private void dobbelstenenUpdate()
    {
        dobbelstenenGegooid = new HBox();
        for (int teller = 0; teller < 8; teller++) 
        {
            if (dc.getDobbelsteenGepakt(teller) == false) {
                switch(dc.getDobbelsteen(teller))
            {
                case "1":
                    
                    gegooideDobbelstenen[teller].setImage(dobbelsteen1);
                    gegooideDobbelstenen[teller].setOnMouseClicked((MouseEvent event) -> {
                        dobbelstenenNemen("1");
                    });
                    break;
                case "2":
                    
                    gegooideDobbelstenen[teller].setImage(dobbelsteen2);
                    gegooideDobbelstenen[teller].setOnMouseClicked((MouseEvent event) -> {
                        dobbelstenenNemen("2");
                    });
                    break;
                case "3":
                    
                    gegooideDobbelstenen[teller].setImage(dobbelsteen3);
                    gegooideDobbelstenen[teller].setOnMouseClicked((MouseEvent event) -> {
                        dobbelstenenNemen("3");
                    });
                    break;
                case "4":
                    
                    gegooideDobbelstenen[teller].setImage(dobbelsteen4);
                    gegooideDobbelstenen[teller].setOnMouseClicked((MouseEvent event) -> {
                        dobbelstenenNemen("4");
                    });
                    break;
                case "5":
                    
                    gegooideDobbelstenen[teller].setImage(dobbelsteen5);
                    gegooideDobbelstenen[teller].setOnMouseClicked((MouseEvent event) -> {
                        dobbelstenenNemen("5");
                    });
                    break;
                case "worm":
                    
                    gegooideDobbelstenen[teller].setImage(dobbelsteen6);
                    gegooideDobbelstenen[teller].setOnMouseClicked((MouseEvent event) -> {
                        dobbelstenenNemen("worm");
                    });
                    break;
            }
            }else
            {
                gegooideDobbelstenen[teller].imageProperty().set(null);
            }}
            
        
        for (int nummer = 0; nummer < 8; nummer++) {
            gegooideDobbelstenen[nummer].setFitHeight(200);
            gegooideDobbelstenen[nummer].setFitWidth(200);
            gegooideDobbelstenen[nummer].setPreserveRatio(true);
        }
        dobbelstenenGegooid.setBackground(Background.EMPTY);
        for (int i = 0; i < 8; i++) {
            dobbelstenenGegooid.getChildren().add(gegooideDobbelstenen[i]);
        }
             
        Scene sceneDobbelstenenGegooid  = new Scene(dobbelstenenGegooid,800,200);
        
        grid.add(dobbelstenenGegooid,2,dc.getAantalSpelers()+3);
    }
    private void tegelUpdate()
    {
        if (dc.getTegelPositie(0).equals("tafel") && dc.getSom() >= 21) {
            tegels[0].setImage(tegel21);
            tegels[0].setOnMouseClicked((MouseEvent event) -> {
            tegelNemen(21);
        });  
        }else if(dc.getSom() == 21 && dc.getStackWaarde(0) == 1 && !dc.getTegelPositie(0).equals("omgedraaid") && !dc.getTegelPositie(0).equals("tafel"))
        {
            tegels[0].setImage(tegel21);
            tegels[0].setOnMouseClicked((MouseEvent event) -> {
            steelTegel(21);
        });
        }else
        {
            tegels[0].setImage(tegel21Trans);
        }
        
        if (dc.getTegelPositie(1).equals("tafel") && dc.getSom() >= 22)
        {
            tegels[1].setImage(tegel22);
            tegels[1].setOnMouseClicked((MouseEvent event) -> {
            tegelNemen(22);
        }); 
        }else if(dc.getSom() == 22 && dc.getStackWaarde(1) == 1 && !dc.getTegelPositie(1).equals("omgedraaid") && !dc.getTegelPositie(1).equals("tafel"))
        {
            tegels[1].setImage(tegel21);
            tegels[1].setOnMouseClicked((MouseEvent event) -> {
            steelTegel(22);
        });
        }else
        {
            tegels[1].setImage(tegel22Trans);
        }
        /////////////////////////////////////////////////////////
        if (dc.getTegelPositie(2).equals("tafel") && dc.getSom() >= 23) {
            tegels[2].setImage(tegel23);
            tegels[2].setOnMouseClicked((MouseEvent event) -> {
            tegelNemen(23);
        });  
        }else if(dc.getSom() == 23 && dc.getStackWaarde(2) == 1 && !dc.getTegelPositie(2).equals("omgedraaid") && !dc.getTegelPositie(2).equals("tafel")){
            tegels[2].setImage(tegel23);
            tegels[2].setOnMouseClicked((MouseEvent event) -> {
            steelTegel(23);
        });
        }else
        {
            
            tegels[2].setImage(tegel23Trans);
        }
        if (dc.getTegelPositie(3).equals("tafel") && dc.getSom() >= 24) {
            
            tegels[3].setImage(tegel24);
            tegels[3].setOnMouseClicked((MouseEvent event) -> {
            tegelNemen(24);
        });  
        }else if(dc.getSom() == 24 && dc.getStackWaarde(3) == 1 && !dc.getTegelPositie(3).equals("omgedraaid") && !dc.getTegelPositie(3).equals("tafel"))
        {
            
            tegels[3].setImage(tegel24);
            tegels[3].setOnMouseClicked((MouseEvent event) -> {
            steelTegel(24);
        });        
        }else
        {
            
            tegels[3].setImage(tegel24Trans);
        }
        if (dc.getTegelPositie(4).equals("tafel") && dc.getSom() >= 25) {
            tegels[4].setImage(tegel25);
            tegels[4].setOnMouseClicked((MouseEvent event) -> {
            tegelNemen(25);
        });  
        }else if(dc.getSom() == 25 && dc.getStackWaarde(4) == 1 && !dc.getTegelPositie(4).equals("omgedraaid") && !dc.getTegelPositie(4).equals("tafel"))
                    {
            tegels[4].setImage(tegel25);
            tegels[4].setOnMouseClicked((MouseEvent event) -> {
            steelTegel(25);
        }); 
        }else
        {
            
            tegels[4].setImage(tegel25Trans);
        }
        if (dc.getTegelPositie(5).equals("tafel") && dc.getSom() >= 26) {
            
            tegels[5].setImage(tegel26);
            tegels[5].setOnMouseClicked((MouseEvent event) -> {
            tegelNemen(26);
        });  
            }else if(dc.getSom() == 26 && dc.getStackWaarde(5) == 1 && !dc.getTegelPositie(5).equals("omgedraaid") && !dc.getTegelPositie(5).equals("tafel"))
                    {
            
            tegels[5].setImage(tegel26);
            tegels[5].setOnMouseClicked((MouseEvent event) -> {
            steelTegel(26);
        });          
        }else
        {
            
            tegels[5].setImage(tegel27Trans);
        }
        if (dc.getTegelPositie(6).equals("tafel") && dc.getSom() >= 27) {
            
            tegels[6].setImage(tegel27);
            tegels[6].setOnMouseClicked((MouseEvent event) -> {
            tegelNemen(27);
        });  
        }else if(dc.getSom() == 27 && dc.getStackWaarde(6) == 1 && !dc.getTegelPositie(6).equals("omgedraaid") && !dc.getTegelPositie(6).equals("tafel"))
        {
            
            tegels[6].setImage(tegel27);
            tegels[6].setOnMouseClicked((MouseEvent event) -> {
            steelTegel(27);
            });  
        }else
        {
            
            tegels[6].setImage(tegel27Trans);
        }
        if (dc.getTegelPositie(7).equals("tafel") && dc.getSom() >= 28) {
            
            tegels[7].setImage(tegel28);
            tegels[7].setOnMouseClicked((MouseEvent event) -> {
            tegelNemen(28);
        });  
            }else if(dc.getSom() == 28 && dc.getStackWaarde(7) == 1 && !dc.getTegelPositie(7).equals("omgedraaid") && !dc.getTegelPositie(7).equals("tafel"))
        {
            
            tegels[7].setImage(tegel28);
            tegels[7].setOnMouseClicked((MouseEvent event) -> {
            steelTegel(28);
        });  
        }else
        {
            
            tegels[7].setImage(tegel28Trans);
        }
        if (dc.getTegelPositie(8).equals("tafel") && dc.getSom() >= 29) {
            
            tegels[8].setImage(tegel29);
            tegels[8].setOnMouseClicked((MouseEvent event) -> {
            tegelNemen(29);
        });  
            }else if(dc.getSom() == 29 && dc.getStackWaarde(8) == 1 && !dc.getTegelPositie(8).equals("omgedraaid") && !dc.getTegelPositie(8).equals("tafel"))
                    {
                        
            tegels[8].setImage(tegel29);
            tegels[8].setOnMouseClicked((MouseEvent event) -> {
            steelTegel(29);}); 
        }else
        {
            
            tegels[8].setImage(tegel29Trans);
        }
        if (dc.getTegelPositie(9).equals("tafel") && dc.getSom() >= 30) {
            
            tegels[9].setImage(tegel30);
            tegels[9].setOnMouseClicked((MouseEvent event) -> {
            tegelNemen(30);
        });  
            }else if(dc.getSom() == 30 && dc.getStackWaarde(9) == 1 && !dc.getTegelPositie(9).equals("omgedraaid") && !dc.getTegelPositie(9).equals("tafel"))
                    {
                        
            tegels[9].setImage(tegel30);
            tegels[9].setOnMouseClicked((MouseEvent event) -> {
            steelTegel(30);
        });  
        }else
        {
            
            tegels[9].setImage(tegel30Trans);
        }
        if (dc.getTegelPositie(10).equals("tafel") && dc.getSom() >= 31) {
           
            tegels[10].setImage(tegel31);
            tegels[10].setOnMouseClicked((MouseEvent event) -> {
            tegelNemen(31);
        });  
            }else if(dc.getSom() == 31 && dc.getStackWaarde(10) == 1 && !dc.getTegelPositie(10).equals("omgedraaid") && !dc.getTegelPositie(10).equals("tafel"))
                    {
                        
            tegels[10].setImage(tegel31);
            tegels[10].setOnMouseClicked((MouseEvent event) -> {
            steelTegel(31);
        });  
        }else
        {
            
            tegels[10].setImage(tegel31Trans);
        }
        if (dc.getTegelPositie(11).equals("tafel") && dc.getSom() >= 32) {
            
            tegels[11].setImage(tegel32);
            tegels[11].setOnMouseClicked((MouseEvent event) -> {
            tegelNemen(32);
        });  
            }else if(dc.getSom() == 32 && dc.getStackWaarde(11) == 1 && !dc.getTegelPositie(11).equals("omgedraaid") && !dc.getTegelPositie(11).equals("tafel"))
                    {
                        
            tegels[11].setImage(tegel32);
            tegels[11].setOnMouseClicked((MouseEvent event) -> {
            steelTegel(32);
        }); 
        }else
        {
            
            tegels[11].setImage(tegel32Trans);
        }
        if (dc.getTegelPositie(12).equals("tafel") && dc.getSom() >= 33) {
            
            tegels[12].setImage(tegel33);
            tegels[12].setOnMouseClicked((MouseEvent event) -> {
            tegelNemen(33);
        });  
            }else if(dc.getSom() == 33 && dc.getStackWaarde(12) == 1 && !dc.getTegelPositie(12).equals("omgedraaid") && !dc.getTegelPositie(12).equals("tafel"))
                    {
                        
            tegels[12].setImage(tegel33);
            tegels[12].setOnMouseClicked((MouseEvent event) -> {
            steelTegel(33);
        });  
        }else
        {
            
            tegels[12].setImage(tegel33Trans);
        }
        if (dc.getTegelPositie(13).equals("tafel") && dc.getSom() >= 34) {
            
            tegels[13].setImage(tegel34);
            tegels[13].setOnMouseClicked((MouseEvent event) -> {
            tegelNemen(34);
        }); 
            }else if(dc.getSom() == 34 && dc.getStackWaarde(13) == 1 && !dc.getTegelPositie(13).equals("omgedraaid") && !dc.getTegelPositie(13).equals("tafel"))
                    {
                        
            tegels[13].setImage(tegel34);
            tegels[13].setOnMouseClicked((MouseEvent event) -> {
            steelTegel(34);
        }); 
        }else
        {
            
            tegels[13].setImage(tegel34Trans);
        }
        if (dc.getTegelPositie(14).equals("tafel") && dc.getSom() >= 35) {
            
            tegels[14].setImage(tegel35);
            tegels[14].setOnMouseClicked((MouseEvent event) -> {
            tegelNemen(35);
        });  
            }else if( dc.getSom() == 35 && dc.getStackWaarde(14) == 1 && !dc.getTegelPositie(14).equals("omgedraaid") && !dc.getTegelPositie(14).equals("tafel"))
                    {
                        
            tegels[14].setImage(tegel35);
            tegels[14].setOnMouseClicked((MouseEvent event) -> {
            steelTegel(35);
        });  
        }else
        {
            
            tegels[14].setImage(tegel35Trans);
        }
        if (dc.getTegelPositie(15).equals("tafel") && dc.getSom() >= 36) {
            
            tegels[15].setImage(tegel36);
            tegels[15].setOnMouseClicked((MouseEvent event) -> {
            tegelNemen(36);
        }); 
            }else if(dc.getSom() == 36 && dc.getStackWaarde(15) == 1 && !dc.getTegelPositie(15).equals("omgedraaid") && !dc.getTegelPositie(15).equals("tafel"))
                    {
                        
            tegels[15].setImage(tegel36);
            tegels[15].setOnMouseClicked((MouseEvent event) -> {
            steelTegel(36);
        });  
        }else
        {
            
            tegels[15].setImage(tegel36Trans);
        }
        for (int nummer = 0; nummer < 16; nummer++) {
            tegels[nummer].setFitHeight(200);
            tegels[nummer].setFitWidth(200);
            tegels[nummer].setPreserveRatio(true);
        }
        
    }
    
    private void scoreUpdate()
    {
        dc.scoreBerekenen();
        switch(dc.getAantalSpelers())
        {
            case 7:
                lblScore7.setText(Integer.toString(dc.getScore(6)));
            case 6:
                lblScore6.setText(Integer.toString(dc.getScore(5)));
            case 5:
                lblScore5.setText(Integer.toString(dc.getScore(4)));
            case 4:
                lblScore4.setText(Integer.toString(dc.getScore(3)));
            case 3:
                lblScore3.setText(Integer.toString(dc.getScore(2)));
            case 2:
                lblScore1.setText(Integer.toString(dc.getScore(0)));
                lblScore2.setText(Integer.toString(dc.getScore(1)));
                break;
        }
    }
    
    private void opgeven(ActionEvent event)
    {
        if (dc.getScore(dc.getSpelerAanBeurt()) >= 1) {
         dc.TegelVerliezen(Integer.toString(dc.getSpelerAanBeurt()));
         lblCommunicatie.setText("Jammer u beurt is onsuccesvol u verliest u bovenste tegel en de laatste tegel word omgedraaid");
        }
        else
        {
            lblCommunicatie.setText("Jammer u beurt is onsuccesvol de laatste tegel word omgedraaid");
        }

        for (int index = 16; index == 0; index--) 
            {
                if (dc.getTegelPositie(index).equals("tafel")) {
                    dc.setTegelPositie(index,"omgedraaid");
                    index=0;
                }
            }
        dc.reset();
        dc.setSpelerAanBeurt();
        lblspelerAanBeurt.setText("Het is nu aan speler "+dc.getNaam(dc.getSpelerAanBeurt()));
        lblsom.setText("U som is momenteel "+ dc.getSom());
        lblDobbelstenenAanKant.setText("");
        scoreUpdate();
        tegelUpdate();
        dobbelstenenUpdate();
        String genomen1 = "",genomen2= "",genomen3= "",genomen4= "",genomen5= "",genomen6= "",genomen7= "";
        for (int index = 0; index < 16; index++) {
                switch(dc.getTegelPositie(index))
                {
                    case "6":
                        genomen7 = genomen7 + " " + dc.getTegel(index);
                        lblgenomenTegels7.setText(genomen7);
                        break;
                    case "5":
                        genomen6 = genomen6 + " " +dc.getTegel(index);
                        lblgenomenTegels6.setText(genomen6); 
                        break;
                    case "4":
                        genomen5 = genomen5 + " " +dc.getTegel(index);
                        lblgenomenTegels5.setText(genomen5);
                        break;
                    case "3":
                        genomen4 = genomen4 + " " +dc.getTegel(index);
                        lblgenomenTegels4.setText(genomen4);
                        break;
                    case "2":
                        genomen3 = genomen3 + " " +dc.getTegel(index);
                        lblgenomenTegels3.setText(genomen3);
                        break;
                    case "1":
                        genomen2 = genomen2 + " " +dc.getTegel(index);
                        lblgenomenTegels2.setText(genomen2);
                        break;
                    case "0":
                        genomen1 = genomen1 + " " +dc.getTegel(index);
                        lblgenomenTegels1.setText(genomen1); 
                        break;
                }
                }
        grid.getChildren().remove(dobbelstenenGegooid); 
    }
}

