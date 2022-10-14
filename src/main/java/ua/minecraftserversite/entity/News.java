package ua.minecraftserversite.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "news")
public class News {
    @Id
    @Column(name = "news_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "news_title")
    private String title;
    @Column(name = "news_text")
    private String text;
    @Column(name = "news_photo")
    private String photo;

    public News(String title, String text){
        this.title = title;
        this.text = text;
    }
}
