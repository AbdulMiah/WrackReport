package cf.ac.uk.wrackreport.api.controllers;

import cf.ac.uk.wrackreport.service.MediaService;
import cf.ac.uk.wrackreport.service.dto.MediaDTO;
import cf.ac.uk.wrackreport.service.dto.ReportDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class MediaAPIController {

    private MediaService mediaService;

    public MediaAPIController(MediaService aMediaService) {
        mediaService = aMediaService;
    }

    @GetMapping("media")
    public ResponseEntity<List<MediaDTO>> findAll() {
        List<MediaDTO> mediaDTOList;
        mediaDTOList = mediaService.findAllMedia();

        return ResponseEntity.ok(mediaDTOList);
    }

}
