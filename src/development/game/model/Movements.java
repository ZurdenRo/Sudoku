package development.game.model;

public enum Movements{

    LEFT(-1), RIGHT(1), DOWN(-1), UP(1);

    private int number;

    Movements(int number){ }

    public int getMovements(){
        return this.number;
    }
}
