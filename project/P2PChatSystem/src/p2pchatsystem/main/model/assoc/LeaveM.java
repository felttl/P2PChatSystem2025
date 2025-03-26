package p2pchatsystem.main.model.assoc;

import p2pchatsystem.main.views.LeaveV;

/**
 * manage data flow of the leave view
 * connected to Main Controller
 */
public class LeaveM {

    // composition
    private LeaveV leavev;

    public LeaveM() {
        leavev = new LeaveV();
    }



    public LeaveM get(){
        return this;
    }


}
