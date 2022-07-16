public class Frog {
 
    private String name;
    private int age;
    private double tongueSpeed;
    private boolean isFroglet;
    private static String species = "Rare Pepe";

    public static final int default_age = 5;
    public static final double default_speed = 5;

  
    public Frog(String initName) {
        this(initName, default_age, default_speed);
     }

    public Frog(String initName, double ageInYears) {
        this(initName, (int) ageInYears * 12, default_speed);
     }

    public Frog(String initName, int initAge, double initSpeed) {
        this.name = initName;
        this.age = initAge;
        this.tongueSpeed = initSpeed;
     }

	public boolean isFroglet() {
		if (this.age>1 && this.age<7) {
			return true;
		}
		return false;
 	}


	public void grow(int ageGrow) {
		this.age= this.age+ ageGrow ;
		for (getAge(); this.age<12;this.age++){
			this.tongueSpeed=this.tongueSpeed+1;
			isFroglet();//das ist ein boolean..ist true bei if (this.age>1 && this.age<7) 
		}
		
		if(this.age>=30) {
			while (this.tongueSpeed<5) {	
			this.tongueSpeed=this.tongueSpeed-1;
			isFroglet();
			}
	}
		}
 

    public void grow() {
		grow(1);
	}
	public void eat(Fly fly){
		  //  Fly myFly = (Fly) fly; //copy object to instance
			if (fly.isDead()){
				//return;
			}
			else{
				if(this.tongueSpeed>fly.getSpeed()){//caught when  tongueSpeed is greater than the speed
		           // 
					if (fly.getMass()>= (0.5*this.age)){
						this.grow();
					}
					
					
					fly.setMass(0.0);
				}
				else{
					fly.grow(1);
					
				}
				
			}
		}
    public String toString() {
        if (isFroglet) {
            return "My name is " + name + " and I’m a rare froglet! I’m " + age + " months old and my tongue has a speed of " + String.format("%.2f", tongueSpeed) + ".";
        } else {
            return "My name is " + name + " and I’m a rare frog. I’m " + age + " months old and my tongue has a speed of " + String.format("%.2f", tongueSpeed) + ".";
        }
    }

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the tongueSpeed
	 */
	public double getTongueSpeed() {
		return tongueSpeed;
	}

	/**
	 * @param tongueSpeed the tongueSpeed to set
	 */
	public void setTongueSpeed(double tongueSpeed) {
		this.tongueSpeed = tongueSpeed;
	}

	/**
	 * @return the isFroglet
	 */


	/**
	 * @return the species
	 */
	public String getSpecies() {
		return this.species;
	}

	/**
	 * @param species the species to set
	 */
	public void setSpecies(String species) {
		this.species = species;
	}

	/**
	 * @param isFroglet the isFroglet to set
	 */
	public void setFroglet(boolean isFroglet) {
		this.isFroglet = isFroglet;
	}

 
}