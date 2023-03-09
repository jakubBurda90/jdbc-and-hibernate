package pl.sda.orange2.dao;

import pl.sda.orange2.entity.Car;

import java.util.List;

public interface DataAcess<E, ID> {

    void save(E car);


    List<E> findAll();


    E findById(ID id);

    void deleteById(ID id);
}

