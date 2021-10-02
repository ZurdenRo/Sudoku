package development.game.model;

public class Position{

    private int fila;
    private int columna;

    public Position(int fila, int columna){
        setFila(fila);
        setColumna(columna);
    }

    public int getFila(){
        return fila;
    }

    public void setFila(int fila){
        this.fila = fila;
    }

    public int getColumna(){
        return columna;
    }

    public void setColumna(int columna){
        this.columna = columna;
    }


    public boolean equals(Position obj){
        if(obj == null) return false;
        if(this.getColumna() == obj.getColumna() && this.getFila() == obj.getFila()) return true;
        if(this.getColumna() != obj.getColumna() || this.getFila() != obj.getFila()) return false;
        return this.getColumna() != obj.getColumna() && this.getFila() != obj.getFila();
    }

    @Override
    public String toString(){
        return "{" +
                "fila=" + fila +
                ", columna=" + columna +
                '}';
    }


}