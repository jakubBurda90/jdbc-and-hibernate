package pl.sda.orange2.lambda;

@FunctionalInterface
// it's functional interface because has one abstract method
public interface Metody {

    void wyswietl();

    default void cry() {
    }
}
