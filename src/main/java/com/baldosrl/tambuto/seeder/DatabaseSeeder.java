package com.baldosrl.tambuto.seeder;

import com.baldosrl.tambuto.entities.Articolo;
import com.baldosrl.tambuto.repositories.ArticoloRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;

@Component()
public class DatabaseSeeder implements CommandLineRunner {

    private final ArticoloRepo articoloRepo;

    public DatabaseSeeder(ArticoloRepo articoloRepo) {
        this.articoloRepo = articoloRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        // Controllo il DB, solo se è vuoto lo riempio
        if (articoloRepo.count() == 0) {
            Articolo art1 = new Articolo();
            art1.setNome("Bara in mogano");
            art1.setDescrizione("Bara in mogano 200x60x40");
            art1.setQuantita(15);
            art1.setTipoArticolo("bara");
            art1.setPrezzo(3000);
            art1.setLista(new HashSet<>());
            Articolo art2 = new Articolo();
            art2.setNome("Urna bianca");
            art2.setDescrizione("Urna di color bianco  30x22x19");
            art2.setQuantita(15);
            art2.setTipoArticolo("urna");
            art2.setPrezzo(80);
            art2.setLista(new HashSet<>());
            articoloRepo.saveAll(List.of(art1, art2));

        }
    }
}
