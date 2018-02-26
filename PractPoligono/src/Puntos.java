
public class Puntos {
    
private int X;
private int Y;

    public Puntos(int a, int b) {
        this.X=a;
        this.Y=b;
        
    }

    public int getX() {
        return X;
    }

    public void setX(int X) {
        this.X = X;
    }

    public int getY() {
        return Y;
    }

    public void setY(int Y) {
        this.Y = Y;
    }
    public String CoordenadaPoligono(){
        return "("+this.X+","+this.Y+")";
    }
    

}
