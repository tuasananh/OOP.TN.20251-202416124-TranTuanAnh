package com.hust.kstn.test;
import com.hust.kstn.models.Cart;
import com.hust.kstn.models.DigitalVideoDisc;

public class CartTest {
    private static final DigitalVideoDisc[] availableDVDs = {
        new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95),
        new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95),
        new DigitalVideoDisc("Aladdin", "Animation", "Ron Clements", 90, 15.50),
        new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 152, 29.99),
        new DigitalVideoDisc("Pulp Fiction", "Crime", "Quentin Tarantino", 154, 17.80),
        new DigitalVideoDisc("Inception", "Science Fiction", "Christopher Nolan", 148, 22.50),
        new DigitalVideoDisc("Forrest Gump", "Drama", "Robert Zemeckis", 142, 14.95),
        new DigitalVideoDisc("Finding Nemo", "Animation", "Andrew Stanton", 100, 16.99),
        new DigitalVideoDisc("The Matrix", "Science Fiction", "Lana Wachowski", 136, 18.00),
        new DigitalVideoDisc("The Godfather", "Crime", "Francis Ford Coppola", 175, 26.90),
        new DigitalVideoDisc("Titanic", "Romance", "James Cameron", 195, 12.50),
        new DigitalVideoDisc("Avatar", "Science Fiction", "James Cameron", 162, 21.00),
        new DigitalVideoDisc("Jurassic Park", "Adventure", "Steven Spielberg", 127, 13.99),
        new DigitalVideoDisc("Shrek", "Animation", "Andrew Adamson", 90, 11.95),
        new DigitalVideoDisc("Gladiator", "Historical", "Ridley Scott", 155, 19.50),
        new DigitalVideoDisc("Toy Story", "Animation", "John Lasseter", 81, 15.00),
        new DigitalVideoDisc("Frozen", "Animation", "Chris Buck", 102, 18.25),
        new DigitalVideoDisc("Interstellar", "Science Fiction", "Christopher Nolan", 169, 23.75),
        new DigitalVideoDisc("E.T. the Extra-Terrestrial", "Science Fiction", "Steven Spielberg", 115, 10.99),
        new DigitalVideoDisc("Spirited Away", "Fantasy", "Hayao Miyazaki", 125, 25.00),
        new DigitalVideoDisc("The Avengers", "Action", "Joss Whedon", 143, 20.00),
        new DigitalVideoDisc("The Martian", "Science Fiction", "Ridley Scott", 144, 16.50),
        new DigitalVideoDisc("The Silence of the Lambs", "Horror", "Jonathan Demme", 118, 16.00),
        new DigitalVideoDisc("Whiplash", "Drama", "Damien Chazelle", 106, 17.50),
        new DigitalVideoDisc("Mad Max: Fury Road", "Action", "George Miller", 120, 21.99),
        new DigitalVideoDisc("La La Land", "Musical", "Damien Chazelle", 128, 14.50),
        new DigitalVideoDisc("The Social Network", "Biography", "David Fincher", 120, 18.90),
        new DigitalVideoDisc("No Country for Old Men", "Thriller", "Joel Coen", 122, 19.25),
        new DigitalVideoDisc("Parasite", "Thriller", "Bong Joon-ho", 132, 25.00),
        new DigitalVideoDisc("Blade Runner 2049", "Science Fiction", "Denis Villeneuve", 164, 28.50),
        new DigitalVideoDisc("Get Out", "Horror", "Jordan Peele", 104, 15.75),
        new DigitalVideoDisc("The Grand Budapest Hotel", "Comedy", "Wes Anderson", 100, 13.00)
    };
    // Should be run with assertions enabled (-ea flag)
    public static void main(String[] args) {
        Cart cart = new Cart();

        System.out.println("Removing DVD from empty cart:");
        cart.removeDVD(availableDVDs[0]);
        cart.print();

        System.out.println("Adding DVDs to cart:");
        for (int i = 0; i < 14; i++) {
            assert cart.addDVD(availableDVDs[i]) == 1;
        }
        cart.print();

        System.out.println("Add single DVD to cart:");
        assert cart.addDVD(availableDVDs[0]) == 1; // singular
        cart.print();

        System.out.println("Add two DVDs to cart:");
        assert cart.addDVD(availableDVDs[0], availableDVDs[1]) == 2; // try adding 2 DVDs
        cart.print();

        System.out.println("Add multiple DVDs to cart:");
        assert cart.addDVD(availableDVDs[0], availableDVDs[1], availableDVDs[2]) == 3; // multiple
        cart.print();

        assert cart.removeDVD(availableDVDs[0]) == 4; // remove all copies of availableDVDs[0]
        cart.print();

        assert cart.removeDVD(availableDVDs[3]) == 1;
        cart.print();

        assert cart.removeDVD(availableDVDs[3]) == 0; // should be nothing
        cart.print();
    } 

}
