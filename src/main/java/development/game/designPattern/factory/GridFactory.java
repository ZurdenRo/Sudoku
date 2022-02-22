package development.game.designPattern.factory;

public class GridFactory{

    private IGrid grid;



    IGrid createGrid(){
        return grid;
    }
}
