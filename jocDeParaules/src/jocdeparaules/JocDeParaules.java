/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jocdeparaules;

import java.util.Scanner;

/**
 * @author Antonio
 * @author Gerard
 * @author Montse
 */
public class JocDeParaules {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JocDeParaules prg = new JocDeParaules();
        prg.inici();
    }
  public void inici() {
        interficiesUsuari pinta = new interficiesUsuari();
        pinta.inici();
        menu();

    }

   
    /**
     * l'usuari escollirà  un dels jocs
     * @author antonio
     * @param opcio
     */
    public void opcioEscollida(int opcio) {
//        System.out.println("El joc escollit es: " + opcio);
        ComencarPer joc1 = new ComencarPer();
        BarrejarParaules joc2 = new BarrejarParaules();
        if (opcio == 1) {
            joc1.OpcioComenca(opcio);
        }
        if (opcio == 2) {
            joc2.opcioBarrejar(opcio);
        }
        if (opcio == 3) {
            //sortir
        }
    }

    public void menu() {
        Scanner lector = new Scanner(System.in);
        int opcio = 0;
        boolean incorrecte = false;
        System.out.println("A quin joc vols jugar?");
        System.out.println("------------------------");
        System.out.println("1 - Començar per...");
        System.out.println("2 - Barrejar Paraules");
        System.out.println("3 - Sortir");
        System.out.println("Tria una opció:");   
        do {       //--------------------------------------Todo Esto debería de estar en funciones
            if (lector.hasNextInt()) {   //--Por ejemplo la funcion entraUnEnter.
                opcio = lector.nextInt();
                incorrecte = true;
            } else {
                lector.next();
                System.out.println("No has introduit un enter.");
            }
            if ((opcio > 3) || (opcio < 1)) {
                incorrecte = false;
                lector.nextLine();
                System.out.println("Siusplau escriu un dels dos joc, '1' o '2'.");
            
            }
        } while (!incorrecte);  ///--------------Hasta aquí­

        /////////////////// a codificar demanar a l'usuari possar un número 1 o 2. Verificar que sigui un número
        /////////////////// a codificar.... Un cop introduït  el joc carregara...
//        System.out.print("     Carregant joc ");
//        System.out.println("\n");
              switch (opcio) {
            case 1:
                opcioEscollida(opcio);
                break;
            case 2:
                opcioEscollida(opcio);
                break;
            case 3:
                System.out.println("Fins Aviat!!!");
                //sortir
                break;
        }
        /////////////////// ens portarà  a l'opcio que hem triat a public class ComençarPer{
        /////////////////// o public class BarrejarParaules

        /////////////// a codificar la part d'adalt per que aquí carregui!! 
    }
}
   
}
