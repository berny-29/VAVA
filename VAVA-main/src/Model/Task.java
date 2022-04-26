package src.Model;

import java.sql.*;
import java.time.LocalTime;
import java.time.OffsetDateTime;

public class Task {
    private boolean stat = false, repetitiveTask = false;
    private String desc;
    private LocalTime start, end;

    

    public Task() {

    }

    public Task(String desc) {
        this.desc = desc;
    }


    public boolean isStat() {
        return stat;
    }
    public boolean isRepetitiveTask() {
        return repetitiveTask;
    }
    //Geters
    public String getDesc() {
        return desc;
    }
    public LocalTime getEnd() {
        return end;
    }
    public LocalTime getStart() {
        return start;
    }
    //Setters
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public void setStat(boolean stat) {
        this.stat = stat;
    }
    public void setStart(LocalTime start) {
        this.start = start;
    }
    public void setEnd(LocalTime end) {
        this.end = end;
    }

    public static void createTask(Boolean repetitive, String description, LocalTime start, LocalTime end, int account_id, int child_id) throws SQLException {

        Connection conn = Database.getInstance().getConnection();

        String insert = "INSERT INTO tasks (repetitive,description,start_date,end_date,account_id,child_id) VALUES(?,?,?,?,?,?)";

        Timestamp time = java.sql.Timestamp.valueOf(java.time.LocalDateTime.of(2022,4,26,start.getHour(),start.getMinute()));


        PreparedStatement pi = conn.prepareStatement(insert);
        pi.setBoolean(1,repetitive);
        pi.setString(2,description);
        pi.setTimestamp(3,java.sql.Timestamp.valueOf(java.time.LocalDateTime.of(2022,4,26,start.getHour(),start.getMinute())));
        pi.setTimestamp(4,java.sql.Timestamp.valueOf(java.time.LocalDateTime.of(2022,4,26,end.getHour(),end.getMinute())));
        pi.setInt(5,account_id);
        pi.setInt(6,child_id);


        int rowi = pi.executeUpdate();

    }

    public static StringBuilder getTasks(int account_id){

        try {
            Connection conn = Database.getInstance().getConnection();
            String statement = "SELECT * FROM tasks where account_id = ?";

            PreparedStatement query = conn.prepareStatement(statement);
            query.setInt(1, account_id);


            ResultSet r = query.executeQuery();

            String result = "";

            StringBuilder str = new StringBuilder();

            str.append("Task\t\tStart\t\tEnd\n");

            while ( r.next() ) {
                str.append(r.getString("description"));
                str.append("\t\t");
                str.append(r.getTimestamp("start_date").toString().split(" ")[1]);
                str.append("\t");
                str.append(r.getTimestamp("end_date").toString().split(" ")[1]);
                str.append("\n");
            }

            return str;

        } catch (Exception e) {
            return null;
        }
    }


}
