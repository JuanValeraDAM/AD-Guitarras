package ad.spring.ejemploguitarras;

import ad.spring.ejemploguitarras.model.Guitar;
import ad.spring.ejemploguitarras.model.GuitarPlayer;
import ad.spring.ejemploguitarras.model.Song;
import ad.spring.ejemploguitarras.repositories.GuitarPlayerRepository;
import ad.spring.ejemploguitarras.repositories.GuitarRepository;
import ad.spring.ejemploguitarras.repositories.SongRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

@Configuration
public class Demo {

/*  Esto es inyección de campos, que en Spring no está recomendada,
    prefiriéndose la inyección de parámetros.

    @Autowired
    GuitarPlayerRepository players;
    @Autowired
    GuitarRepository guitars;*/

    @Bean
    public CommandLineRunner otraDemo(GuitarPlayerRepository players, SongRepository songs) {
        return new CommandLineRunner() {
            @Override
            @Transactional
            public void run(String... args) throws Exception {
                Song s1 = new Song("Baila con Java");
                Song s2 = new Song("Baila con Java feat. Leo");
                GuitarPlayer p1 = new GuitarPlayer("Chufli", 2);
                GuitarPlayer p2 = new GuitarPlayer("Agus", 20000);
                players.saveAll(List.of(p1, p2));
                songs.saveAll(List.of(s1, s2));
                s1.setDuration(Duration.ofSeconds(100));
                s2.setDuration(Duration.ofSeconds(140));
                s1.addAuthor(p1);
                s1.addAuthor(p2);
            }
        };
    }


    public CommandLineRunner hazDemo(GuitarPlayerRepository players, GuitarRepository guitars) {
        return new CommandLineRunner() {
            @Override
            @Transactional
            public void run(String... args) throws Exception {
                /*GuitarPlayer leo = new GuitarPlayer("Leo", 1000);
                players.save(leo);
                leo.setTrainingTime(2000);
                Guitar guitar = new Guitar();
                guitar.setSerial(123L);
                guitars.save(guitar);
                guitar.setMake("Gibson");
                guitar.setModel("Les Paul");
                guitar.setStrings(6);
                guitar.setAmplified(true);
                guitar.setOwner(leo);
                Guitar st = new Guitar();
                st.setOwner(leo);
                st.setReleased_at(LocalDate.of(1970, 8, 15));
                st.setAmplified(true);
                st.setSerial(555L);
                st.setMake("Fender");
                st.setModel("Stratocaster");
                st.setStrings(6);
                guitars.save(st);*/

                GuitarPlayer leo = players.findById(1L).orElseThrow();

                Guitar g = new Guitar();
                g.setSerial(999L);
                g.setModel("Cutreguitar II");
                //g.setOwner(leo);
                leo.addGuitar(g);
                guitars.save(g);

                leo = players.findById(1L).orElseThrow();

                System.out.printf("%s tiene %d guitarras.\n",
                        leo.getName(),
                        leo.getGuitars().size()
                );

            }
        };
    }

}
