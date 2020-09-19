package com.researchandranking.learnr.model;

public class DashboardModule {

    private int image;
    private String heading;
    private String subHeading;

    public DashboardModule(int image, String heading, String subHeading) {
        this.image = image;
        this.heading = heading;
        this.subHeading = subHeading;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getSubHeading() {
        return subHeading;
    }

    public void setSubHeading(String subHeading) {
        this.subHeading = subHeading;
    }
}
