/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ApiRest6.ApiRestActvidad6.services;

import com.ApiRest6.ApiRestActvidad6.models.VideoJuego;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public interface VideoJuegoService {
    
    public List<VideoJuego>findAll();
    public Optional<VideoJuego> listarId(Long id);
    public VideoJuego guardar(VideoJuego videojuego);
    public void eliminar(Long id);
}
