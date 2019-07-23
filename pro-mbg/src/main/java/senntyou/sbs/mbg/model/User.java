package senntyou.sbs.mbg.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    @JsonIgnore
    private Integer id;

    /**
     * uuid
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "uuid")
    private String uuid;

    /**
     * username
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "username")
    private String username;

    /**
     * email
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "email")
    private String email;

    /**
     * password(encrypted)
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "password(encrypted)")
    @JsonIgnore
    private String password;

    /**
     * deleted or not
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "deleted or not")
    private Boolean deleted;

    /**
     * create time
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "create time")
    private Date createTime;

    /**
     * update time
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "update time")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", uuid=").append(uuid);
        sb.append(", username=").append(username);
        sb.append(", email=").append(email);
        sb.append(", password=").append(password);
        sb.append(", deleted=").append(deleted);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}