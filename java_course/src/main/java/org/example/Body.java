import Exceptions.EmptyObject;

public class Body {
    private double indexWB = 0;
    public void imtResult(double weight, double high) {
        if (weight <= 0  || high <=  0){
            throw new EmptyObject("weight and high don't may be 0");
        } else {
            double tempFormula = weight / (high * high);
            setIndexWB(tempFormula);
        }

        if (getIndexWB() < 16){
            System.out.printf("You are IWB: %s %n Оценка: %s",getIndexWB(),"Дефицит массы тела (истощение)");
        } else if (getIndexWB() >= 16 && getIndexWB() < 18.5 ) {
            System.out.printf("You are IWB: %s %n Оценка: %s",getIndexWB(),"Недостаточная масса тела (дефицит)");
        } else if (getIndexWB() >= 18.5 && getIndexWB() < 24.9 ) {
            System.out.printf("You are IWB: %s %n Оценка: %s",getIndexWB(),"Норма");
        } else if (getIndexWB() >= 25 && getIndexWB() < 29.9 ) {
            System.out.printf("You are IWB: %s %n Оценка: %s", getIndexWB(), "Лишний вес (предожирение)");
        } else {
            System.out.printf("You are IWB: %s %n Оценка: %s", getIndexWB(), "Ожирение");
        }
    }

    public double getIndexWB() {
        return indexWB;
    }

    public void setIndexWB(double indexWB) {
        this.indexWB = indexWB;
    }
}

