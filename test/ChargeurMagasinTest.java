import XML.ChargeurMagasin;
import donnees.Magasin;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ChargeurMagasinTest {

    @Test
    public void testChargerMagasin() throws FileNotFoundException {
        ChargeurMagasin chargeur = new ChargeurMagasin("musicbrainzSimple/");
        Magasin magasin = chargeur.chargerMagasin();
        assertEquals(12, magasin.getNombreCds());
    }

    @Test
    public void test2_chargerMagasin_exception() {
        boolean exception = false;
        try {
            ChargeurMagasin chargeurMagasin = new ChargeurMagasin("rep_faux");
            Magasin magasin = chargeurMagasin.chargerMagasin();
        } catch (FileNotFoundException e){
            exception = true;
        }
        assertEquals(true, exception);
    }
    
}
