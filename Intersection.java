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
    public static void MoveCar(Matrix M){
        for (int i = 0; i< 5; i++){ //TEMPORARY
            if ("c".equals(M.EWtraffic[i])) {
                M.EWtraffic[i + 1] = M.EWtraffic[i];
                M.EWtraffic[i] = " ";
            } else if ("c".equals(M.NStraffic[i])) {
                M.NStraffic[i + 1] = M.NStraffic[i];
                M.NStraffic[i] = " ";
            }
        }
    }*/
    
    public static void main(String[] args) {
        //int vlane = InputVLane();
        //int hlane = InputHLane();
        Matrix M1 = new Matrix(3,3);
        Direction D1 = new Direction();
        //Car C1 = new Car(D1);
        //M1.InitTrafficMatrix(M1);
        //M1.AddCar(C1,M1);
        //test 5 times with move in each cycle
        for (int i = 0;i<5;i++){
            //MoveCar(M1);
            M1.DrawMatrix(M1);
            System.out.println("cycle no." + i);
        }   
    }
}
