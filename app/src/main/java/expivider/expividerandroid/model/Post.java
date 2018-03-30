package expivider.expividerandroid.model;

import java.io.Serializable;
import java.util.List;

public class Post implements Serializable{

    private String id;
    private String company_name;
    private String title;
    private String description;
    private String type;
    private String date;
    private int numberOfApplications;
    private List<Application> applications;


    public Post(String id, String company_name, String title, String description, String type, String date, int numberOfApplications, List<Application> applications) {
        this.id = id;
        this.company_name = company_name;
        this.title = title;
        this.description = description;
        this.type = type;
        this.date = date;
        this.numberOfApplications = numberOfApplications;
        this.applications = applications;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public  List<Application> getApplications() {
        return applications;
    }

    public void setApplications( List<Application> applications) {
        this.applications = applications;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyName() {
        return company_name;
    }

    public void setCompanyName(String companyName) {
        this.company_name = companyName;
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

    @Override
    public String toString() {
        return company_name + " : " + title;
    }
}
