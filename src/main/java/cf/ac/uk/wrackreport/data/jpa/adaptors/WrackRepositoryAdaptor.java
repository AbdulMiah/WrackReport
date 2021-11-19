package cf.ac.uk.wrackreport.data.jpa.adaptors;

import cf.ac.uk.wrackreport.data.interfaces.WrackReportRepository;
import cf.ac.uk.wrackreport.data.jpa.entities.ReportEntity;
import cf.ac.uk.wrackreport.data.jpa.entities.UserEntity;
import cf.ac.uk.wrackreport.data.jpa.repositories.ReportRepository;
import cf.ac.uk.wrackreport.data.jpa.repositories.UserRepository;
import cf.ac.uk.wrackreport.domain.Report;
import cf.ac.uk.wrackreport.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public class WrackRepositoryAdaptor implements WrackReportRepository {

    private UserRepository userRepository;
    private ReportRepository reportRepository;

    public WrackRepositoryAdaptor(UserRepository aUserRepo, ReportRepository aReportRepo) {
        userRepository = aUserRepo;
        reportRepository = aReportRepo;
    }

    public void saveReport(Report aReport) {
        ReportEntity reportEntity = new ReportEntity(aReport);
        reportRepository.save(reportEntity);
    }

    public void saveUser(User aUser) {
        UserEntity userEntity = new UserEntity(aUser);
        userRepository.save(userEntity);
    }

}
