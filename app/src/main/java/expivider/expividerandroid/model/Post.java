package expivider.expividerandroid.model;

public class Post {

    private String id;
    private String companyName;
    private String title;
    private String description;
    private String type;
    private String date;
    private int numberOfApplications;


    public Post(String id, String companyName, String title, String description, String type, String date, int numberOfApplications) {
        this.id = id;
        this.companyName = companyName;
        this.title = title;
        this.description = description;
        this.type = type;
        this.date = date;
        this.numberOfApplications = numberOfApplications;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNumberOfApplications() {
        return numberOfApplications;
    }

    public void setNumberOfApplications(int numberOfApplications) {
        this.numberOfApplications = numberOfApplications;
    }
}
