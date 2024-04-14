package com.vtw.view;

import com.vtw.dto.OrderDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import java.util.List;
import java.util.Map;

public class OrderHistoryXlsView extends AbstractXlsView {
    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook,
                                      HttpServletRequest request, HttpServletResponse response) throws Exception {
        Sheet sheet = null;
        Row headerRow = null;
        List<OrderDto> orderDtos = null;

        sheet = workbook.createSheet("order history");
        headerRow = sheet.createRow(1);

        Cell cell1 = headerRow.createCell(1);
        cell1.setCellValue("Order#");

        Cell cell2 = headerRow.createCell(2);
        cell2.setCellValue("Order Placed Date");

        Cell cell3 = headerRow.createCell(3);
        cell3.setCellValue("Quantity");

        Cell cell4 = headerRow.createCell(4);
        cell4.setCellValue("Amount");

        Cell cell5 = headerRow.createCell(5);
        cell5.setCellValue("Status");

        orderDtos = (List<OrderDto>) model.get("orders");
        for (int i = 0; i < orderDtos.size(); i++) {
            OrderDto dto = orderDtos.get(i);
            Row row = sheet.createRow(i+2);
            cell1 = row.createCell(1);
            cell1.setCellValue(dto.getOrderNo());
            cell2 = row.createCell(2);
            cell2.setCellValue(dto.getOrderPlacedDate());
            cell3 = row.createCell(3);
            cell3.setCellValue(dto.getQuantity());
            cell4 = row.createCell(4);
            cell4.setCellValue(dto.getAmount());
            cell5 = row.createCell(5);
            cell5.setCellValue(dto.getStatus());
        }
    }
}
