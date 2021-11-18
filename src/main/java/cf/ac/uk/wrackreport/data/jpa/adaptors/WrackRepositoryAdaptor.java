package cf.ac.uk.wrackreport.data.jpa.adaptors;

import cf.ac.uk.wrackreport.data.interfaces.WrackReportRepository;
import cf.ac.uk.wrackreport.data.jpa.entities.ReportEntity;
import cf.ac.uk.wrackreport.data.jpa.entities.UserEntity;
import cf.ac.uk.wrackreport.data.jpa.repositories.ReportRepository;
import cf.ac.uk.wrackreport.domain.Report;
import cf.ac.uk.wrackreport.domain.User;

public class WrackRepositoryAdaptor implements WrackReportRepository {

    private ReportRepository reportRepository;

    public void ReportRepository(ReportRepository repo) {
        reportRepository = repo;
    }

    public void saveReport(Report aReport) {
        ReportEntity reportEntity = new ReportEntity(aReport);
        reportRepository.save(reportEntity);
    }

    public void saveUser(User aUser) {
        UserEntity userEntity = new UserEntity(aUser);
        reportRepository.save(userEntity);
    }

}
