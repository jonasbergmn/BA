package sample;

import javafx.event.ActionEvent;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Controller {



    private static final String COMMA_DELIMITER = ";";


    public void buttonClick(ActionEvent actionEvent) {

        String name = "test";
        String name2 =  "test2";

        //objektno gibt an ob es sich um das erste oder zweite objekt handelt


        Objekt o = new Objekt(name, extractWerte(1), extractEbene());
        Objekt o2 = new Objekt(name2, extractWerte(2), extractEbene());
        System.out.println(o.getBetrachtungsebenen());
        System.out.println(o.getWerte());
        System.out.println(o2.getBetrachtungsebenen());
        System.out.println(o2.getWerte());


    }

    public List<List<String>> getData2(){
        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("C:\\Users\\joebe\\IdeaProjects\\BA\\src\\sample\\bacsv.CSV"));) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return records;

    }

    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(COMMA_DELIMITER);
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }

    public ArrayList<String> extractEbene(){
        List<List<String>> x;
        x = getData2();

        ArrayList<String> e = new ArrayList<String>();

        for(int i = 0; i<x.get(0).size(); i++){
            e.add(x.get(0).get(i));
        }

        e.remove(0);
       return e;
    }

    public ArrayList<Integer> extractWerte(int objektno){

        try {
            List<List<String>> x;
            x = getData2();
            ArrayList<Integer> helper = new ArrayList<Integer>();

            ArrayList<String> e = new ArrayList<String>();

            for (int i = 0; i < x.get(objektno).size(); i++) {
                e.add(x.get(objektno).get(i));
            }

            e.remove(0);

            for (int i = 0; i < e.size(); i++) {
                helper.add(Integer.parseInt(e.get(i)));
            }
            return helper;
        }
        catch (Exception e){
            System.out.println("werte nicht korrekt");
            return null;
        }
    }

}
