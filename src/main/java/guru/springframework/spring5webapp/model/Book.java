package guru.springframework.spring5webapp.model;



import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String time;



    public Book() {
    }

    public Book(String time) {
        this.time = time;

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }



    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", time='" + time + '\'' +
                '}';
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Book book = (Book) o;
//
//        return id != null ? id.equals(book.id) : book.id == null;
//    }
//
//    @Override
//    public int hashCode() {
//        return id != null ? id.hashCode() : 0;
//    }
}
