package com.johnson.demos.redis.model;

/**
 * @author johnson lin
 * @date 2019/12/18 9:08 PM
 */
public class Tag {
    /**
     * 标签Id
     */
    private int tagId;

    /**
     * 标签名称
     */
    private String tagName;

    /**
     * 标签状态：1-正常 2-暂不显示
     */
    private int status;

    /**
     * 标签文章数
     */
    private int count;

    public int getTagId() {
        return tagId;
    }

    public Tag setTagId(int tagId) {
        this.tagId = tagId;
        return this;
    }

    public String getTagName() {
        return tagName;
    }

    public Tag setTagName(String tagName) {
        this.tagName = tagName;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public Tag setStatus(int status) {
        this.status = status;
        return this;
    }

    public int getCount() {
        return count;
    }

    public Tag setCount(int count) {
        this.count = count;
        return this;
    }
}
