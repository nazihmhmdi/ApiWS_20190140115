/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pws.nazih5;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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

/**
 *
 * @author nazih
 */
@CrossOrigin
@RestController
@RequestMapping("/kameralist")
public class kameraController {

    @Autowired
    private kamerarepo kamera;

    @GetMapping("/kamera")
    public List<kamera> getAllkamera() {
        return kamera.findAll();
    }

    @GetMapping("/kamera/{id}")
    public kamera getkamerabById(@PathVariable String id) {
        return kamera.findById(id).get();
    }

    @PostMapping("/kamera")
    public kamera savekameraDetails(@RequestBody kamera i) {
        return kamera.save(i);
    }

    @PutMapping("/kamera")
    public kamera updatekamera(@RequestBody kamera i) {
        return kamera.save(i);
    }

    @DeleteMapping("/kamera/{id}")
    public ResponseEntity<HttpStatus> deletekameraById(@PathVariable String id) {
        kamera.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
} 
