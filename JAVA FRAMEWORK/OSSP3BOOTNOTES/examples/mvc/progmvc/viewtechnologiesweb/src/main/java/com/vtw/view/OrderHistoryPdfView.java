package com.vtw.view;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Table;
import com.vtw.dto.OrderDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class OrderHistoryPdfView extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> model, com.lowagie.text.Document document,
                                    com.lowagie.text.pdf.PdfWriter writer,
                                    HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<OrderDto> orderDtos = null;
        final Table table = new Table(5);

        orderDtos = (List<OrderDto>) model.get("orders");


        table.addCell("Order#");
        table.addCell("Order Placed Date");
        table.addCell("Quantity");
        table.addCell("Amount");
        table.addCell("Status");

        orderDtos.forEach(order -> {
            try {
                table.addCell(order.getOrderNo());
                table.addCell(order.getOrderPlacedDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                table.addCell(String.valueOf(order.getQuantity()));
                table.addCell(String.valueOf(order.getAmount()));
                table.addCell(order.getStatus());
            } catch (BadElementException e) {
                throw new RuntimeException(e);
            }
        });

        document.add(table);
    }
}
