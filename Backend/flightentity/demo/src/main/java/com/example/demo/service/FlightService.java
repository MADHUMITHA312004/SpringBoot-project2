package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Flight;
import com.example.demo.repository.FlightRepo;

@Service
public class FlightService {
    @Autowired
    private FlightRepo flightRepo;

    public Flight save (Flight flight)
    {
        return flightRepo.save(flight);
    }
    public List<Flight> getFlight()
    {
         return flightRepo.findAll();
    }
    public Page<Flight> paginationFlight(int offset,int pagesize)
    {
        return flightRepo.findAll(PageRequest.of(offset,pagesize));
    }
    public Page<Flight> pageSortFlight(int offset,int pagesize,String field)
    {
        PageRequest pageRequest=PageRequest.of(offset, pagesize , Sort.by(field));
        return flightRepo.findAll(pageRequest);
    }
}
