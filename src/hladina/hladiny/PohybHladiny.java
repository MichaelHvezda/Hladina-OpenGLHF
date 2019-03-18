package hladina.hladiny;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import io.vavr.Tuple2;
import transforms.Point2D;
import transforms.Point3D;
import transforms.Vec3D;

import java.util.ArrayList;
import java.util.List;

public class PohybHladiny {

    private VodniHladina vodniHladina;
    private double utlum = 0.99;
    private int modyZobrazeni = 0;
    private List<Boolean> modyTF = new ArrayList<>();



    public PohybHladiny(){
        this.vodniHladina = new VodniHladina();
        falseSeznam();
    }

    public PohybHladiny(int x, int y){
        this.vodniHladina = new VodniHladina(x,y);
        falseSeznam();
    }

    public PohybHladiny(int x, int y, int ppp){
        this.vodniHladina = new VodniHladina(x,y,ppp);
        falseSeznam();
    }



    public void trouhelnik(GLAutoDrawable glDrawable){
        for(int index = 0; index < vodniHladina.getNeposunutyListPoint3D().size()-vodniHladina.getxMatice(); index++ ){

            if((index+1)%vodniHladina.getxMatice()!=0){

                if (modyZobrazeni ==0){
                    vykresleniMrizky(index,glDrawable);
                }

                if (modyZobrazeni ==1){
                    vykresleniPoloLeft(index,glDrawable);
                }
                if (modyZobrazeni ==2){
                    vykresleniPoloRight(index,glDrawable);
                }
                if (modyZobrazeni ==3){
                    vykresleniFull(index,glDrawable);
                }



            }


        }



        pohyb(vodniHladina);

    }

    public void pohybMysi(int dx, int dy, double sila){
        List<Tuple2<Point3D,Double>> novy = new ArrayList<>();


        for (int index = 0; index < vodniHladina.getNeposunutyListPoint3D().size(); index++) {

            //*
            //hrany se neposouvaji
            if( index <vodniHladina.getxMatice() ||
                    index%vodniHladina.getxMatice()==0 ||
                    (index+1)%vodniHladina.getxMatice()==0 ||
                    index >vodniHladina.getNeposunutyListPoint3D().size()-vodniHladina.getxMatice() ){

                novy.add(vodniHladina.getNeposunutyListPoint3D().get(index));

            }else {
/*/
            //hrany se posouvaji
            if(index==0 ||
                    index == vodniHladina.getxMatice()-1 ||
                    index == vodniHladina.getPosunutyListPoint3D().size()-vodniHladina.getxMatice() ||
                    index == vodniHladina.getPosunutyListPoint3D().size()-1
                    ){

                novy.add(vodniHladina.getPosunutyListPoint3D().get(index));

            }else {

 //*/
                if(dx==vodniHladina.getNeposunutyListPoint3D().get(index)._1.getX() &&
                        dy==vodniHladina.getNeposunutyListPoint3D().get(index)._1.getY()){
                    novy.add(new Tuple2<Point3D,Double>(new Point3D(vodniHladina.getNeposunutyListPoint3D().get(index)._1.getX(),
                            vodniHladina.getNeposunutyListPoint3D().get(index)._1.getY(),
                            vodniHladina.getNeposunutyListPoint3D().get(index)._1.getZ()),

                            vodniHladina.getNeposunutyListPoint3D().get(index)._2+sila

                    ));

                }else {

                    if( (dx+1==vodniHladina.getNeposunutyListPoint3D().get(index)._1.getX() &&
                            dy==vodniHladina.getNeposunutyListPoint3D().get(index)._1.getY()) ||
                            (dx-1==vodniHladina.getNeposunutyListPoint3D().get(index)._1.getX() &&
                                    dy==vodniHladina.getNeposunutyListPoint3D().get(index)._1.getY()) ||
                            (dx==vodniHladina.getNeposunutyListPoint3D().get(index)._1.getX() &&
                                    dy-1==vodniHladina.getNeposunutyListPoint3D().get(index)._1.getY()) ||
                            (dx==vodniHladina.getNeposunutyListPoint3D().get(index)._1.getX() &&
                                    dy+1==vodniHladina.getNeposunutyListPoint3D().get(index)._1.getY())
                            ){

                        novy.add(new Tuple2<Point3D,Double>(new Point3D(vodniHladina.getNeposunutyListPoint3D().get(index)._1.getX(),
                                vodniHladina.getNeposunutyListPoint3D().get(index)._1.getY(),
                                vodniHladina.getNeposunutyListPoint3D().get(index)._1.getZ()),

                                vodniHladina.getNeposunutyListPoint3D().get(index)._2+sila/2

                        ));

                    }else {
                        novy.add(new Tuple2<Point3D,Double>(new Point3D(vodniHladina.getNeposunutyListPoint3D().get(index)._1.getX(),
                                vodniHladina.getNeposunutyListPoint3D().get(index)._1.getY(),
                                vodniHladina.getNeposunutyListPoint3D().get(index)._1.getZ()),

                                vodniHladina.getNeposunutyListPoint3D().get(index)._2

                        ));
                    }



                }



            }

        }
        // System.out.println(novy);

        this.vodniHladina = new VodniHladina(novy,vodniHladina.getxMatice(),vodniHladina.getyMatice());

    }

