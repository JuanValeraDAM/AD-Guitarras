package ad.spring.ejemploguitarras.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Song extends AbstractPersistable<Long> {
    private String title;
    private Duration duration;
    @ManyToMany
    private Set<GuitarPlayer> authors = new HashSet<>();

    public Song() {
    }

    public Song(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public Set<GuitarPlayer> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<GuitarPlayer> authors) {
        this.authors = authors;
    }

    public void addAuthor(GuitarPlayer guitarPlayer) {
        authors.add(guitarPlayer);
        guitarPlayer.getSongs().add(this);
    }
}
