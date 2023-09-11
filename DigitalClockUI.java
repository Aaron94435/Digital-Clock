package clockclasses;
import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DigitalClockUI extends JFrame implements Serializable {

    /*
	 * The serial ID for this class
	 */
	private static final long serialVersionUID = 1L;
	Calendar calendar;
    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    SimpleDateFormat timeZoneFormat;

    JLabel timeLabel;
    JLabel timeZoneLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    String time;
    String day;
    String date;
    String timeZone;
    DigitalClockUI() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Digital Clock");
        this.setLayout(new FlowLayout());
        this.setSize(465, 320);
        this.setResizable(false);

        timeFormat = new SimpleDateFormat("hh:mm:ss:SSS a");
        dayFormat=new SimpleDateFormat("EEEE");
        dateFormat=new SimpleDateFormat("dd MMMMM, yyyy");
        timeZoneFormat = new SimpleDateFormat("z");
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("SANS_SERIF", Font.PLAIN, 59));
        timeLabel.setBackground(Color.BLACK);
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setOpaque(true);
        dayLabel=new JLabel();
        dayLabel.setFont(new Font("Ink Free",Font.BOLD,34));
        timeZoneLabel = new JLabel();
        timeZoneLabel.setFont(new Font("Ink Free", Font.BOLD, 25));
        dateLabel=new JLabel();
        dateLabel.setFont(new Font("Ink Free",Font.BOLD,30));

        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);
        this.add(timeZoneLabel);
        this.setVisible(true);

        setTimer();
    }

    public void setTimer() {
        while (true) {
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);

            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);

            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);
            
            timeZone = timeZoneFormat.format(Calendar.getInstance().getTime());
            timeZoneLabel.setText(timeZone);
            try {
                Thread.sleep(1);
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new DigitalClockUI();
    }
}
