/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package intersection;

/**
 *
 * @author skarta
 */
public class TrafficLight {
    boolean Red;
    int RedDuration;
    int GreenDuration;
    int border;
    
    public TrafficLight(int TR, int TG, int b){
        RedDuration = TR;
        GreenDuration = TG;
        border = b;
        Red = true;
    }
    
    public void StartRedCounter(){
        if (Red) {
            RedDuration--;
        } else {
            Red = false;
            StartGreenCounter();
        }
        
    }
    
    public void StartGreenCounter(){
        GreenDuration--;
    }
    
    public void Reset(int T){
        RedDuration = T;
        Red = true;
    }
   
}
