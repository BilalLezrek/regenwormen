package domein;
public class Tegels 
{
    private int waarde;
    private String positie;
    private int stackWaarde;
    private int regenwormen;
    
    public Tegels(int waarde)
    {
        this.waarde = waarde;
        this.positie = "tafel";
        this.stackWaarde = 0;
        this.regenwormen = 1;
    }
    
    public int getWaarde()
    {
        return waarde;
    }
    public String getPositie()
    {
        return positie;
    }
    public int getstackWaarde()
    {
        return stackWaarde;
    }
    public void setWaarde(int waarde)
    {
        this.waarde = waarde;
    }
    public void setPositie(String positie)
    {
        this.positie = positie;
    }
    public void setstackWaarde(int stackWaarde)
    {
        this.stackWaarde = stackWaarde;
    }
    public int getRegenwormen()
    {
        return regenwormen;
    }
    public void setRegenwormen(int regenwormen)
    {
        this.regenwormen = regenwormen;
    }
}