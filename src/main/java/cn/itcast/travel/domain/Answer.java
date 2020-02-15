package cn.itcast.travel.domain;

public class Answer {
    private int id;
    private int qid; 
    private String username;
    private String content;
    private String time;

    public Answer(){ }

    public Answer(int id, int qid, String username, String content, String time) {
        this.id = id;
        this.qid = qid;
        this.username = username;
        this.content = content;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", qid=" + qid +
                ", username='" + username + '\'' +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
