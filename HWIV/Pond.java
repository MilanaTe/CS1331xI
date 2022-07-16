public class Pond {
    public static void main(String args[]) {
 
       
    	        //System.out.println(frog1.name);
		Frog frog_peepo= new Frog ("Peepo");
		Frog frog_pepe=new Frog("Pepe",10,15);
 		Frog frog_yourliking=new Frog("Micha",29,5);
		
    	        Fly fly_light = new Fly(1,3);
		Fly fly_heavy = new Fly(6);
		Fly fly_yourliking=new Fly(12);
		
		frog_yourliking.setSpecies("1331 Frogs"); //1
		System.out.println(frog_peepo.toString()); //2
		frog_peepo.eat(fly_heavy); //3
		System.out.println(fly_heavy.toString()); //4
		frog_peepo.grow(8); // 5
		frog_peepo.eat(fly_heavy);//6
		System.out.println(fly_heavy.toString());//7
		System.out.println(frog_peepo.toString());//8
		System.out.println(frog_yourliking.toString());//9
		
 		
 		System.out.println(frog_pepe.toString()); //11
		
 
    }
}