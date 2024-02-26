package com.ruoyi.ledger.domain.vo;

/**
 * @program: qrcode-ruoyi
 * @description: 用于前端传送选项的类
 * @author: Disda
 * @create: 2024-02-26 08:26
 */
public class ElementOptions {
    @Override
    public String toString() {
        return "ElementOptions{" +
                "value=" + value +
                ", label='" + label + '\'' +
                '}';
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    private Long value;

    private String label;
}