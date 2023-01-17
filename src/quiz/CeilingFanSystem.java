package quiz;
public class CeilingFanSystem {
public boolean isPowered;
public CeilingFan fan;
public int speed = 0;

public CeilingFanSystem() {
isPowered = false;
speed = 0;
fan = null;
}

public void powerButtonPushed() { // called when user presses button
if (isPowered) {
speed = fan.speed; 
fan = null; // destroy CeilingFan object to cut power
} else {
fan = new CeilingFan(speed); // create CeilingFan
}
isPowered = !isPowered;
}

public static void main() {
CeilingFanSystem system = new CeilingFanSystem();
}
}
