/*
1. Visa meny
2. Val av meny
 */
package WakeUp;

import java.util.Scanner;
import javax.swing.*;

/**
 *
 * @author robin
 */
public class Meny {

    public static void main(String[] args) {

        Meny hantera = new Meny();

        //Kallar på grafisk meny, behövs ej bara något jag lekte runt med
        //hantera.createMeny();

        do {

            System.out.println("1. Bli medlem \n2. Logga in \n3. Boka plats på aktivitet \n4. Avsluta");
            Scanner input = new Scanner(System.in);
            int val = input.nextInt();

            switch (val) {
                case 1:
                    //Här skapar vi ett konto
                    hantera.createAcc();
                    break;
                case 2:
                    //Här loggar vi in
                    System.out.println("Du valde logga in");
                    break;
                case 3:
                    //Här bokar vi en aktivitet
                    System.out.println("Du valde boka plats på aktivitet");
                    break;
                case 4:
                    //Här avslutar vi programmet
                    System.out.println("Du valde avsluta");
                    System.exit(0);
                default:
                    break;
            }

        } while (true);

    }

    //Vi skapar all grafik här för menyn, behövs ej, något jag bara lekt runt med
    public void createMeny() {

        JFrame frame = new JFrame("WakeUp");
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JButton b1 = new JButton();
        b1.setText("Bli medlem");
        mainPanel.add(b1);

        JButton b2 = new JButton();
        b2.setText("Logga in");
        mainPanel.add(b2);

        JButton b3 = new JButton();
        b3.setText("Boka plats på aktivitet");
        mainPanel.add(b3);

        JButton b4 = new JButton();
        b4.setText("Avsluta");
        mainPanel.add(b4);

        frame.add(mainPanel);
        frame.setSize(1000, 1000);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
//<-- Behövs ej 
    
    
    
    
    //Här sköts skapandet av ett konto
    public void createAcc() {
        System.out.println("Hej vi ser att du vill bli medlem \nskriv in ditt personnummer 10 siffror: ");
        Scanner input = new Scanner(System.in);
        String persnr = input.nextLine();
        System.out.println("Skriv in namn: ");
        String namn = input.nextLine();

        if (checkPersNr(persnr)) {
            Member account = new Member(persnr, namn);

            System.out.printf("%s's personnummer är: %s%n",
                    account.getNamn(), account.getPersnr());
        } else {
            System.out.println("FEL!");
        }
    }

    //Här kan vi kolla om personnummret stämmer och se vilket input som görs
    //Denna kommer att retunera true om ett svenskt personnummer matas in
    //på 10 siffror och utan bindestreck eller mellanrum
    public boolean checkPersNr(String persnr) {
        int sum = 0, tilf;
        //Om personnummret består av fler än 10 siffror
        if (persnr.length() == 10) {
            //Gå igenom varje siffra i persnr
            for (int i = 0; i < persnr.length(); i++) {
                //Ansätt tilf till ett nummer
                tilf = persnr.charAt(i) - '0';
                //Se att det är en siffra som matats in
                if (tilf > 0 || tilf < 9) {
                    //Om det är den första siffran ska det multipliceras med 2 annars 1
                    if (i % 2 == 0) {
                        //Om siffran är större än 9 efter att den multiplicerats med 2 ska den delas upp och individuellt adderas
                        sum += (tilf * 2 > 9) ? (tilf * 2) - 9 : tilf * 2;
                    } else {
                        sum += tilf;
                    }
                } else {
                    return false;
                }
            }
            //Ser att det resulterande talet går att dela med 10
            return ((sum % 10) == 0);
        }
        return false;
    }
}
