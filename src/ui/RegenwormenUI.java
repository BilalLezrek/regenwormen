package ui;

import domein.Domeincontroller;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;
public class RegenwormenUI 
{

    Scanner invoer = new Scanner(System.in);
    
    Domeincontroller dc = new Domeincontroller();

    public RegenwormenUI(Domeincontroller dc) {
       this.dc = dc;
    }
    
    public void aantalSpelers()
    {
        
        try{
            System.out.print("Hoeveel spelers zijn er aanwezig? ");
            dc.setAantalSpelers(invoer.nextInt());

                if (dc.getAantalSpelers() >= 2 && dc.getAantalSpelers() <= 7) 
                {
                   infoSpelers();
                }
                else
                {
                    System.out.println("Aantal spelers moet tussen 2 en 7 zitten.");
                    aantalSpelers();
                }
        }catch(InputMismatchException e)
        {
            invoer.next();
            System.out.println("Gelieve een getal in te geven");
            aantalSpelers();
        }
    }
    
    public void infoSpelers()
    {
        invoer.nextLine();
        try{
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("d/M/u");
        for (int index = 0; index < dc.getAantalSpelers(); index++)
        {
            System.out.printf("Naam speler %d: ",index+1);
            dc.setNaam(index,invoer.nextLine());
            System.out.printf("Geboortedatum speler %s (in dd/mm/jjjj formaat): ",dc.getNaam(index));
            String datum = invoer.nextLine();
            dc.setDatum(index,LocalDate.parse(datum, dateFormat));
        }
        }catch(Exception e)
        {
            System.out.print("Er is iet fout gegeaan gelieve uw gegevens nog eens in te voeren.");
            infoSpelers();
        }
        System.out.println("--------------------------------------------------------------");
        dc.setBeurt();
        dc.createTegels();
        dc.createDobbelstenen();
        spelBeginnen();
        
    }
    public void spelBeginnen()
    {
        boolean EindeSpel= false;
        do {
        boolean ronde = false;
        boolean gepakt = false;
        boolean geldig = false;
        boolean doorgaan = false;
        System.out.printf("Het is nu aan speler %s:%n",dc.getNaam(dc.zoekSpeler()));
        
        do{
            if (dc.rolDobbelstenen() <= 7) {
                System.out.println("--------------------------------------------------------------");
                System.out.printf("speler %s gooit: ",dc.getNaam(dc.zoekSpeler()));
                dc.rolDobbelstenen();
                    for (int index = 0; index < 8; index++) 
                    {
                        if (dc.getDobbelsteenGepakt(index)==false) 
                        {
                            System.out.printf(" %s",dc.getDobbelsteen(index));
                        }
                    }
                System.out.printf("%nU heeft deze dobbelstenen al gepakt: ");
            for (int index = 0; index < 8; index++) 
            {
                if (dc.getDobbelsteenGepakt(index) ==true) 
                {
                    System.out.printf(" %s",dc.getDobbelsteen(index));
                }
            }
            if (dc.DobbelsteenBeschikbaar() == true) 
            {
                doorgaan = false;
                    do {
                        doorgaan = false;
                        
                        System.out.printf("%nWelke dobbelstenen wilt u nemen?: ");
                        String waarde=invoer.nextLine();
                        if ("einde".equals(waarde)) {
                            for (int index = 0; index < 16; index++) {
                                dc.setTegelPositie(index, "0");
                                doorgaan = true;
                                ronde = true;
                            }
                        }else{
                            for (int index = 0; index < 8; index++) 
                            {
                                if (dc.getDobbelsteen(index).equals(waarde)) 
                                {
                                    geldig = true;
                                }
                            }
                            if ( geldig == true) 
                            {

                                for (int index = 0; index < 8; index++) 
                                {
                                    if (dc.getDobbelsteenGepakt(index)== true && dc.getDobbelsteen(index).equals(waarde))
                                    {
                                        gepakt = true;
                                    }
                                }
                                if (gepakt==true) 
                                {
                                    System.out.printf("al gepakt");
                                    gepakt = false;
                                }else
                                {
                                    for (int index = 0; index < 8; index++) 
                                    {
                                        if (gepakt == false) 
                                        {
                                        dc.pakDobbelstenen(waarde,index);
                                        doorgaan = true;
                                        }
                                    }
                                }
                            }else if(geldig == false)
                            {
                                System.out.print("nope");
                            }
                            geldig = false;
                        }
                        } while (doorgaan == false);
                    System.out.printf("u heeft nu een som van %d%n",dc.getSom());
                    boolean stopbaar=false;
                    int minimum = 0;
                for (int index = 15; index >= 0; index--) {
                    if (dc.getTegelPositie(index).equals("tafel")) {
                        minimum = dc.getTegel(index);
                    }
                }
                if (dc.getSom() >= minimum) 
                {
                    for (int index = 0; index < 8; index++) 
                    {
                        if (dc.getDobbelsteenGepakt(index) == true && "worm".equals(dc.getDobbelsteen(index))) 
                        {
                            for (int index2 = 0; index2 < 16; index2++) 
                            {
                                if (dc.getTegelPositie(index2).equals("tafel") && dc.getTegel(index2) <= dc.getSom()) 
                                {
                                    stopbaar = true;
                                }
                                else if(dc.getTegel(index2) == dc.getSom() && dc.getStackWaarde(index2) == 1 && !dc.getTegelPositie(index2).equals("tafel") && !dc.getTegelPositie(index2).equals("omgedraaid") && !dc.getTegelPositie(index2).equals(dc.zoekSpeler()))
                                {
                                    stopbaar = true;
                                }
                            }
                            
                        }
                    }
                }
            if (stopbaar == true) 
            {
                boolean verkeerdeInvoer = true;
                            do {
                            System.out.print("Wilt u Stoppen? ");
                            String stoppen= invoer.nextLine();
                    
                            if (stoppen.equals("ja")) {
                                tegelPakken();
                                ronde = true;
                                verkeerdeInvoer = false;
                                System.out.println("--------------------------------------------------------------");
                            }else if(stoppen.equals("nee"))
                            {
                                verkeerdeInvoer = false;
                            }
                            else{}
                        } while (verkeerdeInvoer == true);
                stopbaar = false;  
            }
            
            }else if(dc.DobbelsteenBeschikbaar()==false)
            {
             System.out.printf("%nronde mislukt u verliest u bovenste tegel%n");
             dc.TegelVerliezen(Integer.toString(dc.zoekSpeler()));
              for (int index = 16; index == 0; index--) 
            {
                if (dc.getTegelPositie(index).equals("tafel")) {
                    dc.setTegelPositie(index,"omgedraaid");
                    index=0;
                }
            }
             System.out.println("--------------------------------------------------------------");
             ronde = true;
            }
           }else if(dc.rolDobbelstenen() > 7)
        {
             System.out.printf("%nronde mislukt u verliest u bovenste tegel%n");
             dc.TegelVerliezen(Integer.toString(dc.zoekSpeler()));
              for (int index = 16; index == 0; index--) 
            {
                if (dc.getTegelPositie(index).equals("tafel")) {
                    dc.setTegelPositie(index,"omgedraaid");
                    index=0;
                }
            }
             System.out.println("--------------------------------------------------------------");
             ronde = true;
        }
            
        }while(ronde == false);
        dc.scoreBerekenen();
        System.out.printf("dit zijn de scores tot nu toe:%n");
            for (int index = 0; index < dc.getAantalSpelers(); index++) {
                System.out.printf("%s ",dc.getNaam(index));
                System.out.printf("heeft %d punten%n",dc.getScore(index));
            }
            System.out.println("--------------------------------------------------------------");
        int check = 0;
        for (int index = 0; index < 16; index++) {
            if (!dc.getTegelPositie(index).equals("tafel")) {
                check++;
            }
        }
        if (check == 16) {
            EindeSpel= true;
        }
        dc.reset();
        dc.setSpelerAanBeurt();
        } while (EindeSpel== false);
        spelEindigen();
    }
    public void tegelPakken()
    {
        try{
            
        int beschikbaarTegel=0;
        System.out.println("--------------------------------------------------------------");
        System.out.print("Tegels op tafel:");
        for (int index = 0; index < 16; index++) {
            if (dc.getTegelPositie(index).equals("tafel")) {
                System.out.printf(" %d ",dc.getTegel(index));
            }
            
        }
        System.out.printf("%nU heeft keuze tussen deze tegels:");
        for (int index = 0; index < 16; index++) {
            if (dc.getTegelPositie(index).equals("tafel") && dc.getTegel(index) <= dc.getSom()) 
            {
                System.out.printf(" %d ",dc.getTegel(index));
            }
            else if (dc.getTegel(index) == dc.getSom() && dc.getStackWaarde(index) == 1 && !dc.getTegelPositie(index).equals("tafel") && !dc.getTegelPositie(index).equals("omgedraaid") && !dc.getTegelPositie(index).equals(Integer.toString(dc.zoekSpeler()))) {
                
                System.out.printf(" %d(stelen van %s) ",dc.getTegel(index),dc.getNaam(Integer.parseInt(dc.getTegelPositie(index))));
            }
            else{
                beschikbaarTegel++;
            }
        }
        if (beschikbaarTegel == 16) {
            System.out.printf("%nJammer u beurt was onsuccesvol u bovenste tegel word terug gelegd en laatste tegel word omgedraaid%n");
            for (int index = 0; index < 16; index++) {
                if ("1".equals(dc.getStackWaarde(index)) && dc.getTegelPositie(index).equals(dc.zoekSpeler()))
                {
                    dc.setTegelPositie(index, "tafel");
                    dc.setStackwaarde(index, 0);
                }
            }
            dc.TegelVerliezen(Integer.toString(dc.zoekSpeler()));
            for (int index = 16; index == 0; index--) 
            {
                if (dc.getTegelPositie(index).equals("tafel")) {
                    dc.setTegelPositie(index,"omgedraaid");
                    index=0;
                }
            }
        }
        System.out.printf("%nU heeft deze tegels al gepakt: ");
        for (int index = 0; index < 16; index++) {
            if (dc.getTegelPositie(index).equals(Integer.toString(dc.zoekSpeler()))) {
                System.out.printf(" %d ",dc.getTegel(index));
            }
        }
        boolean tegelGepakt = false;
        boolean tegelkeuze = false;
        do{
            int tegel;
            do {
                System.out.printf("%nwelke tegel wilt u pakken?%n");
                tegel = invoer.nextInt();
                if (tegel >= 21 && tegel <=36) {
                    
                    tegelkeuze = true;
                }else{System.out.print("U kunt deze tegel niet pakken");}
            } while (tegelkeuze == false);
                
        
        
        tegel = tegel - 21;
        if (dc.getTegelPositie(tegel).equals("tafel") && dc.getTegel(tegel) <= dc.getSom()) 
            {
               dc.tegelToevoegen(tegel); 
               tegelGepakt = true;
            }
        else if (dc.getTegel(tegel) == dc.getSom() && dc.getStackWaarde(tegel) == 1 && !dc.getTegelPositie(tegel).equals("tafel") && !dc.getTegelPositie(tegel).equals("omgedraaid") && !dc.getTegelPositie(tegel).equals(Integer.toString(dc.zoekSpeler()))) 
        {
            String verliezendeSpeler = "";
            for (int index = 0; index < 16; index++) {
                if (tegel == dc.getTegel(index)) {
                    verliezendeSpeler = dc.getTegelPositie(index);
                }
                
            }
            dc.TegelVerliezen(verliezendeSpeler);
            
            dc.tegelToevoegen(tegel); 
            
            tegelGepakt = true;
        }else{System.out.print("U kunt deze tegel niet pakken");}
        }while(tegelGepakt == false);
        invoer.nextLine();
        }catch(InputMismatchException e)
        {
            invoer.next();
            System.out.println("Gelieve een getal in te geven");
            tegelPakken();
        }
    }

    public void spelEindigen() 
    {
        System.out.print("--------------------------------------------------------------");
        System.out.printf("%n                   SPEL AFGELOPEN%n");
        System.out.println("--------------------------------------------------------------");
        System.out.printf("dit zijn de uiteindelijke scores:%n");
            for (int index = 0; index < dc.getAantalSpelers(); index++) {
                System.out.printf("%s ",dc.getNaam(index));
                System.out.printf("heeft %d punten%n",dc.getScore(index));
            }
        System.out.println("--------------------------------------------------------------");
        System.out.printf("Proficiat aan %S u heeft gewonnen met %d punten",dc.getNaam(dc.berekenWinnaar()),dc.getScore(dc.berekenWinnaar()));
    }
    
}