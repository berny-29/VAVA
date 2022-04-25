package src.Model;

import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;

import static src.Main.GPlans;

public class populateGlobals {

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

        GPlans.add(plan1);
        GPlans.add(plan2);
        GPlans.add(plan3);

    }

    public static void printPlans(){
        int i,j = 0;

        for (i=0;i<GPlans.size();i++){
            System.out.println(GPlans.get(i).getName());
            ArrayList<Task> tArr=GPlans.get(i).getTasks();
            for (j = 0; j<tArr.size();j++) {
                System.out.println(tArr.get(j).getDesc());
            }
        }
    }

}
