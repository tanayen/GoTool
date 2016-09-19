package com.vng.teg.logteam.gotool.gamelist.tbpayment.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by cpu10865 on 16/09/2016.
 */
@Embeddable
public class EmbeddableTableWithoutId implements Serializable {
    int columnA;
    long columnB;

    public int getColumnA() {
        return columnA;
    }

    public void setColumnA(int columnA) {
        this.columnA = columnA;
    }

    public long getColumnB() {
        return columnB;
    }

    public void setColumnB(long columnB) {
        this.columnB = columnB;
    }
}
