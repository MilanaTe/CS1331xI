import java.util.Arrays;

public class BlueAstronaut extends Player implements Crewmate{


    private int numTasks;
    private int taskSpeed;

    public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed){
        super(name, susLevel);
        this.numTasks=numTasks;
        this.taskSpeed=taskSpeed;

    }
    public BlueAstronaut(String name){
        this(name, 15, 6, 10);


    }
    boolean CheckFrozen=  !(this.isFrozen());

    public int getNumTasks() {
        return numTasks;
    }

    public int setNumTasks(int numTasks) {
        this.numTasks = numTasks;
        return numTasks;
    }

    @Override
    public void completeTask() {
        if(CheckFrozen && this.numTasks != 0){
            if(!(this.taskSpeed>20)){
                this.numTasks=this.numTasks-2;

                if (this.numTasks<=0);
                    this.numTasks=setNumTasks(0);

            }else {   
            	this.numTasks=this.numTasks-1;
                if (this.numTasks<=0);
                    this.numTasks=setNumTasks(0);
            }
                
        }
        this.numTasks=setNumTasks(0);
        System.out.println("I have completed all my tasks ");
        this.setSusLevel((int) (this.getSusLevel()*0.5));
    }
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if ((this.getName() == ((BlueAstronaut) o).getName()) &&
                (this.getSusLevel() == ((BlueAstronaut) o).getSusLevel()) &&
                (this.numTasks == ((BlueAstronaut) o).numTasks) &&
                (this.taskSpeed == ((BlueAstronaut) o).taskSpeed) &&
                (this.isFrozen() == ((BlueAstronaut) o).isFrozen())) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        String frozzz="frozen";
        String notFrozen= "not frozen";

        String notMessage= "My name is "  + getName() + ", and I have a suslevel of "+ getSusLevel() + "." +
                " I am currently " + notFrozen + ". I have " +
                this.numTasks+ " left over.";
        String message= "My name is "  + getName() + ", and I have a suslevel of "+ getSusLevel() + "." +
                " I am currently " + frozzz + ". I have " +
                this.numTasks+ " left over.";
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

    @Override
    public void emergencyMeeting() {
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
