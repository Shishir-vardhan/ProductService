package com.productservice.productservice;

//import com.productservice.productservice.inheritencerelations.mappedsuperclass.Mentor;
//import com.productservice.productservice.inheritencerelations.mappedsuperclass.MentorRepository;
//import com.productservice.productservice.inheritencerelations.tableperclass.*;
//import com.productservice.productservice.inheritencerelations.tableperclass.Mentor;
//import com.productservice.productservice.inheritencerelations.tableperclass.Student;
//import com.productservice.productservice.inheritencerelations.tableperclass.User;
//import com.productservice.productservice.inheritencerelations.joindedclass.*;
//import com.productservice.productservice.inheritencerelations.singletable.*;
import com.productservice.productservice.models.Category;
import com.productservice.productservice.models.Price;
import com.productservice.productservice.models.Product;
import com.productservice.productservice.repositories.CategoryRepository;
import com.productservice.productservice.repositories.PriceRepository;
import com.productservice.productservice.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
@Transactional
public class ProductServiceApplication implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final PriceRepository priceRepository;

    public ProductServiceApplication(CategoryRepository categoryRepository, ProductRepository productRepository,
                                     PriceRepository priceRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.priceRepository = priceRepository;
    }

    //creating a instance of MentorRepository to save a metor
    /*

     This block is used for creating instance of repositories and constructor injection for
     seeding data into db for each entity.

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


     */

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Seeding data of mentor class of mappedsuperclass into database
//        Mentor mentor = new Mentor();
//        mentor.setName("Shishir");
//        mentor.setEmail("Shishir@gmail.com");
//        mentor.setAvgRating(4.8);
//        mentorRepository.save(mentor);

//        Seeding data of mentor class of tableperclass into database
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

//        Seeding data in singletable
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


        /*
        Below code will seed a single category and a single product bcoz
        first we create a category then pass it to product.
        After putting constrain on name attribute no duplicate category will gets created and not more
        that 1 product gets created.
         */
//        Category categories = new Category();
//        categories.setName("Samsung Devices");
//        Category category =categoryRepository.save(categories);
//        /*
//        First the category will be created and later category is given to product along with id to store
//        in product table.
//         */
//        Product product = new Product();
//        product.setTitle("Samsung S25 ultra");
//        product.setDescription("S25 ultra is the best android phone in the market with best specs");
//        product.setCategory(category);
//        productRepository.save(product);




        /*
        For creating multiple product and single category.
        If you had category in a table no need to see the data into db.
        1. Fetch data by uuid
        2. get the record and store in category.
        3. give the category to product.setCategory() method.
         */
//        Optional<Category> optionalCategory = categoryRepository.findById(UUID.fromString("4f89e446-e2ca-4009-9b0d-8d810ce3e448"));
//
//        Category category = optionalCategory.get();
//
//        Product product = new Product();
//        product.setTitle("Samsung S25 ultra");
//        product.setDescription("S25 ultra is the best android phone in the market with best specs");
//        product.setCategory(category);
//        productRepository.save(product);


        /* Find all the products with category = Samsung Devices
            1. Getting data using id(ie. of Samsung Devices) and assign to optionalCategory
            2. Assign the received values to category
            3. Using the values get all product for that id(i.e. of Samsung devices category) and assign to products
            4. print all the products.
         */
//        Optional<Category> optionalCategory = categoryRepository.findById(UUID.fromString("4f89e446-e2ca-4009-9b0d-8d810ce3e448"));
//        if (optionalCategory.isEmpty()) {
//            throw new Exception("Category not found");
//        }
//        Category category = optionalCategory.get();
//        List<Product> products = category.getProducts();
//        for(Product product : products) {
//            System.out.println(product.getTitle());
//        }


        /*
        Seeding price, category and Product into db. Implementing @OneToOne in b/w price -> Product
         */
//        Price price = new Price();
//        price.setCurrency("INR");
//        price.setValue(100000);

//        Category category = new Category();
//        category.setName("Samsung Devices");
//        Category category1 = categoryRepository.save(category);

//        Product product = new Product();
//        product.setTitle("Samsung S25 ultra");
//        product.setDescription("S25 ultra is the best android phone in the market with best specs");
//        product.setCategory(category);
//        product.setPrice(price);
//        productRepository.save(product);

//        productRepository.deleteById(UUID.fromString("6d0033a7-44b3-4482-8c41-27db8f621792"));

        /*
        Eager vs Lazy Fetch type
        1. Check in Category model, List<Product> should be Eager and call the below getProduct() method. check query.
        2. Change product to Lazy fetch type and comment getProducts() and for loop.Run the application. o/p - 1 query
        3. Uncomment the getProducts() and for loop -> o/p single query + lazy initialization error
        4. If you @Transactional before start of this class. Make it as a single transaction like in db.
         In console - get list of product but with 2 queries
         */

        Optional<Category> optionalCategory =  categoryRepository.findById(UUID.fromString("82737706-0a8e-4dd4-8bd2-186af7531c08"));
        Category category = optionalCategory.get();

        List<Product> products = category.getProducts();
        for(Product product : products) {
            System.out.println(product.getTitle());
        }

    }
}