    public void pohybMysi(double dx, double dy, double sila, double velikost){
        List<Tuple2<Point3D,Double>> novy = new ArrayList<>();


        for (int index = 0; index < vodniHladina.getNeposunutyListPoint3D().size(); index++) {

            //*
            //hrany se neposouvaji
            if( index <vodniHladina.getxMatice() ||
                    index%vodniHladina.getxMatice()==0 ||
                    (index+1)%vodniHladina.getxMatice()==0 ||
                    index >vodniHladina.getNeposunutyListPoint3D().size()-vodniHladina.getxMatice() ){

                //novy.add(vodniHladina.getNeposunutyListPoint3D().get(index));
                novy.add(new Tuple2<>(
                        new Point3D(
                                vodniHladina.getNeposunutyListPoint3D().get(index)._1.getX(),
                                vodniHladina.getNeposunutyListPoint3D().get(index)._1.getY(),
                                vodniHladina.getNeposunutyListPoint3D().get(index)._1.getZ()),
                        vodniHladina.getNeposunutyListPoint3D().get(index)._2
                ));

            }else {
/*/
            //hrany se posouvaji
            if(index==0 ||
                    index == vodniHladina.getxMatice()-1 ||
                    index == vodniHladina.getPosunutyListPoint3D().size()-vodniHladina.getxMatice() ||
                    index == vodniHladina.getPosunutyListPoint3D().size()-1
                    ){

                novy.add(vodniHladina.getPosunutyListPoint3D().get(index));

            }else {

 //*/

                novy.add(new Tuple2<>(
                        new Point3D(
                                vodniHladina.getNeposunutyListPoint3D().get(index)._1.getX(),
                                vodniHladina.getNeposunutyListPoint3D().get(index)._1.getY(),
                                sila * posunCos(dx,dy,velikost,vodniHladina.getNeposunutyListPoint3D().get(index)._1) + vodniHladina.getNeposunutyListPoint3D().get(index)._1.getZ()  ),
                        vodniHladina.getNeposunutyListPoint3D().get(index)._2
                ));




            }

        }
        // System.out.println(novy);

        this.vodniHladina = new VodniHladina(novy,vodniHladina.getxMatice(),vodniHladina.getyMatice(), vodniHladina.getPointPerPoint());

    }

