package com.example.Cua_Hang_Oto.controller;

import com.example.Cua_Hang_Oto.entity.Car;
import com.example.Cua_Hang_Oto.entity.Showroom;
import com.example.Cua_Hang_Oto.service.ShowroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/showroom")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ShowroomController {
    @Autowired
    private ShowroomService showroomService;

    @GetMapping("/getShowroom")
    public List<Showroom> getShowroom() {
        return showroomService.getAllSRoom();
    }
    @GetMapping("/getShowroomById/{id}")
    public ResponseEntity<Showroom> getShowroomById(@PathVariable Long id) {
        Optional<Showroom> showroom = showroomService.getSRoomById(id);
        return showroom.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping("/createShowroom")
    public Showroom createShowroom(@RequestBody Showroom showroom) {
        return showroomService.saveSRoom(showroom);
    }
    @PutMapping("/update/{id}")
    public Showroom updateShowroom(@PathVariable Long id, @RequestBody Showroom showroom) {
        showroom.setId(id);
        return showroomService.saveSRoom(showroom);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteShowroom(@PathVariable Long id) {
        showroomService.deleteSRoom(id);
    }

}
