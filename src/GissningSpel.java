import java.util.Random;
import java.util.Scanner;

public class GissningSpel {

    // Metod som jämför spelarens gissning med det slumpade talet
    public static String evalueraGissning(int gissning, int korrektTal) {
        if (gissning > korrektTal) {
            return "För högt!";
        } else if (gissning < korrektTal) {
            return "För lågt!";
        } else {
            return "Korrekt!";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // För att läsa in spelarens gissningar
        Random random = new Random(); // För att generera slumptal

        // Spel-loopen
        while (true) {
            int korrektTal = random.nextInt(101); // Slumptal mellan 0 och 100
            int antalGissningar = 0; // Räknar antalet gissningar
            boolean gissatRätt = false; // Flagga för att hålla koll om spelaren har gissat rätt

            System.out.println("Jag har tänkt på ett tal mellan 0 och 100. Kan du gissa vilket?");

            // Inre loop för gissningarna
            while (!gissatRätt) {
                System.out.print("Ange din gissning: ");
                int gissning = scanner.nextInt();
                antalGissningar++;

                // Anropa metoden för att jämföra gissningen
                String resultat = evalueraGissning(gissning, korrektTal);
                System.out.println(resultat);

                // Kontrollera om spelaren gissat rätt
                if (resultat.equals("Korrekt!")) {
                    gissatRätt = true;
                    System.out.println("Grattis! Du gissade rätt på " + antalGissningar + " försök.");
                }
            }

            // Fråga om spelaren vill spela igen
            System.out.print("Vill du spela igen? (ja/nej): ");
            String spelaIgen = scanner.next();

            if (!spelaIgen.equalsIgnoreCase("ja")) {
                System.out.println("Tack för att du spelade! Hej då!");
                break;
            }
        }

        scanner.close(); // Stäng scanner
    }
}
