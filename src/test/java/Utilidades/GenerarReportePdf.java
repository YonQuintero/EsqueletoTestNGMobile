package Utilidades;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import ClasesBase.ClaseBase;

public class GenerarReportePdf {
	static String nombre = "prueba";
	static String fecha;
	static Document documento;
	static FileOutputStream archivo;
	static Paragraph titulo;
	String rutaImagen;
	String hora;
	String horaIni, horaFin;

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

	public void crearPlantilla(String nomTest, File rutaCarpeta) {
		// INSTANCIAR DOCUMENTO
		documento = new Document();
		// TOMAR LA HORA DEL SISTEMA
		hora = ClaseBase.fechaHora();
		horaIni = ClaseBase.fechaHora2();

		try {
			// CREAR RUTA Y NOMBRE DEL PDF
			archivo = new FileOutputStream(rutaCarpeta + "\\" + "Reporte-" + nomTest + "-" + hora + ".pdf");
			PdfWriter.getInstance(documento, archivo);

			// ****CREAR ENCABEZADO
			// UBICACION DE LA IMAGEN
			Image header = Image.getInstance(rutaImagen);
			header.setBorderColor(BaseColor.BLACK);
			header.setBorder(Image.BOX);
			header.setBorderWidth(5);
			header.setBorderColor(BaseColor.BLACK);
			// TAMAÑO DE LA IMAGEN
			header.scaleToFit(150, 400);
			// header.setAlignment(Chunk.ALIGN_CENTER);
			header.setWidthPercentage(100);

			// CREAR TITULO DEL PDF
			titulo = new Paragraph(
					nomTest + "\n\n" + "Fecha inicio: " + horaIni + "\n\n" + "Automatizador junior: Yon Quintero ");
			titulo.setAlignment(1);

			// CREAR TABLA DE ENCABEZADO
			PdfPTable table = new PdfPTable(2);
			table.setWidthPercentage(100);

			PdfPCell pos1 = new PdfPCell(header);
			pos1.setHorizontalAlignment(1);
			pos1.setVerticalAlignment(2);

			PdfPCell pos2 = new PdfPCell(titulo);
			pos2.setHorizontalAlignment(1);// 0=Left, 1= Center, 2=Right
			pos2.setVerticalAlignment(2);

			table.addCell(pos2);
			table.addCell(pos1);

			// GENERAR MARGEN
			documento.setMargins(30, 30, 30, 30);
			// ABRIR DOCUMENTO
			documento.open();
			// INSERTA LA IMAGEN
			documento.add(table);

			documento.add(Chunk.NEWLINE);
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (DocumentException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println("Error al logo periferia" + e.getMessage());
		}
	}

	public void crearBody(By locator, String rutaImagen, String msj) throws DocumentException, MalformedURLException, IOException {
		// OBTENER EL NOMBRE DEL LOCALIZADOR
		String locator1 = locator.toString();
		// DAR FORMATO ALA FUENTE
		Paragraph parrafo = new Paragraph();
		parrafo.setAlignment(Chunk.ALIGN_CENTER);
		parrafo.setFont(FontFactory.getFont("Arial", 10, Font.NORMAL));
		parrafo.add(msj + "\n\n");

		// INSERTAR IMAGEN
		// UBICACION DE LA IMAGEN
		Image imagen = Image.getInstance(rutaImagen);
		imagen.setBorderColor(BaseColor.BLACK);
		imagen.setBorder(Image.BOX);
		imagen.setBorderWidth(5);
		imagen.setBorderColor(BaseColor.BLACK);

		// TAMAÑO DE LA IMAGEN
		imagen.scaleToFit(500, 500);
		// imagen.scaleToFit(700,1000);
		imagen.setAlignment(Chunk.ALIGN_CENTER);
		// Insertamos salto de linea
		Paragraph saltoDeLinea = new Paragraph(
				"                                                                                                                                                                                                                                                                                                                                                                                   ");
		// CREAMOS UNA TABLA
		PdfPTable tb = new PdfPTable(1);
		// CREAMOS UNA CELDA
		PdfPCell c1 = new PdfPCell();
		c1.setBorder(0);
		c1.setIndent(1);
		// AGREGAMOS EL TEXTO Y LA IMAGEN A LA CELDA
		c1.addElement(parrafo);
		c1.addElement(saltoDeLinea);
		c1.addElement(imagen);
		// ANEXAMOS LA CELDA A LA TABLA
		tb.addCell(c1);
		// ANEXAMOS LA TABLA AL DOCUMENTO
		documento.add(tb);
		documento.add(saltoDeLinea);
	}

	public void crearbodyError(By locator, String rutaImagen, String msnError)
			throws DocumentException, MalformedURLException, IOException {
		// OBTENER EL NOMBRE DEL LOCALIZADOR
		String locator1 = locator.toString();
		// DAR FORMATO A LA FUENTE
		Paragraph parrafo = new Paragraph();
		parrafo.setAlignment(Chunk.ALIGN_LEFT);
		parrafo.setFont(FontFactory.getFont("Arial", 10, Font.NORMAL));
		parrafo.add("Se realiza accion sobre el elemento: " + locator1);

		// INSERTAR IMAGEN
		// UBICACION DE LA IMAGEN
		Image imagen = Image.getInstance(rutaImagen);
		imagen.setBorder(Image.BOX);
		imagen.setBorderWidth(5);
		imagen.setBorderColor(BaseColor.RED);
		// TAMAÑO DE LA IMAGEN
		imagen.scaleToFit(300, 300);
		imagen.setAlignment(Chunk.ALIGN_CENTER);

		// MENSAJE DE ERROR
		// DAR FORMATO A LA FUENTE
		Paragraph parrafoError = new Paragraph();
		parrafo.setAlignment(Chunk.ALIGN_LEFT);
		parrafo.setFont(FontFactory.getFont("Arial", 8, Font.NORMAL, BaseColor.BLACK));
		parrafo.add("El mensaje de error: " + "\n" + msnError);
		// documento.add(parrafoError);
		// Insertamos salto de linea
		Paragraph saltoDeLinea = new Paragraph(
				"                                                                                                                                                                                                                                                                                                                                                                                   ");
		// CREAMOS UNA TABLA
		PdfPTable tb = new PdfPTable(1);
		// CREAMOS UNA CELDA
		PdfPCell c1 = new PdfPCell();
		c1.setBorder(0);
		c1.setIndent(1);
		// AGREGAMOS EL TEXTO Y LA IMAGEN A LA CELDA
		c1.addElement(parrafo);
		c1.addElement(saltoDeLinea);
		c1.addElement(imagen);
		c1.addElement(parrafoError);
		// ANEXAMOS LA CELDA A LA TABLA
		tb.addCell(c1);
		// ANEXAMOS LA TABLA AL DOCUMENTO
		documento.add(tb);
		documento.add(saltoDeLinea);
	}

	public void cerrarPlantilla() throws DocumentException {
		documento.add(Chunk.NEWLINE);
		// DAR FORMATO A LA FUENTE
		Paragraph parrafo = new Paragraph();
		parrafo.setAlignment(Chunk.ALIGN_RIGHT);
		parrafo.setFont(FontFactory.getFont("Arial", 10, Font.BOLD));
		parrafo.add("Fecha inicio: " + horaIni + "\n");

		// ADICIONAR MENSAJE AL PDF
		horaFin = ClaseBase.fechaHora2();
		parrafo.add("Fecha Fin: " + horaFin);

		// ADICIONAR MENSAJE AL PDF
		documento.add(parrafo);
		documento.close();
	}
}
