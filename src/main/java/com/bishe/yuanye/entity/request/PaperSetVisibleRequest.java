package com.bishe.yuanye.entity.request;

/**
 * Created by yuanye on 2017/5/31.
 *
 * @author yuanye
 * @date 2017/05/31
 */
public class PaperSetVisibleRequest {

    public int paperId;

    public int isVisible;

    public int getPaperId() {
        return paperId;
    }

    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

    public int getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(int isVisible) {
        this.isVisible = isVisible;
    }
}
