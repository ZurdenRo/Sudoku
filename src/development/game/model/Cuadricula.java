package development.game.model;

import java.util.ArrayList;
import java.util.Random;

public class Cuadricula {
	
	public static  Celda arr[] = new Celda[9];
    public static Celda [] numerosDisponibles = new Celda [9];
    public static ArrayList<Integer> numerosFaltantes;
    
    public Cuadricula() {

    }

    public int generateNumberRandom() {
        Random number = new Random();
        int n = number.nextInt(9);
        return n += 1;
    }

    public void createArrayNumber(){
        for (int i = 0 ; i < arr.length ; i++){
            arr[i] = new Celda(generateNumberRandom(),false, i);
        }
    }

    public static void addNumber(){
        for (int i = 0 ; i < numerosDisponibles.length ; i++){
            numerosDisponibles[i] = new Celda(i +1 , true) ;
        }

    }

    public void printNumber(Object [] arr){
        for (int i =  0; i < arr.length ; i++) {
            System.out.println(arr[i]);
        }
    }

    public void removeNumberRepetitive(){
        for (int i = 0; i < arr.length; i++) {
            //System.out.println(arr[i]);
            for (int j = 0; j < arr.length; j++) {
                if(!(arr[i].isRepeat())){
                    if(arr[i].getPosition() != arr[j].getPosition()){
                        if(arr[i].getNumber() == arr[j].getNumber()  ){
                            // System.out.println( arr[j].getNumber() + "Repeat");
                            arr[j].setRepeat(true);
                        }
                    }
                }
            }
        }
    }

    public void printNumberRepetitive(){
        for (int i = 0; i < arr.length; i++) {

            if(arr[i].isRepeat()){
                System.out.println(arr[i].getNumber() + "Repetido");

            }else{
                System.out.println(arr[i].getNumber());
            }
        }
    }

    public void markTrueNumberRepetitive(){
        numerosFaltantes = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
             searchArrNumberEnable(arr[i]);
        }
        changerNumerosReptidosPorFaltantes();
        seleccionarNumerosFaltantes();
    }

    public void searchArrNumberEnable(Celda c){
        for (int i = 0; i < numerosDisponibles.length; i++) {
            if(numerosDisponibles[i].getNumber() == c.getNumber()){
                numerosDisponibles[i].setNumberAbsent(false);
            }
        }
    }

    public void changerNumerosReptidosPorFaltantes(){
        for (int i = 0; i < numerosDisponibles.length; i++) {
            if(numerosDisponibles[i].isNumberAbsent()){
                numerosFaltantes.add(numerosDisponibles[i].getNumber());
            }
        }
    }
    public void seleccionarNumerosFaltantes(){
        Random r = new Random();

        for (int i = 0; i < arr.length; i++) {
            if(arr[i].isRepeat()){
                int n = r.nextInt(numerosFaltantes.size());

                arr[i].setNumber(numerosFaltantes.get(n));
                numerosFaltantes.remove(n);
            }
        }
    }

    public void sizeNumberAbsent(){
        System.out.println(numerosFaltantes.size());
    }


}