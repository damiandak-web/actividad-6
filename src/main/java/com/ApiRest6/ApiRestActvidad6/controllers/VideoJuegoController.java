package com.ApiRest6.ApiRestActvidad6.controllers;

import com.ApiRest6.ApiRestActvidad6.exception.UserNotFoundException;
import com.ApiRest6.ApiRestActvidad6.models.VideoJuego;
import com.ApiRest6.ApiRestActvidad6.services.VideoJuegoService;
import java.util.List;
import java.util.Optional;
import javax.swing.text.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

@RestController
@CrossOrigin("http:/localhost:3000")
@RequestMapping("/api")
public class VideoJuegoController {
    @Autowired
    private VideoJuegoService videojuegoServiceImpl;
    
    @GetMapping("/VideoJuegos")
    @CrossOrigin(origins = "*")
    public List<VideoJuego> index(){
        return videojuegoServiceImpl.findAll();
    }
    
    @PostMapping("/save")
    @CrossOrigin(origins = "*")
    public ResponseEntity<VideoJuego> saveVideoJuego(@RequestBody VideoJuego videojuego){
        
        VideoJuego responseBody = videojuegoServiceImpl.guardar(videojuego);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-header","Saving VideoJuego");
        
        return new ResponseEntity<>(responseBody, headers, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    @CrossOrigin(origins = "*")
    public List<VideoJuego> DeleteVideoJuego(@PathVariable Long id){
        videojuegoServiceImpl.eliminar(id);
        return videojuegoServiceImpl.findAll();
    }
    /*@PutMapping("/update/{id}")
    @CrossOrigin(origins = "*")
     public ResponseEntity<VideoJuego> saveVideoJuegoInfo(@RequestBody VideoJuego videojuego){
        
        VideoJuego responseBody = videojuegoServiceImpl.guardar(videojuego);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-header","Saving VideoJuego");
        
        return new ResponseEntity<>(responseBody, headers, HttpStatus.OK);
    }*/
     
    @GetMapping("/ver/{id}")
    @CrossOrigin(origins = "*")
    VideoJuego getVideoJuegoById(@PathVariable Long id){
        return videojuegoServiceImpl.listarId(id)
                .orElseThrow(()->new UserNotFoundException(id));
    }
    
    @PutMapping("/update/{id}")
    @CrossOrigin(origins = "*")
    VideoJuego updateVideojuego(@RequestBody VideoJuego newvideojuego, @PathVariable Long id){
        return videojuegoServiceImpl.listarId(id)
                .map(videojuego ->{
                    videojuego.setFecha_de_compra(newvideojuego.getFecha_de_compra());
                    videojuego.setGenero(newvideojuego.getGenero());
                    videojuego.setNombre(newvideojuego.getNombre());
                    videojuego.setPlataforma(newvideojuego.getPlataforma());
                    videojuego.setPrecio(newvideojuego.getPrecio());
                    return videojuegoServiceImpl.guardar(videojuego);
                }).orElseThrow(()->new UserNotFoundException(id));
               
    } 
}

