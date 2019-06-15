package com.movierental;

import org.junit.Test;
import static org.junit.Assert.*;

public class CustomerTest {

    @Test
    public void shouldGenerateStatementWithZeroRental(){
        Customer customer = new Customer("Alok");
        String statement = customer.statement();
        String expected = "Rental Record for Alok\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter points";
        assertEquals(expected,statement);

    }

    @Test
    public void shouldGenerateStatementWithOneRental() {
        Movie movie = new Movie("Jungle Book", Movie.CHILDRENS);
        Rental rental = new Rental(movie, 10);
        Customer customer = new Customer("Alok");
        customer.addRental(rental);
        String statement = customer.statement();
        String expected = "Rental Record for Alok\n" +
                "\tJungle Book\t12.0\n" +
                "Amount owed is 12.0\n" +
                "You earned 1 frequent renter points";
        assertEquals(expected, statement);

    }



    @Test
    public void shouldGenerateStatementWithAllRentals(){
        Movie jungleBook = new Movie("Jungle Book",Movie.CHILDRENS);
        Movie dieHard = new Movie("Die Hard",Movie.REGULAR);
        Movie terminator = new Movie("Terminator",Movie.NEW_RELEASE);
        Rental rentalJungleBook = new Rental(jungleBook,10);
        Rental rentalDieHard = new Rental(dieHard,5);
        Rental rentalTerminator = new Rental(terminator,3);
        Customer customer = new Customer("Alok");
        customer.addRental(rentalJungleBook);
        customer.addRental(rentalDieHard);
        customer.addRental(rentalTerminator);
        String statement = customer.statement();
        String expected = "Rental Record for Alok\n" +
                "\tJungle Book\t12.0\n" +
                "\tDie Hard\t6.5\n" +
                "\tTerminator\t9.0\n" +
                "Amount owed is 27.5\n" +
                "You earned 4 frequent renter points";
        assertEquals(expected,statement);

    }

    @Test
    public void shouldGenerateHTMLStatement(){
        Movie jungleBook = new Movie("Jungle Book",Movie.CHILDRENS);
        Movie dieHard = new Movie("Die Hard",Movie.REGULAR);
        Movie terminator = new Movie("Terminator",Movie.NEW_RELEASE);
        Rental rentalJungleBook = new Rental(jungleBook,10);
        Rental rentalDieHard = new Rental(dieHard,5);
        Rental rentalTerminator = new Rental(terminator,3);
        Customer customer = new Customer("Alok");
        customer.addRental(rentalJungleBook);
        customer.addRental(rentalDieHard);
        customer.addRental(rentalTerminator);
        String statement = customer.htmlStatement();
        String expected = "<h1>Rental Record for <b>Alok</b></h1><br />" +
                "Jungle Book 12.0<br />" +
                "Die Hard 6.5<br />" +
                "Terminator 9.0<br />" +
                "Amount owed is 27.5<br />" +
                "You earned <b>4</b> frequent renter points";
        assertEquals(expected,statement);

    }





}