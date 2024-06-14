package local.wpr.start.sios.service.impl;

import local.wpr.start.sios.model.Announcement;
import local.wpr.start.sios.repository.AnnouncementRepository;
import local.wpr.start.sios.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {
    @Autowired
    AnnouncementRepository announcementRepository;

    public AnnouncementServiceImpl(AnnouncementRepository announcementRepository) {
        this.announcementRepository = announcementRepository;
    }

    @Override
    public List<Announcement> getAllAnnouncement() {
        return announcementRepository.findAll();
    }

    @Override
    public Announcement getAnnouncementById(Long announcementId) {
        return announcementRepository.getReferenceById(announcementId);
    }

    @Override
    public Announcement getLast() {
        return announcementRepository.getLast();
    }

    @Override
    public void saveAnnouncement(Announcement announcement) {
        announcementRepository.save(announcement);
    }
}
