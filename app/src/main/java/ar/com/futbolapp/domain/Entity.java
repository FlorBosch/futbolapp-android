package ar.com.futbolapp.domain;

/**
 * Created by Ignacio on 28/02/2016.
 */
public abstract class Entity {

    protected Long id;

    public void setId(Long value) { id = value; }

    public Long getId() { return id; }
}
