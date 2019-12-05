import java.util.Scanner;
    public class RistiNolla {
    
        public static void main(String[] args) {
            
        Scanner lukija = new Scanner(System.in);
        
        Pelilauta ristinolla = new Pelilauta();
        ristinolla.laudanTyhjennys();
        System.out.println("Ristinolla!");
        do
        {
            System.out.println("Nykyinen laudan tila:");
            ristinolla.tulostaLauta();
            int rivi;
            int sarake;
            do
            {
                System.out.println("Pelaaja: " + ristinolla.getNykyinenPelaaja() + ", aseta tyhjä rivi ja sarake mihin haluat nappulan!");
                rivi = lukija.nextInt()-1;
                sarake = lukija.nextInt()-1;
            }
            while (!ristinolla.merkkaa(rivi, sarake));
            ristinolla.pelaajanVaihto();
        }
        while(!ristinolla.tarkistaVoitto() && !ristinolla.lautaTaysi());
        if (ristinolla.lautaTaysi() && !ristinolla.tarkistaVoitto())
        {
            System.out.println("Tasapeli!");
            ristinolla.tulostaLauta();
        }
        else
        {
            System.out.println("Nykyinen laudan tila:");
            ristinolla.tulostaLauta();
            ristinolla.pelaajanVaihto();
            System.out.println(Character.toUpperCase(ristinolla.getNykyinenPelaaja()) + " Wins!");
            System.out.println();
            ristinolla.tulostaLauta();
        }
    }
}