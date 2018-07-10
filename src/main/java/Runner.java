

import db.DBGolfer;
import models.Golfer;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Golfer golfer = new Golfer("John", "Billson", 47);
        DBGolfer.save(golfer);

        List<Golfer> golfers = DBGolfer.getAll();
        Golfer foundGolfer = DBGolfer.find(golfer.getId());

        System.out.println(golfers);

        System.exit(0);
    }
}