    public void pohybMysiSin(double dx, double dy, double sila, double velikost){
        List<Tuple2<Point3D,Double>> novy = new ArrayList<>();


        for (int index = 0; index < vodniHladina.getNeposunutyListPoint3D().size(); index++) {

            //*
            //hrany se neposouvaji
            if( index <vodniHladina.getxMatice() ||
                    index%vodniHladina.getxMatice()==0 ||
                    (index+1)%vodniHladina.getxMatice()==0 ||
                    index >vodniHladina.getNeposunutyListPoint3D().size()-vodniHladina.getxMatice() ){

                //novy.add(vodniHladina.getNeposunutyListPoint3D().get(index));
                novy.add(new Tuple2<>(
                        new Point3D(
                                vodniHladina.getNeposunutyListPoint3D().get(index)._1.getX(),
                                vodniHladina.getNeposunutyListPoint3D().get(index)._1.getY(),
                                vodniHladina.getNeposunutyListPoint3D().get(index)._1.getZ()),
                        vodniHladina.getNeposunutyListPoint3D().get(index)._2
                ));

            }else {
/*/
            //hrany se posouvaji
            if(index==0 ||
                    index == vodniHladina.getxMatice()-1 ||
                    index == vodniHladina.getPosunutyListPoint3D().size()-vodniHladina.getxMatice() ||
                    index == vodniHladina.getPosunutyListPoint3D().size()-1
                    ){

                novy.add(vodniHladina.getPosunutyListPoint3D().get(index));

            }else {

 //*/

                novy.add(new Tuple2<>(
                        new Point3D(
                                vodniHladina.getNeposunutyListPoint3D().get(index)._1.getX(),
                                vodniHladina.getNeposunutyListPoint3D().get(index)._1.getY(),
                                sila * posunSin(dx,dy,velikost,vodniHladina.getNeposunutyListPoint3D().get(index)._1) + vodniHladina.getNeposunutyListPoint3D().get(index)._1.getZ()  ),
                        vodniHladina.getNeposunutyListPoint3D().get(index)._2
                ));




            }

        }
        // System.out.println(novy);

        this.vodniHladina = new VodniHladina(novy,vodniHladina.getxMatice(),vodniHladina.getyMatice(), vodniHladina.getPointPerPoint());

    }



    public void pohybMysi(Point2D a, double sila, double velikost){
        double dx = a.getX();
        double dy = a.getY();

        pohybMysi(dx,dy,sila,velikost);



    }
    public void pohybMysiSin(Point2D a, double sila, double velikost){
        double dx = a.getX();
        double dy = a.getY();

        pohybMysiSin(dx,dy,sila,velikost);



    }

    public void reset(){
        List<Tuple2<Point3D,Double>> novy = new ArrayList<>();
        modyZobrazeni = 0;


        for (int index = 0; index < vodniHladina.getNeposunutyListPoint3D().size(); index++) {



                novy.add(new Tuple2<>(
                        new Point3D(
                                vodniHladina.getNeposunutyListPoint3D().get(index)._1.getX(),
                                vodniHladina.getNeposunutyListPoint3D().get(index)._1.getY(),
                                0),
                        0.0
                ));

        }

        this.vodniHladina = new VodniHladina(novy,vodniHladina.getxMatice(),vodniHladina.getyMatice(), vodniHladina.getPointPerPoint());

    }

    public VodniHladina getVodniHladina() {
        return vodniHladina;
    }

    public void setVodniHladina(VodniHladina vodniHladina) {
        this.vodniHladina = vodniHladina;
    }

    public double getUtlum() {
        return utlum;
    }

    public void setUtlum(double utlum) {
        this.utlum = utlum;
    }

    public void falseSeznam(){
        modyTF.clear();
        for (int index = 0 ; index< 8 ; index++){
            modyTF.add(false);
        }

    }

    public void trueSeznam(){
        modyTF.clear();
        for (int index = 0 ; index< 8 ; index++){
            modyTF.add(true);
        }
    }

    public void tfSeznam(int a){
         List<Boolean> pom = new ArrayList<>();
        for (int index = 0 ; index< 8 ; index++){
            if (index==a){
                pom.add(!modyTF.get(index));
            }else {
                pom.add(modyTF.get(index));
            }
        }
        modyTF.clear();
        modyTF.addAll(pom);
    }

    public void modyZobrazeni(){
        setModyZobrazeni( ( getModyZobrazeni() + 1 ) % 4 );

      //  modyZobrazeni = (modyZobrazeni +1)%4;
    }

    public int getModyZobrazeni() {
        return modyZobrazeni;
    }

    public String getModyTFS(int index){
        if( getModyTF().get(index)){
            return "T";
        }else {
            return "F";
        }

    }

    private void setModyZobrazeni(int modyZobrazeni) {
        this.modyZobrazeni = modyZobrazeni;
    }

    private List<Boolean> getModyTF() {
        return modyTF;
    }

    private void setModyTF(List<Boolean> modyTF) {
        this.modyTF = modyTF;
    }

