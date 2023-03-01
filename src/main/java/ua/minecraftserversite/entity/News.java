package ua.minecraftserversite.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
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
        this.photo = "photo";
    }
}
