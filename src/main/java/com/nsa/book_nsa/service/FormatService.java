package com.nsa.book_nsa.service;

import com.nsa.book_nsa.exception.DuplicateException;
import com.nsa.book_nsa.exception.NotFoundException;
import com.nsa.book_nsa.model.Format;
import com.nsa.book_nsa.repository.FormatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormatService {

    private final FormatRepository formatRepository;

    public FormatService(FormatRepository formatRepository) {
        this.formatRepository = formatRepository;
    }

    public List<Format> getAllFormats() {
        return formatRepository.findAll();
    }

    public Format getFormatById(Long id) {
        return formatRepository.findById(id).orElseThrow(() -> new NotFoundException("format", id));
    }

    public Format addFormat(Format formatDetails) {
        Format format = formatRepository.getByName(formatDetails.getName());
        if(format != null) {
            throw new DuplicateException("format", format.getId());
        }
        return formatRepository.save(formatDetails);
    }

    public Format updateFormat(Long id, Format formatDetails) {
        Format updatedFormat = getFormatById(id);
        Format format = formatRepository.getByName(updatedFormat.getName());
        if(format != null) {
            throw new DuplicateException("format", format.getId());
        }
        updatedFormat.setName(formatDetails.getName());
        return formatRepository.save(formatDetails);
    }

    public void deleteFormatById(Long id) {
        Format updatedFormat = getFormatById(id);
        formatRepository.deleteById(updatedFormat.getId());
    }
}
