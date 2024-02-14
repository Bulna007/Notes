package com.vtw.controller;

import com.vtw.dto.OrderDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OrderHistoryController extends AbstractController {
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request,
                                                 HttpServletResponse response) throws Exception {
        int months = 0;
        String viewType = null;
        List<OrderDto> orderDtos = null;
        ModelAndView modelAndView = null;

        viewType = request.getParameter("viewType");
        if (viewType == null || viewType.trim().length() == 0) {
            modelAndView = new ModelAndView("order-history");
            return modelAndView;
        }

        // database
        months = Integer.parseInt(request.getParameter("months"));
        orderDtos = IntStream.range(1, months * 2).mapToObj(i -> {
            return OrderDto.of().orderNo(String.valueOf(i)).orderPlacedDate(LocalDate.now().minusDays(i)).quantity(i).status(i % 2 == 0 ? "delivered" : "returned").amount(i * 500).build();
        }).collect(Collectors.toList());

        modelAndView = new ModelAndView();
        modelAndView.addObject("orders", orderDtos);
        modelAndView.addObject("months", months);

        if (viewType.equals("pdf")) {
            modelAndView.setViewName("orderHistoryPdfView");
        } else if (viewType.equals("xls")) {
            modelAndView.setViewName("orderHistoryXlsView");
        } else {
            modelAndView.setViewName("order-history");
        }

        return modelAndView;
    }
}
