package entity;

import java.io.Serializable;

// TODO: bring in moviescreening entity as an attribute
public class MovieTicket implements Serializable{
    private float price;
    private String TID;

    // features
    private AgeGroup ageGroup;
    private boolean weekday;
    private boolean before6;
    private ScreeningFormat format;
    private int day;
    private Cinema cinema;
    private Cineplex cineplex;
    private String date;
    private int time;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public MovieTicket(AgeGroup ageGroup, boolean weekday, boolean before6, ScreeningFormat format, int day, float price) {
        this.ageGroup = ageGroup;
        this.weekday = weekday;
        this.before6 = before6;
        this.format = format;
        this.day = day;
        this.price = price;
        this.cinema = null;
        this.cineplex = null;
        this.date = null;
        this.time = 0;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public Cineplex getCineplex() {
        return cineplex;
    }

    public void setCineplex(Cineplex cineplex) {
        this.cineplex = cineplex;
    }

    public void printTicketDetails() {
        System.out.println("Ticket details:");
        System.out.println("Age Group: " + this.getAgeGroup());
        System.out.println("Day: " + this.getDay());
        System.out.println((this.isBefore6() ? "Before 6" : "After 6"));
        System.out.println("Screening format: " + this.getFormat());
        System.out.println("Price: " + this.getPrice());
        return;
    }


    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public AgeGroup getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(AgeGroup ageGroup) {
        this.ageGroup = ageGroup;
    }

    public String getTID() {
        return TID;
    }

    public void setTID(String TID) {
        this.TID = TID;
    }
    public boolean isWeekday() {
        return weekday;
    }

    public boolean isBefore6() {
        return before6;
    }

    public ScreeningFormat getFormat() {
        return format;
    }

    public int getDay() {
        return day;
    }
}
