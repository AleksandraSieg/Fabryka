package pl.madison;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.madison.dao.PracownikDao;
import pl.madison.dao.WynagrodzenieDao;
import pl.madison.domain.Pracownik;
import pl.madison.domain.Wynagrodzenie;

@SpringBootApplication
public class FabrykaApplication implements CommandLineRunner{
    public static void main(String[] args){
        SpringApplication.run(FabrykaApplication.class, args).start();
    }

    @Autowired
    PracownikDao pracownikDao;
    @Autowired
    WynagrodzenieDao wynagrodzenieDao;

    public void run(String... strings) throws Exception {
        Wynagrodzenie wynagrodzenie1 = new Wynagrodzenie();
        Wynagrodzenie wynagrodzenie2 = new Wynagrodzenie();
        Wynagrodzenie wynagrodzenie3 = new Wynagrodzenie();

        wynagrodzenie1.setWartość(3455.89);
        wynagrodzenieDao.save(wynagrodzenie1);
        wynagrodzenie2.setWartość(7678.90);
        wynagrodzenieDao.save(wynagrodzenie2);
        wynagrodzenie3.setWartość(6527.00);
        wynagrodzenieDao.save(wynagrodzenie3);

        Pracownik pracownik1 = new Pracownik();
        Pracownik pracownik2 = new Pracownik();
        Pracownik pracownik3 = new Pracownik();

        pracownik1.setImie("Zenon");
        pracownik1.setNazwisko("Martyniuk");
        pracownik1.setWynagrodzenie(wynagrodzenie1);
        pracownikDao.save(pracownik1);

        pracownik2.setImie("Zdzisław");
        pracownik2.setNazwisko("Nowak");
        pracownik2.setWynagrodzenie(wynagrodzenie2);
        pracownikDao.save(pracownik2);

        pracownik3.setImie("Tomasz");
        pracownik3.setNazwisko("Kowalski");
        pracownik3.setWynagrodzenie(wynagrodzenie3);
        pracownikDao.save(pracownik3);
    }
}
