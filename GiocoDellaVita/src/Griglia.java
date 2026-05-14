class Griglia {

    private final int righe;
    private final int colonne;
    private final boolean[][] celle;

    public Griglia(int righe, int colonne) {
        this.righe = righe;
        this.colonne = colonne;
        this.celle = new boolean[righe][colonne];
    }

    public void impostaCella(int riga, int colonna, boolean viva) {
        celle[riga][colonna] = viva;
    }

    public boolean eViva(int riga, int colonna) {
        return celle[riga][colonna];
    }

    public Griglia prossimaGenerazione() {
        Griglia nuova = new Griglia(righe, colonne);

        for (int r = 0; r < righe; r++) {
            for (int c = 0; c < colonne; c++) {

                int vicineVive = contaVicineVive(r, c);
                boolean vivaOra = celle[r][c];

                // Regole del Gioco della Vita
                if (vivaOra) {
                    if (vicineVive < 2) nuova.impostaCella(r, c, false);          // solitudine
                    else if (vicineVive == 2 || vicineVive == 3) nuova.impostaCella(r, c, true); // sopravvive
                    else nuova.impostaCella(r, c, false);                         // sovraffollamento
                } else {
                    if (vicineVive == 3) nuova.impostaCella(r, c, true);          // nascita
                }
            }
        }

        return nuova;
    }

    private int contaVicineVive(int r, int c) {
        int conteggio = 0;

        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {

                if (dr == 0 && dc == 0) continue;

                int nr = r + dr;
                int nc = c + dc;

                if (nr >= 0 && nr < righe && nc >= 0 && nc < colonne) {
                    if (celle[nr][nc]) conteggio++;
                }
            }
        }

        return conteggio;
    }

    public void stampa() {
        for (int r = 0; r < righe; r++) {
            for (int c = 0; c < colonne; c++) {
                System.out.print(celle[r][c] ? "1 " : "0 ");
            }
            System.out.println();
        }
    }
}
