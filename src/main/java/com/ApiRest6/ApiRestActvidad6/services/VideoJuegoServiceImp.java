/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ApiRest6.ApiRestActvidad6.services;

import com.ApiRest6.ApiRestActvidad6.dao.VideoJuegoDao;
import com.ApiRest6.ApiRestActvidad6.models.VideoJuego;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author user
 */
@Service
public class VideoJuegoServiceImp implements VideoJuegoService {
    
    
   @Autowired
    private VideoJuegoDao videjojuegoDao, data;
    
    @Override
    public List<VideoJuego> findAll() {
        return (List<VideoJuego>) videjojuegoDao.findAll();
    }

    @Override
    public VideoJuego guardar(VideoJuego videojuego) {
        
        return videjojuegoDao.save(videojuego);
    }

    @Override
    public void eliminar(Long id) {
        videjojuegoDao.deleteById(id);
    }

    @Override
    public Optional<VideoJuego> listarId(Long id) {
        return videjojuegoDao.findById(id);
    }
    
}
