package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class FlightInfo {
    @Id
    private int id;
    private String departure;
    private String arrival;


    @JsonBackReference
    @JoinColumn(name="flight_id")
    @ManyToOne
    private Flight flight;
  
    

}
