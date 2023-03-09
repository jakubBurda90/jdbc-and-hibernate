package pl.sda.orange2.dao;

import pl.sda.orange2.entity.Car;

import java.util.List;

public class CarDao implements DataAcess <Car, Long>{

    @Override
    public void save(Car car) {

    }

    @Override
    public List<Car> findAll() {
        return List.of();
    }

    @Override
    public Car findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
