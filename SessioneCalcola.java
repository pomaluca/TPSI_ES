import java.util.ArrayList;

public class SessioneCalcola {

    private Calcolatrice calcolatrice = new Calcolatrice();
    private ArrayList<String> lista = new ArrayList<>();

    public void eseguiDivisione(double a, double b){
        try {
            double somma = calcolatrice.divide(a, b);
            lista.add("divisione: "+a+" / "+b+" = "+somma);
        } catch (ArithmeticException e) {
            lista.add("Errore: divisione per 0");

        }
    }
    public void eseguiRadice(double x){
        try {
            double somma = calcolatrice.radiceQuadrata(x);
            lista.add("Radice quadrata di: "+x+" = "+somma);
        } catch (NumeroNegativoException e) {
            lista.add("Errore: radice di un numero negativo");
        }
    }
    public void stampalista(){
        for(String s : lista){
            System.out.println(s);
        }
    }

}
