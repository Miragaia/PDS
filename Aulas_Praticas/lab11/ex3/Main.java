import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Biblioteca library = new Biblioteca("Livros da Marta");

        library.addBook(new Book("Harry Potter", 200, 2012, "J.K. Rowling"));
        library.addBook(new Book("The Lord of the Rings", 300, 2010, "J.R.R. Tolkien"));
        library.addBook(new Book("The Hobbit", 150, 2000, "J.R.R. Tolkien"));
        library.addBook(new Book("The Hunger Games", 250, 2015, "Suzanne Collins"));

        List<Book> bookList = library.returnBook();

        while (true) {
            System.out.println("*** Biblioteca ***\n");
            int i = 0;
            for (Book book : bookList) {
                i++;
                System.out.println(i + "     " + book);
            }
            System.out.println(
                    ">> <livro>, <operacao>: (1) regista; (2) requisita; (3) devolve; (4) reserva; (5) cancela");
            System.out.printf(">> ");
            try {
                String[] input = sc.nextLine().split(",");
                int livro_field = Integer.parseInt(input[0]);
                int operacao_field = Integer.parseInt(input[1]);
                Book book = bookList.get(livro_field - 1);
                menu(library, book, operacao_field);
            } catch (NumberFormatException e) {
                System.err.println("\nError: Wrong input format, please try again. Input example:\n>>1,1\n");
                continue;
            }
        }
    }

    public static void menu(Biblioteca library, Book book, int operation) {
        switch (operation) {
            case 1:
                library.register(book);
                break;
            case 2:
                library.request(book);
                break;
            case 3:
                library.returnBook(book);
                break;
            case 4:
                library.reserve(book);
                break;
            case 5:
                library.cancelReserve(book);
                break;
        }
    }

}
