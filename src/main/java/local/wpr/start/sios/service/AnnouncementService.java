package local.wpr.start.sios.service;

import local.wpr.start.sios.model.Announcement;

import java.util.List;

public interface AnnouncementService {
    List<Announcement> getAllAnnouncement();
    Announcement getAnnouncementById(Long announcementId);
    void saveAnnouncement(Announcement announcement);
}
