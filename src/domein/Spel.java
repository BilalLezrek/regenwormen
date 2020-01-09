package domein;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
public class Spel 
{
    
    private String dobbelWaarde;
    private int random;
    private int aantalSpelers;
    private int spelerAanBeurt = 0;
    private int som;
    
    Random rand = new Random();
    
    Tegels[] tegel = new Tegels[16];
    Dobbelstenen[] dobbelsteen = new Dobbelstenen[8];
    Spelers[] speler = new Spelers[7];
    public Spel()
    {
        
        this.aantalSpelers = 7;
        createTegels();
        createDobbelstenen();
        
    }
    public void setAantalSpelers(int aantal)
    {
        this.aantalSpelers = aantal;
    }
    public int getAantalSpelers()
    {
        return aantalSpelers;
    }
    public int getSom()
    {
        return som;
    }
    public int getBeurt(int speler)
    {
        return this.speler[speler].getBeurt();
    }
    public String getNaam(int speler)
    {
        return this.speler[speler].getNaam();
    }
    public int getSpelerAanBeurt()
    {
        return spelerAanBeurt;
    }
    public int getTegel(int tegel)
    {
       return this.tegel[tegel].getWaarde();
    }
    public void setSpelerAanBeurt()
    {
        if (spelerAanBeurt == aantalSpelers-1) {
            spelerAanBeurt=0;
        }else{
        spelerAanBeurt = spelerAanBeurt + 1;}
        
    }
    public void createTegels()
    {
        for (int index = 21; index <= 36; index++) {
            
            tegel[index-21] = new Tegels(index);
            
            if (index <= 24) {
              tegel[index-21].setRegenwormen(1);
            }
            if (index > 24 && index <= 28) {
               tegel[index-21].setRegenwormen(2); 
            }
            if (index > 28 && index <= 32) {
                tegel[index-21].setRegenwormen(3);
            }
            if (index > 32 && index <= 36) {
                tegel[index-21].setRegenwormen(4);
            }
        }
    }
    public String getDobbelsteen(int dobbelsteen)
    {
        return this.dobbelsteen[dobbelsteen].getWaarde();
    }
    public boolean getDobbelsteenGepakt(int dobbelsteen)
    {
        return this.dobbelsteen[dobbelsteen].getGenomen();
    }
    public void setNaamSpeler(int speler,String naam)
    {
        
            this.speler[speler] = new Spelers();
        
            this.speler[speler].setNaam(naam);
        
    }
    public void setGeboorteDatum(int speler,LocalDate datum)
    {
        
            this.speler[speler].setGeboorteDatum(datum);
            
    }
    public void setBeurt()
    {
        
        for (int index = 0; index < aantalSpelers; index++) {
            int beurt = 1;
            for (int j = 0; j < aantalSpelers; j++) {
                if (index != j) {
                    if (speler[index].getGeboorteDatum().compareTo(speler[j].getGeboorteDatum())<0) 
                    {
                        beurt++;
                    }
                }
                
            }
            speler[index].setBeurt(beurt);
        }
    }
    public void createDobbelstenen()
    {
        for (int index = 0; index < 8; index++) {
            this.dobbelsteen[index] = new Dobbelstenen();
        }
    }
    public int zoekSpeler()
    {
        int speler = 0;
        for (int index = 0; index < aantalSpelers; index++) {
            if (this.speler[index].getBeurt() == spelerAanBeurt+1) {
                speler = index;
            }
        }
        return speler;
    }
    public void reset()
    {
        for (int index = 0; index < 8; index++) {
            dobbelsteen[index].setGenomen(false);
        }
        som = 0;
    }
    
    public int rolDobbelstenen()
    {  
        int check=0;
        for (int index = 0; index < 8; index++) {
            if (dobbelsteen[index].getGenomen() == false) {
            random = rand.nextInt(6);
            random = random + 1;
            if (random == 6) {
                    dobbelWaarde = "worm";
                }else{
            dobbelWaarde = Integer.toString(random);}
                
            dobbelsteen[index].setWaarde(dobbelWaarde);
            }else
            {
                check++;
            }
        }
        return check;
    }
    public boolean DobbelsteenBeschikbaar()
    {
        ArrayList<String> gepakteWaarde = new ArrayList<>();
        ArrayList<String> waardeTafel = new ArrayList<>();
        boolean beschikbaar = true;
                for (int index = 0; index < 8; index++) {
                    if (dobbelsteen[index].getGenomen()==false) {
                        waardeTafel.add(dobbelsteen[index].getWaarde());
                    }
                    else if (dobbelsteen[index].getGenomen()==true) {
                        gepakteWaarde.add(dobbelsteen[index].getWaarde());
                    }
                }
                if (gepakteWaarde.containsAll(waardeTafel)) {
                    beschikbaar = false;
                    
                }
                return beschikbaar;
    }
    public void pakDobbelstenen(String waarde,int index)
    {
        
            
            if (dobbelsteen[index].getGenomen() == false && dobbelsteen[index].getWaarde().equals(waarde)) {
                
                switch(waarde)
                {
                    case "1":
                        som = som + 1;
                        break;
                    case "2":
                        som = som + 2;
                        break;
                    case "3":
                        som = som + 3;
                        break;
                    case "4":
                        som = som + 4;
                        break;
                    case "5":
                        som = som + 5;
                        break;
                    case "worm":
                        som = som + 5;
                        break;
                }
                dobbelsteen[index].setGenomen(true);
            }
        }

