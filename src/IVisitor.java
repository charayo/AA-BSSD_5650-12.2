public interface IVisitor {
    public double visit(Clothing clothingItem);

    public double visit(Liquor liquorItem);

    public double visit(Tobacco tobaccoItem);
    public double visit(Necessity necessityItem);
}
