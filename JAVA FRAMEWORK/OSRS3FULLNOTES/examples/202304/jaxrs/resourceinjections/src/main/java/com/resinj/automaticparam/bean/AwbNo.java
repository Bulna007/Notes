package com.resinj.automaticparam.bean;

public class AwbNo {
    private String sourceLocationCode;
    private String destLocationCode;
    private int parcelNo;

//    public AwbNo(String in) {
//        this.sourceLocationCode = in.substring(0, 6);
//        this.destLocationCode = in.substring(6, 12);
//        this.parcelNo = Integer.parseInt(in.substring(12, 16));
//    }

    public String getSourceLocationCode() {
        return sourceLocationCode;
    }

    public void setSourceLocationCode(String sourceLocationCode) {
        this.sourceLocationCode = sourceLocationCode;
    }

    public String getDestLocationCode() {
        return destLocationCode;
    }

    public void setDestLocationCode(String destLocationCode) {
        this.destLocationCode = destLocationCode;
    }

    public int getParcelNo() {
        return parcelNo;
    }

    public void setParcelNo(int parcelNo) {
        this.parcelNo = parcelNo;
    }

//    public static AwbNo valueOf(String in) {
//        AwbNo awbNo = new AwbNo();
//
//        awbNo.setSourceLocationCode(in.substring(0,6));
//        awbNo.setDestLocationCode(in.substring(6,12));
//        awbNo.setParcelNo(Integer.parseInt(in.substring(12, 16)));
//        return awbNo;
//    }

    public static AwbNo fromString(String in) {
        AwbNo awbNo = new AwbNo();
        System.out.println("fromString(in)");
        awbNo.setSourceLocationCode(in.substring(0,6));
        awbNo.setDestLocationCode(in.substring(6,12));
        awbNo.setParcelNo(Integer.parseInt(in.substring(12, 16)));
        return awbNo;
    }

    @Override
    public String toString() {
        return "AwbNo{" +
                "sourceLocationCode='" + sourceLocationCode + '\'' +
                ", destLocationCode='" + destLocationCode + '\'' +
                ", parcelNo=" + parcelNo +
                '}';
    }
}
