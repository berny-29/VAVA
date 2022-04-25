package src.Model;

import src.Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;

public class PopulateGlobals {

    public static void populateGplans(){

        /**
         * fill the global plan array
         */
        Plan plan1 = new Plan();
        plan1.setName("workout plan - 1 week");
        plan1.addTask("workout", LocalTime.of(16,0),LocalTime.of(18,0));
        plan1.addTask("study",LocalTime.of(18,30),LocalTime.of(20,30));
        plan1.setStart(OffsetDateTime.now());
        plan1.setEnd(OffsetDateTime.now());

        Plan plan2 = new Plan();
        plan2.setName("workout plan - 2 week");
        plan2.addTask("workout",LocalTime.of(16,0),LocalTime.of(18,0));
        plan2.addTask("study",LocalTime.of(18,30),LocalTime.of(20,30));
        plan2.setStart(OffsetDateTime.now());
        plan2.setEnd(OffsetDateTime.now());

        Plan plan3 = new Plan();
        plan3.setName("workout plan - 3 week");
        plan3.addTask("workout",LocalTime.of(16,0),LocalTime.of(18,0));
        plan3.addTask("study",LocalTime.of(18,30),LocalTime.of(20,30));
        plan3.setStart(OffsetDateTime.now());
        plan3.setEnd(OffsetDateTime.now());

        Main.GPlans.add(plan1);
        Main.GPlans.add(plan2);
        Main.GPlans.add(plan3);

    }

    public static void printPlans(){
        int i,j = 0;

        for (i=0;i<Main.GPlans.size();i++){
            System.out.println(Main.GPlans.get(i).getName());
            ArrayList<Task> tArr=Main.GPlans.get(i).getTasks();
            for (j = 0; j<tArr.size();j++) {
                System.out.println(tArr.get(j).getDesc());
            }
        }
    }

    public static void populateGUserPlans() throws SQLException {

        int i;

        Connection conn = Database.getInstance().getConnection();

        String find = "SELECT COUNT(*) FROM accounts";
        PreparedStatement pf = conn.prepareStatement(find);

        ResultSet rowf = pf.executeQuery();
        if (rowf.next()){
            int count = rowf.getInt(1);
            System.out.println(count);
            for(i=1;i<=count;i++){
                Plan plan = new Plan();
                UserPlan uPlan = new UserPlan(i,plan);
                Main.UsersPlans.add(uPlan);
            }

        }

    }

}
