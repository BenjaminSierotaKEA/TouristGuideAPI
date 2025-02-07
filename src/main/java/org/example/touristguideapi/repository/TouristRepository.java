package org.example.touristguideapi.repository;

import org.example.touristguideapi.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {
    private List<TouristAttraction> attractions = new ArrayList<>();

    public TouristRepository(){
        populateAttractions();
    }

    private void populateAttractions(){
        TouristAttraction attraction1 = new TouristAttraction("The Eiffel Tower", "A four sided pointy steel tower in the center of Paris");
        attractions.add(attraction1);
        TouristAttraction attraction2 = new TouristAttraction("Burj Khalifa", "The worlds tallest skyscraper, almost a kilometer tall");
        attractions.add(attraction2);
        TouristAttraction attraction3 = new TouristAttraction("The Little Mermaid", "A small yet beautiful statue of a mermaid located in Copenhagens harbour");
        attractions.add(attraction3);
    }


    public void createAttraction(String name, String description){
        TouristAttraction attraction = new TouristAttraction(name, description);
        attractions.add(attraction);
    }

    public boolean updateAttractionByIndex(int index, String name, String description){
        TouristAttraction chosen = null;
        try{
            chosen = attractions.get(index);
        }catch (IndexOutOfBoundsException e){
            return false;
        }

        if(chosen == null){
            return false;
        }else{
            chosen.setName(name);
            chosen.setDescription(description);
            return true;
        }
    }

    public boolean updateAttractionByName(String searchName, String name, String description){

        for(TouristAttraction t : attractions){
            if(t.getName().equals(searchName)){
                t.setName(name);
                t.setDescription(description);
                return true;
            }
        }
        return false;
    }

    public TouristAttraction getAttractionByName(String name){
        for(TouristAttraction t : attractions){
            if(t.getName().equals(name)){
                return t;
            }
        }

        return null;
    }

    public List<TouristAttraction> getAttractions(){
        return attractions;
    }

    public boolean deleteAttractionByName(String name){
        for(TouristAttraction t: attractions){
            if(t.getName().equals(name)){
                attractions.remove(t);
                return true;
            }
        }
        return false;
    }
}
