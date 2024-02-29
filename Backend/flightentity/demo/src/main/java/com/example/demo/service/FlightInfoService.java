package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.FlightInfo;
import com.example.demo.repository.FlightInfoRepo;

@Service
public class FlightInfoService {
    @Autowired
    private FlightInfoRepo flightInfoRepo;

    public FlightInfo save (FlightInfo flightInfo)
    {
        return flightInfoRepo.save(flightInfo);
    }
    public List<FlightInfo> getFlightInfo()
    {
         return flightInfoRepo.findAll();
    } 
}
