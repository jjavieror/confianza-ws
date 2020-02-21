package co.com.ws.confianza.common.util.dto;

import java.io.Serializable;

public class PageDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String url;

    private String title;

    private String description;

    private String image;

    private String video;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    
}
