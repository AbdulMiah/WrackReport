package cf.ac.uk.wrackreport.service.impl;

import cf.ac.uk.wrackreport.data.interfaces.WrackReportRepository;
import cf.ac.uk.wrackreport.domain.Media;
import cf.ac.uk.wrackreport.service.MediaService;
import cf.ac.uk.wrackreport.service.dto.DetailedReportDTO;
import cf.ac.uk.wrackreport.service.dto.MediaDTO;
import cf.ac.uk.wrackreport.service.dto.ReportDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MediaServiceImpl implements MediaService {

    private WrackReportRepository repo;

    public MediaServiceImpl(WrackReportRepository repo) {
        this.repo = repo;
    }

    public List<MediaDTO> findAllMediaByReportId(Long reportId) {
        log.debug("Getting all media from MediaServiceImpl by report id");
        return repo
                .findAllMediaByReportId(reportId)
                .stream()
                .map(m -> new MediaDTO(m))
                .collect(Collectors.toList());
    }

    public List<MediaDTO> findAllMedia() {
        return repo
                .findAllMedia()
                .stream()
                .map(m -> new MediaDTO(m))
                .collect(Collectors.toList());
    }

}
