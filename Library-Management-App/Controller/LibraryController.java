package com.example.LibraryManagementApplication.controller;

import com.example.LibraryManagementApplication.model.Library;
import com.example.LibraryManagementApplication.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/library-app/")
public class LibraryController {

    @Autowired
    private LibraryService service;

    //Url : http://localhost:8080/api/v1/library-app/libraries
    @GetMapping("libraries") // get all
    public List<Library> getAllLibraries(){
        return service.getAllLibraries();
    }

    //Url : http://localhost:8080/api/v1/library-app/library/name/khudabaksha Oriental Library
    @GetMapping("library/name/{name}") // get by name
    public Library getLibrary(@PathVariable String name){
        return service.getLibrary(name);
    }

    //Url : http://localhost:8080/api/v1/library-app/add
    @PostMapping("add") // Adding new Libraries
    public String addLibrary(@RequestBody Library library){
        return service.addLibrary(library);
    }

    //Url : http://localhost:8080/api/v1/library-app/update/name/The Google Library
    @PutMapping("update/name/{name}") // update existing Library
    public String updateLibrary(@RequestBody Library library, @PathVariable String name){
        return service.updateLibrary(library, name);
    }

    //Url : http://localhost:8080/api/v1/library-app/delete/name/The Google Library
    @DeleteMapping("delete/name/{name}") // delete Library
    public String deleteLibrary(@PathVariable String name){
        return service.deleteLibrary(name);
    }
}
