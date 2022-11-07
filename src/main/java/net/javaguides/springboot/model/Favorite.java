package net.javaguides.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "favorites")
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "favoriteId")
    private String favoriteId;

    @Column(name = "favoriteName")
    private String favoriteName;

    @Column(name = "deleted")
    private boolean deleted;

	public String getFavoriteId() {
		// TODO Auto-generated method stub
		return favoriteId;
	}

	public String getFavoriteName() {
		// TODO Auto-generated method stub
		return favoriteName;
	}

	public void setUserName(String favoriteId2) {
		// TODO Auto-generated method stub
		this.favoriteId = favoriteId2;
		
	}

	public void setPassword(String favoriteName2) {
		this.favoriteName = favoriteName2;
	}
}
