//write a class that will give an object a position and it's speed in x & y
//create an update that will change x and y positions based on speed 

 
public class Movement{
  double xSpeed;
  double ySpeed;
  int xPos, yPos;
  
  public Movement (double xSpeed, double ySpeed, int xPos, int yPos){
    this.xSpeed = xSpeed;
    this.ySpeed = ySpeed;
    this.xPos = xPos;
    this.yPos  = yPos;
  }
  
  public int getXPos() {
    return xPos;
  }
  
  public int getYPos() {
    return yPos;
  }

}
