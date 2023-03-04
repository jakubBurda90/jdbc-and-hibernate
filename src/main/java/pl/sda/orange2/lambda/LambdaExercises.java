package pl.sda.orange2.lambda;

public class LambdaExercises {

    public static void main(String[] args) {


        Metody obietk_1 = new Implementujaca();
        obietk_1.wyswietl();
        ((Implementujaca)obietk_1).sing();



        Implementujaca obiekt_2 = new Implementujaca();
        obiekt_2.sing();



    }
}
