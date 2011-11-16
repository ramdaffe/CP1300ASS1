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

    public static void GlobalMover(Matrix M){
        EWMover(M);
        NSMover(M);
    }

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
           
    public static void Say(String S){
        System.out.println(S);
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
        Say("initial condition");
        //test 5 times with move in each cycle
        for (int i = 0;i<7;i++){
            GlobalMover(M1);
            M1.DrawMatrix(M1);
            Say("cycle no." + (i+1));
        }   
    }
}
