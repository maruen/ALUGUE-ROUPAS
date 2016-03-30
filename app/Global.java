import static constants.Common.ACCESS_LOGGER;

import java.lang.reflect.Method;

import play.GlobalSettings;
import play.Play;
import play.libs.F.Promise;
import play.mvc.Action;
import play.mvc.Http.Context;
import play.mvc.Http.Request;
import play.mvc.Result;
import play.mvc.Results;


public class Global extends GlobalSettings {
    
    
    static final org.slf4j.Logger accessLogger  = org.slf4j.LoggerFactory.getLogger(ACCESS_LOGGER);

    @SuppressWarnings("rawtypes")
    @Override
    public Action onRequest(Request actionRequest, Method actionMethod) {
        accessLogger.info("IP: " + actionRequest.remoteAddress()  + " REQUEST: " + actionRequest );
    
        if (!actionRequest.secure()) {

            String httpPort     = Play.application().configuration().getString("http.port");
            String httpsPort    = Play.application().configuration().getString("https.port");
            String host         = actionRequest.host().replace(httpPort,httpsPort);
            String method       = actionRequest.uri();

            final String secureURL = "https://" + host + method;
            return new Action.Simple() {
                @Override
                public Promise<Result> call(Context ctx) throws Throwable {
                    return Promise.pure(Results.movedPermanently(secureURL));
                }
            };

        } else {
            return super.onRequest(actionRequest, actionMethod);
        }
    
    }
    
    
}
