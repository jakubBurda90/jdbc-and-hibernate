package pl.sda.orange2.lambda;

public class LambdaExercises {

    public static void main(String[] args) {


        Metody obietk1 = new Implementujaca();
        obietk1.wyswietl();
        ((Implementujaca)obietk1).sing();



        Implementujaca obiekt2 = new Implementujaca();
        obiekt2.sing();
        obiekt2.wyswietl();



    }
}