    //*
    private void pohyb(VodniHladina vodniHladina){
        List<Tuple2<Point3D,Double>> novy = new ArrayList<>();


        for (int index = 0; index < vodniHladina.getPosunutyListPoint3D().size(); index++) {
            //zjisteni krajnich hran
            if( index <vodniHladina.getxMatice() ||
                    index%vodniHladina.getxMatice()==0 ||
                    (index+1)%vodniHladina.getxMatice()==0 ||
                    index >vodniHladina.getPosunutyListPoint3D().size()-vodniHladina.getxMatice() ){

                //*
                //vyhozeni krajnich bodu
                if(index==0 ||
                        index == vodniHladina.getxMatice()-1 ||
                        index == vodniHladina.getPosunutyListPoint3D().size()-vodniHladina.getxMatice() ||
                        index == vodniHladina.getPosunutyListPoint3D().size()-1
                        ){
                    //levy horni
                    if(index==0){
                        if (modyTF.get(0)){
                            novy.add(new Tuple2<Point3D,Double>(new Point3D(vodniHladina.getPosunutyListPoint3D().get(index)._1.getX(),
                                    vodniHladina.getPosunutyListPoint3D().get(index)._1.getY(),
                                    vodniHladina.getPosunutyListPoint3D().get(index)._1.getZ()),
                                    (
                                            vodniHladina.getPosunutyListPoint3D().get(index)._2*utlum

                                                    +((vodniHladina.getPosunutyListPoint3D().get(index+1)._1.getZ()
                                                    - vodniHladina.getPosunutyListPoint3D().get(index)._1.getZ() )

                                                    +(vodniHladina.getPosunutyListPoint3D().get(index+vodniHladina.getxMatice())._1.getZ()
                                                    - vodniHladina.getPosunutyListPoint3D().get(index)._1.getZ() ))/2



                                    )
                            ));
                        }else {
                            novy.add(new Tuple2<>(
                                    new Point3D(
                                            vodniHladina.getPosunutyListPoint3D().get(index)._1.getX(),
                                            vodniHladina.getPosunutyListPoint3D().get(index)._1.getY(),
                                            0.0
                                    ),0.0
                            ));
                        }

                    }
                    //pravy horni
                    if(index == vodniHladina.getxMatice()-1){
                        if (modyTF.get(2)){
                            novy.add(new Tuple2<Point3D,Double>(new Point3D(vodniHladina.getPosunutyListPoint3D().get(index)._1.getX(),
                                    vodniHladina.getPosunutyListPoint3D().get(index)._1.getY(),
                                    vodniHladina.getPosunutyListPoint3D().get(index)._1.getZ()),
                                    (
                                            vodniHladina.getPosunutyListPoint3D().get(index)._2*utlum



                                                    +((vodniHladina.getPosunutyListPoint3D().get(index+vodniHladina.getxMatice())._1.getZ()
                                                    - vodniHladina.getPosunutyListPoint3D().get(index)._1.getZ() )

                                                    +(vodniHladina.getPosunutyListPoint3D().get(index-1)._1.getZ()
                                                    - vodniHladina.getPosunutyListPoint3D().get(index)._1.getZ() ))/2



                                    )
                            ));
                        }else {
                            novy.add(new Tuple2<>(
                                    new Point3D(
                                            vodniHladina.getPosunutyListPoint3D().get(index)._1.getX(),
                                            vodniHladina.getPosunutyListPoint3D().get(index)._1.getY(),
                                            0.0
                                    ),0.0
                            ));
                        }

                    }
                    //levy dolni
                    if(index == vodniHladina.getPosunutyListPoint3D().size()-vodniHladina.getxMatice()){
                        if (modyTF.get(6)){
                            novy.add(new Tuple2<Point3D,Double>(new Point3D(vodniHladina.getPosunutyListPoint3D().get(index)._1.getX(),
                                    vodniHladina.getPosunutyListPoint3D().get(index)._1.getY(),
                                    vodniHladina.getPosunutyListPoint3D().get(index)._1.getZ()),
                                    (
                                            vodniHladina.getPosunutyListPoint3D().get(index)._2*utlum

                                                    +((vodniHladina.getPosunutyListPoint3D().get(index+1)._1.getZ()
                                                    - vodniHladina.getPosunutyListPoint3D().get(index)._1.getZ() )


                                                    +(vodniHladina.getPosunutyListPoint3D().get(index-vodniHladina.getxMatice())._1.getZ()
                                                    - vodniHladina.getPosunutyListPoint3D().get(index)._1.getZ() ))/2



                                    )
                            ));
                        }else {
                            novy.add(new Tuple2<>(
                                    new Point3D(
                                            vodniHladina.getPosunutyListPoint3D().get(index)._1.getX(),
                                            vodniHladina.getPosunutyListPoint3D().get(index)._1.getY(),
                                            0.0
                                    ),0.0
                            ));
                        }

                    }
                    //pravy dolni
                    if(index == vodniHladina.getPosunutyListPoint3D().size()-1){
                        if (modyTF.get(4)){
                            novy.add(new Tuple2<Point3D,Double>(new Point3D(vodniHladina.getPosunutyListPoint3D().get(index)._1.getX(),
                                    vodniHladina.getPosunutyListPoint3D().get(index)._1.getY(),
                                    vodniHladina.getPosunutyListPoint3D().get(index)._1.getZ()),
                                    (
                                            vodniHladina.getPosunutyListPoint3D().get(index)._2*utlum


                                                    +((vodniHladina.getPosunutyListPoint3D().get(index-1)._1.getZ()
                                                    - vodniHladina.getPosunutyListPoint3D().get(index)._1.getZ() )

                                                    +(vodniHladina.getPosunutyListPoint3D().get(index-vodniHladina.getxMatice())._1.getZ()
                                                    - vodniHladina.getPosunutyListPoint3D().get(index)._1.getZ() ))/2



                                    )
                            ));
                        }else {
                            novy.add(new Tuple2<>(
                                    new Point3D(
                                            vodniHladina.getPosunutyListPoint3D().get(index)._1.getX(),
                                            vodniHladina.getPosunutyListPoint3D().get(index)._1.getY(),
                                            0.0
                                    ),0.0
                            ));
                        }

                    }

                }else {
                    //horni hrana
                    if ( index <vodniHladina.getxMatice() ){
                        if (modyTF.get(1)){
                            novy.add(new Tuple2<Point3D,Double>(new Point3D(vodniHladina.getPosunutyListPoint3D().get(index)._1.getX(),
                                    vodniHladina.getPosunutyListPoint3D().get(index)._1.getY(),
                                    vodniHladina.getPosunutyListPoint3D().get(index)._1.getZ()),
                                    (
                                            vodniHladina.getPosunutyListPoint3D().get(index)._2*utlum

                                                    +((vodniHladina.getPosunutyListPoint3D().get(index+1)._1.getZ()
                                                    - vodniHladina.getPosunutyListPoint3D().get(index)._1.getZ() )

                                                    +(vodniHladina.getPosunutyListPoint3D().get(index+vodniHladina.getxMatice())._1.getZ()
                                                    - vodniHladina.getPosunutyListPoint3D().get(index)._1.getZ() )

                                                    +(vodniHladina.getPosunutyListPoint3D().get(index-1)._1.getZ()
                                                    - vodniHladina.getPosunutyListPoint3D().get(index)._1.getZ() ))/3



                                    )
                            ));
                        }else {
                            novy.add(new Tuple2<>(
                                    new Point3D(
                                            vodniHladina.getPosunutyListPoint3D().get(index)._1.getX(),
                                            vodniHladina.getPosunutyListPoint3D().get(index)._1.getY(),
                                            0.0
                                    ),0.0
                            ));
                        }

                    }
                    //leva hrana

                    if (index%vodniHladina.getxMatice()==0){
                        if (modyTF.get(7)){
                            novy.add(new Tuple2<Point3D,Double>(new Point3D(vodniHladina.getPosunutyListPoint3D().get(index)._1.getX(),
                                    vodniHladina.getPosunutyListPoint3D().get(index)._1.getY(),
                                    vodniHladina.getPosunutyListPoint3D().get(index)._1.getZ()),
                                    (


                                            vodniHladina.getPosunutyListPoint3D().get(index)._2*utlum

                                                    +((vodniHladina.getPosunutyListPoint3D().get(index+1)._1.getZ()
                                                    - vodniHladina.getPosunutyListPoint3D().get(index)._1.getZ() )

                                                    +(vodniHladina.getPosunutyListPoint3D().get(index+vodniHladina.getxMatice())._1.getZ()
                                                    - vodniHladina.getPosunutyListPoint3D().get(index)._1.getZ() )



                                                    +(vodniHladina.getPosunutyListPoint3D().get(index-vodniHladina.getxMatice())._1.getZ()
                                                    - vodniHladina.getPosunutyListPoint3D().get(index)._1.getZ() ))/3

                                    )
                            ));
                        }else {
                            novy.add(new Tuple2<>(
                                    new Point3D(
                                            vodniHladina.getPosunutyListPoint3D().get(index)._1.getX(),
                                            vodniHladina.getPosunutyListPoint3D().get(index)._1.getY(),
                                            0.0
                                    ),0.0
                            ));
                        }

                    }

                    //prava
                    if ((index+1)%vodniHladina.getxMatice()==0){
                        if (modyTF.get(3)){
                            novy.add(new Tuple2<Point3D,Double>(new Point3D(vodniHladina.getPosunutyListPoint3D().get(index)._1.getX(),
                                    vodniHladina.getPosunutyListPoint3D().get(index)._1.getY(),
                                    vodniHladina.getPosunutyListPoint3D().get(index)._1.getZ()),
                                    (
                                            vodniHladina.getPosunutyListPoint3D().get(index)._2*utlum

                                                    +((vodniHladina.getPosunutyListPoint3D().get(index-1)._1.getZ()
                                                    - vodniHladina.getPosunutyListPoint3D().get(index)._1.getZ() )

                                                    +(vodniHladina.getPosunutyListPoint3D().get(index+vodniHladina.getxMatice())._1.getZ()
                                                    - vodniHladina.getPosunutyListPoint3D().get(index)._1.getZ() )



                                                    +(vodniHladina.getPosunutyListPoint3D().get(index-vodniHladina.getxMatice())._1.getZ()
                                                    - vodniHladina.getPosunutyListPoint3D().get(index)._1.getZ() ))/3



                                    )
                            ));
                        }else {
                            novy.add(new Tuple2<>(
                                    new Point3D(
                                            vodniHladina.getPosunutyListPoint3D().get(index)._1.getX(),
                                            vodniHladina.getPosunutyListPoint3D().get(index)._1.getY(),
                                            0.0
                                    ),0.0
                            ));
                        }

                    }
                    //dolni
                    if (index >vodniHladina.getPosunutyListPoint3D().size()-vodniHladina.getxMatice()){
                        if (modyTF.get(5)){
                            novy.add(new Tuple2<Point3D,Double>(new Point3D(vodniHladina.getPosunutyListPoint3D().get(index)._1.getX(),
                                    vodniHladina.getPosunutyListPoint3D().get(index)._1.getY(),
                                    vodniHladina.getPosunutyListPoint3D().get(index)._1.getZ()),
                                    (
                                            vodniHladina.getPosunutyListPoint3D().get(index)._2*utlum

                                                    +((vodniHladina.getPosunutyListPoint3D().get(index+1)._1.getZ()
                                                    - vodniHladina.getPosunutyListPoint3D().get(index)._1.getZ() )


                                                    +(vodniHladina.getPosunutyListPoint3D().get(index-1)._1.getZ()
                                                    - vodniHladina.getPosunutyListPoint3D().get(index)._1.getZ() )

                                                    +(vodniHladina.getPosunutyListPoint3D().get(index-vodniHladina.getxMatice())._1.getZ()
                                                    - vodniHladina.getPosunutyListPoint3D().get(index)._1.getZ() ))/3



                                    )
                            ));
                        }else {
                            novy.add(new Tuple2<>(
                                    new Point3D(
                                            vodniHladina.getPosunutyListPoint3D().get(index)._1.getX(),
                                            vodniHladina.getPosunutyListPoint3D().get(index)._1.getY(),
                                            0.0
                                    ),0.0
                            ));
                        }

                    }


                }



                /*/





                novy.add(vodniHladina.getPosunutyListPoint3D().get(index));

                //*/

            }else {

                novy.add(new Tuple2<Point3D,Double>(new Point3D(vodniHladina.getPosunutyListPoint3D().get(index)._1.getX(),
                        vodniHladina.getPosunutyListPoint3D().get(index)._1.getY(),
                        vodniHladina.getPosunutyListPoint3D().get(index)._1.getZ()),
                        (
                                vodniHladina.getPosunutyListPoint3D().get(index)._2*utlum

                                        +((vodniHladina.getPosunutyListPoint3D().get(index+1)._1.getZ()
                                        - vodniHladina.getPosunutyListPoint3D().get(index)._1.getZ() )

                                        +(vodniHladina.getPosunutyListPoint3D().get(index+vodniHladina.getxMatice())._1.getZ()
                                        - vodniHladina.getPosunutyListPoint3D().get(index)._1.getZ() )

                                        +(vodniHladina.getPosunutyListPoint3D().get(index-1)._1.getZ()
                                        - vodniHladina.getPosunutyListPoint3D().get(index)._1.getZ() )

                                        +(vodniHladina.getPosunutyListPoint3D().get(index-vodniHladina.getxMatice())._1.getZ()
                                        - vodniHladina.getPosunutyListPoint3D().get(index)._1.getZ() ))/4



                        )
                ));

            }

        }
       // System.out.println(novy);

       this.vodniHladina = new VodniHladina(novy,vodniHladina.getxMatice(),vodniHladina.getyMatice(),vodniHladina.getPointPerPoint());

    }
    //*/


