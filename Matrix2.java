/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package intersection;
import java.util.*;
/**
 *
 * @author skarta
 */
public class Matrix2 {
    String[][] lanematrix;
    ArrayList<Lanes> EWlanes;
    ArrayList<Lanes> NSlanes;
    ArrayList<Car> EWCars;
    ArrayList<Car> NSCars;
    int v1,vb1,vb2,h1,hb1, hb2 = 0;
    static final int XSIZE = 20;
    static final int YSIZE = 20; 
    
    public Matrix2(int vl, int hl){
        lanematrix = new String[XSIZE][YSIZE];
        EWlanes = new ArrayList<Lanes>();
        NSlanes = new ArrayList<Lanes>();
        for (int i = 0; i < hl; i++){
            EWlanes.add(new Lanes());
        }
        for (int j = 0; j < vl; j++){
            NSlanes.add(new Lanes());
        }
        v1 = (XSIZE - NSlanes.size()) / 2;
        vb1 = v1;
        vb2 = v1+NSlanes.size()+1;
        h1 = (YSIZE-EWlanes.size()) / 2;
        hb1 = h1;
        hb2 = h1+EWlanes.size()+1;
    }   
    
    public int getInitPosH(){
        return hb1+1;
    }
    
    public int getInitPosV(){
        return vb1+1;
    }
    
    public void FillLaneMatrix(){
        for (int i = 0;i<XSIZE;i++)
            for (int j = 0;j<YSIZE;j++) {
                if ((vb1 < i ) && (i < vb2)) {
                    lanematrix[i][j] = " "; //VL
                } else if ((hb1 < j ) && (j < hb2)) {
                    lanematrix[i][j] = " "; //HL
                } else if ((i == vb1) || (i == vb2)) {
                    lanematrix[i][j] = "|";
                } else if ((j == hb1) || (j == hb2)) {
                    lanematrix[i][j] = "-";
                }else {
                    lanematrix[i][j] = " ";
                }
                
            }        
        
    }

    public int GetEWLane(){
        Random R = new Random();
        int randomlane = R.nextInt(EWlanes.size());
        return randomlane;
    }

    public int GetNSLane(){
        Random R = new Random();
        int randomlane = R.nextInt(NSlanes.size());
        return randomlane;
    }

    public void AddCar(Direction D){
        if (D.EW){
            Car C = new Car(D);
            C.currpos = getInitPosH();
            C.currlane = GetEWLane();
            EWCars.add(C);
        } else {
            Car C = new Car(D);
            C.currpos = getInitPosH();
            C.currlane = GetNSLane();
            NSCars.add(C);
        }
    }

    public void FillEWMatrix(){
        for (int h = 0;h<EWlanes.size();h++){
            for (int i = 0;i<XSIZE;i++){
                EWlanes.get(h).LanesArray[i] = " ";
            }
        }
        for (Car C: EWCars){
            EWlanes.get(C.currlane).LanesArray[C.currpos] = "c";
        }

    }

    public void FillNSMatrix(){
        for (int h = 0;h<NSlanes.size();h++){
            for (int i = 0;i<YSIZE;i++){
                NSlanes.get(h).LanesArray[i] = " ";
            }
        }
        for (Car C: NSCars){
            NSlanes.get(C.currlane).LanesArray[C.currpos] = "c";
        }

    }

}
