import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int currentYear = LocalDate.now().getYear();

        LocalDate arriveAliceLD = LocalDate.parse(currentYear + "-" + arriveAlice);
        LocalDate leaveAliceLD = LocalDate.parse(currentYear + "-" + leaveAlice);
        LocalDate arriveBobLD = LocalDate.parse(currentYear + "-" + arriveBob);
        LocalDate leaveBobLD = LocalDate.parse(currentYear + "-" + leaveBob);

        if (leaveAliceLD.isBefore(arriveBobLD)) {
            arriveBobLD = arriveBobLD.plusYears(1);
            leaveBobLD = leaveBobLD.plusYears(1);
        }

        if (arriveAliceLD.isAfter(leaveBobLD) || arriveBobLD.isAfter(leaveAliceLD)) {
            return 0;
        }

        LocalDate startDate = arriveAliceLD.isBefore(arriveBobLD) ? arriveBobLD : arriveAliceLD;
        LocalDate endDate = leaveAliceLD.isBefore(leaveBobLD) ? leaveAliceLD : leaveBobLD;
        long daysTogether = ChronoUnit.DAYS.between(startDate, endDate) + 1;
        return (int) daysTogether;
    }
}

