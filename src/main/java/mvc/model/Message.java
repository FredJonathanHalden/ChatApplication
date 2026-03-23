package mvc.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="Message")
public class Message {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="Mnr", nullable = false, unique = true)
    private Integer mnr;

    @Column(name="Sdate")
    private Date sentDate = new Date();

    @Column(name="Sname", length=30)
    private String senderName;

    @Column(name="Text", length=300)
    private String text;

    public Integer getMnr() {
        return mnr;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getText() {
        return text;
    }


    public void setMnr(Integer mMnr) {
        this.mnr = mMnr;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "[" + sentDate + "] " + senderName + "> " + text;
    }
}
