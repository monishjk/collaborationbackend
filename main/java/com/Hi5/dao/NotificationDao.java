package com.Hi5.dao;

import java.util.List;


import com.Hi5.model.Notification;

public interface NotificationDao
{
    void addNotification(Notification notification);
	List<Notification> getAllNotificationsNotViewed(String email);
	Notification getNotification(int notificationId);
	void updateNotificactionViewedStatus(int notificationId);

}
