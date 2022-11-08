/**
 * 
 */
package net.javaguides.springboot.repository;
import net.javaguides.springboot.model.Favorite;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unused")
@Repository
public interface FavoriteInterface extends JpaRepository<Favorite, Long>{

	List<Favorite> findByuserName(String userName);// {
	List<Favorite> findByFavoriteId(String favId);
//	Favorite findById(long favId);
}