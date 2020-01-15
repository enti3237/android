package kr.co.ch06.viewpager;

public class MyViewPagerData {

    private int poster;
    private String title;
    private String company;


    public MyViewPagerData(int poster, String title, String company){
        this.poster = poster;
        this.title = title;
        this.company = company;
    }


    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
