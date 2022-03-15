package Connectors;
public class Celebrity {
    public int celebId;
    public String name;
    public String imageURL;

    CelebrityImageService celebrityImageService;

    public void setCelebid(int celebid) {
        this.celebId = celebid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(CelebrityImageService service) {
        imageURL=service.Search();
    }
}
