package com.vehiclewebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleController {

    @GetMapping("list")
    public String showVehicleList(){
        return "list-vehicles";
    }

}
