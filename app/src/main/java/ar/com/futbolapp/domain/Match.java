package ar.com.futbolapp.domain;


import java.util.Date;

public class Match {

    private final String name;
    private final Date date;

    public Match(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }
}
