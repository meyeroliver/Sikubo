package com.example.sikubo.model;

public class LineUpdates {
    private String event_id;
    private String create_date;
    private String creator_id;
    private String type_id;
    private String message_id;
    private String receiver;
    private String receiver_id;
    private String portal_id;
    private String target_id;
    private String target2_id;
    private String use_grouping;
    private String title;
    private String message;
    private String user_name;

    public LineUpdates(String event_id, String create_date, String creator_id, String type_id, String message_id, String receiver, String receiver_id, String portal_id, String target_id, String target2_id, String use_grouping, String title, String message, String user_name) {
        this.event_id = event_id;
        this.create_date = create_date;
        this.creator_id = creator_id;
        this.type_id = type_id;
        this.message_id = message_id;
        this.receiver = receiver;
        this.receiver_id = receiver_id;
        this.portal_id = portal_id;
        this.target_id = target_id;
        this.target2_id = target2_id;
        this.use_grouping = use_grouping;
        this.title = title;
        this.message = message;
        this.user_name = user_name;
    }

    public String getEvent_id() {
        return event_id;
    }

    public String getCreate_date() {
        return create_date;
    }

    public String getCreator_id() {
        return creator_id;
    }

    public String getType_id() {
        return type_id;
    }

    public String getMessage_id() {
        return message_id;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getReceiver_id() {
        return receiver_id;
    }

    public String getPortal_id() {
        return portal_id;
    }

    public String getTarget_id() {
        return target_id;
    }

    public String getTarget2_id() {
        return target2_id;
    }

    public String getUse_grouping() {
        return use_grouping;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public String getUser_name() {
        return user_name;
    }
}
