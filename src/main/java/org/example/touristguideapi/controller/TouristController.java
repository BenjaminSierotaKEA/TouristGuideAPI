package org.example.touristguideapi.controller;

import org.example.touristguideapi.model.TouristAttraction;
import org.example.touristguideapi.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TouristController {

    TouristService service = new TouristService();

    @GetMapping("/getAttraction/{attractionName}")
    public ResponseEntity<TouristAttraction> getAttraction(@PathVariable("attractionName") String name){
        TouristAttraction attraction = service.getAttractionByName(name);
        return new ResponseEntity<>(attraction, HttpStatus.OK);
    }

}
