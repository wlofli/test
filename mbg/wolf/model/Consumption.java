package mbg.wolf.model;

import java.math.BigDecimal;
import java.util.Date;

public class Consumption {
    private String orderId;

    private String userId;

    private Integer consumptionType;

    private Long consumptionAmount;

    private Date consumptionTime;

    private Integer status;

    private String sericalNumber;

    private String remark;

    private String deleted;

    private String userType;

    private Long currentAmount;

    private BigDecimal otherPayAmount;

    private Integer otherPayType;

    private BigDecimal otherRewardAmount;

    private BigDecimal otherAwardAmount;

    private BigDecimal otherPayAward;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getConsumptionType() {
        return consumptionType;
    }

    public void setConsumptionType(Integer consumptionType) {
        this.consumptionType = consumptionType;
    }

    public Long getConsumptionAmount() {
        return consumptionAmount;
    }

    public void setConsumptionAmount(Long consumptionAmount) {
        this.consumptionAmount = consumptionAmount;
    }

    public Date getConsumptionTime() {
        return consumptionTime;
    }

    public void setConsumptionTime(Date consumptionTime) {
        this.consumptionTime = consumptionTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSericalNumber() {
        return sericalNumber;
    }

    public void setSericalNumber(String sericalNumber) {
        this.sericalNumber = sericalNumber;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Long getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(Long currentAmount) {
        this.currentAmount = currentAmount;
    }

    public BigDecimal getOtherPayAmount() {
        return otherPayAmount;
    }

    public void setOtherPayAmount(BigDecimal otherPayAmount) {
        this.otherPayAmount = otherPayAmount;
    }

    public Integer getOtherPayType() {
        return otherPayType;
    }

    public void setOtherPayType(Integer otherPayType) {
        this.otherPayType = otherPayType;
    }

    public BigDecimal getOtherRewardAmount() {
        return otherRewardAmount;
    }

    public void setOtherRewardAmount(BigDecimal otherRewardAmount) {
        this.otherRewardAmount = otherRewardAmount;
    }

    public BigDecimal getOtherAwardAmount() {
        return otherAwardAmount;
    }

    public void setOtherAwardAmount(BigDecimal otherAwardAmount) {
        this.otherAwardAmount = otherAwardAmount;
    }

    public BigDecimal getOtherPayAward() {
        return otherPayAward;
    }

    public void setOtherPayAward(BigDecimal otherPayAward) {
        this.otherPayAward = otherPayAward;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Consumption other = (Consumption) that;
        return (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getConsumptionType() == null ? other.getConsumptionType() == null : this.getConsumptionType().equals(other.getConsumptionType()))
            && (this.getConsumptionAmount() == null ? other.getConsumptionAmount() == null : this.getConsumptionAmount().equals(other.getConsumptionAmount()))
            && (this.getConsumptionTime() == null ? other.getConsumptionTime() == null : this.getConsumptionTime().equals(other.getConsumptionTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getSericalNumber() == null ? other.getSericalNumber() == null : this.getSericalNumber().equals(other.getSericalNumber()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()))
            && (this.getUserType() == null ? other.getUserType() == null : this.getUserType().equals(other.getUserType()))
            && (this.getCurrentAmount() == null ? other.getCurrentAmount() == null : this.getCurrentAmount().equals(other.getCurrentAmount()))
            && (this.getOtherPayAmount() == null ? other.getOtherPayAmount() == null : this.getOtherPayAmount().equals(other.getOtherPayAmount()))
            && (this.getOtherPayType() == null ? other.getOtherPayType() == null : this.getOtherPayType().equals(other.getOtherPayType()))
            && (this.getOtherRewardAmount() == null ? other.getOtherRewardAmount() == null : this.getOtherRewardAmount().equals(other.getOtherRewardAmount()))
            && (this.getOtherAwardAmount() == null ? other.getOtherAwardAmount() == null : this.getOtherAwardAmount().equals(other.getOtherAwardAmount()))
            && (this.getOtherPayAward() == null ? other.getOtherPayAward() == null : this.getOtherPayAward().equals(other.getOtherPayAward()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getConsumptionType() == null) ? 0 : getConsumptionType().hashCode());
        result = prime * result + ((getConsumptionAmount() == null) ? 0 : getConsumptionAmount().hashCode());
        result = prime * result + ((getConsumptionTime() == null) ? 0 : getConsumptionTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getSericalNumber() == null) ? 0 : getSericalNumber().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
        result = prime * result + ((getUserType() == null) ? 0 : getUserType().hashCode());
        result = prime * result + ((getCurrentAmount() == null) ? 0 : getCurrentAmount().hashCode());
        result = prime * result + ((getOtherPayAmount() == null) ? 0 : getOtherPayAmount().hashCode());
        result = prime * result + ((getOtherPayType() == null) ? 0 : getOtherPayType().hashCode());
        result = prime * result + ((getOtherRewardAmount() == null) ? 0 : getOtherRewardAmount().hashCode());
        result = prime * result + ((getOtherAwardAmount() == null) ? 0 : getOtherAwardAmount().hashCode());
        result = prime * result + ((getOtherPayAward() == null) ? 0 : getOtherPayAward().hashCode());
        return result;
    }
}