package com.nsa.book_nsa.service;

import com.nsa.book_nsa.exception.NotFoundException;
import com.nsa.book_nsa.model.Line;
import com.nsa.book_nsa.repository.LineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LineService {
    private final LineRepository lineRepository;
    private final BookService bookService;
    private final OrderService orderService;

    public LineService(LineRepository lineRepository, BookService bookService, OrderService orderService) {
        this.lineRepository = lineRepository;
        this.bookService = bookService;
        this.orderService = orderService;
    }

    public List<Line> getAllLines() {
        return lineRepository.findAll();
    }

    public Line getLineById(Long id) {
        return lineRepository.findById(id).orElseThrow(()-> new NotFoundException("line", id));
    }

    public Line addLine(Line lineDetails) {
        bookService.getBookById(lineDetails.getBook().getId());
        orderService.getOrderById(lineDetails.getOrder().getId());
        return lineRepository.save(lineDetails);
    }

    public Line updateLine(Long id, Line lineDetails) {
        Line updatedLine = getLineById(id);
        updatedLine.setPrice(lineDetails.getPrice());
        updatedLine.setQuantity(lineDetails.getQuantity());
        return lineRepository.save(updatedLine);
    }

    public void deleteLine(Long id) {
        Line deletedLine = getLineById(id);
        lineRepository.delete(deletedLine);
    }
}
