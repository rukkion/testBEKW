
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
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
    public static final String IMG = "src/Icons/EL MERENGUEx100.png";
    CONECTAR_SERVER CS;
    Connection conect;
    private void conectarBD() throws ClassNotFoundException{
        CS=new CONECTAR_SERVER();
        CS.conectarBD();
        this.conect=CS.getConect();
    }
    private String getDate(int id) throws ClassNotFoundException{
        conectarBD();
        String fecha="";
        try{    
                String cad = "SELECT FECHA FROM VENTAS"
                        + " WHERE ID_VENTA="+id;
                Statement stmt = conect.createStatement();
                stmt.executeQuery(cad);
                ResultSet rs = stmt.getResultSet();
                
                if(null!=rs){
                    while(rs.next()){
                        fecha=rs.getDate("FECHA").toString();
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
            Image logo = Image.getInstance(IMG);
            //foto.scaleToFit(650, 1000);
            logo.setAlignment(Chunk.ALIGN_CENTER);

            documento.open();


            Paragraph empresa= new Paragraph();
            Paragraph descripcion=new Paragraph();
            Paragraph linea=new Paragraph();
            Paragraph textoTotalVenta=new Paragraph();
            Paragraph bottom=new Paragraph(); //bottom = a lo de abajo del ticket :v
            
            
            empresa.setAlignment(Paragraph.ALIGN_CENTER);
            empresa.setFont(FontFactory.getFont("Tahoma", 12, Font.BOLD, BaseColor.DARK_GRAY));
            empresa.add(" PASTELERIA EL MERENGUE \n\n");
            
            descripcion.setAlignment(Paragraph.ALIGN_JUSTIFIED);
            descripcion.setFont(FontFactory.getFont("Tahoma", 12, Font.NORMAL, BaseColor.DARK_GRAY));
            descripcion.add("LEONIDAS SIBAJAS #25, CAMINERA \n\n");
            descripcion.add("TEPIC, NAYARIT         FECHA: "+FechaVenta+" \n\n");
            descripcion.add("FOLIO: "+idVenta+"         EMPLEADO: "+empleado+" \n\n");
            
            linea.setFont(FontFactory.getFont("Tahoma",16,Font.BOLD,BaseColor.BLACK));
            linea.add("---------------------------------------------------------------------------------------------");
          
            

            PdfPTable table = new PdfPTable(new float[] { 12, 35,13,15,25 });
            table.setWidthPercentage(100);
            PdfPCell titulo1 = new PdfPCell(new Phrase("CODIGO"));
            PdfPCell titulo2 = new PdfPCell(new Phrase("PRODUCTO"));
            PdfPCell titulo3 = new PdfPCell(new Phrase("P.U."));
            PdfPCell titulo4 = new PdfPCell(new Phrase("CANTIDAD"));
            PdfPCell titulo5 = new PdfPCell(new Phrase("TOTAL"));
            
            titulo3.setVerticalAlignment(Element.ALIGN_RIGHT);
            titulo4.setVerticalAlignment(Element.ALIGN_RIGHT);
            titulo5.setVerticalAlignment(Element.ALIGN_RIGHT);
            
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
            int totalVenta=0;
            String nombreCliente="";
            try {

                Statement st = conect.createStatement();
                String consultaVenta="SELECT DV.ID_VENTA, DV.ID_PRODUCTO, P.NOMBRE as NOMBRE_PRODUCTO, P.PRECIO, DV.CANTIDAD, C.NOMBRE as NOMBRE_CLIENTE, C.APE_PAT as PATERNO, C.APE_MAT as MATERNO " +
                "FROM DETALLE_VENTAS as DV, PRODUCTOS as P, PERSONAS as C " +
                "WHERE DV.ID_PRODUCTO=P.ID_PRODUCTO AND DV.ID_CLIENTE=C.ID_PERSONA " +
                "AND DV.ID_VENTA="+idVenta+"";
                ResultSet rs = st.executeQuery(consultaVenta);
                
                
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
                        PdfPCell cellPUProducto = new PdfPCell(new Phrase(precioUnitario+""));
                        PdfPCell cellcantidadProducto = new PdfPCell(new Phrase(cantidad+""));
                        PdfPCell celltotalProducto = new PdfPCell(new Phrase(totalProducto+""));
                        //QUITARLE LOS BORDES A LAS CELDAS
                        cellcodigoProducto.setBorder(Rectangle.NO_BORDER);
                        cellnombreProducto.setBorder(Rectangle.NO_BORDER);
                        cellPUProducto.setBorder(Rectangle.NO_BORDER);
                        cellcantidadProducto.setBorder(Rectangle.NO_BORDER);
                        celltotalProducto.setBorder(Rectangle.NO_BORDER);
                        //alineando al centro las celdas
                        cellPUProducto.setVerticalAlignment(Element.ALIGN_RIGHT);
                        cellcantidadProducto.setVerticalAlignment(Element.ALIGN_RIGHT);
                        celltotalProducto.setVerticalAlignment(Element.ALIGN_RIGHT);
                        //probando que si saque lo que deberia
                        System.out.println("prodcuto:"+rs.getString("NOMBRE_PRODUCTO")+"cantidad: "+cantidad+"|pu:"+precioUnitario+"|totalP:"+totalProducto);
                        //agregando celdas al pdf
                        table.addCell(cellcodigoProducto);
                        table.addCell(cellnombreProducto);
                        table.addCell(cellPUProducto);
                        table.addCell(cellcantidadProducto);
                        table.addCell(celltotalProducto);
                        nombreCliente=rs.getString("NOMBRE_CLIENTE")+" "+rs.getString("PATERNO")+" "+rs.getString("MATERNO");
                    } while (rs.next());
                    
                }
            } catch (Exception e) {
            }
            //mostrando total venta
            textoTotalVenta.setAlignment(Paragraph.ALIGN_RIGHT);
            textoTotalVenta.setFont(FontFactory.getFont("Tahoma", 12, Font.BOLD, BaseColor.DARK_GRAY));
            textoTotalVenta.add("TOTAL:         "+totalVenta+".0\n");
            textoTotalVenta.add("CAMBIO:         0.0\n");
            textoTotalVenta.add("-----------------------\n");
            textoTotalVenta.add("EFECTIVO:         0.0\n\n");
            //----
            descripcion.add("BIENVENIDO: "+nombreCliente+"\n\n");
            //AGRADECIMIENTO
            bottom.setAlignment(Paragraph.ALIGN_CENTER);
            bottom.setFont(FontFactory.getFont("Tahoma", 12, Font.NORMAL, BaseColor.DARK_GRAY));
            bottom.add("¡GRACIAS POR SU PREFERENCIA!\n\n");
            
            
            //----
            //descripcion
            documento.add(logo);
            documento.add(empresa);
            documento.add(descripcion);
            documento.add(linea);
            //VENTA
            documento.add(table);
            documento.add(linea);
            documento.add(textoTotalVenta);
            //final
            documento.add(bottom);
            documento.close();
            JOptionPane.showMessageDialog(null, "Venta "+idVenta+" generada exitosamente.");
        } catch (Exception e) {
            System.out.println("Error" + e);
        }

  }
}
