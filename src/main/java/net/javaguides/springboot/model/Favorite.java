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
    
    @Column(name="userName")
    private String userName;

	public String getFavoriteId() {
		return favoriteId;
	}

	public String getFavoriteName() {
		return favoriteName;
	}
	
	public String getUserId() {
		return userName;
	}

	public void setfavoriteId(String favoriteId2) {
		this.favoriteId = favoriteId2;
	}

	public void setusetId(String userName2) {
		this.userName = userName2;
	}
}
