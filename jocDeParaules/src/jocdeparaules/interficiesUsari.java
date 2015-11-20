/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jocdeparaules;

import java.util.Scanner;


/**
 * Biblioteca de mètodes per generar interfícies d'usuari basades en consola.
 *
 * @author Gerard Serra Nov.2015
 */
public class interficiesUsari {
    
    /**
     * Constants per cambiar el color del text. es fa servir incloent dins de
     * print i acabant amb RESET. exemple: System.out.print(VERMELL + "text a
     * mostrar" + RESET);
     */
    public static final String RESET = "\u001B[0m";
    public static final String NEGRE = "\u001B[30m";
    public static final String VERMELL = "\u001B[31m";
    public static final String VERD = "\u001B[32m";
    public static final String GROC = "\u001B[33m";
    public static final String BLAU = "\u001B[34m";
    public static final String PORPRE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";

    /**
     *
     * Funció que inicia el joc i controla el fluxe d'execució del programa.
     */
    public void inici() {
        calibració();
        presentacio();
        pantalla('_', VERD, 80, "Joc de paraules", BLAU);
        System.out.println("\n\n\n");
//        mostrarTitol(1);           //Funcions que es faran servir més endavant, per això estan comentades
//        linia('_', NEGRE, 40);
//        System.out.println("");
//        mostrarTitol(2);
    }

//    void proves() {
//        //recuadre('*', 10, 1, "hola, que tal");
//        //recuadre('*', 75, 13, "0");
//        //linia('@',100);System.out.println("");
//        //recuadre('#', 2, 0, "Menú principal");
//    }
    /**
     * Pinta un recuadre envoltant el text. Només accepta 1 línia de text La
     * funció no té retorn.
     *
     * @param caracter Indica el caràcter que farà servir per pintar el recuadre
     * @param colorCaracter Color del caràcter
     * @param separacioH Seran els espais en blanc que deixarà abans del primer
     * caràcter i després de l'últim caràcter.
     * @param separacioV Seran les línies en blanc que deixarà tant per sobre
     * com per sota del text.Se li ha d'afegir la línia de text + 2 línes.És a
     * dir, la mida total vertical serà de separacioV+1+2.
     * @param text és el text a enmarcar en el recuadre.
     * @param colorText Color del text.
     */
    public void recuadre(char caracter, String colorCaracter, int separacioH, int separacioV, String text, String colorText) {
        if (separacioH < 0 || separacioV < 0) {
            System.out.print("Parámetres incorrectes en fer la crida a recuadre");
        } else {
            if (separacioV == 0) {
                linia(caracter, colorCaracter, separacioH * 2 + text.length() + 2);
                System.out.println("");
            } else {
                linia(caracter, colorCaracter, separacioH * 2 + text.length() + 2);
                for (int i = 0; i < separacioV; i++) {
                    System.out.println("");
                    System.out.print(colorCaracter + caracter + RESET);
                    for (int z = 0; z < separacioH * 2 + text.length(); z++) {
                        System.out.print(" ");
                    }
                    System.out.print(colorCaracter + caracter + RESET);
                }
                System.out.println("");
            }
            if (separacioH == 0) {
                System.out.print(colorCaracter + caracter + RESET);
                for (int i = 0; i < text.length(); i++) {
                    System.out.print(colorText + text.charAt(i) + RESET);
                    if (i == text.length() - 1) {
                        System.out.println(colorCaracter + caracter + RESET);
                    }
                }
            } else {
                System.out.print(colorCaracter + caracter + RESET);
                for (int i = 0; i < separacioH; i++) {
                    System.out.print(" ");
                }
                System.out.print(colorText + text + RESET);
                for (int i = 0; i < separacioH; i++) {
                    System.out.print(" ");
                }
                System.out.print(colorCaracter + caracter + RESET);
                System.out.println("");
            }
            if (separacioV == 0) {
                linia(caracter, colorCaracter, separacioH * 2 + text.length() + 2);
                System.out.println("");
            } else {
                for (int i = 0; i < separacioV; i++) {
                    System.out.print(colorCaracter + caracter + RESET);
                    for (int z = 0; z < separacioH * 2 + text.length(); z++) {
                        System.out.print(" ");
                    }
                    System.out.println(colorCaracter + caracter + RESET);
                }
                linia(caracter, colorCaracter, separacioH * 2 + text.length() + 2);
            }
        }
    }

    /**
     * Dibuixa una línia horitzontal i el cursor queda al final de la línia (no
     * fa salt de línia). La funció no té retorn.
     *
     * @param caracter Indica el caràcter que farà servir per dibuixar la línia.
     * @param color del caràcter a pintar.
     * @param mida el número de caràcters de la línia.
     */
    public void linia(char caracter, String color, int mida) {
        for (int i = 0; i < mida; i++) {
            System.out.print(color + caracter + RESET);
        }
    }

    /**
     * Personalitza les pantalles La funció no té retorn.
     *
     * @param caracter és el caracter que fa servir per dibuixar
     * @param colorCaracter color del caràcter.
     * @param midaH és la mida horitzontal de la línia
     * @param text és el text que mostrarà com a títol de la pantalla.
     * @param colorText color del text.
     */
    public void pantalla(char caracter, String colorCaracter, int midaH, String text, String colorText) {
        linia(caracter, colorCaracter, text.length() - 1);
        System.out.println(colorCaracter + caracter + RESET);
        System.out.print(colorText + text + RESET);
        System.out.print(colorCaracter + "\\" + RESET);
        linia('_', colorCaracter, midaH - text.length() - 1);
        System.out.println("");
    }

