/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package intersection;

/**
 *
 * @author RAMDA YANURZHA 12644700
 */
public class Car {
    Direction Cardir;
    int currpos;
    int currlane;
    
    public Car(Direction D){
        Cardir = D;  
    }
    
    public String DrawCar (){
        return "c";
    }
    
    /*public boolean IsOnBorder (Intersect I){
        return ((xpos == I.EWborder) || (ypos == I.NSborder));
    }*/
}
