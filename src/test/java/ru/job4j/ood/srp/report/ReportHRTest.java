package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

class ReportHRTest {

    @Test
    void whenGeneratedSortedBySalaryDescAndNoDates() {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee low = new Employee("Ivan", now, now, 100);
        Employee high = new Employee("Petr", now, now, 200);
        store.add(low);
        store.add(high);

        Report hrReport = new ReportHR(store);

        StringBuilder expected = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(high.getName()).append(" ").append(high.getSalary())
                .append(System.lineSeparator())
                .append(low.getName()).append(" ").append(low.getSalary())
                .append(System.lineSeparator());

        assertThat(hrReport.generate(e -> true)).isEqualTo(expected.toString());
    }
}
