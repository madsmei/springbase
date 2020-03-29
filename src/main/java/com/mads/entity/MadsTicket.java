package com.mads.entity;

import lombok.Data;

import java.util.Date;

@Data
public class MadsTicket {

    private String ticketId;

    private Integer ticketCount;

    private String ticketStatus;

    private Date ticketTime;

    private Integer version;
}
