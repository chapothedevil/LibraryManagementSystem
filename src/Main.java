import java.time.Year;

// Base class Book
class Book {
    private String title;
    private String author;
    private int publicationYear;

    // Constructor
    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    // Getter methods
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    // Method to calculate the age of the book
    public int ageOfBook() {
        int currentYear = Year.now().getValue();
        return currentYear - publicationYear;
    }

    // Method to check if the book is rare
    public boolean isRare() {
        return ageOfBook() > 50;
    }

    // toString method
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Publication Year: " + publicationYear;
    }
}

// Derived class EBook
class EBook extends Book {
    private double fileSize; // in MB
    private String format; // e.g., EPUB, PDF

    // Constructor
    public EBook(String title, String author, int publicationYear, double fileSize, String format) {
        super(title, author, publicationYear);
        this.fileSize = fileSize;
        this.format = format;
    }

    // Copy constructor
    public EBook(EBook other) {
        super(other.getTitle(), other.getAuthor(), other.getPublicationYear());
        this.fileSize = other.fileSize;
        this.format = other.format;
    }

    // Getter methods
    public double getFileSize() {
        return fileSize;
    }

    public String getFormat() {
        return format;
    }

    // Setter methods
    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    // Method to calculate required storage space
    public double requiredStorageSpace(double numberOfBooks) {
        return numberOfBooks * fileSize;
    }

    // Method to check if the format is supported on a device
    public boolean supportedDevice(String deviceName) {
        // Simple example: Assume all formats are supported on generic devices
        return deviceName.equalsIgnoreCase("Kindle") && format.equalsIgnoreCase("EPUB") ||
                deviceName.equalsIgnoreCase("Tablet") && format.equalsIgnoreCase("PDF");
    }

    // toString method
    @Override
    public String toString() {
        return super.toString() + ", File Size: " + fileSize + " MB, Format: " + format;
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        // Create Book instances
        Book book1 = new Book("The Prince", "Niccolo Machiavelli", 1532);
        Book book2 = new Book("1984", "George Orwell", 1949);

        // Create EBook instances
        EBook ebook1 = new EBook("Crime and Punishment", "Fyodor Dostoevsky", 1866, 2.5, "PDF");
        EBook ebook2 = new EBook("The Adventures of Don Quixote", "Miguel de Cervantes", 1605, 3.2, "EPUB");

        // Copy constructor for EBook
        EBook ebook3 = new EBook(ebook1);

        // Display details of Book objects
        System.out.println("Books:");
        System.out.println(book1);
        System.out.println("Age: " + book1.ageOfBook() + ", Rare: " + book1.isRare());
        System.out.println(book2);
        System.out.println("Age: " + book2.ageOfBook() + ", Rare: " + book2.isRare());

        // Display details of EBook objects
        System.out.println("\nEBooks:");
        System.out.println(ebook1);
        System.out.println("Required Storage for 5 books: " + ebook1.requiredStorageSpace(5) + " MB");
        System.out.println("Supported on Kindle: " + ebook1.supportedDevice("Kindle"));

        System.out.println(ebook2);
        System.out.println("Required Storage for 10 books: " + ebook2.requiredStorageSpace(10) + " MB");
        System.out.println("Supported on Tablet: " + ebook2.supportedDevice("Tablet"));

        System.out.println("\nCopy of EBook:");
        System.out.println(ebook3);
    }
}