    /**
     * Esborra la pantalla actual La funció no té retorn.
     */
    public void netejarPantalla() {
        for (int i = 0; i < 20; i++) {
            System.out.println("");
        }
    }

    /**
     * Funció perquè l'usuari redimensioni la seva pantalla i així asegurar que
     * totes les pantalles es mostren correctament.
     */
    public void calibració() {
        recuadre('*', BLAU, 3, 8, "Ajusta la mida de la consola fins que vegis el rectangle complert. Pulsa Enter per continuar.", VERMELL);
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        netejarPantalla();
    }

    /**
     * mostra una presentació del joc i els crèdits
     */
    public void presentacio() {
        System.out.println(VERMELL + "         |  _   _    ");
        animacioPensar(1, 300, PORPRE, ' ');
        System.out.println(VERMELL + "       \\_| (_) (_ ");
        animacioPensar(1, 300, PORPRE, ' ');
        System.out.println("");
        animacioPensar(1, 300, PORPRE, ' ');
        System.out.println(BLAU + "          _|  _  ");
        animacioPensar(1, 300, PORPRE, ' ');
        System.out.println(BLAU + "         (_| (/_ ");
        animacioPensar(1, 300, PORPRE, ' ');
        System.out.println("");
        animacioPensar(1, 300, PORPRE, ' ');
        System.out.println(PORPRE + " ._   _. ._ _.     |  _   _ ");
        animacioPensar(1, 300, PORPRE, ' ');
        System.out.println(PORPRE + " |_) (_| | (_| |_| | (/_ _> ");
        animacioPensar(1, 300, PORPRE, ' ');
        System.out.println(PORPRE + " | " + RESET);
        animacioPensar(1, 300, PORPRE, ' ');
        linia('_', VERD, 30);
        animacioPensar(1, 300, PORPRE, ' ');
        System.out.println("\n");
        animacioPensar(1, 300, PORPRE, ' ');
        System.out.println(VERMELL + "-Montserrat Maqueda" + RESET);
        animacioPensar(1, 300, PORPRE, ' ');
        System.out.println(VERMELL + "-Antonio Pedrero" + RESET);
        animacioPensar(1, 300, PORPRE, ' ');
        System.out.println(VERMELL + "-Gerard Serra" + RESET);
        animacioPensar(1, 300, PORPRE, ' ');
        linia('_', VERD, 30);
        animacioPensar(1, 300, PORPRE, ' ');
        System.out.println("");
        System.out.print(BLAU + "\n     Carregant joc " + RESET);
        animacioPensar(12, 500, PORPRE, '.');
        System.out.println("\n");
        netejarPantalla();
    }

    /**
     * Representa una animació per simular que l'ordinador està "pensant" La
     * funció no té retorn.
     *
     * @param repeticions nombre de vegades que es repeteix (comença en 0)
     * @param interval de les repeticions el millisegons (1seg=1000milliseg)
     * @param color dels punts que mostra per pantalla
     */
    public void animacioPensar(int repeticions, int interval, String color, char caracter) {
        long temps = System.currentTimeMillis();
        long interval2 = interval + temps;
        long tempsFi = temps + interval * repeticions;
        while (temps < tempsFi) {
            if (temps >= interval2) {
                System.out.print(color + "." + RESET);
                interval2 = interval + temps;
            }
            temps = System.currentTimeMillis();
        }
    }

    /**
     * Funció per dibuixar els titols dels jocs.
     *
     * @param opcio si val1 mostra "comença per...". Si val 2 mostra "paraules
     * barrejades".
     */
    public void mostrarTitol(int opcio) {
        switch (opcio) {

            case 1:
                System.out.println("\n\n\n");
                pantalla('_', VERD, 80, "Comença per...", BLAU);
                System.out.println("\n\n\n");
                String[] titol1 = new String[7];
                titol1[0] = "  _";
                titol1[1] = " /   _  ._ _   _  ._   _  _. ";
                titol1[2] = " \\_ (_) | | | (/_ | | (_ (_| ";
                titol1[3] = "                       S";  //--------------------
                titol1[4] = "  ._   _  ._ ";
                titol1[5] = "  |_) (/_ | o o o            ";
                titol1[6] = "  |                          ";
                for (int i = 0; i < 4; i++) {
                    System.out.println(PORPRE + titol1[i] + RESET);
                    animacioPensar(1, 300, PORPRE, ' ');
                }
                for (int i = 4; i < titol1.length; i++) {
                    System.out.println(VERMELL + titol1[i] + RESET);
                    animacioPensar(1, 300, PORPRE, ' ');
                }
                break;

            case 2:
                System.out.println("\n\n\n");
                String[] titol2 = new String[7];
                titol2[0] = "  _                                ";
                titol2[1] = " |_) _. ._ _.     |  _   _         ";
                titol2[2] = " |  (_| | (_| |_| | (/_ _>         ";
                titol2[3] = " |_   _. ._ ._ _  o  _.  _|  _   _ ";
                titol2[4] = " |_) (_| |  | (/_ | (_| (_| (/_ _> ";
                titol2[5] = "                 _|                ";
                for (int i = 0; i < 3; i++) {
                    System.out.println(VERMELL + titol2[i] + RESET);
                    animacioPensar(1, 300, PORPRE, ' ');
                }
                for (int i = 3; i < titol2.length; i++) {
                    System.out.println(VERD + titol2[i] + RESET);
                    animacioPensar(1, 300, PORPRE, ' ');
                }
                break;
        }

    }
}

}
