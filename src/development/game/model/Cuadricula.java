package development.game.model;

import java.util.ArrayList;
import java.util.Random;

public class Cuadricula {

    public static Cell arr[] = new Cell[9];
    public static Cell[] numbersAvailable = new Cell[9];
    public static ArrayList<Integer> numbersMissing;
    
    public Cuadricula() {

    }

    public static Cell[] getArr(){
        return arr;
    }

    public static void setArr(Cell[] arr){
        Cuadricula.arr = arr;
    }

    public int generateNumberRandom() {
        Random number = new Random();
        int n = number.nextInt(9);
        return n += 1;
    }

    public void createArrayNumber(){
        for (int i = 0 ; i < arr.length ; i++){
            arr[i] = new Cell(generateNumberRandom(),false, i);
        }
    }

    public static void addNumber(){
        for (int i = 0; i < numbersAvailable.length ; i++){
            numbersAvailable[i] = new Cell(i +1 , true) ;
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
                System.out.println(arr[i].getNumber() + "Repeat:");

            }else{
                System.out.println(arr[i].getNumber());
            }
        }
    }

    public void markTrueNumberRepetitive(){
        numbersMissing = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
             searchArrNumberEnable(arr[i]);
        }
        changeNumbersRepetitiveForMissing();
        selectNumberMissing();
    }

    public void searchArrNumberEnable(Cell c){
        for (int i = 0; i < numbersAvailable.length; i++) {
            if(numbersAvailable[i].getNumber() == c.getNumber()){
                numbersAvailable[i].setNumberAbsent(false);
            }
        }
    }

    public void changeNumbersRepetitiveForMissing(){
        for (int i = 0; i < numbersAvailable.length; i++) {
            if(numbersAvailable[i].isNumberAbsent()){
                numbersMissing.add(numbersAvailable[i].getNumber());
            }
        }
    }
    public void selectNumberMissing(){
        Random r = new Random();

        for (int i = 0; i < arr.length; i++) {
            if(arr[i].isRepeat()){
                int n = r.nextInt(numbersMissing.size());

                arr[i].setNumber(numbersMissing.get(n));
                numbersMissing.remove(n);
            }
        }
    }

    public void sizeNumberAbsent(){
        System.out.println(numbersMissing.size());
    }


    @Override
    public String toString(){
        return super.toString();
    }
}