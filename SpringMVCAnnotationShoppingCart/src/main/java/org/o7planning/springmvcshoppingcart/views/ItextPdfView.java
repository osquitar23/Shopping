package org.o7planning.springmvcshoppingcart.views;

import java.text.DateFormat;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.o7planning.springmvcshoppingcart.model.CartInfo;
import org.o7planning.springmvcshoppingcart.model.CartLineInfo;
import org.o7planning.springmvcshoppingcart.model.CustomerInfo;
import org.o7planning.springmvcshoppingcart.util.Utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ItextPdfView extends AbstractITextPdfView {

    private static final DateFormat DATE_FORMAT = DateFormat.getDateInstance(DateFormat.SHORT);

    @Override
    protected void buildPdfDocument(Map<String, Object> model,
                                    Document document, PdfWriter writer, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {
    	
    	   	
        @SuppressWarnings("unchecked")
        CartInfo cartInfo = Utils.getCartInSession(request);
        CustomerInfo cliente = CustomerInfo(request);

        PdfPTable table = new PdfPTable(4);
        table.setWidths(new int[]{25, 25, 25, 25});

        table.addCell("Precio ");
        table.addCell("Cantidad Total " );
        table.addCell("Producto ");
        table.addCell("Cliente ");

      for (CartLineInfo product : cartInfo.getCartLines()){
           table.addCell(String.valueOf(cartInfo.getAmountTotal()));
           table.addCell(String.valueOf(cartInfo.getQuantityTotal()));
           table.addCell(String.valueOf(product.getProductInfo().getName()));        
           table.addCell(String.valueOf(cartInfo.getCustomerInfo().getName()));
    
      
      }



        document.add(table);
    }

	private CustomerInfo CustomerInfo(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
