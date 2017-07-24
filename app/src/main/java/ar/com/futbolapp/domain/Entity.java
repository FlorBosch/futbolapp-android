package ar.com.futbolapp.domain;

public abstract class Entity {

    protected Long id;

    public void setId(Long value) {
        id = value;
    }

    public Long getId() {
        return id;
    }
}
