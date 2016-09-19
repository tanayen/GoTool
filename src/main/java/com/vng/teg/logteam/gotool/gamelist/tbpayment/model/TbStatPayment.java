package com.vng.teg.logteam.gotool.gamelist.tbpayment.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Embeddable
@Table(name = "tb_stat_payment")
public class TbStatPayment implements Serializable {

    private String gameCode;
    private Date logDate;
    private String serverId;
    private String account;
    private Double chargeAmt;

    @Column(name = "game_code", nullable = false)
    public String getGameCode() {
        return gameCode;
    }

    public void setGameCode(String gameCode) {
        this.gameCode = gameCode;
    }

    @Column(name = "log_date", nullable = false)
    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    @Column(name = "server_id", nullable = false)
    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    @Column(name = "account", nullable = false)
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Column(name = "charge_amt", nullable = false)
    public Double getChargeAmt() {
        return chargeAmt;
    }

    public void setChargeAmt(Double chargeAmt) {
        this.chargeAmt = chargeAmt;
    }

}
