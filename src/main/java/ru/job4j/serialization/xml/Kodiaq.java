package ru.job4j.serialization.xml;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.*;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "kodiaq")
@XmlAccessorType(XmlAccessType.FIELD)
public class Kodiaq {
    @XmlAttribute
    private boolean diesel;

    @XmlAttribute
    private int clearance;

    @XmlAttribute
    private String wheelDrive;

    private Engine engine;

    @XmlElementWrapper(name = "sizes")
    @XmlElement(name = "size")
    private String[] size;

    public Kodiaq() {
    }

    public Kodiaq(boolean diesel, int clearance, String wheelDrive, Engine engine, String[] size) {
        this.diesel = diesel;
        this.clearance = clearance;
        this.wheelDrive = wheelDrive;
        this.engine = engine;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Kodiaq{"
                + "diesel=" + diesel
                + ", clearance=" + clearance
                + ", wheelDrive='" + wheelDrive + '\''
                + ", engine=" + engine
                + ", size=" + Arrays.toString(size)
                + '}';
    }

    public static void main(String[] args) throws JAXBException {
        final Kodiaq kodiaq = new Kodiaq(true, 188, "all wheel drive",
                new Engine("Diesel", 180), new String[]{"Length: 4697 mm", "Width: 1882 mm", "Height: 1655 mm"});

        JAXBContext context = JAXBContext.newInstance(Kodiaq.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";

        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(kodiaq, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            Kodiaq result = (Kodiaq) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}