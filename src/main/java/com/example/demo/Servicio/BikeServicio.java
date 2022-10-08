/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Servicio;

import com.example.demo.Modelo.Bike;
import com.example.demo.Repositorio.BikeRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BikeServicio {
    @Autowired
    private BikeRepositorio bikeRepository;
   
    public List<Bike> getAll() {
        return bikeRepository.getAll();
    }

    public Optional<Bike> getBike(int bikeId) {
        return bikeRepository.getBike(bikeId);
    }

    public Bike save(Bike bike) {
        if (bike.getId() == null) {
            return bikeRepository.save(bike);
        } else {
            Optional<Bike> e=bikeRepository.getBike(bike.getId());
            if(e.isEmpty()){
                return bikeRepository.save(bike);
            }else{
                return bike;
            }
        }
    } 
}
    
