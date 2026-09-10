// Exportable.java
// An INTERFACE = a list of promises. It says WHAT, never HOW.

public interface Exportable {

    String toCsv();

    default void printExport() {
        System.out.println(toCsv());
    }
}
