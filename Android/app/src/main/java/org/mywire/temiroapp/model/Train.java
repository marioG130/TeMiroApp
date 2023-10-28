package org.mywire.temiroapp.model;

public class Train {
    private int id;
    private String title;
    private String description;
    private String videoUrl;

    public Train(int id, String title, String description, String videoUrl) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.videoUrl = videoUrl;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getVideoUrl() {
        return videoUrl;
    }
}
