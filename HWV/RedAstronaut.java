import java.util.Arrays;

public class RedAstronaut extends Player implements Impostor {
   
    private String skill;
    private Object p;


    public RedAstronaut(String name) {
        this(name, 15, "experienced");


    }

    public RedAstronaut(String name, int susLevel, String skill) {
        super(name, susLevel);
        this.skill = skill;
     }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if ((this.getName() == ((RedAstronaut) o).getName()) &&
                (this.getSusLevel() == ((RedAstronaut) o).getSusLevel()) &&
                (this.skill == ((RedAstronaut) o).skill) &&
                (this.isFrozen() == ((RedAstronaut) o).isFrozen())) {
            return true;
        }
     

        return false;
    }


    @Override
    public String toString() {
        String frozzz="frozen";
        String notFrozen= "not frozen";

        String notMessage= "My name is "  + getName() + ", and I have a suslevel of "+ getSusLevel() + "." +
                " I am currently " + notFrozen + ". I am an " +
                skill+ " player!";
        String message= "My name is "  + getName() + ", and I have a suslevel of "+ getSusLevel() + "." +
                " I am currently " + frozzz + ". I am an " +
                skill+ " player!";
        String messageCapital=  message.toUpperCase();
        if (!(this.getSusLevel()>15)){
            if (this.isFrozen()==false){

                return notMessage;
            }return message;
        }else
        if (this.isFrozen()==false){
            return notMessage.toUpperCase();
        }return message.toUpperCase();
    }


    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
 

    @Override
    public void freeze(Player p) {
        if((p.isFrozen())|| (this.isFrozen())|| p instanceof Impostor) {
            return; 
        }
        
        if(this.getSusLevel() < p.getSusLevel()){ 
         	p.setFrozen(true);
            gameOver();

        }else{
           int setMultiplyCurrent=this.getSusLevel()*2;
           this.setSusLevel(setMultiplyCurrent); 

        }this.gameOver(); 


    }

    @Override
    public void sabotage(Player p) {

        boolean b = p instanceof Impostor;
        if((p.isFrozen())||(this.isFrozen())|| b) {
            return;
        }
       if (this.getSusLevel() < 20) {
                p.setSusLevel((int) (p.getSusLevel() * 1.5));
        } else {
                p.setSusLevel((int) (p.getSusLevel() * 1.25));
       
    }
    }

    @Override
    public void emergencyMeeting() {
         boolean CheckFrozen=  !(this.isFrozen());
         if(CheckFrozen) {
             Player[] players=Player.getPlayers();
             Arrays.sort(players);

             // The player that has the highest susLevel will be accused
             // being the impostor and will be voted off
 int IndexSusLevelPlayerMost= players.length-1;
 Player SusLevelPlayerMost=players[IndexSusLevelPlayerMost];
 Player SusLevelPlayerMost2=players[IndexSusLevelPlayerMost-1];

             while(players.length-1>=0){
                 SusLevelPlayerMost=players[IndexSusLevelPlayerMost];
                 if(!SusLevelPlayerMost.isFrozen()&& SusLevelPlayerMost!=this){
                     break;
                 }
                 IndexSusLevelPlayerMost--;

             }

             if(SusLevelPlayerMost.getSusLevel()==SusLevelPlayerMost2.getSusLevel()){
                    return;
             }else{
                 SusLevelPlayerMost.setFrozen(true);
                 SusLevelPlayerMost.gameOver();

             }
         }
    }



}
