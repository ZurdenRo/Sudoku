package development.game.model;

public enum Movements{

    LEFT(-1, PositionMovements.HORIZONTAL),
    RIGHT(1, PositionMovements.HORIZONTAL),
    DOWN(-1, PositionMovements.VERTICAL),
    UP(1, PositionMovements.VERTICAL);

    private int number;
    private PositionMovements positionMovements;

    Movements(int number, PositionMovements positionMovements){
        setNumber(number);
        setPositionMovements(positionMovements);
    }

    public void setNumber(int number){
        this.number = number;
    }

    public int getNumber(){
        return number;
    }

    public void setPositionMovements(PositionMovements positionMovements){
        this.positionMovements = positionMovements;
    }

    public String getPositionMovements(){
        return positionMovements.getPosMovements();
    }

    private enum PositionMovements{
        VERTICAL("VERTICAL"), HORIZONTAL("HORIZONTAL");

        private String posMovements;

        PositionMovements(String posMovements){
            this.posMovements = posMovements;
        }

        public String getPosMovements(){
            return this.posMovements;
        }
    }

}
