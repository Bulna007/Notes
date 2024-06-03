package com.dmlops.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "service_request")
public class ServiceRequest implements Serializable {
    @Id
    @Column(name = "service_req_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serviceRequestNo;
    @Column(name = "request_type")
    private String requestType;
    @Column(name = "customer_nm")
    private String customerName;
    @Column(name = "mobile_no")
    private String mobileNo;
    @Column(name = "email_address")
    private String emailAddress;
    private String problem;
    @Column(name = "raised_dt")
    private LocalDate raisedDate;
    private String status;

    public int getServiceRequestNo() {
        return serviceRequestNo;
    }

    public void setServiceRequestNo(int serviceRequestNo) {
        this.serviceRequestNo = serviceRequestNo;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public LocalDate getRaisedDate() {
        return raisedDate;
    }

    public void setRaisedDate(LocalDate raisedDate) {
        this.raisedDate = raisedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceRequest that = (ServiceRequest) o;
        return serviceRequestNo == that.serviceRequestNo && Objects.equals(requestType, that.requestType) && Objects.equals(customerName, that.customerName) && Objects.equals(mobileNo, that.mobileNo) && Objects.equals(emailAddress, that.emailAddress) && Objects.equals(problem, that.problem) && Objects.equals(raisedDate, that.raisedDate) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceRequestNo, requestType, customerName, mobileNo, emailAddress, problem, raisedDate, status);
    }

    @Override
    public String toString() {
        return "ServiceRequest{" +
                "serviceRequestNo=" + serviceRequestNo +
                ", requestType='" + requestType + '\'' +
                ", customerName='" + customerName + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", problem='" + problem + '\'' +
                ", raisedDate=" + raisedDate +
                ", status='" + status + '\'' +
                '}';
    }
}
