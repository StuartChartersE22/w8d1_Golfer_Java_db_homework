package db;

import models.Golfer;

import java.util.List;

public class DBGolfer extends DBGeneric {

    public static List<Golfer> getAll(){
        return getAll(Golfer.class);
    }
}
