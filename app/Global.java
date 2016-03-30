import static constants.Common.ACCESS_LOGGER;

import java.lang.reflect.Method;

import play.GlobalSettings;
import play.mvc.Action;
import play.mvc.Http.Request;


public class Global extends GlobalSettings {
    
    
    static final org.slf4j.Logger accessLogger  = org.slf4j.LoggerFactory.getLogger(ACCESS_LOGGER);

    @SuppressWarnings("rawtypes")
    @Override
    public Action onRequest(Request actionRequest, Method actionMethod) {
        accessLogger.info("IP: " + actionRequest.remoteAddress()  + " REQUEST: " + actionRequest );
        return super.onRequest(actionRequest, actionMethod);
        
    }
    
    
}
