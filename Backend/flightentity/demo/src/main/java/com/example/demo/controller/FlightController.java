package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Flight;
import com.example.demo.service.FlightService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class FlightController {
    
    @Autowired
    private FlightService flightService;

    @PostMapping("/flight")
    public Flight create(@RequestBody Flight flight)
    {
        return flightService.save(flight);
    }
    @GetMapping("/flight")
    public List<Flight> getFlight()
    {
        return flightService.getFlight();
    }
    @GetMapping("/flight/{offset}/{pagesize}")
    public ResponseEntity<Page<Flight>> getPaginationFlight(@PathVariable("offset") int offset,@PathVariable("pagesize") int pagesize) 
    {
        Page<Flight> f=flightService.paginationFlight(offset,pagesize);
        if(f!=null)
        {
            return new ResponseEntity<>(f,HttpStatus.OK);
        }
        return new ResponseEntity<>(f,HttpStatus.NOT_FOUND);
    }
    @GetMapping("/flight/{offset}/{pagesize}/{field}")
    public ResponseEntity<Page<Flight>> getPageSortFlight(@PathVariable("offset") int offset,@PathVariable("pagesize") int pagesize,@PathVariable("field") String field) 
    {
        Page<Flight> sort=flightService.pageSortFlight(offset,pagesize,field);
        if(sort!=null){
            return new ResponseEntity<>(sort,HttpStatus.OK);
        }
        return new ResponseEntity<>(sort,HttpStatus.NOT_FOUND);
    }


}
