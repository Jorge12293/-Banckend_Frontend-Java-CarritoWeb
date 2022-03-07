/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import Modelos.Producto;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.util.List;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author JORGE
 */
public class ExportarPdf {
     private List<Producto> getProducto=null;

    public ExportarPdf(List<Producto> getProducto) {
        this.getProducto = getProducto;
    }
    
    public void writeHeader(PdfPTable pdfTable){
        PdfPCell cell=new PdfPCell();
        cell.setBackgroundColor(Color.darkGray);
        cell.setPadding(6);
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setColor(Color.white);
        
        cell.setPhrase(new Phrase("NOMBRE",font));
        pdfTable.addCell(cell);
        
        cell.setPhrase(new Phrase("MODELO",font));
        pdfTable.addCell(cell);
        
        cell.setPhrase(new Phrase("CATEGORIA",font));
        pdfTable.addCell(cell);  
        
        cell.setPhrase(new Phrase("PRECIO",font));
        pdfTable.addCell(cell);  
        
    }
    
    public void writeTableData(PdfPTable pTable){
        for(Producto prod: getProducto){
            pTable.addCell(String.valueOf(prod.getNombre()));
            pTable.addCell(String.valueOf(prod.getModelo()));
            pTable.addCell(String.valueOf(prod.getCategoria()));
            pTable.addCell(String.valueOf(prod.getPrecio()));
        }
    }
    
    public void export(HttpServletResponse response){
        try (Document document = new Document(PageSize.A4)){
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();
            
            Font font= FontFactory.getFont(FontFactory.HELVETICA);
            font.setSize(20);
            font.setColor(Color.BLUE);
            
            Paragraph paragraph= new Paragraph("Lista Produtos");
            
            
            paragraph.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(paragraph);
            PdfPTable pdftable = new PdfPTable(4);
            pdftable.setWidthPercentage(100f);
            pdftable.setWidths(new float[]{1.5f,2.5f,3.0f,3.0f});
            pdftable.setSpacingBefore(10);
            
            writeHeader(pdftable);
            writeTableData(pdftable);
            
            document.add(pdftable);
            document.close();
            
        } catch (Exception e) {
            System.out.println("ERROOOOOO"+e);
        }
    }
}
