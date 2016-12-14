package com.example;

/**
 * Created by User on 11/18/2016.
 */

public class Room {

    public final boolean isInfected;
    public boolean visited = false;


    public Room(boolean infected) {
        isInfected = infected;
    }

    public static boolean isOutbreak(Room[][] hotel) {
        int countInfections = 0, numFloors = 0, numRooms = 0, aNumFloor = 0;
        numFloors = hotel.length;
        for(int numFloor = 0; numFloor < numFloors; numFloor++){
            numRooms = hotel[numFloor].length;
            for (int numRoom=0; numRoom < numRooms; numRoom++){
                //System.out.println("Piso: "+ numFloor + " Cuarto: "+ numRoom);
                Room room = hotel[numFloor][numRoom];
                if(room.isInfected){
                    if(countInfections >= 5){
                        return true;
                    }if(countInfections == 0 ){
                        countInfections++;
                        aNumFloor = numFloor;
                    }else{
                        if(roomNearInfected(hotel, room, numFloor, numRoom, numRooms)){
                            countInfections++;
                            aNumFloor = numFloor;
                        }else{
                            if(aNumFloor != numFloor) {
                                countInfections = 0;
                            }
                        }
                    }
                }else {
                    if(countInfections >= 5){
                        return true;
                    }
                }
                room.visited = true;
            }
        }
        return false;
    }

    private static boolean roomNearInfected(Room[][] hotel, Room room, int numFloor, int numRoom, int numRooms){
        boolean flag = false;
        if(numFloor != 0){
            if(numRoom !=0){
                int bFloor = numFloor - 1;
                int bRoom = numRoom - 1;
                if(hotel[bFloor][numRoom].isInfected || hotel[numFloor][bRoom].isInfected){
                    flag = true;
                }
            }else if(numRoom == 0){
                int bFloor = numFloor - 1;
                if( hotel[bFloor][numRoom].isInfected ){
                    flag = true;
                }
            }
        }else if(numFloor == 0){
            if(numRoom !=0){
                int aRoom = numRoom - 1;
                if( hotel[numFloor][aRoom].isInfected) {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {

        Room[][] verticalTrue = new Room[][]{
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false)},
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false)},
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false)},
                //{new Room(false), new Room(true), new Room(false), new Room(true), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false)},
                {new Room(false), new Room(true), new Room(false), new Room(true), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false)},
                {new Room(false), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false)},
                {new Room(false), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false)},
                {new Room(false), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false)},
                {new Room(false), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false)},
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false)},
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false)}};

        Room[][] horizontalTrue = new Room[][]{
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false)},
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false)},
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false)},
                {new Room(false), new Room(true), new Room(true), new Room(true), new Room(true), new Room(true), new Room(false), new Room(false), new Room(false)},
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false)},
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false)},
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false)},
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false)},
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false)},
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false)}};

        Room[][] noInfection = new Room[][]{
                {new Room(true), new Room(false), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false)},
                {new Room(false), new Room(true), new Room(false), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false)},
                {new Room(true), new Room(false), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false)},
                {new Room(false), new Room(true), new Room(false), new Room(true), new Room(false), new Room(true), new Room(false), new Room(false), new Room(false)},
                {new Room(false), new Room(true), new Room(false), new Room(false), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false)},
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(true), new Room(false), new Room(false), new Room(false)},
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(true), new Room(false), new Room(false)},
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false)},
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false)},
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false)}};

        System.out.println("Vertical true: " + isOutbreak(verticalTrue));
        System.out.println("Horizontal true: " + isOutbreak(horizontalTrue));
        System.out.println("noInfection: " + isOutbreak(noInfection));
    }
}

