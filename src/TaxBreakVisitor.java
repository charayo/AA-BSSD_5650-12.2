import java.text.DecimalFormat;

public class TaxBreakVisitor implements IVisitor{

    DecimalFormat df = new DecimalFormat("#.##");

    public double visit(Liquor liquorItem) {
        System.out.println("Liquor Item: Price with Tax");
        return Double.parseDouble(df.format((liquorItem.getPrice() * .50) + liquorItem.getPrice()));
    }

    public double visit(Tobacco tobaccoItem) {
        System.out.println("Tobacco Item: Price with Tax");
        return Double.parseDouble(df.format((tobaccoItem.getPrice() * .60) + tobaccoItem.getPrice()));
    }

    public double visit(Necessity necessityItem) {
        System.out.println("Necessity Item: Price with Tax");
        return Double.parseDouble(df.format(necessityItem.getPrice()));
    }

    public double visit(Clothing clothingItem) {
        System.out.println("Clothing Item: Price with Tax");
        return Double.parseDouble(df.format(clothingItem.getPrice()));
    }
}
