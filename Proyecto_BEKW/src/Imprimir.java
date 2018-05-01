
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author willi
 */

public class Imprimir {
    CONECTAR_SERVER CS;
    Connection conect;
    private void conectarBD() throws ClassNotFoundException{
        CS=new CONECTAR_SERVER();
        CS.conectarBD();
        this.conect=CS.getConect();
    }
    private String getDate(int idVenta) throws ClassNotFoundException{
        conectarBD();
        String fecha="";
        try{    
                String cad = "SELECT FECHA FROM VENTAS"
                        + " WHERE ID_VENTA="+idVenta+"";
                Statement stmt = conect.createStatement();
                stmt.executeQuery(cad);
                ResultSet rs = stmt.getResultSet();
                
                if(null!=rs){
                    while(rs.next()){
                        fecha=rs.getDate("ID_VENTA").toString();
                    }
                    return fecha;
                }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return fecha;
    }
    void imprimirVenta(String empleado,int idVenta){
      Document documento = new Document();
        
        try {
            //idVenta="102";
            String FechaVenta=getDate(idVenta); 
            PdfWriter.getInstance(documento, new FileOutputStream("Venta_"+idVenta+".pdf"));
               
            
            //empleado="williams";
            Image logo = Image.getInstance("Icons/EL MERENGUEx100.png");
            //foto.scaleToFit(650, 1000);
            logo.setAlignment(Chunk.ALIGN_CENTER);

            documento.open();


            Paragraph empresa= new Paragraph();
            Paragraph descripcion=new Paragraph();
            Paragraph linea=new Paragraph();
            
            empresa.setAlignment(Paragraph.ALIGN_CENTER);
            empresa.setFont(FontFactory.getFont("Tahoma", 12, Font.BOLD, BaseColor.DARK_GRAY));
            empresa.add(" PASTELERIA EL MERENGUE \n\n");
            
            descripcion.setAlignment(Paragraph.ALIGN_JUSTIFIED);
            descripcion.setFont(FontFactory.getFont("Tahoma", 12, Font.NORMAL, BaseColor.DARK_GRAY));
            
            descripcion.add("LEONIDAS SIBAJAS #25, CAMINERA \n\n");
            descripcion.add("TEPIC, NAYARIT  FECHA:"+FechaVenta+" \n\n");
            descripcion.add("FOLIO:"+idVenta+"   EMPLEADO:"+empleado+" \n\n");
            descripcion.setFont(FontFactory.getFont("Tahoma",16,Font.BOLD,BaseColor.BLACK));
            linea.add("----------------------------------------------------------");
          
            documento.add(logo);
            documento.add(empresa);
            documento.add(descripcion);
            documento.add(linea);

            PdfPTable table = new PdfPTable(5);
            PdfPCell titulo1 = new PdfPCell(new Phrase("CODIGO"));
            PdfPCell titulo2 = new PdfPCell(new Phrase("PRODUCTO"));
            PdfPCell titulo3 = new PdfPCell(new Phrase("P.U."));
            PdfPCell titulo4 = new PdfPCell(new Phrase("CANTIDAD"));
            PdfPCell titulo5 = new PdfPCell(new Phrase("TOTAL"));
            
            titulo1.setBorder(Rectangle.NO_BORDER);
            titulo2.setBorder(Rectangle.NO_BORDER);
            titulo3.setBorder(Rectangle.NO_BORDER);
            titulo4.setBorder(Rectangle.NO_BORDER);
            titulo5.setBorder(Rectangle.NO_BORDER);
            
            
            table.addCell(titulo1);
            table.addCell(titulo2);
            table.addCell(titulo3);
            table.addCell(titulo4);
            table.addCell(titulo5);
            
            try {

                Statement st = conect.createStatement();
                String consultaVenta="SELECT DV.ID_VENTA, DV.ID_PRODUCTO, P.NOMBRE as NOMBRE_PRODUCTO, P.PRECIO, DV.CANTIDAD, C.NOMBRE as NOMBRE_CLIENTE " +
                "FROM DETALLE_VENTAS as DV, PRODUCTOS as P, PERSONAS as C " +
                "WHERE DV.ID_PRODUCTO=P.ID_PRODUCTO AND DV.ID_CLIENTE=C.ID_PERSONA " +
                "AND DV.ID_VENTA="+idVenta+"";
                ResultSet rs = st.executeQuery(consultaVenta);
                int totalVenta=0;
                if (rs.next()) {
                    do {
                        float precioUnitario=0;
                        int cantidad=0;
                        float totalProducto=0;
                        
                        precioUnitario=rs.getFloat("PRECIO");
                        cantidad=rs.getInt("CANTIDAD");        
                        totalProducto=precioUnitario*cantidad;
                        totalVenta+=totalProducto;
                        
                        PdfPCell cellcodigoProducto = new PdfPCell(new Phrase(rs.getString("ID_PRODUCTO")));
                        PdfPCell cellnombreProducto = new PdfPCell(new Phrase(rs.getString("NOMBRE_PRODUCTO")));
                        PdfPCell cellPUProducto = new PdfPCell(new Phrase(precioUnitario));
                        PdfPCell cellcantidadProducto = new PdfPCell(new Phrase(cantidad));
                        PdfPCell celltotalProducto = new PdfPCell(new Phrase(totalProducto));
                        
                        table.addCell(cellcodigoProducto);
                        table.addCell(cellnombreProducto);
                        table.addCell(cellPUProducto);
                        table.addCell(cellcantidadProducto);
                        table.addCell(celltotalProducto);
                    } while (rs.next());
                    documento.add(table);
                }
            } catch (Exception e) {
            }
            documento.add(table);
            documento.add(linea);
            documento.close();
            JOptionPane.showMessageDialog(null, "Venta "+idVenta+" generada exitosamente.");
        } catch (Exception e) {
            System.out.println("Error" + e);
        }

  }
}
