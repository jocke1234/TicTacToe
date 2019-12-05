public class Pelilauta
{
    
    public char[][] lauta;
    private char nykyinenPelaaja;
    
    public Pelilauta() {
        lauta = new char [3][3];
        nykyinenPelaaja = 'x';
        laudanTyhjennys();
    }
    
    public char getNykyinenPelaaja() {
        return nykyinenPelaaja;
    }
   
    public void laudanTyhjennys() {
       
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                lauta[i][j] = '-';
            }
        }
    }
    
    public void tulostaLauta() {
        System.out.println("-------------");

        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(lauta[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
    
    public Boolean lautaTaysi() {
        boolean onTaynna = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (lauta[i][j] == '-') {
                    onTaynna = false;
                }
            }
        }
        return onTaynna;
    }
    
    public Boolean tarkistaVoitto() {
        return riviTarkistus() || sarakeTarkistus() || vinoTarkistus();
    }
    
    private Boolean riviTarkistus() {
        for (int i = 0; i < 3; i++) {
            if (riviSarake(lauta [i][0], lauta [i][1], lauta [i][2]) == true) {
                return true;
        }
    }
        return false;
    }
    
    private Boolean sarakeTarkistus() {
        for (int i = 0; i < 3; i++) {
            if (riviSarake(lauta [0][i], lauta [1][i], lauta [2][i]) == true) {
                return true;
        }
    }
        return false;
    }
    
    private Boolean vinoTarkistus() {
        
        return (riviSarake(lauta[0][0], lauta[1][1], lauta[2][2]) == true || riviSarake(lauta[0][2], lauta[1][1], lauta[2][0]) == true);
    }
    
    private boolean riviSarake(char c1, char c2, char c3) {
        return ((c1 != '-') && (c1 == c2) && (c2 == c3));

    }
    
    public void pelaajanVaihto() {
        if (nykyinenPelaaja == 'x') {
            nykyinenPelaaja = 'o';
        }
        else {
            nykyinenPelaaja = 'x';
        }
    }
    
    public Boolean merkkaa (int rivi, int sarake) {
        if (rivi >= 0 && rivi < 3) {
            if (sarake >= 0 && sarake < 3) {
                if (lauta [rivi][sarake] == '-') {
                    lauta [rivi][sarake] = nykyinenPelaaja;
                    return true;
                }
            }
        }
        return false;
    }
            
    
}