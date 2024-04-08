package com.berlincoders.romeo.photoz.clone;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController

public class PhotozController {

    // what is a map in Java?
    private Map<String, Photo> db = new HashMap<>() {{
        put("1", new Photo("1","hello.jpg"));
    }};

    @GetMapping("/")
    public String hello() {
        return "Hello world";
    }
    //Adding endpoint All the photos
    @GetMapping ("/photoz")
    public Collection<Photo> get(){
     return db.values();
    }

    // specific photo
    @GetMapping ("/photoz/{id}")
    public Photo  get(@PathVariable String id){
        Photo photo = db.get(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }
    // Delete one specific photo
    //Ask the frontedn to send it some json, and spring boot will convert to a photo objet.
    @DeleteMapping ("/photoz/{id}")
    public void   delete(@PathVariable String id){
        Photo photo = db.remove(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    // Post mapping
    @PostMapping Mapping ("/photoz/")
    public void   create(@RequestBody Photo photo){
        // We should generate the ID.
        photo.setId(UUID.randomUUID().toString());
        db.put(photo.getId(), photo);
    }


}
