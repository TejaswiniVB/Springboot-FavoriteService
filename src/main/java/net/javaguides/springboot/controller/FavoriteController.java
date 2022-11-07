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
    	// List<Favorite> favRec = favRepository.findByFavoriteId(fav.favoriteId);
//     	Favorite addFav = fav.get(0);
//     	if(addFav){
//     		addFav.setDeleted(true);
//     	}
		return favRepository.save(fav);
    }

    // build get FavoriteRecord by FavoriteId REST API
    @GetMapping("{favId}")
    public ResponseEntity<List<Favorite>> getFavoriteRecord(@PathVariable String favId){
    	List<Favorite> user = favRepository.findByFavoriteId(favId);
    	return ResponseEntity.ok(user);
    }
    
 // build delete FavoriteRecord REST API
    @DeleteMapping("{favId}")
    public ResponseEntity<HttpStatus> deleteFavoriteRecord(@PathVariable String favId){
        List<Favorite> fav = favRepository.findByFavoriteId(favId);
        Favorite deleteFav = fav.get(0);
//         deleteFav.setDeleted(true);
        favRepository.delete(deleteFav);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}