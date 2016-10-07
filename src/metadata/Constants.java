package metadata;

/**
 * The Constants class stores important variables as constants for later use.
 */
public class Constants {

    // Request (1xx) + Response (2xx)
    public static final short CMSG_AUTH = 101;
    public static final short SMSG_AUTH = 201;

    public static final short CMSG_HEARTBEAT = 102;
    public static final short SMSG_HEARTBEAT = 202;

    public static final short CMSG_ENEMIES = 103;
    public static final short SMSG_ENEMIES = 203;

    public static final short CMSG_TEST = 104;
    public static final short SMSG_TEST = 204;

    public static final short CMSG_ADD_BULLET = 105;
    public static final short SMSG_ADD_BULLET = 205;

    public static final short CMSG_PLATERUPDATE = 106;
    public static final short SMSG_PLATERUPDATE = 206;
    
    public static final short CMSG_UPDATE_BULLET = 107;
    public static final short SMSG_UPDATE_BULLET = 207;

    public static final short CMSG_UI_INFO_UPDATE = 108;
    public static final short SMSG_UI_INFO_UPDATE = 208;

    public static final short CMSG_REMOVE_POWER_UP = 109;
    public static final short SMSG_REMOVE_POWER_UP = 209;

    public static final short CMSG_ADD_POWER_UP = 110;
    public static final short SMSG_ADD_POWER_UP = 210;
    
    public static final short CMSG_LOG_OFF = 111;

    // Organism Type
    public static final short ORGANISM_TYPE_ANIMAL = 0;
    public static final short ORGANISM_TYPE_PLANT = 1;
    // Parameter Type
    public static final short PARAMETER_K = 0;	//Plants Carrying capacity >0
    public static final short PARAMETER_R = 1;	//Plants Growth rate 0-1
    public static final short PARAMETER_X = 2;	//Plants Metabolic rate 0-1
    public static final short PARAMETER_X_A = 3;	//Animals
    public static final short PARAMETER_E = 4; //Animals assimilationEfficiency
    public static final short PARAMETER_D = 5; //Animals predatorInterference
    public static final short PARAMETER_Q = 6; //Animals functionalResponseControl
    public static final short PARAMETER_A = 7; //Animals relativeHalfSaturationDensity
    // Other
    public static final float BIOMASS_SCALE = 1000;
    public static final String CLIENT_VERSION = "1.00";
    public static final int TIMEOUT_SECONDS = 90;
    public static final String CSV_SAVE_PATH = "src/log/";
}
