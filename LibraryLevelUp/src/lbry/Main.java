package lbry;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // create objects
        Librarian librarian = new Librarian("L01", "Tani Yuusuke");
        Member member = new Member("M01", "Miyu Suzuki");

        // register member
        librarian.registerMember(member);

        int choice;

        do {
            System.out.println("\n===== LIBRARY SYSTEM =====");
            System.out.println("1. Show All Items");
            System.out.println("2. Add Book");
            System.out.println("3. Remove Book");
            System.out.println("4. Borrow Item");
            System.out.println("5. Return Item");
            System.out.println("6. Search Item");
            System.out.println("7. Show Member Info");
            System.out.println("8. Exit");
            System.out.print("Choose: ");

            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    librarian.showAllItems();
                    break;

                case 2:
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    System.out.print("Genre: ");
                    String genre = sc.nextLine();
                    librarian.addBook("B" + (int)(Math.random()*1000), title, author, genre);
                    break;

                case 3:
                    System.out.print("Book ID: ");
                    String id = sc.nextLine();
                    librarian.removeBook(id);
                    break;

                case 4:
                    System.out.print("Borrow Book: ");
                    String borrow = sc.nextLine();
                    LibraryItem item = librarian.findItemByTitle(borrow);

                    if (item != null && item.isAvailable()) {
                        member.borrowItem(item);
                        librarian.recordBorrow(member, item);
                        System.out.println("Borrowed: " + item.getTitle());
                    } else {
                        System.out.println("Item not available!");
                    }
                    break;

                case 5:
                    System.out.print("Book to return: ");
                    String ret = sc.nextLine();
                    LibraryItem rItem = librarian.findItemByTitle(ret);

                    if (rItem != null) {
                        member.returnItem(rItem);
                        librarian.recordReturn(rItem);
                        System.out.println("Returned: " + rItem.getTitle());
                    }
                    break;

                case 6:
                    System.out.print("Keyword: ");
                    String key = sc.nextLine();

                    member.searchItem(
                        librarian.getAllItems().toArray(new LibraryItem[0]),
                        librarian.getAllItems().size(),
                        key
                    );
                    break;

                case 7:
                    System.out.println(member.getInfo());
                    break;

                case 8:
                    System.out.println("Exit");
                    break;

                default:
                    System.out.println("Invalid!");
            }

        } while (choice != 8);

        sc.close();
    }
}