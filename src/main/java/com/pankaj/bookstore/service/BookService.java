package com.pankaj.bookstore.service;

import com.pankaj.bookstore.model.Book;
import com.pankaj.bookstore.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public List<Book> getAllBooks(){
        return bookRepo.findAll();
    }

    public String load(){
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald", 1500, "A classic novel of the Roaring Twenties.", "Available"));
        books.add(new Book(2, "To Kill a Mockingbird", "Harper Lee", 1200, "A novel about racial injustice in the Deep South.", "Available"));
        books.add(new Book(3, "1984", "George Orwell", 1300, "A dystopian novel about totalitarianism.", "Checked Out"));
        books.add(new Book(4, "Pride and Prejudice", "Jane Austen", 1000, "A romantic novel about manners and matrimonial machinations.", "Available"));
        books.add(new Book(5, "Moby Dick", "Herman Melville", 1600, "An epic tale of the voyage of the whaling ship Pequod.", "Available"));
        books.add(new Book(6, "War and Peace", "Leo Tolstoy", 2000, "A novel that chronicles the French invasion of Russia.", "Available"));
        books.add(new Book(7, "The Catcher in the Rye", "J.D. Salinger", 1100, "A story about teenage angst and alienation.", "Checked Out"));
        books.add(new Book(8, "The Hobbit", "J.R.R. Tolkien", 1400, "A fantasy novel about the quest of Bilbo Baggins.", "Available"));
        books.add(new Book(9, "Fahrenheit 451", "Ray Bradbury", 1300, "A dystopian novel about a future where books are banned.", "Available"));
        books.add(new Book(10, "Jane Eyre", "Charlotte Brontë", 1200, "A novel about the experiences of the titular character, including her growth to adulthood and her love for Mr. Rochester.", "Available"));
        books.add(new Book(11, "Brave New World", "Aldous Huxley", 1300, "A dystopian novel about a future society controlled by technology and conditioning.", "Checked Out"));
        books.add(new Book(12, "Wuthering Heights", "Emily Brontë", 1250, "A novel about the passionate and doomed love between Catherine Earnshaw and Heathcliff.", "Available"));
        books.add(new Book(13, "The Odyssey", "Homer", 1500, "An epic poem about the journey of Odysseus returning home from the Trojan War.", "Available"));
        books.add(new Book(14, "Crime and Punishment", "Fyodor Dostoevsky", 1700, "A novel about the mental anguish and moral dilemmas of Rodion Raskolnikov.", "Available"));
        books.add(new Book(15, "The Brothers Karamazov", "Fyodor Dostoevsky", 1900, "A novel that explores deep philosophical and spiritual themes.", "Checked Out"));
        books.add(new Book(16, "One Hundred Years of Solitude", "Gabriel Garcia Marquez", 1400, "A novel that tells the multi-generational story of the Buendía family.", "Available"));
        books.add(new Book(17, "Madame Bovary", "Gustave Flaubert", 1300, "A novel about the life of an unfulfilled doctor's wife, Emma Bovary.", "Available"));
        books.add(new Book(18, "The Divine Comedy", "Dante Alighieri", 1800, "An epic poem about the journey through Hell, Purgatory, and Paradise.", "Checked Out"));
        books.add(new Book(19, "The Catch-22", "Joseph Heller", 1600, "A satirical novel about the absurdities of war.", "Available"));
        books.add(new Book(20, "The Grapes of Wrath", "John Steinbeck", 1400, "A novel about the struggles of a poor family during the Great Depression.", "Available"));
        bookRepo.saveAll(books);
        return "Load Successfully";
    }

    public void addBook(Book book){
        bookRepo.save(book);
    }

    public Book getBook(int bookId){
        return bookRepo.findById(bookId).orElse(new Book());
    }

    public void deleteBook(int bookId) {
        bookRepo.deleteById(bookId);
    }

    public List<Book> search(String keyword){
        return bookRepo.findByBookNameContainingOrBookDescContaining(keyword, keyword);
    }

    public void sellBook(String bookName){
        bookRepo.findByBookName(bookName).setStatus("sold");
    }
}