    private double posunCos(double x, double y, double vzdalenost, Point3D a){
        double x0 = a.getX();
        double y0 = a.getY();
        double vysledek;

        if(vzdalenost == 0){
            if(x == a.getX() && y == a.getY()){
                return 1.0;
            }else {
                return 0.0;
            }

        }

        vysledek =
                Math.sqrt(
                        ((x0 - x)*(x0 - x) ) + ((y0 - y)*(y0 - y) )
                );

        if (vysledek <= vzdalenost){

            vysledek = vysledek/vzdalenost;
            vysledek = Math.PI * vysledek;
            vysledek = (Math.cos(vysledek)+1)/2;
            return vysledek;
        }else {
            return 0.0;
        }


    }

    private double posunSin(double x, double y, double vzdalenost, Point3D a){
        double x0 = a.getX();
        double y0 = a.getY();
        double vysledek;

        if(vzdalenost == 0){
            if(x == a.getX() && y == a.getY()){
                return 1.0;
            }else {
                return 0.0;
            }

        }

        vysledek =
                Math.sqrt(
                        ((x0 - x)*(x0 - x) ) + ((y0 - y)*(y0 - y) )
                );

        if (vysledek <= vzdalenost){

            vysledek = vysledek/vzdalenost;
            vysledek = Math.PI * vysledek;
            vysledek = (Math.sin(vysledek)+1)/2;
            return vysledek;
        }else {
            return 0.0;
        }


    }

