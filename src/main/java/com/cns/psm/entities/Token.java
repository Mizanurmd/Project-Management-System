package com.cns.psm.entities;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="token")
public class Token {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private Integer id;

	    @Column(name = "access_token")
	    private String accessToken;

	    @Column(name = "refresh_token")
	    private String refreshToken;

	    @Column(name = "is_logged_out")
	    private boolean loggedOut;

	    @ManyToOne
	    @JoinColumn(name = "user_id")
	    private User user;

}
