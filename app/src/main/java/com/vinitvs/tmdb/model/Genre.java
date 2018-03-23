package com.vinitvs.tmdb.model;

/**
 * Created by Vinit on 3/22/2018.
 */

/*Model class of Genre created by converting JSON response of API to POJO
  */

public class Genre {
    private String id;

    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ClassPojo [id = " + id + ", name = " + name + "]";
    }
}
