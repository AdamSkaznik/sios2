package local.wpr.start.sios.service;

import local.wpr.start.sios.model.Announcement;

import java.util.List;

public interface AnnouncementService {
    List<Announcement> getAllAnnouncement();
    Announcement getAnnouncementById(Long announcementId);
    Announcement getLast();
    void saveAnnouncement(Announcement announcement);
}
