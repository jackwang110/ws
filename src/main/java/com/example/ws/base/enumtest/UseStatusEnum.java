package com.example.ws.base.enumtest;

public enum UseStatusEnum {
    PACKING_NOT_USE(1),  // 未领用
    PACKING_HAS_USED(2),  // 已领用
    PACKING_BACK_USE(3);
    private Integer useStatus;

    private UseStatusEnum(int useStatus) {
        this.useStatus = useStatus;
    }
    private Integer getUseStatus(){
        return useStatus;
    }

    public static void main(String[] args) {
        System.out.println(UseStatusEnum.PACKING_HAS_USED.getUseStatus());
    }
}
