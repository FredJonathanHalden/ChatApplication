package mvc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name="Message")
public class Message {

    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    @Column(name="Mnr", nullable = false, unique = true)
    private byte[] mMnr;

    @Column(name="Sdate")
    private Date mSentDate;

    @Column(name="Stime")
    private Time mSentTime;

    @Column(name="Sname", length=30)
    private String mSenderName;

    @Column(name="Text", length=300)
    private String mText;

    public Message() {
        java.util.Date currentDate = new java.util.Date();
        mSentDate = new Date(currentDate.getYear(), currentDate.getMonth(), currentDate.getDay());
        mSentTime = new Time(currentDate.getTime());
    }

    public byte[] getMnr() {
        return mMnr;
    }

    public Date getSentDate() {
        return mSentDate;
    }

    public Time getSentTime() {
        return mSentTime;
    }

    public String getSenderName() {
        return mSenderName;
    }

    public String getText() {
        return mText;
    }

    public void setMnr(byte[] mnr) {
        mMnr = mnr;
    }

    public void setSentDate(Date sentDate) {
        mSentDate = sentDate;
    }

    public void setSentTime(Time sentTime) {
        mSentTime = sentTime;
    }

    public void setSenderName(String senderName) {
        mSenderName = senderName;
    }

    public void setText(String text) {
        mText = text;
    }

    @Override
    public String toString() {
        String timeString = "";
        long totalSeconds = mSentTime.getTime() / 1000;
        long seconds = totalSeconds % 60;
        long minutes = (totalSeconds % 3600) / 60;
        long hours = (totalSeconds / 3600) - (mSentTime.getTimezoneOffset() / 60);
        if (hours < 10) {
            timeString += "0";
        }
        timeString += hours + ":";

        if (minutes < 10) {
            timeString += "0";
        }
        timeString += minutes + ":";

        if (seconds < 10) {
            timeString += "0";
        }
        timeString += seconds;
        return "[" + mSentDate + "][" + timeString + "] " + mSenderName + "> " + mText;
    }
}
