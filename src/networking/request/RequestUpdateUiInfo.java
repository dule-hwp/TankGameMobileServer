package networking.request;

// Java Imports
import networking.response.ResponseUIinfo;
import core.NetworkManager;
import java.io.IOException;
import metadata.Constants;
import model.UiInfo;

// Other Imports
/**
 * The RequestHeartbeat class is mainly used to release all pending responses
 * the client. Also used to keep the connection alive.
 */
public class RequestUpdateUiInfo extends GameRequest {
    private UiInfo uiInfo;

//    private Bullet mBullet;
//    private ArrayList<Bullet>  mBullets;
    public RequestUpdateUiInfo() {
//        responseBullet = new ResponseBullet();
    }

    @Override
    public void parse() throws IOException {
        int ownerId = dataInput.readInt();
        int score = dataInput.readInt();
        int health = dataInput.readInt();
        int weaponID = dataInput.readInt();
        
        uiInfo = new UiInfo(ownerId, score, health, weaponID);
    }

    @Override
    public void doBusiness() throws Exception {

        ResponseUIinfo rui = new ResponseUIinfo(Constants.SMSG_UI_INFO_UPDATE);
        rui.setUiInfo(uiInfo);
        NetworkManager.addResponseForAllOnlinePlayers(-1, rui);  

    }
}
