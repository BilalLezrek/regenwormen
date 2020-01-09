package domein;

import java.time.LocalDate;

public class Spelers 
{
    private int beurt;
    private String naam;
    private LocalDate geboorteDatum;
    private boolean laatsteSpeler;
    private int score;
    
    public Spelers()
    {
    this.beurt = 1;
    this.naam = "Barry";
    this.laatsteSpeler = false;
    this.score = 0;
    }
    public int getBeurt()
    {
        return beurt;
    }
    public String getNaam()
    {
        return naam;
    }
    public LocalDate getGeboorteDatum()
    {
        return geboorteDatum;
    }
    public boolean getLaatsteSpeler()
    {
        return laatsteSpeler;
    }
    public int getScore()
    {
        return score;
    }
    public void setBeurt( int beurt)
    {
        this.beurt = beurt;
    }
    public void setNaam(String naam)
    {
        this.naam = naam;
    }
    public void setGeboorteDatum(LocalDate datum)
    {
        this.geboorteDatum = datum;
    }
    public void LaatsteSpeler(boolean laatste)
    {
        this.laatsteSpeler = laatste;
    }
    public void setScore(int score)
    {
        this.score = score;
    }  
}
