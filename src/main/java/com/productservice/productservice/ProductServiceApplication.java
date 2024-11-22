package com.productservice.productservice;

//import com.productservice.productservice.inheritencerelations.mappedsuperclass.Mentor;
//import com.productservice.productservice.inheritencerelations.mappedsuperclass.MentorRepository;
//import com.productservice.productservice.inheritencerelations.tableperclass.*;
//import com.productservice.productservice.inheritencerelations.tableperclass.Mentor;
//import com.productservice.productservice.inheritencerelations.tableperclass.Student;
//import com.productservice.productservice.inheritencerelations.tableperclass.User;
//import com.productservice.productservice.inheritencerelations.joindedclass.*;
import com.productservice.productservice.inheritencerelations.singletable.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

    //creating a instance of MentorRepository to save a metor
    private MentorRepository mentorRepository;
    private StudentRepository studentRepository;
    private UserRepository userRepository;

    //Constructor injection. Injecting MentorRepository dependency to the constructor.
    ProductServiceApplication(@Qualifier("s_mentorrepository") MentorRepository mentorRepository,
                              @Qualifier("s_studentrepository") StudentRepository studentRepository,
                              @Qualifier("s_userrepository") UserRepository userRepository) {
        this.mentorRepository = mentorRepository;
        this.studentRepository = studentRepository;
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Seeding data of mentor class of mappedsuperclass into database
//        Mentor mentor = new Mentor();
//        mentor.setName("Shishir");
//        mentor.setEmail("Shishir@gmail.com");
//        mentor.setAvgRating(4.8);
//        mentorRepository.save(mentor);

        // Seeding data of mentor class of tableperclass into database
        /*
            Need to comment the above seeding bcoz we can create a single instance of same name class.
            Also comment the import of that class.
         */
//        Mentor mentor = new Mentor();
//        mentor.setName("HanumanJi");
//        mentor.setEmail("hanumanji@gmail.com");
//        mentor.setAvgRating(5);
//        mentorRepository.save(mentor);
//
//        Student student = new Student();
//        student.setName("Shishir");
//        student.setEmail("shishir@gmail.com");
//        student.setPsp(90.5);
//        studentRepository.save(student);
//
//        User users = new User();
//        users.setName("Anmol");
//        users.setEmail("Anmol@gmail.com");
//        userRepository.save(users);


        Mentor mentor = new Mentor();
        mentor.setName("HanumanJi");
        mentor.setEmail("hanumanji@gmail.com");
        mentor.setAvgRating(5);
        mentorRepository.save(mentor);

        Student student = new Student();
        student.setName("Shishir");
        student.setEmail("shishir@gmail.com");
        student.setPsp(90.5);
        studentRepository.save(student);

        User users = new User();
        users.setName("Anmol");
        users.setEmail("Anmol@gmail.com");
        userRepository.save(users);

    }
}
