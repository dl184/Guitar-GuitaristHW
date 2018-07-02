import db.DBGuitar;
import db.DBGuitarist;
import models.Guitar;
import models.Guitarist;

public class Runner {

    public static void main(String[] args) {

        Guitar guitar = new Guitar("Gibson", "LesPaul");
        DBGuitar.save(guitar);

        Guitarist guitarist = new Guitarist("Jimi Hendrix", 27);
        DBGuitarist.save(guitarist);

        Guitar foundGuitar = DBGuitar.findOne(guitar.getId());

        Guitarist foundGuitarist = DBGuitarist.findOne(guitarist.getId());

    }
}
