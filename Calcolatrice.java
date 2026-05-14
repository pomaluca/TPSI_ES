public class Calcolatrice {

    public double divide(double a, double b) throws ArithmeticException{
        double somma=0;
        if(a<0){
            throw new ArithmeticException("non puoi mettere il dividendo uguale a 0");
        }
        somma=a / b;
        return somma;
    }

    public double radiceQuadrata(double x) throws NumeroNegativoException{
        if(x<0){
            throw new NumeroNegativoException("non si può calcolare la radice quadrata di un numero negativo");
        }
        return Math.sqrt(x);

    }
}

