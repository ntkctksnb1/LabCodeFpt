
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Kien
 */
public class StaxWriter {

    public void writeXML(Race race) {
        FileWriter fileWriter = null;
        try {
            XMLOutputFactory factory = XMLOutputFactory.newInstance();
            fileWriter = new FileWriter("Data.xml");
            XMLStreamWriter writer = factory.createXMLStreamWriter(fileWriter);
            writer.writeStartDocument("UTF-8", "1.0");
            writer.writeCharacters("\n");
            writer.writeStartElement("Race");
            writer.writeAttribute("date", race.getDate());
            writer.writeAttribute("name", race.getName());

            writer.writeCharacters("\n\t");
            writer.writeStartElement("Course");

            writer.writeCharacters("\n\t\t");
            writer.writeStartElement("CourseName");
            writer.writeCharacters(race.getCourseName());
            writer.writeEndElement();

            writer.writeCharacters("\n\t\t");
            writer.writeStartElement("Address");
            writer.writeCharacters(race.getCourseAddress());
            writer.writeEndElement();

            writer.writeCharacters("\n\t");
            writer.writeEndElement();
            writer.writeCharacters("\n\t");
            writer.writeStartElement("Horses");

            for (Horse h : race.getHorses()) {
                writer.writeCharacters("\n\t\t");
                writer.writeStartElement("Horse");
                writer.writeAttribute("Name", h.getName());

                writeSimpleElement(writer, "\n\t\t\t", "Value", h.getValue());
                writeSimpleElement(writer, "\n\t\t\t", "DateOfBirth", h.getDateOfBirth());
                writeSimpleElement(writer, "\n\t\t\t", "Gender", h.getGender());

                writer.writeCharacters("\n\t\t");
                writer.writeEndElement();
            }

            writer.writeCharacters("\n\t");
            writer.writeEndElement();
            writer.writeCharacters("\n");
            writer.writeEndElement();
            writer.writeEndDocument();
        } catch (IOException | XMLStreamException ex) {
            Logger.getLogger(StaxWriter.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(StaxWriter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void writeSimpleElement(XMLStreamWriter writer, String indent, String tag, String content) {
        try {
            writer.writeCharacters(indent);
            writer.writeStartElement(tag);
            writer.writeCharacters(content);
            writer.writeEndElement();
        } catch (XMLStreamException ex) {
            Logger.getLogger(StaxWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void writeSimpleElementAtrribute(XMLStreamWriter writer, String indent, String tag, String content, String attr) {
        try {
            writer.writeCharacters(indent);
            writer.writeStartElement(tag);
            writer.writeAttribute(attr, content);
            writer.writeEndElement();
        } catch (XMLStreamException ex) {
            Logger.getLogger(StaxWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
