package com.berlincoders.romeo.photoz.clone;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController

public class PhotozController {

    // what is a Map in Java?
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

    @DeleteMapping ("/photoz/{id}")
    public  void delete(@PathVariable String id){
        Photo photo = db.remove(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    // Post Mapping
    // we wanted to request the frontend, to create some Json (create(Photo photo)), and then spring boot
   // should convert that json to an Object, (Photo object defined before as a Model), and we can handle the object directly

    @PostMapping ("/photoz")
    public Photo create(@RequestBody @Validated Photo photo){  //@whatever mark anotation,
        // We should Generate the Id , in thr Backend
        String id =UUID.randomUUID().toString(); // --> to Google :)
        photo.setId(id);

        // Store the photo in the map
         db.put(id, photo);

      return photo;
    }

}
