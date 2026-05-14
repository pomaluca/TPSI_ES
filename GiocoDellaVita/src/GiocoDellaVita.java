public class GiocoDellaVita {

    public static void main(String[] args) {

        Griglia griglia = new Griglia(3, 3);

        // Stato iniziale (oscillatore verticale)
        griglia.impostaCella(0, 0, true);
        griglia.impostaCella(0, 2, true);
        griglia.impostaCella(1, 1, true);
        griglia.impostaCella(0, 1, true);

        System.out.println("Stato iniziale:");
        griglia.stampa();

        // Simula 5 generazioni
        for (int generazione = 1; generazione <= 5; generazione++) {
            griglia = griglia.prossimaGenerazione();
            System.out.println("\nGenerazione " + generazione + ":");
            griglia.stampa();
        }
    }
}
