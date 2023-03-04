package pl.sda.orange2.lambda;

public class LambdaExercises {

    public static void main(String[] args) {


        Metody obietk1 = new Implementujaca();
        obietk1.wyswietl();
        ((Implementujaca)obietk1).sing();



        Implementujaca obiekt2 = new Implementujaca();
        obiekt2.sing();
        obiekt2.wyswietl();


        // klasa anonimowa
        Metody anonymusClassReference = new Metody() {
            @Override
            public void wyswietl() {
                System.out.println("Przykład 1");
            }
        };

        anonymusClassReference.wyswietl();

        // Metody obiekt3 = new String ("");

        Metody firstLambda = () ->{};
        Metody secondLambda = () -> System.out.println("Lambda");
        firstLambda.wyswietl();
        secondLambda.wyswietl();

        Metody thirdLambda = () -> {

            for(int i=0; i<5; i++){
                System.out.println(i);
            }
        };

        thirdLambda.wyswietl();

        Metody fouthLambda = () ->{};
        fouthLambda.cry();

        //lambda to metoda anonimowa która pociąga za sobą zawsze definicje klasy.
    }
}
