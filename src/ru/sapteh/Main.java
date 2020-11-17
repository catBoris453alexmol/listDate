package ru.sapteh;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
       // read file
        String fileName = "listStudents.txt";
        ArrayList<Person> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                Person person = getPerson(reader.readLine());
                list.add(person);
            }
        }
        // console po id
        try(BufferedReader readerId = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("Введите айди студента: ");
            int id = Integer.parseInt(readerId.readLine());
            for (Person person: list) {
                if (id == person.getId()){
                    System.out.printf("Студент: %s %s %s имеет возвраст %d года ", person.getLastname(),person.getName(),person.getFname(),person.getYear());
                }

            }

        }



        //write in file
        File file = new File("C:/java_42/listStudents2.txt");
        file.createNewFile();
        FileWriter fw = new FileWriter(file);
        for (Person person : list) {
            fw.write(person.toString());
        }
        fw.close();
    }
        //Metod write File
    public static Person getPerson(String stringLine) throws ParseException {
        String[] strPerson = stringLine.split(" ");
        int id = Integer.parseInt(strPerson[0]);
        String lastname = strPerson[1];
        String name = strPerson[2];
        String fname = strPerson[3];
        Date date = new SimpleDateFormat("MM/dd/yyyy").parse(strPerson[4]);
        return new Person(id, lastname, name, fname, date);
    }
}
