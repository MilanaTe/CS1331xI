public class Fly {
    private double mass;
    private double speed;

   
    public Fly(double mass, double speed) {
        this.mass = mass;
        this.speed = speed;
    }
    
    public Fly(double mass) {
    	this.speed=10;    
    	}
    
    public Fly() {
        this(5, 10);
    }



	public String toString() {
		if (mass==0) {
			String i= "I’m dead, but I used to be a fly with a speed of " + String.format("%.2f", speed) + ".";
			return i;
		}
		else {
		String j= "I’m a speedy fly with "+ String.format("%.2f", speed) + " speed and " + String.format("%.2f", mass) + " mass.";
 		return j;
		} 	
		
	}
	public void grow(int i){
		this.mass=this.mass+i;
		double diff= Math.abs(20-this.mass);
		
		this.speed=this.mass < 20 ? this.speed + diff:this.speed - 0.5 * diff;		
	}
	
	public boolean isDead() {
		if(this.mass==0) {
		return true;
	}return false;
	}
	
	/**

	 * @return the mass
	 */
	public double getMass() {
		return this.mass;
	}

	/**
	 * @param mass the mass to set
	 */
	public void setMass(double _mass) {
		this.mass = _mass;
	}

	/**
	 * @return the speed
	 */
	public double getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(double speed) {
		this.speed = speed;
	}
}