package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.FlightInfo;

public interface FlightInfoRepo extends JpaRepository<FlightInfo,Integer>
{
    
}
