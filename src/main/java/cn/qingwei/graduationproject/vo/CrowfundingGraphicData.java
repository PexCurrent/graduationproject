package cn.qingwei.graduationproject.vo;

import lombok.Data;

@Data
public class CrowfundingGraphicData {
    private int x;
    private int y;
    private int width;
    private int height;

    @Override
    public String toString() {
        return "GraphicData{" +
                "x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                '}';
    }


}
