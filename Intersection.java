/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package intersection;
import java.util.Scanner;
/**
 *
 * @author Ramda
 */
public class Intersection {

    /**
     * @param args the command line arguments
     */
    
    public static int InputVLane(){
        Scanner S = new Scanner(System.in);
        System.out.println("Enter value of vertical lane: ");
        return S.nextInt();
    }
    
    public static int InputHLane(){
        Scanner S = new Scanner(System.in);
        System.out.println("Enter value of horizontal lane: ");
        return S.nextInt();
    }
    /*
    public static void GlobalMover(Matrix M){
        int L = 0;
           if ("c".equals(M.SelectLane(M,L).LanesArray[i])) {
                M.SelectLane(M,L).LanesArray[i+1] = M.SelectLane(M,L).LanesArray[i];
                M.SelectLane(M,L).LanesArray[i] = " ";
            }
    }*/

    public static void EWMover(Matrix M){
        int i = 0;
        while (!"c".equals(M.EWlanes.get(0).LanesArray[i])){
            i++;
        }
        M.EWlanes.get(0).LanesArray[i+1] = "c";
        M.EWlanes.get(0).LanesArray[i] = " ";
        }

   public static void NSMover(Matrix M){
        int i = 0;
        while (!"c".equals(M.NSlanes.get(0).LanesArray[i])){
            i++;
        }
        M.NSlanes.get(0).LanesArray[i+1] = "c";
        M.NSlanes.get(0).LanesArray[i] = " ";
        }
           
    
    public static void main(String[] args) {
        int vlane = InputVLane();
        int hlane = InputHLane();
        Matrix M1 = new Matrix(vlane,hlane);
        Direction DEW = new Direction();
        Direction DNS = new Direction();
        DNS.EW = false; //DNS is NS
        Car C1 = new Car(DEW);
        Car C2 = new Car(DNS);
        M1.InitTrafficMatrix(M1);
        M1.AddCar(C1,M1);
        M1.AddCar(C2,M1);
        M1.DrawMatrix(M1);
        //test 5 times with move in each cycle
        for (int i = 0;i<7;i++){
            EWMover(M1);
            NSMover(M1);
            M1.DrawMatrix(M1);
            System.out.println("cycle no." + i);
        }   
    }
}
