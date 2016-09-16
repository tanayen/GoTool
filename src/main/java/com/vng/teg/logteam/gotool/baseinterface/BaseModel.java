package com.vng.teg.logteam.gotool.baseinterface;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Created by tringuyen on 9/18/15.
 */
public class BaseModel {
    protected Integer status;
    protected Date creationDate;
    protected Date modificationDate;
}
