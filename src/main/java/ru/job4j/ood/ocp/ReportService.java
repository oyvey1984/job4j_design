package ru.job4j.ood.ocp;

public class ReportService {
    private PDFExporter exporter = new PDFExporter();

    public void export() {
        exporter.exportPDF();
    }
}