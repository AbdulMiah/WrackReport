package cf.ac.uk.wrackreport.data.jpa.adaptors;

import cf.ac.uk.wrackreport.data.interfaces.WrackReportRepository;
import cf.ac.uk.wrackreport.data.jpa.entities.ReportEntity;
import cf.ac.uk.wrackreport.data.jpa.repositories.ReportRepository;
import cf.ac.uk.wrackreport.domain.Report;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class WrackReportRepositoryAdaptor implements WrackReportRepository {

    private ReportRepository reportRepository;

    public WrackReportRepositoryAdaptor(ReportRepository repo) {
        reportRepository = repo;
    }

    public void saveReport(Report aReport) {
        ReportEntity reportEntity = new ReportEntity(aReport);
        reportRepository.save(reportEntity);
    }
}
