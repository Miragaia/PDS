import java.util.ArrayList;
import java.util.List;

//ignorar os ficheiros individuais

public class teste{
   public static void main(String[] args) {
        System.out.println("a)");
        List<Geometria> geometria = new ArrayList<>();

        Ponto point1 = new Ponto(0, 0);
        Ponto point2 = new Ponto(0, 4);
        Ponto point3 = new Ponto(4, 4);
        Ponto point4 = new Ponto(4, 0);
        Ponto point5 = new Ponto(2, 6);

        geometria.add(point1);
        geometria.add(point2);
        geometria.add(point3);
        geometria.add(point4);
        geometria.add(point5);

        List<Ponto> polygon1Pontos = new ArrayList<>();
        polygon1Pontos.add(point4);
        polygon1Pontos.add(point1);
        polygon1Pontos.add(point2);
        polygon1Pontos.add(point3);
        polygon1Pontos.add(point4);
        Geometria polygon1 = new Poligno(polygon1Pontos);   

        List<Ponto> polygon2Pontos = new ArrayList<>();
        polygon2Pontos.add(point3);
        polygon2Pontos.add(point5);
        polygon2Pontos.add(point4);
        polygon2Pontos.add(point1);
        Geometria polygon2 = new Poligno(polygon2Pontos);

        geometria.add(polygon1);
        geometria.add(polygon2);
        int i = 1;
        for (Geometria geometry : geometria) {
            if (geometry instanceof Ponto) {
                geometry.draw();
            }
            if (geometry instanceof Poligno) {
                if (geometry.isValid()){
                    geometry.draw();
                }
                else {
                    System.out.println(geometry + String.valueOf(i) + " is null");
                }
                i = i +1;
            }
        }

        System.out.println();
        System.out.println();
        System.out.println("b)");

        PolignoComposto multiPoligno1 = new PolignoComposto();
        multiPoligno1.add(new Ponto(4, 4));

        List<Ponto> multipolygon1Pontos = new ArrayList<>();
        multipolygon1Pontos.add(new Ponto(4, 0));
        multipolygon1Pontos.add(new Ponto(0, 0));
        multipolygon1Pontos.add(new Ponto(0, 4));
        multipolygon1Pontos.add(new Ponto(4, 4));
        multipolygon1Pontos.add(new Ponto(4, 0));
        multiPoligno1.add(new Poligno(multipolygon1Pontos));

        multiPoligno1.add(new Ponto(0, 4));
        multiPoligno1.add(new Ponto(4, 0));

        PolignoComposto multiPoligno2 = new PolignoComposto();
        multiPoligno2.add(multiPoligno1);

        multiPoligno1.draw();
        System.out.println();
        System.out.println();
        multiPoligno2.draw();
    }
}

abstract class Geometria {
    abstract void draw();
    abstract boolean isValid();
}


class Ponto extends Geometria {
    private int x;
    private int y;

    public Ponto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    void draw() {
        System.out.println("Drawing a point  (x =" + x + ", y= " + y + ")");
    }

    @Override
    boolean isValid() {
        if (x >= 0 && y >= 0) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Point (x=" + x + ", y=" + y + ")";
    }
}

class Poligno extends Geometria {
    private List<Ponto> pontos;

    public Poligno(List<Ponto> pontos) {
        this.pontos = pontos;
    }

    @Override
    void draw() {
        System.out.println("Drawing a polygon with points: ");
        for (Ponto ponto : pontos) {
            System.out.print("(" + ponto + ") ");
        }
        System.out.println();
    }

    @Override
    boolean isValid() {
        if (pontos.size() < 4)
            return false;

        Ponto f = pontos.get(0);
        Ponto l = pontos.get(pontos.size() - 1);

        return f.getX() == l.getX() && f.getY() == l.getY();
    }

    @Override
    public String toString() {
        return "Polygon";
    }
}

class PolignoComposto extends Geometria {
    private List<Geometria> geometrias;

    public PolignoComposto() {
        geometrias = new ArrayList<>();
    }

    public void add(Geometria geometria) {
        geometrias.add(geometria);
    }

    @Override
    void draw() {
        System.out.println("Drawing Multi-polygon:");
        for (Geometria geometria : geometrias) {
            geometria.draw();
        }
    }

    @Override
    boolean isValid() {
        for (Geometria geometria : geometrias) {
            if (!geometria.isValid()) {
                return false;
            }
        }
        return true;
    }
}



    