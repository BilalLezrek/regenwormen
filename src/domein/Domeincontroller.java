package domein;

import java.time.LocalDate;

public class Domeincontroller 
{
    Spel spel;
    
    public Domeincontroller(){
        this.spel = new Spel();
    }
    
    public void setAantalSpelers(int aantal)
    {
        spel.setAantalSpelers(aantal);
    }
    public int getAantalSpelers()
    {
        return spel.getAantalSpelers();
    }
    public void setNaam(int speler,String naam)
    {
       spel.setNaamSpeler(speler, naam);
    }
    public String getNaam(int speler)
    {
       return spel.getNaam(speler);
    }
    public int getTegel(int tegel)
    {
       return spel.getTegel(tegel);
    }
    
    public int getSom()
    {
       return spel.getSom();
    }
    public void setDatum(int speler,LocalDate datum)
    {
        spel.setGeboorteDatum(speler, datum);
    }
    public void createTegels()
    {
        spel.createTegels();
    }
    public void setBeurt()
    {
        spel.setBeurt();
    }
    public int getBeurt(int speler)
    {
       return spel.getBeurt(speler);
    }
    public int getSpelerAanBeurt()
    {
        return spel.getSpelerAanBeurt();
    }
    public String getDobbelsteen(int dobbelsteen)
    {
        return spel.getDobbelsteen(dobbelsteen);
    }
    public LocalDate getDatum(int speler)
    {
        return spel.getDatum(speler);
    }
    public boolean getDobbelsteenGepakt(int dobbelsteen)
    {
        return spel.getDobbelsteenGepakt(dobbelsteen);
    }
    public int rolDobbelstenen()
    {
         return spel.rolDobbelstenen();
    }
    public void pakDobbelstenen(String waaarde,int index)
    {
        spel.pakDobbelstenen(waaarde,index);
    }
    public void createDobbelstenen()
    {
        spel.createDobbelstenen();
        spel.createTegels();
    }
    public void setSpelerAanBeurt()
    {
        spel.setSpelerAanBeurt();
    }
    public int zoekSpeler()
    {
        return spel.zoekSpeler();
    }
    public void reset()
    {
        spel.reset();
    }
    public boolean DobbelsteenBeschikbaar()
    {
        return spel.DobbelsteenBeschikbaar();
    }

    public String getTegelPositie(int i) {
        return spel.getTegelPositie(i);
    }

    public int getStackWaarde(int i) {
        return spel.getStackWaarde(i);
    }

    public void setTegelPositie(int i, String omgedraaid) {
        spel.setTegelPositie(i,omgedraaid);
    }

    public void setStackwaarde(int tegel,int stackWaarde) {
        spel.setStackwaarde(tegel,stackWaarde);
    }

    public void tegelToevoegen(int tegel) {
        spel.tegelToevoegen(tegel);
    }

    public void TegelVerliezen(String verliezendeSpeler) {
        spel.tegelVerliezen(verliezendeSpeler);
    }
    public void scoreBerekenen()
    {
        spel.scoreBerekenen();
    }

    public int getScore(int speler)
    {
        return spel.getScore(speler);
    }
    public int berekenWinnaar()
    {
        return spel.berekenWinnaar();
    }
}
