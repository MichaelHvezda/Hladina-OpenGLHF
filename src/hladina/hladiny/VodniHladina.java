package hladina.hladiny;

import io.vavr.Tuple2;
import transforms.Point3D;

import java.util.ArrayList;
import java.util.List;

public class VodniHladina {
    private List<Tuple2<Point3D,Double>> neposunutyListPoint3D = new ArrayList<>();
    private List<Tuple2<Point3D,Double>> posunutyListPoint3D = new ArrayList<>();

    private int xMatice;
    private int yMatice;
    private int pointPerPoint;


    public VodniHladina(){
        this.xMatice =20;
        this.yMatice =6;
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-10, -3, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-9, -3, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-8, -3, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-7, -3, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-6, -3, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-5, -3, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-4, -3, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-3, -3, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-2, -3, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-1, -3, 0),0.0));

        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(0, -3, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(1, -3, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(2, -3, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(3, -3, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(4, -3, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(5, -3, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(6, -3, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(7, -3, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(8, -3, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(9, -3, 0),0.0));


        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-10, -2, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-9, -2, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-8, -2, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-7, -2, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-6, -2, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-5, -2, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-4, -2, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-3, -2, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-2, -2, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-1, -2, 0),0.0));

        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(0, -2, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(1, -2, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(2, -2, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(3, -2, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(4, -2, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(5, -2, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(6, -2, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(7, -2, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(8, -2, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(9, -2, 0),0.0));


        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-10, -1, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-9, -1, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-8, -1, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-7, -1, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-6, -1, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-5, -1, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-4, -1, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-3, -1, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-2, -1, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-1, -1, 0),0.0));

        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(0, -1, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(1, -1, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(2, -1, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(3, -1, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(4, -1, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(5, -1, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(6, -1, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(7, -1, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(8, -1, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(9, -1, 0),0.0));


        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-10, 0, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-9, 0, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-8, 0, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-7, 0, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-6, 0, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-5, 0, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-4, 0, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-3, 0, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-2, 0, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-1, 0, 0),0.0));

        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(0, 0, 1),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(1, 0, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(2, 0, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(3, 0, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(4, 0, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(5, 0, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(6, 0, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(7, 0, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(8, 0, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(9, 0, 0),0.0));


        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-10, 1, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-9, 1, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-8, 1, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-7, 1, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-6, 1, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-5, 1, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-4, 1, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-3, 1, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-2, 1, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-1, 1, 0),0.0));

        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(0, 1, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(1, 1, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(2, 1, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(3, 1, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(4, 1, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(5, 1, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(6, 1, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(7, 1, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(8, 1, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(9, 1, 0),0.0));


        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-10, 2, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-9, 2, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-8, 2, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-7, 2, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-6, 2, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-5, 2, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-4, 2, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-3, 2, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-2, 2, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-1, 2, 0),0.0));

        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(0, 2, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(1, 2, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(2, 2, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(3, 2, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(4, 2, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(5, 2, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(6, 2, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(7, 2, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(8, 2, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(9, 2, 0),0.0));


        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-10, 3, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-9, 3, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-8, 3, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-7, 3, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-6, 3, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-5, 3, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-4, 3, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-3, 3, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-2, 3, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(-1, 3, 0),0.0));

        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(0, 3, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(1, 3, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(2, 3, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(3, 3, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(4, 3, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(5, 3, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(6, 3, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(7, 3, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(8, 3, 0),0.0));
        neposunutyListPoint3D.add(new Tuple2<>(new Point3D(9, 3, 0),0.0));




        for (int index = 0; index < neposunutyListPoint3D.size(); index++ ){
            posunutyListPoint3D.add(new Tuple2<>(new Point3D(neposunutyListPoint3D.get(index)._1.getX(),
                    neposunutyListPoint3D.get(index)._1.getY(),
                    neposunutyListPoint3D.get(index)._1.getZ()+ neposunutyListPoint3D.get(index)._2),
                    neposunutyListPoint3D.get(index)._2
            ));
        }


    }

    public VodniHladina(int xMatice, int yMatice) {
        this.xMatice = xMatice;
        this.yMatice = yMatice;


        for (int indexX =-this.xMatice/2; indexX<=this.xMatice/2-1;indexX++){
            for (int indexY =-this.yMatice/2; indexY<=this.yMatice/2-1;indexY++){
                neposunutyListPoint3D.add(new Tuple2<>(new Point3D(
                      indexX,indexY,0
                ),0.0
                ));
            }

        }




        for (int index = 0; index < neposunutyListPoint3D.size(); index++ ){
            posunutyListPoint3D.add(new Tuple2<>(new Point3D(neposunutyListPoint3D.get(index)._1.getX(),
                    neposunutyListPoint3D.get(index)._1.getY(),
                    neposunutyListPoint3D.get(index)._1.getZ()+ neposunutyListPoint3D.get(index)._2),
                    neposunutyListPoint3D.get(index)._2
            ));
        }


    }

    public VodniHladina(int xMatice, int yMatice, int pointPerPoint) {
        this.xMatice = (xMatice-1)*pointPerPoint+1;
        this.yMatice = (yMatice-1)*pointPerPoint+1;
        this.pointPerPoint = pointPerPoint;
        double ppp = 1.0/pointPerPoint;
        int xBodu = xMatice;
        int yBodu = yMatice;

        for (double indexX =-xBodu/2; indexX<=xBodu/2-1;indexX = indexX +ppp){
            for (double indexY =-yBodu/2; indexY<=yBodu/2-1;indexY= indexY + ppp){

                neposunutyListPoint3D.add(new Tuple2<>(new Point3D(
                        indexX,indexY,0.0
                ),0.0
                ));
            }

        }




        for (int index = 0; index < neposunutyListPoint3D.size(); index++ ){
            posunutyListPoint3D.add(new Tuple2<>(new Point3D(neposunutyListPoint3D.get(index)._1.getX(),
                    neposunutyListPoint3D.get(index)._1.getY(),
                    neposunutyListPoint3D.get(index)._1.getZ()+ neposunutyListPoint3D.get(index)._2),
                    neposunutyListPoint3D.get(index)._2
            ));
        }


    }


    public VodniHladina(List<Tuple2<Point3D, Double>> listPoint3D,int xMatice, int yMatice, int pointPerPoint) {
        this.neposunutyListPoint3D = listPoint3D;
        this.xMatice = xMatice;
        this.yMatice = yMatice;
        this.pointPerPoint = pointPerPoint;


        for (int index = 0; index < listPoint3D.size(); index++ ){
            posunutyListPoint3D.add(new Tuple2<>(new Point3D(listPoint3D.get(index)._1.getX(),
                    listPoint3D.get(index)._1.getY(),
                    listPoint3D.get(index)._1.getZ()+ listPoint3D.get(index)._2),
                   listPoint3D.get(index)._2
            ));
        }

    }

    public VodniHladina(List<Tuple2<Point3D, Double>> listPoint3D,int xMatice, int yMatice) {
        this.neposunutyListPoint3D = listPoint3D;
        this.xMatice = xMatice;
        this.yMatice = yMatice;


        for (int index = 0; index < listPoint3D.size(); index++ ){
            posunutyListPoint3D.add(new Tuple2<>(new Point3D(listPoint3D.get(index)._1.getX(),
                    listPoint3D.get(index)._1.getY(),
                    listPoint3D.get(index)._1.getZ()+ listPoint3D.get(index)._2),
                    listPoint3D.get(index)._2
            ));
        }

    }


    public int getPointPerPoint() {
        return pointPerPoint;
    }

    public void setPointPerPoint(int pointPerPoint) {
        this.pointPerPoint = pointPerPoint;
    }

    public int getxMatice() {
        return xMatice;
    }

    public List<Tuple2<Point3D, Double>> getPosunutyListPoint3D() {
        return posunutyListPoint3D;
    }

    public void setPosunutyListPoint3D(List<Tuple2<Point3D, Double>> posunutyListPoint3D) {
        this.posunutyListPoint3D = posunutyListPoint3D;
    }

    public void setxMatice(int xMatice) {
        this.xMatice = xMatice;
    }

    public int getyMatice() {
        return yMatice;
    }

    public void setyMatice(int yMatice) {
        this.yMatice = yMatice;
    }


    public List<Tuple2<Point3D,Double>> getNeposunutyListPoint3D() {
        return neposunutyListPoint3D;
    }

    public void setNeposunutyListPoint3D(List<Tuple2<Point3D,Double>> neposunutyListPoint3D) {
        this.neposunutyListPoint3D = neposunutyListPoint3D;
    }





}
