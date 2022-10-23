package com.ata;

public class StringFormatUtil {

    public static String formatPriceLine(double price) {
        return String.format("$%10.2f", price);
    }

    // I have no idea how this format works, this does work as expected.
    // More at: http://underpop.online.fr/j/java/help/using-flags-in-the-printf-format-string-formatted-output.html.gz
    public static String formatLabeledValue(String label, int value) {
        return String.format("%s:%n%d -> %+(,d", label, value, value);
    }


    // Main function to test.
    // In fact, every class can have 1 main function.
    // But on start, JVM only launch one of them.
    // For simple testing(test if the code works as expect), just write to its main (as here).
    // If you want to test 1 large project with thousands of line, you will need a testing framework,
    // like Junit or TestNG...
    // Just a few line to let you explore yourself.
    public static void main(String[] args) {
        System.out.println(formatPriceLine(8.0));
        System.out.println(formatLabeledValue("Profit", 123456));
        System.out.println(formatLabeledValue("Deficit", -9870));

    }
}
