package main;

import domein.Domeincontroller;
import ui.RegenwormenUI;

public class StartUpUI 
{
    public static void main(String[] args) 
    {
        Domeincontroller dc = new Domeincontroller();
        RegenwormenUI Regenwormen = new RegenwormenUI(dc);
        Regenwormen.aantalSpelers();
    }
}

