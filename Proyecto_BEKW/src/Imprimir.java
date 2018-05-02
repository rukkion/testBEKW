
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
    private String getDateVenta(int id) throws ClassNotFoundException{
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
    private String getFechaPedido(int idPedido) throws ClassNotFoundException{
        conectarBD();
        String fecha="";
        try{    
                String cad = "SELECT FECHA_PEDIDO as FECHA FROM PEDIDOS"
                        + " WHERE ID_PEDIDO="+idPedido;
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
    private String getFechaEntregaPedido(int idPedido) throws ClassNotFoundException{
        conectarBD();
        String fecha="";
        try{    
                String cad = "SELECT FECHA_ENTREGA as FECHA FROM PEDIDOS"
                        + " WHERE ID_PEDIDO="+idPedido;
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
    void imprimirPedido(String empleado, int idPedido,float efectivo,float cambio,float adelanto){
        try{
            Document documento= new Document();
            PdfWriter.getInstance(documento, new FileOutputStream("Pedido_"+idPedido+".pdf"));
              
            String FechaPedido=getFechaPedido(idPedido);
            String FechaEntrega=getFechaEntregaPedido(idPedido);
            Image logo = Image.getInstance(IMG);
            
            logo.setAlignment(Chunk.ALIGN_CENTER);

            documento.open();
            

            Paragraph empresa= new Paragraph();
            Paragraph descripcion=new Paragraph();
            Paragraph linea=new Paragraph();
            Paragraph textoTotalPedido=new Paragraph();
            Paragraph tipo=new Paragraph();
            Paragraph bottom=new Paragraph(); //bottom = a lo de abajo del ticket :v
            
               empresa.setAlignment(Paragraph.ALIGN_CENTER);
            empresa.setFont(FontFactory.getFont("Tahoma", 12, Font.BOLD, BaseColor.DARK_GRAY));
            empresa.add(" PASTELERIA EL MERENGUE \n\n");
            
            descripcion.setAlignment(Paragraph.ALIGN_JUSTIFIED);
            descripcion.setFont(FontFactory.getFont("Tahoma", 12, Font.NORMAL, BaseColor.DARK_GRAY));
            descripcion.add("LEONIDAS SIBAJAS #25, CAMINERA \n\n");
            descripcion.add("TEPIC, NAYARIT         FECHA: "+FechaPedido+" \n\n");
            descripcion.add("FOLIO: "+idPedido+"         EMPLEADO: "+empleado+" \n\n");
            
            tipo.setAlignment(Paragraph.ALIGN_CENTER);
            tipo.setFont(FontFactory.getFont("Tahoma", 12, Font.BOLD, BaseColor.DARK_GRAY));
            tipo.add(" PEDIDO \n");
            
            linea.setFont(FontFactory.getFont("Tahoma",16,Font.BOLD,BaseColor.BLACK));
            linea.add("---------------------------------------------------------------------------------------------");
            
            PdfPTable table = new PdfPTable(new float[] { 12, 35,13,15,25 });
            table.setWidthPercentage(100);
            PdfPCell titulo1 = new PdfPCell(new Phrase("CODIGO"));
            PdfPCell titulo2 = new PdfPCell(new Phrase("PRODUCTO"));
            PdfPCell titulo3 = new PdfPCell(new Phrase("P.U."));
            PdfPCell titulo4 = new PdfPCell(new Phrase("CANTIDAD"));
            PdfPCell titulo5 = new PdfPCell(new Phrase("TOTAL"));
            
            titulo3.setHorizontalAlignment(Element.ALIGN_RIGHT);
            titulo4.setHorizontalAlignment(Element.ALIGN_RIGHT);
            titulo5.setHorizontalAlignment(Element.ALIGN_RIGHT);
            
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
            int totalPedido=0;
            String nombreCliente="";
            try {

                Statement st = conect.createStatement();
                String consultaVenta="SELECT P.ID_PRODUCTO,P.NOMBRE as NOMBRE_PRODUCTO, DP.CANTIDAD, P.PRECIO,C.NOMBRE AS NOMBRE_CLIENTE, "
                        + "C.APE_PAT AS PATERNO, C.APE_MAT AS MATERNO " +
                    "FROM PRODUCTOS as P, DETALLE_PEDIDO as DP, PERSONAS as C " +
                    "WHERE DP.ID_PRODUCTO=P.ID_PRODUCTO AND dp.ID_CLIENTE=c.ID_PERSONA " +
                    "AND DP.ID_PEDIDO="+idPedido;
                ResultSet rs = st.executeQuery(consultaVenta);
                
                
                if (rs.next()) {
                    do {
                        float precioUnitario=0;
                        int cantidad=0;
                        float totalProducto=0;
                        
                        precioUnitario=rs.getFloat("PRECIO");
                        
                        cantidad=rs.getInt("CANTIDAD");        
                        totalProducto=precioUnitario*cantidad;
                        totalPedido+=totalProducto;
                        
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
                        cellPUProducto.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cellcantidadProducto.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        celltotalProducto.setHorizontalAlignment(Element.ALIGN_RIGHT);
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
            textoTotalPedido.setAlignment(Paragraph.ALIGN_RIGHT);
            textoTotalPedido.setFont(FontFactory.getFont("Tahoma", 12, Font.BOLD, BaseColor.DARK_GRAY));
            textoTotalPedido.add("TOTAL:         "+totalPedido+".0\n");
            textoTotalPedido.add("ADELANTO:         "+adelanto+"\n\n");
            
            textoTotalPedido.add("PENDIENTE:         "+(totalPedido-adelanto)+"\n");
            textoTotalPedido.add("-----------------------\n");
            
            textoTotalPedido.add("EFECTIVO:         "+efectivo+"\n\n");
            textoTotalPedido.add("CAMBIO:         "+cambio+"\n");
             //----
            descripcion.add("CLIENTE: "+nombreCliente+"\n");
            descripcion.add("FECHA ENTREGA: "+FechaEntrega);
            //AGRADECIMIENTO
            bottom.setAlignment(Paragraph.ALIGN_CENTER);
            bottom.setFont(FontFactory.getFont("Tahoma", 12, Font.NORMAL, BaseColor.DARK_GRAY));
            bottom.add("¡GRACIAS POR SU PREFERENCIA!\n\n");
            bottom.add("LA EMPRESA EL MERENGUE NO SE HACE RESPONSABLE DE LA RECOLECCION DEL PRODUCTO FUERA DEL TIEMPO ESTIMADO."
                    + "CUALQUIER PEDIDO EXPIRA DESPUES DE SU FECHA DE ENTREGA, ASI COMO EL ADELANTO.\n");
            bottom.add("NO HAY DEVOLUCIONES.\n");
            
            //----
            //descripcion
            documento.add(logo);
            documento.add(empresa);
            documento.add(descripcion);
            documento.add(tipo);
            documento.add(linea);
            //VENTA
            documento.add(table);
            documento.add(linea);
            documento.add(textoTotalPedido);
            //final
            documento.add(bottom);
            documento.close();
            JOptionPane.showMessageDialog(null, "Pedido "+idPedido+" generado exitosamente.");
        }catch(Exception e){
            System.out.println("ERROR AL IMPRIMIR PEDIDO "+e.getMessage());
        }
        
    }
    void imprimirVenta(String empleado,int idVenta,float efectivo,float cambio){
      Document documento = new Document();
        
        try {
            //idVenta="102";
            String FechaVenta=getDateVenta(idVenta); 
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
            Paragraph tipo=new Paragraph();
            Paragraph bottom=new Paragraph(); //bottom = a lo de abajo del ticket :v
            
            
            empresa.setAlignment(Paragraph.ALIGN_CENTER);
            empresa.setFont(FontFactory.getFont("Tahoma", 12, Font.BOLD, BaseColor.DARK_GRAY));
            empresa.add(" PASTELERIA EL MERENGUE \n\n");
            
            descripcion.setAlignment(Paragraph.ALIGN_JUSTIFIED);
            descripcion.setFont(FontFactory.getFont("Tahoma", 12, Font.NORMAL, BaseColor.DARK_GRAY));
            descripcion.add("LEONIDAS SIBAJAS #25, CAMINERA \n\n");
            descripcion.add("TEPIC, NAYARIT         FECHA: "+FechaVenta+" \n\n");
            descripcion.add("FOLIO: "+idVenta+"         EMPLEADO: "+empleado+" \n\n");
            
            tipo.setAlignment(Paragraph.ALIGN_CENTER);
            tipo.setFont(FontFactory.getFont("Tahoma", 12, Font.BOLD, BaseColor.DARK_GRAY));
            tipo.add(" VENTA \n");
            
            linea.setFont(FontFactory.getFont("Tahoma",16,Font.BOLD,BaseColor.BLACK));
            linea.add("---------------------------------------------------------------------------------------------");
          
            
            PdfPTable table = new PdfPTable(new float[] { 12, 35,13,15,25 });
            table.setWidthPercentage(100);
            PdfPCell titulo1 = new PdfPCell(new Phrase("CODIGO"));
            PdfPCell titulo2 = new PdfPCell(new Phrase("PRODUCTO"));
            PdfPCell titulo3 = new PdfPCell(new Phrase("P.U."));
            PdfPCell titulo4 = new PdfPCell(new Phrase("CANTIDAD"));
            PdfPCell titulo5 = new PdfPCell(new Phrase("TOTAL"));
            
            titulo3.setHorizontalAlignment(Element.ALIGN_RIGHT);
            titulo4.setHorizontalAlignment(Element.ALIGN_RIGHT);
            titulo5.setHorizontalAlignment(Element.ALIGN_RIGHT);
            
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
                        cellPUProducto.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cellcantidadProducto.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        celltotalProducto.setHorizontalAlignment(Element.ALIGN_RIGHT);
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
            textoTotalVenta.add("CAMBIO:         "+cambio+"\n");
            textoTotalVenta.add("-----------------------\n");
            textoTotalVenta.add("EFECTIVO:         "+efectivo+"\n\n");
            //----
            descripcion.add("CLIENTE: "+nombreCliente+"\n\n");
            //AGRADECIMIENTO
            bottom.setAlignment(Paragraph.ALIGN_CENTER);
            bottom.setFont(FontFactory.getFont("Tahoma", 12, Font.NORMAL, BaseColor.DARK_GRAY));
            bottom.add("¡GRACIAS POR SU PREFERENCIA!\n\n");
            
            
            //----
            //descripcion
            documento.add(logo);
            documento.add(empresa);
            documento.add(descripcion);
            documento.add(tipo);
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
