package ru.job4j.ood.srp.report;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class XmlReportEngine implements Report {

    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;
    private final Marshaller marshaller;

    public XmlReportEngine(Store store, DateTimeParser<Calendar> dateTimeParser) throws JAXBException {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
        JAXBContext context = JAXBContext.newInstance(EmployeesDTO.class);
        this.marshaller = context.createMarshaller();
        this.marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> employees = store.findBy(filter);
        List<EmployeeDTO> list = new ArrayList<>();
        for (Employee employee : employees) {
            list.add(new EmployeeDTO(
                    employee.getName(),
                    dateTimeParser.parse(employee.getHired()),
                    dateTimeParser.parse(employee.getFired()),
                    employee.getSalary()
            ));
        }
        EmployeesDTO wrapper = new EmployeesDTO(list);
        StringWriter writer = new StringWriter();
        try {
            marshaller.marshal(wrapper, writer);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        return writer.toString();
    }

    @XmlRootElement(name = "employees")
    private static class EmployeesDTO {
        @XmlElement(name = "employee")
        private List<EmployeeDTO> employees;

        public EmployeesDTO() {
        }

        public EmployeesDTO(List<EmployeeDTO> employees) {
            this.employees = employees;
        }
    }

    @XmlType(propOrder = { "name", "hired", "fired", "salary" })
    private static class EmployeeDTO {
        private String name;
        private String hired;
        private String fired;
        private double salary;

        public EmployeeDTO() {
        }

        public EmployeeDTO(String name, String hired, String fired, double salary) {
            this.name = name;
            this.hired = hired;
            this.fired = fired;
            this.salary = salary;
        }

        @XmlElement
        public String getName() {
            return name;
        }

        @XmlElement
        public String getHired() {
            return hired;
        }

        @XmlElement
        public String getFired() {
            return fired;
        }

        @XmlElement
        public double getSalary() {
            return salary;
        }
    }

}
