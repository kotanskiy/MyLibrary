package library.rest.model.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Book")
@Table(name = "book")
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    int id;

    @Column(name = "name")
    String name;

    @Column(name = "category")
    String category;

    @Column(name = "year")
    int year;

    @Column(name = "country")
    String country;

    @Column(name = "date")
    Date date;

    @Column(name = "link_on_image")
    String linkForImage;

    @Column(name = "author")
    String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLinkForImage() {
        return linkForImage;
    }

    public void setLinkForImage(String linkForImage) {
        this.linkForImage = linkForImage;
    }

    public Book(int id, String name, String category, int year, String country, Date date, String linkForImage, String author) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.year = year;
        this.country = country;
        this.date = date;
        this.linkForImage = linkForImage;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", year=" + year +
                ", country='" + country + '\'' +
                ", date=" + date +
                ", linkForImage='" + linkForImage + '\'' +
                '}';
    }
}
