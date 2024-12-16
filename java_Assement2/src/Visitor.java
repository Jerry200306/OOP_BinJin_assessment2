
public class Visitor extends Person {
    private String ticketNumber;
    private String membershipLevel;

    public Visitor() {
        super();
    }

    public Visitor(String name, int age, String id, String ticketNumber, String membershipLevel) {
        super(name, age, id);
        this.ticketNumber = ticketNumber;
        this.membershipLevel = membershipLevel;
    }


    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getMembershipLevel() {
        return membershipLevel;
    }

    public void setMembershipLevel(String membershipLevel) {
        this.membershipLevel = membershipLevel;
    }
}
