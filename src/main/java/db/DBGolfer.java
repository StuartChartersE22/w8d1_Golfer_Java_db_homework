package db;

import models.Golfer;

import java.util.List;

public class DBGolfer extends DBHelper {

    public static List<Golfer> getAll(){
        return getAll(Golfer.class);
    }

    public static Golfer find(int id){
        return find(id, Golfer.class);
    }

    public static List<Golfer> orderByAge(){
        return orderByCriterion("age", Golfer.class, false);
    }
}
