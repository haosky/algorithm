package com.haosky.algorithm.modules;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by jianhao on 4/12/2018.
 *游戏渠道 monogdb表
 */
@Document(collection = "player_source__info")
public class PlayerSourceInfo {

    @Id
    @Field("_id")
    private String id;

    @Field("source")
    private String source;

    @Field("state")
    private String state;

    @Field("game_id")
    private String gameId;

    @Field("parent_id")
    private String parentId;

    @Field("update_at")
    private Long updateAt;

    @Field("message_time")
    private Long messageTime;

    @Field("source_name")
    private String sourceName;

    @Field("create_at")
    private Long createAt;

    @Field("platform")
    private String platform;

    @Field("level")
    private int level;

    public String getId() {
        return id;
    }
    public String getSource() {
        return source;
    }
    public String getState() {
        return state;
    }
    public String getGameid() {
        return gameId;
    }
    public String getParentid() {
        return parentId;
    }
    public Long getUpdate_at() {
        return updateAt;
    }
    public Long getMessage_time() {
        return messageTime;
    }
    public String getSource_name() {
        return sourceName;
    }
    public Long getCreate_at() {
        return createAt;
    }
    public String getPlatform() {
        return platform;
    }
    public int getLevel() {
        return level;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public void setState(String state) {
        this.state = state;
    }
    public void setGameId(String gameId) {
        this.gameId = gameId;
    }
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }
    public void setMessageTime(Long messageTime) {
        this.messageTime = messageTime;
    }
    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }
    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }
    public void setPlatform(String platform) {
       this.platform = platform;
    }
    public void setLevel(int level) {
        this.level = level;
    }

}