    private void vykresleniMrizky(int index,GLAutoDrawable glDrawable){
        GL2 gl = glDrawable.getGL().getGL2();
        gl.glPolygonMode(GL2.GL_FRONT, GL2.GL_LINE);
        gl.glPolygonMode(GL2.GL_BACK, GL2.GL_NONE);



        bodPoint3D(
                vodniHladina.getPosunutyListPoint3D().get(index+vodniHladina.getxMatice() )._1,
                glDrawable

        );

        bodPoint3D(
                vodniHladina.getPosunutyListPoint3D().get(index )._1,
                glDrawable

        );

        bodPoint3D(
                vodniHladina.getPosunutyListPoint3D().get(index+1+vodniHladina.getxMatice() )._1,
                glDrawable

        );


        bodPoint3D(
                vodniHladina.getPosunutyListPoint3D().get(index )._1,
                glDrawable

        );

        bodPoint3D(
                vodniHladina.getPosunutyListPoint3D().get( index+1)._1,
                glDrawable

        );

        bodPoint3D(
                vodniHladina.getPosunutyListPoint3D().get( index+vodniHladina.getxMatice()+1 )._1,
                glDrawable

        );
    }

    private void vykresleniPoloLeft(int index,GLAutoDrawable glDrawable){



        bodPoint3D(
                vodniHladina.getPosunutyListPoint3D().get(index )._1,
                glDrawable

        );

        bodPoint3D(
                vodniHladina.getPosunutyListPoint3D().get(index+vodniHladina.getxMatice() )._1,
                glDrawable

        );

        bodPoint3D(
                vodniHladina.getPosunutyListPoint3D().get(index+1+vodniHladina.getxMatice() )._1,
                glDrawable

        );



        bodPoint3D(
                vodniHladina.getPosunutyListPoint3D().get(index )._1,
                glDrawable

        );

        bodPoint3D(
                vodniHladina.getPosunutyListPoint3D().get( index+1)._1,
                glDrawable

        );

        bodPoint3D(
                vodniHladina.getPosunutyListPoint3D().get( index+vodniHladina.getxMatice()+1 )._1,
                glDrawable

        );
    }

