package com.hust.kstn.test;

import com.hust.kstn.models.Book;
import com.hust.kstn.models.BookAuthor;
import com.hust.kstn.test.MicroUnit.Test;
import static com.hust.kstn.test.Asserts.*;
import java.util.ArrayList;
import java.util.List;

public class BookTest {

    public static void main(String[] args) {
        MicroUnit.run(BookTest.class);
    }

    @Test
    public void testBookCreation() {
        // Create authors
        BookAuthor author1 = new BookAuthor("Author A", 1970, "An experienced writer.");
        BookAuthor author2 = new BookAuthor("Author B", 1980, "A new upcoming author.");
        List< BookAuthor> authors = new ArrayList<>();
        authors.add(author1);
        Book book1 = new Book("Book One", "Category", 20.2, 20, authors);
        book1.getAuthors().add(author2);
        // authors should not be modified
        assertEquals(1, authors.size());
        assertEquals(1, book1.getAuthors().size());
    }
}
