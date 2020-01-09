package domein;
public class Dobbelstenen 
{
    private String waarde;
    private boolean genomen;
    
    public Dobbelstenen()
    {
        this.waarde = "0";
        this.genomen = false;
    }
    public String getWaarde()
    {
        return waarde;
    }
    public void setWaarde(String waarde)
    {
        this.waarde = waarde;
    }
    public boolean getGenomen()
    {
        return genomen;
    }
    public void setGenomen(boolean genomen)
    {
        this.genomen = genomen;
    }
}
