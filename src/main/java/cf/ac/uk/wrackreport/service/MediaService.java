package cf.ac.uk.wrackreport.service;

import cf.ac.uk.wrackreport.data.jpa.entities.MediaEntity;
import cf.ac.uk.wrackreport.service.dto.MediaDTO;

import java.util.ArrayList;
import java.util.List;

public interface MediaService {

    List<MediaDTO> findAllMediaByReportId(Long reportId);

}
