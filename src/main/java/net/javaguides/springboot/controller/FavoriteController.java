package net.javaguides.springboot.controller;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Favorite;
import net.javaguides.springboot.repository.FavoriteInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("unused")
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/fav")
public class FavoriteController {

    @Autowired
    private FavoriteInterface favRepository;

    @GetMapping
    public List<Favorite> getAllFavorites(){
        return favRepository.findAll();
    }
    
 // build create FavoriteRecord REST API
    @PostMapping
    public Favorite createFavorite(@RequestBody Favorite fav) {
		return favRepository.save(fav);
    }

// build get FavoriteRecord by userId REST API
    @GetMapping("{userName}")
    public ResponseEntity<List<Favorite>> getFavoriteRecord(@PathVariable String userName){
    	List<Favorite> user = favRepository.findByuserName(userName);
    	return ResponseEntity.ok(user);
    }
    
 // build delete FavoriteRecord REST API
    @DeleteMapping("{Id}")
    public ResponseEntity<HttpStatus> deleteFavoriteRecord(@PathVariable long Id){
//        List<Favorite> fav = favRepository.findById(Id);
//        Favorite deleteFav = fav.get(0);
        favRepository.deleteById(Id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}