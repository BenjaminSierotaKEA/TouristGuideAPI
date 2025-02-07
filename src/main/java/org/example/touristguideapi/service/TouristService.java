package org.example.touristguideapi.service;

import org.example.touristguideapi.model.TouristAttraction;
import org.example.touristguideapi.repository.TouristRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristService {

    TouristRepository repo;

    public TouristService(){
        repo = new TouristRepository();
    }

    public void createAttraction(String name, String description){
        repo.createAttraction(name, description);
    }

    public boolean updateAttractionByName(String currentName, String newName, String description){
        return repo.updateAttractionByName(currentName, newName, description);
    }

    public TouristAttraction getAttractionByName(String name){
        return repo.getAttractionByName(name);
    }

    public List<TouristAttraction> getAttractions(){
        return repo.getAttractions();
    }

    public boolean deleteAttractionByName(String name){
        return repo.deleteAttractionByName(name);
    }
}
