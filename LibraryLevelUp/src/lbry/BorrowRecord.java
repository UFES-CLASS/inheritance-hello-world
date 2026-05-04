package lbry;
class BorrowRecord {
    private String recordId;     // record ID
    private Member member;       // who borrowed
    private LibraryItem item;    // borrowed item
    private String borrowDate;   // borrow date
    private String returnDate;   // return date
    private boolean returned;    // status

    public BorrowRecord(String recordId, Member member, LibraryItem item, String borrowDate) {
        this.recordId = recordId;
        this.member = member;
        this.item = item;
        this.borrowDate = borrowDate;
        this.returned = false;
    }

    public String getRecordId() { return recordId; }
    public Member getMember() { return member; }
    public LibraryItem getItem() { return item; }
    public String getBorrowDate() { return borrowDate; }
    public boolean isReturned() { return returned; }

    // mark item returned
    public void markReturned(String date) {
        this.returnDate = date;
        this.returned = true;
    }
}