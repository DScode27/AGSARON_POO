package Control;

import Modelo.Almacen;
import Modelo.Pareja;
import Modelo.Persona;
import Modelo.Producto;
import Vista.DatosPareja;
import Vista.Mensaje;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class ControlPDF {
    private Control control;
    private DatosPareja datosPareja;
    private Pareja pareja;

    Document doc = new Document();

    public void generarPDF(String nombre, String almacen, Pareja pareja) {
        PdfPTable table;

        Paragraph tittle = new Paragraph("HIDE&SEEK MARKET", new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD, new BaseColor(255, 0, 0)));
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        Paragraph hora = new Paragraph("HORA: " + date);
        Paragraph report = new Paragraph("REPORTE DE COMPRAS", FontFactory.getFont(FontFactory.HELVETICA, 14));

        try {
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("Factura" +nombre+ ".pdf"));
            Mensaje.mensajeConsola("PDF created.");
            doc.open();

            tittle.setAlignment(1);
            report.setAlignment(1);
            doc.add(tittle);
            doc.add(report);
            doc.add(Chunk.NEWLINE);
            doc.add(Chunk.NEWLINE);
            hora.setAlignment(2);
            doc.add(hora);
            doc.add(Chunk.NEWLINE);
            doc.add(new Paragraph("Nombre: " + nombre + "                          Almacen: " + almacen, FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD)));
            doc.add(Chunk.NEWLINE);
            table = new PdfPTable(2);
            PdfPCell producto = new PdfPCell(new Phrase("Producto", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD)));
            PdfPCell precio = new PdfPCell(new Phrase("Precio", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD)));
            table.addCell(producto);
            table.addCell(precio);
            for (int i=0;i<pareja.getProductos().size();i++){
                table.addCell(pareja.getProductos().get(i).getNombre());
                table.addCell(Double.toString(pareja.getProductos().get(i).getPrecio()));
            }

            doc.add(table);

            doc.add(Chunk.NEWLINE);

            ArrayList<Double> precios = new ArrayList<>();
            for (Producto product : pareja.getProductos()) {
                precios.add(product.getPrecio());
            }

            // Calcular media
            double media = calcularMedia(precios);
            doc.add(new Paragraph("Media: " + media));

            // Calcular moda
            ArrayList<Double> moda = calcularModa(precios);
            doc.add(new Paragraph("Moda: " + moda));

            // Calcular mediana
            double mediana = calcularMediana(precios);
            doc.add(new Paragraph("Mediana: " + mediana));

            doc.close();
            writer.close();
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private double calcularMedia(ArrayList<Double> datos) {
        double suma = 0;
        for (double dato : datos) {
            suma += dato;
        }
        return suma / datos.size();
    }

    private ArrayList<Double> calcularModa(ArrayList<Double> datos) {
        ArrayList<Double> moda = new ArrayList<>();
        for (double dato : datos) {
            if (Collections.frequency(datos, dato) > 1 && !moda.contains(dato)) {
                moda.add(dato);
            }
        }
        return moda;
    }

    private double calcularMediana(ArrayList<Double> datos) {
        Collections.sort(datos);
        int n = datos.size();
        if (n % 2 == 0) {
            int medio1 = n / 2 - 1;
            int medio2 = n / 2;
            return (datos.get(medio1) + datos.get(medio2)) / 2.0;
        } else {
            return datos.get(n / 2);
        }
    }
}