    public String getTegelPositie(int index) {
        return tegel[index].getPositie();
    }

    public int getStackWaarde(int index) {
        return tegel[index].getstackWaarde();
    }

    public void setTegelPositie(int index, String omgedraaid) {
        tegel[index].setPositie(omgedraaid);
    }

    public void setStackwaarde(int tegel,int stackwaarde) {
        this.tegel[tegel].setstackWaarde(stackwaarde);
    }
     public void scoreBerekenen()
    {
        resetScores();
        for (int index = 0; index < 16; index++) {
            if (!tegel[index].getPositie().equals("tafel") && !tegel[index].getPositie().equals("omgedraaid")) {
            switch(Integer.parseInt(tegel[index].getPositie()))
            {
                case 0:
                speler[0].setScore(speler[0].getScore()+tegel[index].getRegenwormen());
                break;
                case 1:
                speler[1].setScore(speler[1].getScore()+tegel[index].getRegenwormen());
                break;
                case 2:
                speler[2].setScore(speler[2].getScore()+tegel[index].getRegenwormen());
                break;
                case 3:
                speler[3].setScore(speler[3].getScore()+tegel[index].getRegenwormen());
                break;
                case 4:
                speler[4].setScore(speler[4].getScore()+tegel[index].getRegenwormen());
                break;
                case 5:
                speler[5].setScore(speler[5].getScore()+tegel[index].getRegenwormen()); 
                break;
                case 6:
                speler[6].setScore(speler[6].getScore()+tegel[index].getRegenwormen()); 
                break;
                
                    
            }
            }
        }
    }
     public void resetScores()
     {
         for (int index = 0; index < aantalSpelers; index++) {
             speler[index].setScore(0);
         }
     }

    public void tegelToevoegen(int tegel) {
        for (int index = 0; index < 16; index++) {
                    if (this.tegel[index].getPositie().equals(Integer.toString(zoekSpeler()))) 
                    {
                        this.tegel[index].setstackWaarde(this.tegel[index].getstackWaarde()+1);
                    }
                }
                this.tegel[tegel].setPositie(Integer.toString(zoekSpeler()));
                this.tegel[tegel].setstackWaarde(this.tegel[tegel].getstackWaarde()+1);
    }

    public void tegelVerliezen(String verliezendeSpeler) {
        for (int index = 0; index < 16; index++) {
                    if (tegel[index].getPositie().equals(verliezendeSpeler)) 
                    {
                        tegel[index].setstackWaarde(tegel[index].getstackWaarde()-1);
                        if (tegel[index].getstackWaarde() == 0) {
                            tegel[index].setPositie("tafel");
                        }
                    }
                }
    }
    public LocalDate getDatum(int speler)
    {
        return this.speler[speler].getGeboorteDatum();
    }
    public int getScore(int speler) 
    {
        return this.speler[speler].getScore();
    }
    public int berekenWinnaar()
    {
        int winnaar = 0;
        int score = 0;
        for (int index = 0; index < aantalSpelers; index++) {
            if (speler[index].getScore()>score) {
                score = speler[index].getScore();
                winnaar = index;
            }
            if(speler[index].getScore()==score)
            {
                int som1 = 0;
                int som2 = 0;
                for (int j = 0; j < 16; j++) {
                    if (tegel[index].getPositie().equals(Integer.toString(index))) {
                        som1 = som1 + tegel[j].getWaarde();
                    }
                    if (tegel[index].getPositie().equals(Integer.toString(winnaar))) {
                        som2 = som2 + tegel[j].getWaarde();
                    }
                }
                if (som2 < som1) {
                    winnaar = index;
                }
                if (som2 == som1) {
                    if (speler[index].getGeboorteDatum().compareTo(speler[winnaar].getGeboorteDatum()) < 0) {
                        winnaar = index;
                    }
                }
            }
        }
        return winnaar;
    }
    }