    private void vykresleniPoloRight(int index,GLAutoDrawable glDrawable){
        bodPoint3D(
                vodniHladina.getPosunutyListPoint3D().get(index+vodniHladina.getxMatice() )._1,
                glDrawable

        );

        bodPoint3D(
                vodniHladina.getPosunutyListPoint3D().get(index )._1,
                glDrawable

        );

        bodPoint3D(
                vodniHladina.getPosunutyListPoint3D().get(index+1+vodniHladina.getxMatice() )._1,
                glDrawable

        );


        bodPoint3D(
                vodniHladina.getPosunutyListPoint3D().get( index+1)._1,
                glDrawable

        );

        bodPoint3D(
                vodniHladina.getPosunutyListPoint3D().get(index )._1,
                glDrawable

        );

        bodPoint3D(
                vodniHladina.getPosunutyListPoint3D().get( index+vodniHladina.getxMatice()+1 )._1,
                glDrawable

        );
    }

    private void vykresleniFull(int index,GLAutoDrawable glDrawable){
        GL2 gl = glDrawable.getGL().getGL2();
        gl.glPolygonMode(GL2.GL_FRONT, GL2.GL_LINE);
        gl.glPolygonMode(GL2.GL_BACK, GL2.GL_NONE);

        normalaBodu(normalaVec3D(index),glDrawable);

        bodPoint3D(
                vodniHladina.getPosunutyListPoint3D().get(index )._1,
                glDrawable

        );

        normalaBodu(normalaVec3D(index+vodniHladina.getxMatice() ),glDrawable);

        bodPoint3D(
                vodniHladina.getPosunutyListPoint3D().get(index+vodniHladina.getxMatice() )._1,
                glDrawable

        );

        normalaBodu(normalaVec3D(index+1+vodniHladina.getxMatice()),glDrawable);

        bodPoint3D(
                vodniHladina.getPosunutyListPoint3D().get(index+1+vodniHladina.getxMatice() )._1,
                glDrawable

        );


        normalaBodu(normalaVec3D(index+1),glDrawable);

        bodPoint3D(
                vodniHladina.getPosunutyListPoint3D().get( index+1)._1,
                glDrawable

        );

        normalaBodu(normalaVec3D(index),glDrawable);

        bodPoint3D(
                vodniHladina.getPosunutyListPoint3D().get(index )._1,
                glDrawable

        );

        normalaBodu(normalaVec3D(index+vodniHladina.getxMatice()+1),glDrawable);

        bodPoint3D(
                vodniHladina.getPosunutyListPoint3D().get( index+vodniHladina.getxMatice()+1 )._1,
                glDrawable

        );
    }




