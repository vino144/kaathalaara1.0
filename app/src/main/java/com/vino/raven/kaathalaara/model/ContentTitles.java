package com.vino.raven.kaathalaara.model;

/**
 * Created by RAVEN on 7/25/2018.
 */

public class ContentTitles {
    private String id;
    private String title;
    private String kavithai;

    public ContentTitles(String id, String title,String kavithai) {
        this.id = id;
        this.title = title;
        this.kavithai=kavithai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKavithai() {
        return kavithai;
    }

    public void setKavithai(String kavithai) {
        this.kavithai = kavithai;
    }
}
