package com.example.Cua_Hang_Oto.service;

import com.example.Cua_Hang_Oto.entity.Showroom;
import com.example.Cua_Hang_Oto.repository.ShowroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowroomService {
    @Autowired
    private ShowroomRepository showroomRepository;

    public List<Showroom> getAllSRoom(){
        return showroomRepository.findAll();
    }
    public Optional<Showroom> getSRoomById(Long id){
        return showroomRepository.findById(id);
    }

    public Showroom saveSRoom(Showroom showroom){
        return showroomRepository.save(showroom);
    }

    public void deleteSRoom(Long id){
        showroomRepository.deleteById(id);
    }
}
