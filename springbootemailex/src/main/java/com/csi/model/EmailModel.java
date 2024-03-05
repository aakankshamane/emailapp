package com.csi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailModel {

    private String toEmail[];

    private String ccEmail[];

    private String emailSubject;

    private String emailBody;

    private Date emailDate;

    private String emailAttachment;

    private String bccEmail;


}
