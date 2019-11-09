package utils;

import entity.AgeGroup;
import entity.MovieTicket;
import entity.ScreeningFormat;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PaymentHistorySeeder {
    public static void main(String[] args) {
    MovieTicket tix = new MovieTicket(AgeGroup.REGULAR,
            true,
            true,
            ScreeningFormat.REGULAR,
            6,
            10
            );
        ArrayList history = new ArrayList();
        history.add(tix);
        SerializeDB.writeSerializedObject("paymentHistory.dat", history);
    }

}
