package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.TimeTracker;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.TimeTrackerRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class BootStrapData implements CommandLineRunner {



    private final BookRepository bookRepository;
    private final TimeTrackerRepository timeTrackerRepository;



    //tells Spring we want an instance of each class injected
    public BootStrapData(BookRepository bookRepository, TimeTrackerRepository timeTrackerRepository) {

        this.bookRepository = bookRepository;
        this.timeTrackerRepository = timeTrackerRepository;
    }

    @Override
    public void run(String... args) throws Exception {

       // Author eric = new Author("Eric", "Evans");
//        Book ddd = new Book("8:00 AM");
//
//        bookRepository.save(ddd);
//
//
//        Book noEJB = new Book("10:00 AM");
//
//
//        bookRepository.save(noEJB);
//
//        Book codingBook = new Book("1:30 PM");
//
//        bookRepository.save(codingBook);

//
//        LocalTime currentTime = LocalTime.now();
//        TimeTracker currentTimeObj = new TimeTracker(currentTime);
//        timeTrackerRepository.save(currentTimeObj);
//
//
//        LocalTime currentTime2 = LocalTime.now();
//        TimeTracker currentTimeObj2 = new TimeTracker(currentTime2);
//        timeTrackerRepository.save(currentTimeObj2);




        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Mains: " + timeTrackerRepository.count());
       // System.out.println("Current Time" + currentTimeObj.getCurrentTime());

    }
}
