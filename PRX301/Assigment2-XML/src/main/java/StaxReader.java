
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Kien
 */
public class StaxReader {

    public Race getRace() {
        Race race = new Race();
        Horse h = null;
        String currentText = null;
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            FileReader fileReader = new FileReader("Data.xml");
            XMLStreamReader reader = factory.createXMLStreamReader(fileReader);
            while (reader.hasNext()) {
                int category = reader.next();

                switch (category) {
                    case XMLStreamConstants.START_DOCUMENT -> {
                        race = new Race();
                        System.out.println("vo");
                    }
                    case XMLStreamConstants.START_ELEMENT -> {
                        String tag = reader.getLocalName();
                        if (tag.equalsIgnoreCase("Horse")) {
                            h = new Horse();
                            h.setName(reader.getAttributeValue(0));
                        } else if (tag.equalsIgnoreCase("Race")) {
                            race.setDate(reader.getAttributeValue(0));
                            race.setName(reader.getAttributeValue(1));
                        }
                    }
                    case XMLStreamConstants.CHARACTERS -> {
                        currentText = reader.getText();
                    }
                    case XMLStreamConstants.END_ELEMENT -> {
                        String tagg = reader.getLocalName().toLowerCase();
                        switch (tagg) {
                            case "coursename" ->
                                race.setCourseName(currentText);
                            case "address" ->
                                race.setCourseAddress(currentText);
                            case "value" ->
                                h.setValue(currentText);
                            case "dateofbirth" ->
                                h.setDateOfBirth(currentText);
                            case "gender" ->
                                h.setGender(currentText);
                            case "horse" ->
                                race.getHorses().add(h);
                            default -> {
                            }
                        }
                    }
                    default -> {
                    }

                }
            }
        } catch (FileNotFoundException | XMLStreamException ex) {
            Logger.getLogger(StaxReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return race;
    }
}
