package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.FlightInfo;
import com.example.demo.service.FlightInfoService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
public class FlightInfoController {
   @Autowired
   private FlightInfoService flightInfoService;
   
   @PostMapping("/flightInfo")
   public FlightInfo create(@RequestBody FlightInfo flightInfo)
   {
      return flightInfoService.save(flightInfo);
   }
   @GetMapping("/flightInfo")
   public List<FlightInfo> getFlightInfo()
   {
      return flightInfoService.getFlightInfo();
   }
   
    
}
