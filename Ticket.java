public class Ticket {
    static String entryTime, exitTime;
    static int ticketId = 0; 
    public  Ticket(int ticketID )
    {
        this.ticketId=ticketID;
    }


    public static String getEntryTime() {
        return entryTime;
    }

    public static void setEntryTime(String entryTime) {
        Ticket.entryTime = entryTime;
    }

    public static String getExitTime() {
        return exitTime;
    }

    public static void setExitTime(String exitTime) {
        Ticket.exitTime = exitTime;
    }

    public static int getTicketId() {
        return ticketId;
    }

    public static  setTicketId(int ticketId) {
        Ticket.ticketId = ticketId;
    }

    public static void setRegistrationNumber(String registrationNumber) {
    }

}
