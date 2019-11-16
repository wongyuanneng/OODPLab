package utils;

import entity.AgeGroup;
import entity.MovieTicket;
import entity.PriceTableTicket;
import entity.ScreeningFormat;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


/**
 Generic TextTicket DB class that reads and writes price tablr data into text file
 @author SS3_Group4
 @version 1.0
 @since 2019-11-15
*/

public class TextTicketDB {
    /**
    * The separator used in the text file
    */
    public static final String SEPARATOR = "|";

    /** 
    * Read price from file
    * @param filename The file's name
    * @return The entry containing the price
    */
    public static ArrayList readPrices(String filename) {
        try {
            ArrayList stringArray = (ArrayList) read(filename);
            ArrayList alr = new ArrayList();
            for (int i = 0; i < stringArray.size(); i++) {
                String st = (String) stringArray.get(i);

                StringTokenizer star = new StringTokenizer(st, SEPARATOR);

                boolean weekday = star.nextToken().trim().equals("true") ? true : false;
                boolean before6 = star.nextToken().trim().equals("true") ? true : false;
                AgeGroup ageGroup = AgeGroup.valueOf(star.nextToken().trim());
                ScreeningFormat format = ScreeningFormat.valueOf(star.nextToken().trim());
                int day = Integer.parseInt(star.nextToken().trim());
                float price = Float.parseFloat(star.nextToken().trim());

                PriceTableTicket ticket = new PriceTableTicket(ageGroup, weekday, before6, format, day, price);
                alr.add(ticket);

            }
            return alr;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /** 
    * Read from file
    * @param filename The file's name
    * @return The list of objects read
    */
    public static List read (String filename) throws IOException {
        List data = new ArrayList();
        Scanner scan = new Scanner( new FileInputStream("src/data/" + filename));
        try {
            while(scan.hasNextLine()) {
                data.add(scan.nextLine());
            }
        } finally {
            scan.close();
        }
        return data;
    }

    /** 
    * Write price into the file
    * @param filename The file's name
    * @param priceTable The new price table
    */
    public static void savePrices(String filename, ArrayList priceTable) throws IOException {
        List alw = new ArrayList();

//        for (Enumeration i = priceTable.keys(); i.hasMoreElements();) {
//            StringBuilder st = new StringBuilder();
//            String key = (String)i.nextElement();
//            String value = (String)priceTable.get(key);
//            st.append(key);
//            st.append(SEPARATOR);
//            st.append(value);
//            alw.add(st.toString());
//        }
//
        for (int i =0; i < priceTable.size(); i++) {
            StringBuilder st = new StringBuilder();
            PriceTableTicket ticket = (PriceTableTicket) priceTable.get(i);
            st.append(Boolean.toString(ticket.isWeekday()).trim());
            st.append(SEPARATOR);
            st.append(Boolean.toString(ticket.isBefore6()).trim());
            st.append(SEPARATOR);
            st.append(ticket.getAgeGroup().toString().trim());
            st.append(SEPARATOR);
            st.append(ticket.getFormat().toString().trim());
            st.append(SEPARATOR);
            st.append(Integer.toString(ticket.getDay()).trim());
            st.append(SEPARATOR);
            st.append(Float.toString(ticket.getPrice()).trim());
            alw.add(st.toString());
        }
        write(filename, alw);
    }

    /** 
    * Write into file
    * @param filename The file's name
    * @param data The data to be written in
    */
    public static void write(String filename, List data) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter("src/data/" + filename));

        try {
            for (int i =0; i < data.size(); i++) {
                out.println((String)data.get(i));
            }
        } finally {
            out.close();
        }
    }


    public static void main(String[] args) throws IOException {
//        ArrayList priceTable = readPrices("prices.txt");
//        MovieTicket newTicket = new MovieTicket(AgeGroup.REGULAR, true, true,ScreeningFormat.THREEDIMENSION, 1, 10);
//        priceTable.add(newTicket);
//        savePrices("prices.txt", priceTable);
    }
}