    private void bodPoint3D(Point3D a,GLAutoDrawable glDrawable){
        GL2 gl = glDrawable.getGL().getGL2();
        gl.glVertex3d(a.getX(),a.getY(),a.getZ());
    }

    private void normalaBodu(Vec3D a, GLAutoDrawable glDrawable){
        GL2 gl = glDrawable.getGL().getGL2();
        gl.glNormal3d(a.getX(),a.getY(),a.getZ());
    }

    private Vec3D normalaVec3D(int index){
        Point3D bod0;
        Point3D bod1;
        Point3D bod00;
        Point3D bod10;
        Vec3D vec0;
        Vec3D vec1;

        List<Tuple2<Point3D,Double>> pomList = new ArrayList<>();
        pomList = vodniHladina.getPosunutyListPoint3D();

        if(index <vodniHladina.getxMatice() ||
                index%vodniHladina.getxMatice()==0 ||
                (index+1)%vodniHladina.getxMatice()==0 ||
                index >vodniHladina.getNeposunutyListPoint3D().size()-vodniHladina.getxMatice() ){

            return new Vec3D(0,0,1);

        }else{

           bod0= pomList.get(index-1)._1;
           bod1= pomList.get(index+1)._1;
           bod00= pomList.get(index-vodniHladina.getxMatice())._1;
           bod10= pomList.get(index+vodniHladina.getxMatice())._1;

           vec0 = new Vec3D(bod0.getX()-bod1.getX(),bod0.getY()-bod1.getY(),bod0.getZ()-bod1.getZ());
           vec1 = new Vec3D(bod00.getX()-bod10.getX(),bod00.getY()-bod10.getY(),bod00.getZ()-bod10.getZ());
           return vec1.cross(vec0);

        }




    }


}
