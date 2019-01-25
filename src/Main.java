/*
 * Nombre del programa: Agenda de contactos
 * Autor: Luis Ángel De Santiago Guerrero
 * Última fecha de modificación: 27 de Febrero de 2018
 */

public class Main {

    public static void main(String[] args) {
        Book book = new Book();

        book.createNewGroup("Amigos");
        book.addNewContact(new Contact("Angel", "Guerrero", "4426018712"), "Amigos");
        book.addNewContact(new Contact("Mariela", "Sotelo", "4445556611"), "Amigos");
        book.addNewContact(new Contact("Luis", "Santiago", "4445556611"), "Amigos");
        book.addNewContact(new Contact("Eduardo", "García", "4445556611"), "Amigos");
        book.addNewContact(new Contact("Laura", "Puga", "4445556611"), "Amigos");
        book.addNewContact(new Contact("Wendy", "Argente", "4445556661"), "Defecto");
        book.showTable();

        // Buscando el contacto de nombre Laura
        Contact laura;
        laura = book.searchByName("Laura");
        System.out.println("\nBuscando contacto: Laura");
        System.out.println(laura.getNames() + " " + laura.getLastname() + ": " + laura.getTel());

        Contact extrano;
        extrano = book.searchByName("Extraño");

        // Ordenando la lista de contactos de amigos
        System.out.printf("\nContactos ordenados alfabéticamente del grupo amigos: ");
        book.sortByName("Amigos");
        book.showTable();


        // Crea un nuevo grupo y agrega contactos a éste
        book.createNewGroup("Familia");
        book.addNewContact(new Contact("Wendy", "Argente", "4422331155"), "Familia");
        book.addNewContact(new Contact("Mama", "", "4421122333"), "Familia");
        book.addNewContact(new Contact("Papa", "", "44222211133"), "Familia");
        book.showTable();

        // Busca el contacto de wendy del grupo de familia
        Contact wendy;
        wendy = book.searchByName("Wendy");
        System.out.println("\nBuscando contacto: Wendy");
        System.out.println(wendy.getNames() + " " + wendy.getLastname() + ": " + wendy.getTel());

        // Ordenando contactos familiares
        System.out.println("\nOrdenando contactos familiares: ");
        book.sortByName("Familia");
        book.showTable();

    }
}
