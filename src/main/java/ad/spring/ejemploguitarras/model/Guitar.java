package ad.spring.ejemploguitarras.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.time.LocalDate;

@Entity
public class Guitar extends AbstractPersistable<Long> {
    @Column(nullable = false, unique = true)
    private Long serial;
    private int strings;
    @Column(length = 20)
    private String make;
    private String model;
    private LocalDate released_at;
    private boolean amplified;
    @ManyToOne
    private GuitarPlayer owner;

    public Long getSerial() {
        return serial;
    }

    public void setSerial(Long serial) {
        this.serial = serial;
    }

    public int getStrings() {
        return strings;
    }

    public void setStrings(int strings) {
        this.strings = strings;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getReleased_at() {
        return released_at;
    }

    public void setReleased_at(LocalDate released_at) {
        this.released_at = released_at;
    }

    public boolean isAmplified() {
        return amplified;
    }

    public void setAmplified(boolean amplified) {
        this.amplified = amplified;
    }

    @Override
    public String toString() {
        return "Guitar{" +
                "serial=" + serial +
                ", strings=" + strings +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", released_at=" + released_at +
                ", amplified=" + amplified +
                '}';
    }

    public GuitarPlayer getOwner() {
        return owner;
    }

    public void setOwner(GuitarPlayer owner) {
        this.owner = owner;
    }

}
