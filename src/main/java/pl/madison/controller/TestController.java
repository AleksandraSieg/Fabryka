package pl.madison.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.madison.dao.PracownikDao;
import pl.madison.dao.WynagrodzenieDao;
import pl.madison.domain.Pracownik;
import pl.madison.domain.Wynagrodzenie;

@RestController
public class TestController {

    @Autowired
    PracownikDao pracownikDao;
    @Autowired
    WynagrodzenieDao wynagrodzenieDao;

    @RequestMapping(value = "/wyswietlPracownikow", method = RequestMethod.GET)
    public String wyswietlPracownikow(){
        String pracownik = "";

        for (Pracownik pracownik1 : pracownikDao.findAll()) {
            pracownik = pracownik + pracownik1;
        }

        return pracownik;
    }

    @RequestMapping(value = "/sredniaWynagrodzen", method = RequestMethod.GET)
    public String srednia(){
        String srednia = "";
        double suma = 0;

        for (Wynagrodzenie wynagrodzenie : wynagrodzenieDao.findAll()) {
            suma = suma + wynagrodzenie.getWartość();
        }

        double sredniaDouble = suma/wynagrodzenieDao.count();

        return srednia + sredniaDouble;
    }

    @RequestMapping(value = "/pracownikZarabiajacyNajwiecej")
    public String najwiecej(){
        String pracownik = "";

        double maks = 0;
        String nazwisko = "";

        for (Pracownik pracownik1 : pracownikDao.findAll()) {


            for (Wynagrodzenie wynagrodzenie : wynagrodzenieDao.findAll()) {
                if (wynagrodzenie.getWartość() > maks) {
                    maks = wynagrodzenie.getWartość();
                    nazwisko = pracownik1.getNazwisko();
                }
            }
        }

        return pracownik + "Pracownik który zarabia najwiecej " + nazwisko + " " + maks;
    }
}
