package com.daniel.api.rest.Controller;

import com.daniel.api.rest.Models.Sightseeing;
import com.daniel.api.rest.Repo.SightseeingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ApiControllers {

    @Autowired
    private SightseeingRepo sightseeingRepo;

    @GetMapping(value = "/sightseeingRaabs")
    public List<Sightseeing> getSightseeing() {
        return sightseeingRepo.findAll();
    }

    @PostMapping(value = "/save")
    public String saveSightseeing (@RequestBody Sightseeing sightseeing) {
        sightseeingRepo.save(sightseeing);
        return "Saved";
    }

    @PutMapping(value = "updateSightseeing/{id}")
    public String updateSight(@PathVariable long id, @RequestBody Sightseeing sightseeing) {
        Sightseeing updateSightseeing = sightseeingRepo.findById(id).get();
        updateSightseeing.setLocation(sightseeing.getLocation());
        updateSightseeing.setName(sightseeing.getName());
        sightseeingRepo.save(updateSightseeing);
        return "Updated";
    }

    @DeleteMapping(value = "/delete/{id}")
    public  String deleteSight(@PathVariable long id) {
        Sightseeing deleteSightseeing = sightseeingRepo.findById(id).get();
        sightseeingRepo.delete(deleteSightseeing);
        return "deleted sightseeing with id: "+ id;
    }


}
