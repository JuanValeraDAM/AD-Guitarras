package ad.spring.ejemploguitarras.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.HashSet;
import java.util.Set;

@Entity
public class GuitarPlayer extends AbstractPersistable<Long> {
    private String name;
    private int trainingTime;

    public GuitarPlayer(String name, int trainingTime) {
        this.name = name;
        this.trainingTime = trainingTime;
    }

    @OneToMany(mappedBy = "owner")
    private Set<Guitar> guitars = new HashSet<>();

    @ManyToMany(mappedBy = "authors")
    private Set<Song> songs = new HashSet<>();

    public GuitarPlayer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTrainingTime() {
        return trainingTime;
    }

    public void setTrainingTime(int trainingTime) {
        this.trainingTime = trainingTime;
    }

    @Override
    public String toString() {
        return "GuitarPlayer{" +
                "name='" + name + '\'' +
                ", trainingTime=" + trainingTime +
                '}';
    }

    public Set<Guitar> getGuitars() {
        return guitars;
    }

    public void setGuitars(Set<Guitar> guitars) {
        this.guitars = guitars;
    }

    public void addGuitar(Guitar guitar) {
        guitar.setOwner(this);
        guitars.add(guitar);
    }

    public Set<Song> getSongs() {
        return songs;
    }

    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }
}
