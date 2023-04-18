// Some codes taken from : http://newthinktank.com/2012/11/visitor-design-pattern-tutorial/
// Accessed on: 04/16/2023

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Necessity milk = new Necessity(3.47);
        Liquor vodka = new Liquor(11.99);
        Tobacco cigars = new Tobacco(19.99);
        Clothing socks = new Clothing(4.99);

        TaxVisitor taxVisitor = new TaxVisitor();
        TaxHolidayVisitor taxHolidayVisitor = new TaxHolidayVisitor();

        TaxBreakVisitor taxBreakVisitor = new TaxBreakVisitor();
        InvoiceVisitor invoiceVisitor = new InvoiceVisitor("on clearance");

        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        System.out.print("""
                Reply with the type of tax you'd want to apply?\s
                \t1. Tax visitor
                \t2. Tax-Holiday Visitor
                \t3. Tax-Break Visitor
                Input your option:\s""");
        int taxType = sc1.nextInt();
        System.out.print("""
                Do you want to see your invoice?\s
                reply with y/n: \s""");
        String invoiceChoice = sc2.nextLine();

        double cigarProduct = (taxType == 1) ? cigars.accept(taxVisitor) : (taxType == 2) ? cigars.accept(taxHolidayVisitor) : cigars.accept(taxBreakVisitor);
        double svedkaDrink = (taxType == 1) ? vodka.accept(taxVisitor) : (taxType == 2) ? vodka.accept(taxHolidayVisitor) : vodka.accept(taxBreakVisitor);
        double wholeMilk = (taxType == 1) ? milk.accept(taxVisitor) : (taxType == 2) ? milk.accept(taxHolidayVisitor) : milk.accept(taxBreakVisitor);
        double adiSocks = (taxType == 1) ? socks.accept(taxVisitor) : (taxType == 2) ? socks.accept(taxHolidayVisitor) : socks.accept(taxBreakVisitor);

        System.out.println((Objects.equals(invoiceChoice, "y")) ? cigars.accept(invoiceVisitor) + cigarProduct : cigars.accept(taxVisitor));
        System.out.println((Objects.equals(invoiceChoice, "y")) ? vodka.accept(invoiceVisitor) + svedkaDrink : vodka.accept(taxVisitor));
        System.out.println((Objects.equals(invoiceChoice, "y")) ? milk.accept(invoiceVisitor) + wholeMilk : milk.accept(taxVisitor));
        System.out.println((Objects.equals(invoiceChoice, "y")) ? socks.accept(invoiceVisitor) + adiSocks : socks.accept(taxVisitor));


    }
}