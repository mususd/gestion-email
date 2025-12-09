package Controlador;

import Modelo.bandeja.Bandeja;
import Modelo.bandeja.SrvBandeja_Service;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class srvPdfBandeja extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Tipo de respuesta que necesitamos, 
        response.setContentType("application/pdf");
        //Salida de datos, un documento en PDF
        OutputStream out = response.getOutputStream();
        
        try{
            
            try{
            Date date = new Date(); //capturamos el dia, mes y año
            SimpleDateFormat dia = new SimpleDateFormat("dd");
            SimpleDateFormat mes = new SimpleDateFormat("MM");
            SimpleDateFormat anio = new SimpleDateFormat("yyyy");

            float left = 10;
            float right = 10;
            float top = 10;
            float bottom = 10;

            //Palabra reservada que permite declarar el documento
            Document documento = new Document(PageSize.LETTER, left, right, top, bottom);
            PdfWriter.getInstance(documento, out);
            documento.open();
            documento.setMargins(left, right, top, bottom); //colocamos el margen del documento

            //Representamos la informacion
            Paragraph par1 = new Paragraph();
            Font titulo = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD, BaseColor.BLUE);
            par1.add(new Phrase("LISTADO DE BANDEJAS", titulo));
            par1.setAlignment(Element.ALIGN_CENTER);
            par1.add(new Phrase(Chunk.NEWLINE));
            par1.add(new Phrase(Chunk.NEWLINE));
            documento.add(par1);

            Paragraph par2 = new Paragraph();
            Font descripcion = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.NORMAL, BaseColor.BLACK);
            par2.add(new Phrase("Guatemala, " + dia.format(date) + " del " + mes.format(date) + " de " + anio.format(date), descripcion));
            par2.setAlignment(Element.ALIGN_CENTER);
            par2.add(new Phrase(Chunk.NEWLINE));
            par2.add(new Phrase(Chunk.NEWLINE));
            documento.add(par2);

            //Mostramos los datos en una tabla
            PdfPTable tabla = new PdfPTable(8); //asignamos la cantidad de columnas
            PdfPCell celda1 = new PdfPCell(new Paragraph("idBandeja", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
            PdfPCell celda2 = new PdfPCell(new Paragraph("Usuario Remitente", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
            PdfPCell celda3 = new PdfPCell(new Paragraph("idTipoBandeja:", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
            PdfPCell celda4 = new PdfPCell(new Paragraph("idEstadoEmail:", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
            PdfPCell celda5 = new PdfPCell(new Paragraph("Asunto", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
            PdfPCell celda6 = new PdfPCell(new Paragraph("Mensaje", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
            PdfPCell celda7 = new PdfPCell(new Paragraph("Fecha de Envío", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));
            PdfPCell celda8 = new PdfPCell(new Paragraph("Adjunto", FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK)));

            //Le agregamos a la tabla cada una de las celdas
            tabla.addCell(celda1);
            tabla.addCell(celda2);
            tabla.addCell(celda3);
            tabla.addCell(celda4);
            tabla.addCell(celda5);
            tabla.addCell(celda6);
            tabla.addCell(celda7);
            tabla.addCell(celda8);

            //Instanciamos el servicio
            SrvBandeja_Service bandeja = new SrvBandeja_Service();

            //Colocamos una validacion
            if(request.getParameter("btnBuscarIdBandeja")!=null){
                Bandeja b = new Bandeja();
                b = bandeja.getSrvBandejaPort().listarPorID(Integer.parseInt(request.getParameter("txtIdBandeja").toString()));
                tabla.addCell(String.valueOf(b.getIdBandeja()));
                tabla.addCell(b.getUsuarioRemitente());
                tabla.addCell(String.valueOf(b.getIdTipoBandeja()));
                tabla.addCell(String.valueOf(b.getIdEstadoEmail()));
                tabla.addCell(b.getAsunto());
                tabla.addCell(b.getMensaje());
                tabla.addCell(b.getFechaEnvio());
                tabla.addCell(b.getAdjunto());
            }else{
                List<Bandeja> lista;
                lista = bandeja.getSrvBandejaPort().listar();

                for(int i = 0; i<lista.size(); i ++){
                    tabla.addCell(String.valueOf(lista.get(i).getIdBandeja()));
                    tabla.addCell(lista.get(i).getUsuarioRemitente());
                    tabla.addCell(String.valueOf(lista.get(i).getIdTipoBandeja()));
                    tabla.addCell(String.valueOf(lista.get(i).getIdEstadoEmail()));
                    tabla.addCell(lista.get(i).getAsunto());
                    tabla.addCell(lista.get(i).getMensaje());
                    tabla.addCell(lista.get(i).getFechaEnvio());
                    tabla.addCell(lista.get(i).getAdjunto());
                }
            }

            documento.add(tabla);
            documento.close();



            }catch(Exception ex){
                ex.getMessage();
            }
        
        }finally{
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
