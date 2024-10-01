package structural.adapter;

class CheckDimensionFit{
    double dimension;
    CheckDimensionFit(double dimension){
        this.dimension = dimension;
    }

    public boolean fit(RoundDimension r){
        if(this.dimension>=r.getRadius()){
            return true;
        }
        return false;
    }
};

class RoundDimension{
    double radius;

    RoundDimension(){

    }

    RoundDimension(double radius){
        this.radius = radius;
    }

    public double getRadius(){
        return radius;
    }
};

class SquareDimension{
    double size;
    SquareDimension(double size){
        this.size = size;
    }

    public double getSize(){
        return size;
    }
};

class SqareDimensionAdapter extends RoundDimension{
    SquareDimension squareDimension;
    SqareDimensionAdapter(SquareDimension squareDimension) {
        this.squareDimension = squareDimension;
    }

    @Override
    public double getRadius(){
        return squareDimension.getSize()/2;
    }
}

public class AdapterDesignExample {
    public static void main(String[] args) {
        CheckDimensionFit checkDimensionFit = new CheckDimensionFit(5);
        SquareDimension squareDimension = new SquareDimension(4);
        if(checkDimensionFit.fit(new SqareDimensionAdapter(squareDimension))){
            System.out.println("fit1");
        }
    }

    // can't compare solely so need adapter

}
