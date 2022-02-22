package development.game.designPattern.factory;

public class GridFactory{

    private IGrid grid;

    public static IGrid createGridTwo(){
        IGrid grid = new GridTwo();
        grid.buildGrid();
        return grid;
    }

}
