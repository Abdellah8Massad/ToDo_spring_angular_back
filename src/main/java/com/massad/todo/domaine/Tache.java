package com.massad.todo.domaine;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.massad.todo.annotation.CryptoColumn;
import com.massad.todo.annotation.EntityListner;
import com.massad.todo.crypthage.Rsa4096;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.w3c.dom.Text;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@ToString
@EntityListeners(EntityListner.class)
@Table(name="tache")
public class Tache implements Serializable {

    public Tache(){}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    @Column
    public String titre;

    @Column
    public String description;

    @Column
    public Boolean activated;

    @Column(columnDefinition="TEXT")
    @CryptoColumn(clePrivate = "key/private_pkcs8.pem",clePublic = "key/public_pkcs8.pem")
    public String message;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User user;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
