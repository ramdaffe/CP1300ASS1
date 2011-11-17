/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package intersection;
import java.util.*;

/**
 *
 * @author Ramda
 */
public class Matrix {
    String[][] lanematrix;
    ArrayList<Lanes> EWlanes;
    ArrayList<Lanes> NSlanes;
    ArrayList<Car> EWCars;
    ArrayList<Car> NSCars;
    int v1,vb1,vb2,h1,hb1, hb2 = 0;
    static final int XSIZE = 20;
    static final int YSIZE = 20; 
    
    public Matrix(int vl, int hl){
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
    
    public int getInitPosH(Matrix M){
        return M.hb1+1;
    }
    
    public int getInitPosV(Matrix M){
        return M.vb1+1;
    }
    
    public void FillLaneMatrix(Matrix M){
        for (int i = 0;i<XSIZE;i++)
            for (int j = 0;j<YSIZE;j++) {
                if ((M.vb1 < i ) && (i < M.vb2)) {
                    M.lanematrix[i][j] = " ";
                } else if ((M.hb1 < j ) && (j < M.hb2)) {
                    M.lanematrix[i][j] = " ";
                } else if ((i == M.v1) || (i == (M.v1+M.NSlanes.size()+1))) {
                    M.lanematrix[i][j] = "|";
                } else if ((j == M.h1) || (j == (M.h1+M.EWlanes.size()+1))) {
                    M.lanematrix[i][j] = "-";
                }else {
                    M.lanematrix[i][j] = " ";
                }
                
            }        
        
    }
    
    public void FillEWMatrix(Matrix M){
        for (int h = 0;h<M.EWlanes.size();h++){
            for (int i = 0;i<XSIZE;i++){
                M.EWlanes.get(h).LanesArray[i] = " "; 
            }
        }
    }
    
    public void FillNSMatrix(Matrix M){
        for (int h = 0;h<M.NSlanes.size();h++){
            for (int i = 0;i<XSIZE;i++){
                M.NSlanes.get(h).LanesArray[i] = " ";
            }
        }
    }
    
    public void AddTLEW(Matrix M){
        for (int i = 0; i<M.EWlanes.size();i++){
            M.EWlanes.get(i).LaneTL = new TrafficLight(5,5,vb1);
        }
    }
    
    public void AddTLNS(Matrix M){
        for (int i = 0; i<M.NSlanes.size();i++){
            M.NSlanes.get(i).LaneTL = new TrafficLight(5,5,hb1);
        }
    }
    
    public void InitTrafficMatrix(Matrix M){
        FillEWMatrix(M);
        FillNSMatrix(M);
        AddTLEW(M);
        AddTLNS(M);
    }
    
    public void CombineMatrix(Matrix M){
        
        for (int h = 0;h<M.EWlanes.size();h++){
            for (int i = 0;i<XSIZE;i++){
                M.lanematrix[i][M.getInitPosH(M)+h] = M.EWlanes.get(h).LanesArray[i];
            }
        }
        
        for (int h = 0;h<M.NSlanes.size();h++){
            for (int i = 0;i<YSIZE;i++){
                M.lanematrix[M.getInitPosV(M)+h][i] = M.NSlanes.get(h).LanesArray[i];
            }
        }
    }
    
   public void AddCar(Car C, Matrix M){
        if (C.Cardir.EW) {
            EWCars.add(C);
            M.EWlanes.get(0).LanesArray[0] = EWCars.get(0).DrawCar();
        } else {
            NSCars.add(C);
            M.NSlanes.get(0).LanesArray[0] = NSCars.get(0).DrawCar();
        }
    }
    
    public void DrawMatrix(Matrix M){
        FillLaneMatrix(M);
        CombineMatrix(M);
        for (int n = 0;n<YSIZE;n++)
            for (int m = 0;m<XSIZE;m++){
                if (m == 0){
                    System.out.println("");
                    System.out.print(M.lanematrix[m][n]);
                } else {
                    System.out.print(M.lanematrix[m][n]);
                }
            }
        System.out.println(" ");
        for (int n = 0;n<10;n++){
            System.out.print(">");
        }
    }

    //STILL UNDER CONSTRUCTION
    public Lanes SelectLane(Matrix M, int L){
        return M.EWlanes.get(L);
    }
    
    public static void main(String [] args){
        Matrix M  = new Matrix(3,3);
        System.out.println(M.EWlanes.get(0).LanesArray[0]);
    }
}
