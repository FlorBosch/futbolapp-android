package ar.com.futbolapp.domain;

/**
 * Created by Ignacio on 28/02/2016.
 */
public class Player {
    private String name;
    private float average;

    public String getName() {
        return name;
    }

    public void setName(String value) {
        name = value;
    }

    public void setAverage(float average) {
        this.average = average;
    }

    public float getAverage() {
        return average;
    }
}
