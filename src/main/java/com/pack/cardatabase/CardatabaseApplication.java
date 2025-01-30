package com.pack.cardatabase;

import com.pack.cardatabase.domain.Car;
import com.pack.cardatabase.domain.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pack.cardatabase.domain.Owner;
import com.pack.cardatabase.domain.OwnerRepository;

import java.util.Arrays;


@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner {

    //Metodo para registro de Log a fim de  capturar erros inesperados
    private static final Logger logger = LoggerFactory.getLogger(
            CardatabaseApplication.class
    );
    private final CarRepository repository;
    private final OwnerRepository ownerRepository;

    public CardatabaseApplication(CarRepository repository, OwnerRepository ownerRepository) {
        this.repository = repository;
        this.ownerRepository = ownerRepository;
    }

    public static void main(String[] args) {
        // teste de reicinilização
        SpringApplication.run(CardatabaseApplication.class, args);
        //Inicialização do Log
        logger.info("Application started");

    }

    @Override
    public void run(String... args) throws Exception {

        // Add owner objects and save these to db
        Owner owner1 = new Owner("John", "Johnson");
        Owner owner2 = new Owner("Mary", "Robinson");
        ownerRepository.saveAll(Arrays.asList(owner1, owner2));

        repository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2023, 59000, owner1));
        repository.save(new Car("Nissan", "Leaf", "White",
                "SSJ-3002", 2020, 29000, owner2));
        repository.save(new Car("Toyota", "Prius",
                "Silver", "KKO-0212", 2022, 39000, owner2));
        // Fetch all cars and log to console
        for (Car car : repository.findAll()) {
            logger.info("brand: {}, model: {}",
                    car.getbrand(), car.getModel());
        }

    }
}