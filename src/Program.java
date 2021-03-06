import autostrada.*;
import veicolo.*;
import pedaggio.*;
import casello.*;

import java.util.LinkedList;


public class Program {

    //costanti del software
    public static final String nomeSoftware = "ECOtoll";
    public static final String autore = "Alessandro D'Orazio";
    public static final float versione = 1.0f;

    public static void main(String[] args)
    {

        System.out.println(nomeSoftware + " - " + autore + " / v" + versione);

        //inserimento dell'autostrada
        float[] tariffaUnitaria = { 1f, 1.2f, 1.4f, 1.5f, 1.6f }; //tariffe unitarie divise per classe (A-B-3-4-5)
        Autostrada a14 = new Autostrada("Autostrada A14", new LinkedList<Casello>(), false, tariffaUnitaria);

        //inserimento di caselli
        a14.nuovoCasello("AQ Ovest", 300); //il casello viene aggiunto richiamando il metodo nuovoCasello della classe Autostrada
        a14.nuovoCasello("AQ Est", 305);
        a14.nuovoCasello("Assergi", 310);

        //inserimento di veicoli
        Veicolo smart = Veicolo.nuovoVeicolo("ForTwo", "Smart", 2006, "AB123YZ", "Euro 4", 2, 990, 120);
        Veicolo camion = Veicolo.nuovoVeicolo("R 730", "Scania", 2011, "NO1M4C", "Euro 6", 5, 3800, 240);
        System.out.println(smart.toString());
        System.out.println(camion.toString());

        //calcolo pedaggio con messaggio, per avere solo il valore del pedaggio utilizzare calcoloPedaggio()
        System.out.println(Pedaggio.pedaggioMsg(a14.caselli.get(0), a14.caselli.get(2), a14, smart)); //da AQ est ad Assergi con la Smart
        System.out.println(Pedaggio.pedaggioMsg(a14.caselli.get(0), a14.caselli.get(2), a14, camion)); //da AQ est ad Assergi con il camion

    }

}