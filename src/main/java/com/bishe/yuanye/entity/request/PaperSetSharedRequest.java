package com.bishe.yuanye.entity.request;

/**
 * Created by yuanye on 2017/5/31.
 *
 * @author yuanye
 * @date 2017/05/31
 */
public class PaperSetSharedRequest {

    public int paperId;

    public int isShared;

    public int getPaperId() {
        return paperId;
    }

    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

    public int getIsShared() {
        return isShared;
    }

    public void setIsShared(int isShared) {
        this.isShared = isShared;
    }
}
